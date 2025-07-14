package com.stardriver.plataforma.filtro;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguracion {

    @Bean
    public FilterRegistrationBean<ApiKeyFiltro> configurarFiltro() {
        FilterRegistrationBean<ApiKeyFiltro> bean = new FilterRegistrationBean<>();
        bean.setFilter(new ApiKeyFiltro());
        bean.addUrlPatterns("/api/*");

        return bean;
    }

}
