package unbreakable.shop.auto.configuration.mvc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
public class MvcConfig implements WebMvcConfigurer
 {

     private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
     private static final String VIEWS = "/WEB-INF/views/";

     private static final String RESOURCES_LOCATION = "/resources/";
     private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    @Value("${image.path}")
    private String path;


     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
     }

     public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/admin").setViewName("entryForAdmins");
         registry.addViewController("/").setViewName("index");
         registry.addViewController("/login").setViewName("login");
     }

     @Bean
     public ITemplateResolver templateResolver() {
         SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
         resolver.setPrefix(VIEWS);
         resolver.setSuffix(".html");
         resolver.setTemplateMode(TemplateMode.HTML);
         resolver.setCharacterEncoding("UTF-8");
         resolver.setCacheable(false);
         return resolver;
     }
//     @Override
//     public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//         configurer.enable();
//     }

     @Controller
     static class FaviconController {
         @RequestMapping("favicon.ico")
         String favicon() {
             return "forward:/resources/images/favicon.ico";
         }
     }

}