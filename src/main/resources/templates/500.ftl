<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>500Error</title>
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
    <div class="error-page">
        <h2 class="headline text-red">500</h2>
        <div class="error-content">
            <h3><i class="fa fa-warning text-red"></i> 吖! 服务器炸了.</h3>
            <h3><i class="fa fa-warning text-red"></i> 请尝试刷新页面.</h3>
            <h3><i class="fa fa-warning text-red"></i>
                <a href="${basePath}secKill/list/0/10">或者点此返回列表页</a>
            </h3>
        </div>
    </div>
</div>
</body>
</html>