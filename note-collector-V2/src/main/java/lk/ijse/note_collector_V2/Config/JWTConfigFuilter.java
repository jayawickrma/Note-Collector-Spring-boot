package lk.ijse.note_collector_V2.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTConfigFuilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String initoken =request.getHeader("Authorization");
            String userEmail ;
            String extractJWTtocken;

            //todo :validate token
        if (StringUtils.isEmpty(initoken) || initoken.startsWith("bearer")){
            filterChain.doFilter(request,response);
        }

            //Todo :Extract Token
        extractJWTtocken =initoken.substring(7);
    }
}
