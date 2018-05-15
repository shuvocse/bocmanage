package com.csinfotechbd.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			logger.debug(
					"User : " + auth.getName() + "is trying to access un-authorized URL :" + request.getRequestURI());
		else
			logger.debug("Anonymous user is trying to access un-authorized URL :" + request.getRequestURI());
		logger.debug("Conteext path : "+request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/caution/access-denied");
	}

}
