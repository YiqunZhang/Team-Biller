package cc.ankin.teambiller.server.utils;

import cc.ankin.teambiller.server.service.UserService;
import cc.ankin.teambiller.server.utils.exception.FailureLoginException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String email = request.getHeader("email");
        String password = request.getHeader("password");
        System.out.println(email + " " + password);
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            throw new FailureLoginException();
        }
        return true;
    }


}
