package org.example.sample.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// you can configure DelegatingFilterProxy in web.xml or by subclassing AbstractSecurityWebApplicationInitializer
//springSecurityFilterChain   FilterChainProxy
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }


    //todo override methods
//    protected SecurityWebApplicationInitializer() {
//        super();
//    }
//
//    protected SecurityWebApplicationInitializer(Class<?>... configurationClasses) {
//        super(configurationClasses);
//    }
//
//    @Override
//    protected boolean enableHttpSessionEventPublisher() {
//        return super.enableHttpSessionEventPublisher();
//    }
//
//    @Override
//    protected Set<SessionTrackingMode> getSessionTrackingModes() {
//        return super.getSessionTrackingModes();
//    }
//
//    @Override
//    protected String getDispatcherWebApplicationContextSuffix() {
//        return super.getDispatcherWebApplicationContextSuffix();
//    }
//
//    @Override
//    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//        super.beforeSpringSecurityFilterChain(servletContext);
//    }
//
//    @Override
//    protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
//        super.afterSpringSecurityFilterChain(servletContext);
//    }
//
//    @Override
//    protected EnumSet<DispatcherType> getSecurityDispatcherTypes() {
//        return super.getSecurityDispatcherTypes();
//    }
//
//    @Override
//    protected boolean isAsyncSecuritySupported() {
//        return super.isAsyncSecuritySupported();

//    }


}