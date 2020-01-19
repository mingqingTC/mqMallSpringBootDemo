package com.mq.demo.controller;

import javax.servlet.http.HttpServletRequest;

public class ControllerUtil {

    /**
     * 前台页面获取的项目基本路径
     *
     * @param request request请求对象
     * @return 项目基本路径
     */
    public static String basePath(HttpServletRequest request) {
        String path = request.getContextPath();
        return request.getScheme() + "://"
                + request.getServerName() + ":"
                + request.getServerPort()
                + path + "/";
    }

    /**
     * 获取项目所在的真实路径
     *
     * @return 项目所在的真实路径
     */
    public static String realPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }
}
