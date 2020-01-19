<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>404Error</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${basePath}resources/dist/css/AdminLTE.min.css"/>
    <link rel="stylesheet" href="${basePath}resources/dist/css/skins/_all-skins.min.css"/>
    <#include "common/bootstrap-header.ftl" />
    <![endif]-->
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <section class="content">
        <div class="error-page">
            <h2 class="headline text-yellow">404</h2>
            <div class="error-content">
                <h3><i class="fa fa-warning text-yellow"></i> 啊哦! 页面找不到.</h3>
                <h3><i class="fa fa-warning text-yellow"></i> 请检查http链接是否正确.</h3>
                <h3><i class="fa fa-warning text-yellow"></i>
                    <a href="${basePath}secKill/list/0/10">或者点此返回列表页</a>
                </h3>

            </div>
        </div>
    </section>
</div>
</body>
</html>