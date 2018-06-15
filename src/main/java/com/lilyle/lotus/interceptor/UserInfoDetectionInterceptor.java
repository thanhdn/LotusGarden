package com.lilyle.lotus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInfoDetectionInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(UserInfoDetectionInterceptor.class);
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //System.out.println("preHandle");
        logger.debug("---------------------------------------------------------------------------------------");
        logger.debug(request.getRemoteAddr() + " HAS BEGIN A PROCESS");
        logger.debug("---------------------------------------------------------------------------------------");
        return true;
    }
    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
        logger.debug("---------------------------------------------------------------------------------------");
        logger.debug("FINISHED PROCESSING");
        logger.debug("---------------------------------------------------------------------------------------");
    }
    
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.debug("AFTER COMPLETION A PROCESS");
    }
}
