package com.tuneit.edx.lti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Empty request context listener (only for @WebListener)
 */
@WebListener
@Configuration
public class RequestContextListenerConfiguration extends RequestContextListener {}
