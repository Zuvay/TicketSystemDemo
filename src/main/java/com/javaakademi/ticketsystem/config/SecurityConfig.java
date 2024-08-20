package com.javaakademi.ticketsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired //İlgili db bağlantısı için service kısmına bu implementin class'ını yazacağız çünkü bu userdetailservice bir interface
    private UserDetailsService userDetailService;

    //Burada bize başta verdiği security sistemini bypass edip kendi sistemimizi yazıyoruz
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer -> customizer.disable()); //Tokeni disable etmezsek postmande çalışmıyor
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


    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //Böylece setlerken girilmiş olan password'ün 12. kuvvetini alarak kaydedilmiş şifreye dönüşecek. Kriptolanmamış hesaba erişemez ama. NoOpPasswordEncoder.getInstance() -> kriptolanmamışlar için bunu kullanıyorduk
        provider.setUserDetailsService(userDetailService); //Bu yapı bize service'de yazdığımız kodların işe yaramasını sağlıyor. Buraya başka bir ekleme yapmıyoruz
        return provider;
    }



    //Hardcode user üretmek
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userOne = User
//                .withDefaultPasswordEncoder() //Güvenli değil ileriki seviyede yeni bir şey var
//                .username("Ömer")
//                .password("123")
//                .roles("admin")
//                .build();
//        return new InMemoryUserDetailsManager(userOne);
//    }
}
