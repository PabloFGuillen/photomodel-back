package com.photomodel.photomodel_api.utils;

import com.photomodel.photomodel_api.domain.User;
import com.photomodel.photomodel_api.usecase.port.output.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        if (shouldNotFilter(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        if(authHeader == null | !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
        }

        jwt = authHeader.substring(7);

        try {
            username = jwtUtil.extractUsername(jwt);
        } catch (Exception ex){
            filterChain.doFilter(request, response);
            return;
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepository.getUsertByUsername(username);
            if (jwtUtil.validateToken(jwt, user)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user, null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        boolean isCreateUser = request.getRequestURI().equals("/user") && request.getMethod().equals("POST");
        System.out.println("Ruta en filtro: " + request.getMethod() + " " + request.getPathInfo()); // ⬅️ AÑADE ESTA LÍNEA
        // Ruta de Login (GET /user/login)
        boolean isLogin = request.getServletPath().equals("/user/login") && request.getMethod().equals("GET") ;

        return isCreateUser || isLogin;
    }
}
