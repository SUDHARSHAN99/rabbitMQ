package com.adf;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.adf.filter.HttpRequestLoggerFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@SpringBootConfiguration
@EnableWebMvc
@EnableSwagger2
@ComponentScan
public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	@Bean
	 public FilterRegistrationBean < HttpRequestLoggerFilter > filterRegistrationBean() {
	  FilterRegistrationBean < HttpRequestLoggerFilter > registrationBean = new FilterRegistrationBean();
	  HttpRequestLoggerFilter customURLFilter = new HttpRequestLoggerFilter();

	  registrationBean.setFilter(customURLFilter);
	  registrationBean.addUrlPatterns("/rf/update-employment/*");
	  //registrationBean.setOrder(2); //set precedence
	  return registrationBean;
	 }
 
}
