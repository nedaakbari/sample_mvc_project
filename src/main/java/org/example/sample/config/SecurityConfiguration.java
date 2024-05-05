package org.example.sample.config;


import lombok.RequiredArgsConstructor;
import org.example.sample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity=>if you happen to be developing a Spring MVC application
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final DataSource dataSource;
    private final EmployeeService employeeService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//how HTTP requests should be secured and what options a client has for authenticating the user
        http.userDetailsService(employeeService)
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }


/*
    //1=> Working with an in-memory user store
    @Bean
    public UserDetailsService userDetailsService() {
//UserDetailsManagerConfigurer.UserDetailsBuilder.
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();//BCryptPasswordEncoder, NoOpPasswordEncoder, andStandardPasswordEncoder.
        List<UserDetails> userDetails = new ArrayList<>();

//        var admin = User.withDefaultPasswordEncoder()//User.withDefaultPasswordEncoder()  User.withDefaultPasswordEncoder() //todo why PasswordEncoder is required? User.builder() => There is no PasswordEncoder mapped for the id "null"
//                .username("admin").password("admin").roles("USER", "ADMIN").build();

        var user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
        var admin = User.withUsername(("admin")).password(encoder.encode("admin")).roles("USER", "ADMIN").build();

//todo notice role are automatically added Role_ to every authority it is shortcut for them
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "TESTER"));

        var user3 = User.withUsername("neda").password(encoder.encode("123")).authorities(authorities).build();

        userDetails.add(user);
        userDetails.add(admin);
        userDetails.add(user3);
        return new InMemoryUserDetailsManager(userDetails);
    }

 */
    ///////////////////////////
//    2=>Authenticating against database tables


    //    configure(WebSecurity) Override to configure Spring Security’s filter chain.
//    configure(HttpSecurity) Override to configure how requests are secured by interceptors.
//    configure(AuthenticationManagerBuilder) Override to configure user-details services.

/*
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }
  */

/*
    @Override//1 => in memmory
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }



    @Override//2=> in database
     protected void configure(AuthenticationManagerBuilder auth)throws Exception {
         auth
             .jdbcAuthentication()
             .dataSource(dataSource);
     }



     @Override
        protected void configure(AuthenticationManagerBuilder auth)throws Exception {
            auth
              .jdbcAuthentication()
              .dataSource(dataSource).usersByUsernameQuery("select username, password, true " +
              "from Spitter where username=?")
              .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?");
         }

 */
}