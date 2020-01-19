<#ftl
encoding="UTF-8" <#-- 字符编码 -->
strip_whitespace="true" <#-- 空白处理-->
strict_syntax="true" <#-- 严格语法 -->
/> <#-- 定义模板规则,必须位于最开始位置-->
<#setting number_format="#"> <#-- 解决数字自动加逗号 -->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>freemarker语法</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <#include "common/bootstrap-header.ftl" /><#-- 引入其他文件 -->
</head>
<body>
<#-- 注释: 声明一个变量 -->
<#assign insertValue="插值" />
<h3>插值方式: ${insertValue}</h3>

<#-- ftl默认指令 -->
<div id="assign">
    <label>assign指令,用于定义全局变量</label><br/>
    <#assign value1=1 value2=2 />
    <p>value1: ${value1} value2: ${value2}</p>
</div>
<div id="function">
    <label>function,用于定义函数</label><br/>
    <#function add para1 para2 >
        <#return para1+para2 />
    </#function>
    <#function avg nums...>
        <#local sum = 0 />
        <#list  nums as num>
            <#local sum+=num />
        </#list>
        <#return sum/nums?size />
    </#function>
    <p>add: ${add(2,3)}</p>
    <p>avg: ${avg(2,3,5,6)}</p>
</div>
<div id="if">
    <label>if elseif else,条件语句</label><br/>
    <#if value1==1>
        if doSomething
    <#elseif value1==2>
        elseif doSomething
    <#else>
        else doSomething
    </#if>
</div>
<div id="switch">
    <label>switch case,条件语句</label><br/>
    <#switch value1>
        <#case 1>case1 doSomething<#break>
        <#case 2>case2 doSomething<#break>
        <#default>default doSomething<#break>
    </#switch>
</div>
<div id="list">
    <label>list,循环语句</label><br/>
    <ul>
        <#list lists as item>
            <li>${item}</li>
        <#else >
            空数组
        </#list>
    </ul>
</div>
<div id="noParse">
    <label>noParse,不对包含的片段进行解析</label><br/>
    <#noparse>
        ${value} <#-- 这里会直接当成文本输出 -->
    </#noparse>
</div>
<#noparse>
<div id="setting">
    <label>setting,对这个模板文件修改一些设置,在配置文件中可以设定一些默认设置</label>
    <#setting
    locale="" <#-- 本地化 -->
    number_format=""
    boolean_format=""
    date_format=""
    time_format=""
    datetime_format=""
    time_zone="" <#-- 时区,修改该值时sql_date_and_time_time_zone也应修改 -->
    sql_date_and_time_time_zone=""
    url_escaping_charset="" <#-- url转义,通常不在模板文件中配置 -->
    output_encoding="" <#-- 文档输出使用的字符集 -->
    />
</div>
</#noparse>
</body>
</html>
