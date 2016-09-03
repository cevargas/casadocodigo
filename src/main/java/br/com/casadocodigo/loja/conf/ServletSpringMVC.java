package br.com.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletRegistration.Dynamic;

/**
 *
 * @author CarlosEduardode
 */
public class ServletSpringMVC extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppWebConfiguration.class, 
                           JPAConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(
        new MultipartConfigElement(""));
    }
}