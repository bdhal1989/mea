package org.mea;

import static org.springframework.boot.WebApplicationType.SERVLET;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.web(SERVLET);
		return application.sources(MEAApplication.class);
	}
	
	

}
