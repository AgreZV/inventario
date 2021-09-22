package cl.control.inventario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
public class Authentication extends WebSecurityConfigurerAdapter {
    @Value("${spring.security.user.name}")
    private String userAuth;
    @Value("${spring.security.user.password}")
    private String userPass;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser(userAuth)
                //.withUser("admin")
                .password(userPass)
                //.password("$2a$10$SDFnhA0LxbODvLlb059OQebBtMTuOigNZLNQx.CJvhjyogRQhrRAS")
                .roles("USER", "ADMIN")
                .and()
                .withUser("user")
                .password(userPass)
                //.password("$2a$10$SDFnhA0LxbODvLlb059OQebBtMTuOigNZLNQx.CJvhjyogRQhrRAS")
                .roles("USER")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN", "USER").and().
                requestCache().requestCache(new NullRequestCache()).and().
                httpBasic().and().
                cors().and().
                csrf().disable();
    }
}