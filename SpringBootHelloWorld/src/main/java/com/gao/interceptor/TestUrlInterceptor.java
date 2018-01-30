package com.gao.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestUrlInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TestUrlInterceptor.class);
    
    public TestUrlInterceptor(){
        logger.info("--------------- TestUrlInterceptor initialize -------------");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if(request.getRequestURI().equals("/error")){
            logger.info("------------------error path");
            //request.getRequestDispatcher("/invalidPage");
            response.sendRedirect("/invalidPage");
        }
        logger.info("--------------TestUrlInterceptor work-----------------" + request.getRequestURI());

        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        if(modelAndView == null){
            logger.info("not find this path!!!!!");
        }else {
            logger.info("-------------- TestUrlInterceptor post url -----------------" + modelAndView.getViewName());
        }
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null) {
            logger.info("-------------- TestUrlInterceptor completion -----------------" + ex.getMessage());
        }
    }
}