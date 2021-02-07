package com.demo.final_check.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
//	@Autowired
//	UserController usercontroller;
	
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication()
//	            .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
//	            .and()
//	            .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
		 
		 
		 //auth.userDetailsService(inMemoryUserDetailsManager());
		 auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        LOGGER.info("Start");
	        return new BCryptPasswordEncoder();
	    }
	    
//	    
//	    @Bean
//	    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//	        LOGGER.info("Start");
////	        List<UserDetails> userDetailsList = new ArrayList<>();
////
////	        userDetailsList.add(
////	            User.withUsername("user")
////	                .password(passwordEncoder()
////	                .encode("pwd"))
////	                .roles("USER").build());
////	    	
////	        userDetailsList.add(
////	            User.withUsername("admin")
////	                .password(passwordEncoder()
////	                .encode("pwd"))
////	                .roles("ADMIN").build());
////	        
////	        userDetailsList.add(
////		            User.withUsername("anonymousUser")
////		                .password(passwordEncoder()
////		                .encode("pwd"))
////		                .roles("ANONYMOUS").build());
////	        
////	        
//
//	        LOGGER.info("End");
//	        return new InMemoryUserDetailsManager(UserController.userDetailList);
//	    }

	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	    	 httpSecurity.cors();

	        httpSecurity.csrf().disable().httpBasic().and()
	            .authorizeRequests()
	            .antMatchers("/users").permitAll()	          
	            .antMatchers("/movies").permitAll()
	            .antMatchers("/favourites").permitAll()
	            .antMatchers("/authenticate").permitAll()
	            .anyRequest().authenticated().and()
	            .addFilter(new JwtAuthorizationFilter(authenticationManager()));

	            
	    }
	    
}
