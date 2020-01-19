<#setting number_format="#"> <#-- 解决数字自动加逗号 -->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>秒杀列表页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "common/bootstrap-header.ftl" />
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>链接</th>
                </tr>
                </thead>
                <tbody>
                <#list secKillList as secKill>
                    <tr>
                        <td>${secKill.name}</td>
                        <td>${secKill.number}</td>
                        <td>${secKill.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${secKill.endTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${secKill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>
                            <a class="btn btn-info" href="${basePath}secKill/detail/${secKill.secKillId}"
                               target="_blank">link</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<#include "common/bootstrap-js.ftl" />
</body>
</html>
