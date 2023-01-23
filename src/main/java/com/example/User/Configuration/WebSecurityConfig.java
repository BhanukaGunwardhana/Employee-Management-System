package com.example.User.Configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import lombok.Data;

@EnableWebSecurity
@Data
public class WebSecurityConfig{
    public static final String [] whiteListURL= {"/userregistration","/verifyuserregistration"};
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(5);
    }

    @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.
			cors().
			and().
			csrf().
			disable().
			authorizeHttpRequests().
			antMatchers(whiteListURL).permitAll();

		return http.build();
		
	}
}