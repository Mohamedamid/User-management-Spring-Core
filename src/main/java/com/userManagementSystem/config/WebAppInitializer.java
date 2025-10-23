package com.userManagementSystem.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Root context: persistence, services, security, etc.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { PersistenceConfig.class };
    }

    // Web context: controllers, view resolvers, etc.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // DispatcherServlet mapping
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }
}