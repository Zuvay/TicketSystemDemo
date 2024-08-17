package com.javaakademi.ticketsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Burada bize başta verdiği security sistemini bypass edip kendi sistemimizi yazıyoruz
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated()); //Bu kod auth olmayan kişi için erişim engeli demek
        httpSecurity.formLogin(Customizer.withDefaults()); //Bu bize postmande login formun html'ini döndürüyo. Basit bir login formunu tarayıcıda bize sağlıyor

        //Eğer bir login sayfam olsaydı bu kodu kullanırdık
//        httpSecurity.formLogin(form -> form
//                .loginPage("/login") // Giriş sayfanızın URL'sini belirtirsiniz
//                .defaultSuccessUrl("/home", true) // Giriş başarılı olduğunda yönlendirilmesi gereken sayfa
//                .permitAll() // Giriş sayfasının herkese açık olmasını sağlar
//        );


        httpSecurity.httpBasic(Customizer.withDefaults()); //Bu da postmande erişimi sağlatıyo. Bu olmadan da browser üzerinden erişim sağlanabiliyo ama eğer login formu kaldırırsak da direkt erişim sağlanıyo. Galiba auth sağlatıyoruz
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //Bu her seferinde bizim SessionId'mizin değişmesini sağlıyo

        return httpSecurity.build();
    }
}
