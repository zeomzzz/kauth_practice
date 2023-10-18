package com.zeomzzz.kauthPractice.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.zeomzzz.kauthPractice.interceptor.SessionInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
//	@Autowired
//	SessionInterceptor sessionInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("GET", "POST", "PUT", "DELETE");
	}

//	// 인터셉터 설정 추가
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(sessionInterceptor)
//				.addPathPatterns("/**") // 다른 요청들은 다 인터셉터가 통제하겠음!
//				.excludePathPatterns("/api-user/checkId",
//						"/api-user/checkNickname",
//						"/api-user/login", 
//						"/api-user/signup", 
//						"/api-email/emailSendCode", 
//						"/api-email/emailSendPw", 
//						"/swagger-resources/**", // swagger도 로그인 안해도 볼 수 있도록 해주기~
//						"/swagger-ui/**", "/v2/api-docs");
//	}

}
