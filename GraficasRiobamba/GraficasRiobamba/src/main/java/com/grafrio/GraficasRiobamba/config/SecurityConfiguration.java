package com.grafrio.GraficasRiobamba.config;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override 
	protected void configure( HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(
				"/",
            	"/registration**",
                "/js/**",
                "/css/**",
                "/img/**",
                "/h2-console/**",
                "/webjars/**").permitAll()
				 .and().csrf().ignoringAntMatchers("/h2-console/**")
		         .and().headers().frameOptions().sameOrigin()
				.and()
				.formLogin()
				.loginPage("/PortafolioEmpresarial/login")
				.permitAll()
				.successForwardUrl("/PortafolioEmpresarial/private")
				.and()
				.logout()
				.permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/PortafolioEmpresarial/logout"))
				.logoutSuccessUrl("/PortafolioEmpresarial");  
		}
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user").password(passwordEncoder().encode("user")).roles("ADMIN");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}