package com.nrecinos.backend.services.implementations;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nrecinos.backend.models.entities.user.User;
import com.nrecinos.backend.repositories.UserRepository;
import com.nrecinos.backend.services.UserService;
import com.nrecinos.backend.utils.JWTTools;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JWTTokenFIlter extends OncePerRequestFilter{
	@Autowired
	JWTTools jwtTools;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException  {
		String tokenHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;

		if(tokenHeader != null && tokenHeader.startsWith("Bearer ") && tokenHeader.length() > 7) {
		    token = tokenHeader.substring(7);
		    
		    try {
		        username = jwtTools.getUsernameFrom(token);
		    } catch (IllegalArgumentException e) {
		        System.out.println("Unable to get JWT Token");
		    } catch (ExpiredJwtException e) {
		        System.out.println("JWT TOKEN has expired");
		    } catch (MalformedJwtException e) {
		        System.out.println("JWT Malformado");
		    }
		} else {
		    System.out.println("Bearer string not found");
		}
		
		if(username != null && token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			User user = userRepository.findByUsernameOrEmail(username, username);
			
			if(user != null) {
				Boolean tokenValidity = userService.isTokenValid(user, token);
				
				if(tokenValidity) {
					//Preparing the authentication token.
					UsernamePasswordAuthenticationToken authToken 
						= new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
					
					authToken.setDetails(
								new WebAuthenticationDetailsSource().buildDetails(request)
							);
					
					//This line, sets the user to security context to be handled by the filter chain
					SecurityContextHolder
						.getContext()
						.setAuthentication(authToken);
				}
			}
			
		}
		filterChain.doFilter(request, response);
	}


}
