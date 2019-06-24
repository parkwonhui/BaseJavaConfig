package com.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.base.comm.interceptor.LoginInterceptor;

@EnableWebMvc
@ComponentScan(basePackages={"com.base.controller"})
public class ServletConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
		
	}	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
    @Bean
    public LoginInterceptor loginLogInterceptor() {
          return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry)  {
          InterceptorRegistration interceptor =  registry.addInterceptor(loginLogInterceptor());
          interceptor.addPathPatterns("/**");
          registry.addInterceptor(localeChangeInterceptor());  // 인터셉터 등록
    }
    
    // 언어 변경을 위한 인터셉터 생성
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    	interceptor.setParamName("lang");
    	return interceptor;
    }
}
