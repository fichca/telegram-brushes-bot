package by.liatkouski.service.interceptor;

import by.liatkouski.service.config.TokenConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    private final TokenConfig tokenConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("X-Api-Token");
        if (validToken(header)){
            return true;
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalidate token");
        return false;
    }

    private boolean validToken(String token) {
        return tokenConfig.getToken().equals(token);
    }
}
