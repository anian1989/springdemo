package com.fanhanfei.springweb;

import com.fanhanfei.springweb.config.DateConverter;
import com.fanhanfei.springweb.config.InternalApiInterceptor;
import com.fanhanfei.springweb.config.SwaggerConfiguration;
import com.fanhanfei.springweb.config.WebConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(SwaggerConfiguration.class)
public class WebContainer
        implements
        WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>,
        WebMvcConfigurer,
        ApplicationContextAware {

    private static final String SERVER_PORT_KEY = "SERVER_PORT";

    private ApplicationContext applicationContext;

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        String portStr = System.getenv(SERVER_PORT_KEY);
        Integer port = StringUtils.isBlank(portStr) ? 8080 : Integer.valueOf(portStr);
        factory.setPort(port);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(applicationContext.getBean(InternalApiInterceptor.class))
                .addPathPatterns(WebConstants.INTERNAL_ROUTE_PREFIX + "/**");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));

    }
}
