package org.example.sample.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.io.File;

public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebConfig.class};//SecurityConfiguration.class,
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String directory = System.getProperty("catalina.base") + "/uploads";
        File uploadDirectory = new File(directory);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        directory, 2097152, 4194304, 0)
        );
    }

}