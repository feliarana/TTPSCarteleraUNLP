package com.cartelera.infocarteapi.config;

import com.cartelera.infocarteapi.security.CustomUserDetailsService;
import com.cartelera.infocarteapi.security.JwtAuthenticationEntryPoint;
import com.cartelera.infocarteapi.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
//                .csrf()
//                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/", "/**",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                        .permitAll()
                    .antMatchers(HttpMethod.GET,"/billboards", "/billboards/**", "/posts", "/posts/**",
                      "/comments/", "/comments/**", "/users/**")
                        .permitAll()

                    .antMatchers(HttpMethod.POST, "/billboards").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.POST, "/billboards/**").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.POST, "/posts").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.POST, "/posts/**").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.POST, "/comments").authenticated()
                    .antMatchers(HttpMethod.POST, "/comments/**").authenticated()

                    .antMatchers(HttpMethod.PATCH, "/billboards").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/billboards/**").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/posts").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.PATCH, "/posts/**").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.PATCH, "/comments").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/comments/**").hasAuthority("ADMIN")

                    .antMatchers(HttpMethod.DELETE, "/billboards").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/billboards/**").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/posts").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.DELETE, "/posts/**").hasAnyAuthority("ADMIN", "PROFESOR")
                    .antMatchers(HttpMethod.DELETE, "/comments").hasAuthority("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/comments/**").hasAuthority("ADMIN")

                    .antMatchers("/api/auth/**")
                        .permitAll()
                    .antMatchers("/users/checkUsernameAvailability")
                        .permitAll()
                    .antMatchers(HttpMethod.GET, "/api/users/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("*"));
    configuration.setAllowedMethods(Arrays.asList("HEAD",
      "GET", "POST", "PUT", "DELETE", "PATCH"));
    // setAllowCredentials(true) is important, otherwise:
    // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
    configuration.setAllowCredentials(true);
    // setAllowedHeaders is important! Without it, OPTIONS preflight request
    // will fail with 403 Invalid CORS request
    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}