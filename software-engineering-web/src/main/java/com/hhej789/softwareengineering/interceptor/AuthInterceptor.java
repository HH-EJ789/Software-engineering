package com.hhej789.softwareengineering.interceptor;

import com.hhej789.softwareengineering.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Author AICHI
 * @Date 2020/4/23 21:31
 * @Version 1.0
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            response.getWriter().println("用户未登录，请登陆后操作！");
            return false;
        }
        ValueOperations ops = redisTemplate.opsForValue();
        Object loginStatus = ops.get(token);
        if(Objects.isNull(loginStatus)) {
            response.getWriter().println("token错误，请查看！");
            return false;
        }
        redisTemplate.expire(token, 2, TimeUnit.MINUTES);
        redisTemplate.expire(ops.get(token), 2, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
