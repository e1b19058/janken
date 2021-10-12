package oit.is.z0682.kaizi.janken.security;

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
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user1").password("$2y$10$xFwurIrzQB28jPFAPdiAR.UENPp7OrvlwoBumspn10Qg9ZEPD.iNi").roles("USER");

    // $ sshrun htpasswd -nbBC 10 admin adm1n
    // htpasswdでBCryptエンコードを行った後の文字列をパスワードとして指定している．
    auth.inMemoryAuthentication().withUser("user2")
        .password("$2y$10$hJ4m88qZMn7caTkOhnkR6OhIa0N/fmSXsRvC.2sA5uOoEK8sLz51W").roles("USER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeRequests().antMatchers("/lec02/**").authenticated();
    http.logout().logoutSuccessUrl("/");
  }
}
