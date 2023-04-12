package bg.softuni.armory.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("PRE Handle {}", request.getRequestURI());
        LOGGER.info("Start time: {}", System.currentTimeMillis());

        request.setAttribute("startTime", startTime);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        StringBuilder builder = new StringBuilder();

        builder.append("!Status: ").append(response.getStatus()).append("\n");
        builder.append("!URL: ").append(request.getRequestURL());
        builder.append("!Method: ").append(request.getMethod()).append("\n");

        LOGGER.info(builder.toString());

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        LOGGER.info("URL Request Completed. End time: {}", endTime);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
