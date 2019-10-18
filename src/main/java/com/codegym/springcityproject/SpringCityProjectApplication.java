package com.codegym.springcityproject;

import com.codegym.springcityproject.formatter.CountryFormatter;
import com.codegym.springcityproject.service.CityService;
import com.codegym.springcityproject.service.CountryService;
import com.codegym.springcityproject.service.impl.CityServiceImpl;
import com.codegym.springcityproject.service.impl.CountryServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringCityProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCityProjectApplication.class, args);
    }

    @Configuration
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            CountryService countryService = appContext.getBean(CountryService.class);
            Formatter countryFormatter = new CountryFormatter(countryService);
            registry.addFormatter(countryFormatter);
        }
    }

    @Bean
    public CityService cityService() {
        return new CityServiceImpl();
    }

    @Bean
    public CountryService countryService() {
        return new CountryServiceImpl();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("ValidationMessages");
        return messageSource;
    }
}

