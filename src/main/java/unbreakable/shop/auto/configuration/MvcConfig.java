package unbreakable.shop.auto.configuration;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${image.path}")
    private String path;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("file://" + path );
//                .setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
    }
}