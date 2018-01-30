package com.gao.config;

import com.gao.interceptor.TestUrlInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class GlobalWebConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 通过配置ViewControllers 省去写一些controller 例如配置login页面 不用写LoginController了 直接配置
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /*favorPathExtension
        表明是否通过请求url来判断mediatype （优先级最高）默认值是true
        例如请求以/hotels.pdf为结尾 请求的mediatype将会设置为application/pdf 不论请求是否设置了Accept
    favorParameter
        表明是否通过参数来决定mediatype (优先级第二，低于请求路径扩展名) 默认值是false
        例如请求/hotels?format=pdf 请求的mediatype将会设置为application/pdf 不论请求是否设置了Accept
        想要这个参数生效必须通过setMediaTypes(Properties)来设置
    ignoreAcceptHeader
        是否全部忽略http header （优先级第三）默认值是false
    mediaTypes
        加入文件扩展名到mediatype的映射
    ignoreUnknownPathExtensions
        是否忽略文件扩展名与mediatype不匹配 默认值是true
        如果设置成false不匹配时会报HttpMediaTypeNotAcceptableException异常
    useJaf
        表明在映射文件名到mediatype时 是否用 Java Activation Framework作为备选方案
        这个选项要在favorPathExtension=true时配置*/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).useJaf(false).favorParameter(true).parameterName("mediaType")
                .ignoreAcceptHeader(true).defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
    }

    /**
     * Enable forwarding to the "default" Servlet.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation returns {@code null}
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestUrlInterceptor());
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is empty.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

}