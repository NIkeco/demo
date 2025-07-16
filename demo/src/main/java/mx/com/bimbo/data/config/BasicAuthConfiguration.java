package mx.com.bimbo.data.config;

import java.beans.Customizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class BasicAuthConfiguration {

	   @Value("${app.security.username}")
	    private String userName;

	    @Value("${app.security.password}")
	    private String password;

	    @Value("${app.security.rol}")
	    private String rol;
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        
	    	http.csrf(csrf -> csrf.ignoringRequestMatchers( "/api/lealtad/altaUsuario",
	    			"/api/lealtad/consultaSaldo",
	    			"/api/lealtad/registraPuntos",
	    			"/api/lealtad/registraCompra"))
	    		.authorizeHttpRequests(authorizeRequest ->
	                        authorizeRequest
	                                .requestMatchers("/api/lealtad/altaUsuario").hasRole(rol)
	                                .requestMatchers("/api/lealtad/consultaSaldo").hasRole(rol)
	                                .requestMatchers("/api/lealtad/registraPuntos").hasRole(rol)
	                                .requestMatchers("/api/lealtad/registraCompra").hasRole(rol)
	                                .anyRequest().authenticated())
	                .httpBasic(withDefaults());
	        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService(){
	        PasswordEncoder encoder = passwordEncoder();
	        UserDetails userDetails = User.builder().username(userName).password(encoder.encode(password)).roles(rol).build();	        
	        return new InMemoryUserDetailsManager(userDetails);

	    }

	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

}
