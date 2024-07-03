package com.example.WorkFlowManagement.configuration;

import com.example.WorkFlowManagement.dto.response.UserDetail;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String SIGNER_KEY = "CN7MR/pXqgGZpN61nLVXWglUPlh+Z84fsREl+6ssNG9qcyu+pVMkALX4QXTswvn5";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")){
            token = token.substring(7); // Remove "Bearer " prefix
            try {
                JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
                SignedJWT signedJWT = SignedJWT.parse(token);

                if (signedJWT.verify(verifier) && signedJWT.getJWTClaimsSet().getExpirationTime().after(new Date())){
                    String userId = signedJWT.getJWTClaimsSet().getSubject();
                    UserDetail userDetails = new UserDetail(userId, "", Collections.emptyList(), userId);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Collections.emptyList());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    request.setAttribute("userId", userId);
                }
            } catch (ParseException | JOSEException e) {
                throw new RuntimeException(e);
            }
        }
        filterChain.doFilter(request, response);
    }
}
