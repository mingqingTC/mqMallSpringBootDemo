/**
 * 秒杀模块detail页面js
 */
var secKill = {
    BASE_PATH: '/secKill/',

    //后端提供的接口地址
    // GET /error
    // GET /secKill/{offset}/{limit}/list
    // GET /secKill/{secKillId}/detail
    // GET /secKill/systemCurrentTime
    // GET /secKill/{secKillId}/exposer
    // POST /secKill/{secKillId}/{md5}/execution
    URL: {
        error: function () {
            return '/error';
        },

        list: function (offset, limit) {
            return secKill.BASE_PATH + '/list' + offset + '/' + limit;
        },

        detail: function (secKillId) {
            return secKill.BASE_PATH + '/detail' + secKillId;
        },

        systemCurrentTime: function () {
            return secKill.BASE_PATH + 'systemCurrentTime';
        },

        exposer: function (secKillId) {
            return secKill.BASE_PATH + '/exposer' + secKillId;
        },

        execution: function (secKillId, md5) {
            return secKill.BASE_PATH + '/execution' + secKillId + '/' + md5;
        }
    },

    detail: {
        //验证手机号
        validatePhone: function (userPhone) {
            return (userPhone != null && userPhone.length === 11 && !isNaN(userPhone));
        },

        showModal: function () {
            var killPhoneModal = $('#killPhoneModal');
            //显示模态框
            killPhoneModal.modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
            //模态框点击事件
            $('#killPhoneBtn').click(function () {
                var inputPhone = $('#killPhoneKey').val();
                if (secKill.detail.validatePhone(inputPhone)) {
                    //数据写入cookie
                    $.cookie('userPhone', inputPhone, {expires: 7, path: '/mqMall/secKill'});
                    window.location.reload();
                } else {
                    $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
                }
            });
        },

        showCountDown: function (secKIllId, startTime) {
            var secKillBox = $('#sec-kill-box');
            var killTime = new Date(startTime + 1000);
            secKillBox.countdown(killTime, function (event) {
                var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                secKillBox.html(format);
            }).on('finish.countdown', function () {
                //向后台发送请求,判断是否要暴露秒杀按钮
                $.get(secKill.URL.exposer(secKIllId), {}, function (result) {
                    if (result && result['success']) {
                        var exposeEntranceResult = result['data'];
                        secKill.detail.showDetail({
                            secKillId: exposeEntranceResult['secKillId'],
                            exposed: exposeEntranceResult['exposed'],
                            md5: exposeEntranceResult['md5'],
                            systemCurrentTime: exposeEntranceResult['systemCurrentTime'],
                            startTime: exposeEntranceResult['startTime'],
                            endTime: exposeEntranceResult['endTime']
                        });
                    } else {
                        $.get(secKill.URL.error());
                    }
                });
            });
        },

        showSecKillBtn: function (secKillId, md5) {
            var node = $('#sec-kill-box');
            node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
            var killUrl = secKill.URL.execution(secKillId, md5);
            console.log('killUrl:' + killUrl);
            $('#killBtn').one('click', function () {
                $(this).addClass('disabled');
                $.post(killUrl, {}, function (result) {
                    if (result && result['success']) {
                        var killResult = result['data'];
                        var stateInfo = killResult['stateInfo'];
                        node.html('<span class="label label-success">' + stateInfo + '</span>');
                    } else {
                        console.log('result: ' + result);
                    }
                });
            });
            //隐藏计时图标
            $('#clock-icon').hide();
            //显示秒杀按钮
            node.show();
        },

        showDetail: function (params) {
            var exposed = params['exposed']; //判断是否暴露秒杀按钮
            var secKillId = params['secKillId'];
            if (exposed) {
                //暴露秒杀按钮
                var md5 = params['md5'];
                secKill.detail.showSecKillBtn(secKillId, md5);
            } else {
                var startTime = params['startTime'];
                var endTime = params['endTime'];
                var systemCurrentTime = params['systemCurrentTime'];
                if (systemCurrentTime < startTime) {
                    secKill.detail.showCountDown(secKillId, startTime);
                } else if (systemCurrentTime > endTime) {
                    $('#clock-icon').hide();
                    $('#sec-kill-box').hide().html('<button class="btn btn-primary btn-lg disabled" id="killBtn">该商品秒杀已结束</button>').show();
                }
            }
        },

        //详情页初始化
        init: function (params) {
            //验证cookie中是否存在用户手机号
            var userPhone = $.cookie("userPhone");
            if (secKill.detail.validatePhone(userPhone)) {
                secKill.detail.showDetail(params);
            } else {
                secKill.detail.showModal();
            }
        }
    }
};