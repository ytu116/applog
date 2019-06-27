package com.zs.filecenter.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long begin_nao_time = System.nanoTime();    // 系统计时器的当前值，以毫微秒为单位。
        String realIp = getRemortIP(request);       // 访问者IP
        request.setAttribute("p_real_ip", realIp);
        request.setAttribute("begin_nao_time", begin_nao_time);
        logger.info("LogInterceptor--preHandle--p_real_ip = " + realIp + " ; begin_nao_time = " + begin_nao_time);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * 获取用户真实的ip
     */
    private String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 维护redis中访问统计变量 k-v
     * value = {"totalTime":1200,"meanTime":20,"visitCount":60}
     */
    private boolean refreshMonitorUnit2Redis(String uri, long interval) {
        String redis_key = "MTR-URI-" + uri;
        try {

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 维护db中访问统计变量 k-v
     */
    private boolean refreshMonitorUnit2DB(String uri, long interval) {
        // 暂时不需要
        return true;
    }

}
