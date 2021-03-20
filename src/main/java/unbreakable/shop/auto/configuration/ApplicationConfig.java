package unbreakable.shop.auto.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import unbreakable.shop.auto.AutoApplication;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = AutoApplication.class)
class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}