package unbreakable.shop.auto.configuration.mvc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
public class MvcConfig implements WebMvcConfigurer //implements WebMvcConfigurer
 {

    private static final String VIEWS = "/WEB-INF/views/";

    private static final String RESOURCES_LOCATION = "/resources/";
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    @Value("${image.path}")
    private String path;


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/images/**")
//                .addResourceLocations("file://" + path )
//                .setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
//    }

     public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/admin").setViewName("entryForAdmins");
         registry.addViewController("/").setViewName("index");
         registry.addViewController("/hello").setViewName("hello");
         registry.addViewController("/login").setViewName("login");
     }




}