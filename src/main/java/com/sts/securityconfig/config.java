
package com.sts.securityconfig;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sts.userservices.UserDetailsServicesImpl;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class config extends WebSecurityConfigurerAdapter {

	
	@Bean
    public UserDetailsService getUserDetailService() {
    	return new UserDetailsServicesImpl();
    }
	
	 @Bean
	 public DaoAuthenticationProvider daoAuthenticationprovider() {
	   	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setUserDetailsService(this.getUserDetailService());
	    	provider.setPasswordEncoder(encoder());
	    return provider;
	 }
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationprovider());}
//	@Autowired
//    private UserDetailsServicesImpl userDetailsService;

//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    
//    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http
        	
        		.csrf()	
        		.disable()
        		.cors()
        		.disable()
        		.authorizeRequests()
            	.antMatchers("/ngo/**").hasRole("USER")
            	.antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("crowdfund/**","/generate_token")
                .permitAll() 
                .and()
                .formLogin();
        
        		
                

        
//        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
//        http.authenticationProvider(daoAuthenticationprovider());
//        DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
//        
//        return defaultSecurityFilterChain;
    }
    
    

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
   
    
    
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

//    @Bean
//    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
//        return new JwtAuthenticationFilter();
//    } 

    
}
