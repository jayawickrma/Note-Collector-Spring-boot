package lk.ijse.note_collector_V2.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityCoonfig {
    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
            httpSecurity.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(req->req.requestMatchers("api/v1/auth/**")
                    .permitAll()
                            .anyRequest()
                            .authenticated())

                    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider()
                    .addFilterBefore();
            return httpSecurity.build()
        }
        public AuthenticationProvider authenticationProvider(){
            DaoAuthenticationProvider dap =new DaoAuthenticationProvider();

            dap.setUserDetailsService();
        }
}
