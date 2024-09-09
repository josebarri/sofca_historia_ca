package com.sofca.historiaca.security;

import com.sofca.historiaca.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/v3/api-docs") || requestURI.startsWith("/swagger-ui") || requestURI.startsWith("/auth")|| requestURI.startsWith("/mascota")|| requestURI.startsWith("/ubicacion")|| requestURI.startsWith("/tipoIdent")|| requestURI.startsWith("/paciente")|| requestURI.startsWith("/dueno") || requestURI.startsWith("/importar-excel")) {
            filterChain.doFilter(request, response);
            return;
        }

        String correo = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            System.out.println("Entra aqui if #1");
            jwt = authorizationHeader.substring(7);
            correo = jwtUtil.extractCorreo(jwt);
        }

        if (correo != null && jwtUtil.validateToken(jwt, correo)) {
            System.out.println("Entra aqui if");
            // Token es válido, sigue la cadena de filtros
            System.out.println(jwt);
            System.out.println(correo);
            System.out.println(response);
            System.out.println(request);
            filterChain.doFilter(request, response);
        } else {
            System.out.println("Entra aqui else");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido o expirado");
        }
    }
}
