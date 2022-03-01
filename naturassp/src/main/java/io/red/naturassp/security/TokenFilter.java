package io.red.naturassp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        System.out.println("Requisicao passou pelo filtro");
        if (request.getHeader("Authorization") != null){
            Authentication auth = JWTTokenUtil.decodeToken(request);

            SecurityContextHolder.getContext().setAuthentication(auth);
        }


        filterChain.doFilter(request, response);

    }
}
