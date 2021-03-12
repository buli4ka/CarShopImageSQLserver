package unbreakable.shop.auto.configuration.security_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.service.car_service.CarService;
import unbreakable.shop.auto.service.user_service.UserService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    private final String login = "user";
    private final String password = "password";
    private final String role = "ADMIN";

//    private List<String> paths() {
//        List<String> pathL = new ArrayList<String>();
//
//        for (Car car : carService.getCars()) {
//            pathL.add('/' + car.getId().toString());
//        }
//        return pathL;
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        List<String> l = paths();
        http
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .permitAll();


        // l.forEach(http::antMatcher);

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        userService.saveUser(login, password, role);
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(login)
                        .password(password)
                        .roles(role)
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
