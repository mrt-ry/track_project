package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.formLogin(login -> login // フォーム認証の記述開始開始
				.loginProcessingUrl("/login") // ユーザー名・パスワードの送信先URL
				.loginPage("/login") // ログイン画面のURL
				.defaultSuccessUrl("/") // ログイン成功後のリダイレクトURL
				.failureUrl("/login?error") // ログイン失敗後のリダイレクトURL
				.permitAll() // ログイン画面は未ログインでもアクセス可能
		).logout(logout -> logout // ログアウトの設定記述開始
				.logoutSuccessUrl("/login") // ログアウト成功後のリダイレクトURL
		).authorizeHttpRequests(authz -> authz // URLごとの認可設定記述開始
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // "/css/**"などはログイン無しでもアクセス可能
				// .mvcMatchers("/login").permitAll() // "/"はログイン無しでもアクセス可能
                .requestMatchers("/login").permitAll()
                // 下記設定は必要であればコメント解除して使用する。
				// .mvcMatchers("/general").hasRole("GENERAL") // "/general"はROLE_GENERALのみアクセス可能
				// .mvcMatchers("/admin").hasRole("ADMIN") // "/admin"はROLE_ADMINのみアクセス可能
				.anyRequest().authenticated() // 他のURLはログイン後のみアクセス可能 
		);
		return http.build();
    }
}