package com.webservice.webservice.soap;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Collections;
import java.util.List;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    //MessageDispactureServalate
    //ApplicationContext
    //url --> /ws/*

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context)
    {

        MessageDispatcherServlet servlet =new MessageDispatcherServlet();

        servlet .setApplicationContext(context);
        servlet .setTransformWsdlLocations(true);
        return new  ServletRegistrationBean(servlet,"/ws/*");

    }
//ws/courses.wsdl
    //coursePort
    //nameSpace
    //coourse-details.xsd

@Bean(name="courses")
public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema)
{
    DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
    definition.setPortTypeName("CoursePort");
    definition.setTargetNamespace("http://in28minutes.com/courses");
    definition.setLocationUri("/ws");
    definition.setSchema(coursesSchema);
    return definition;
}
   @Bean
    public XsdSchema coursesSchema()
   {
       return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));

   }
    @Bean
    public XwsSecurityInterceptor securityInterceptor(){
        XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
        //Callback Handler -> SimplePasswordValidationCallbackHandler
        securityInterceptor.setCallbackHandler(callbackHandler());
        //Security Policy -> securityPolicy.xml
        securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
        return securityInterceptor;
    }

    @Bean
    public SimplePasswordValidationCallbackHandler callbackHandler() {
        SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("user", "password"));
        return handler;
    }

    //Interceptors.add -> XwsSecurityInterceptor
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

    @Bean(name="CustomerDetailsService")
    public DefaultWsdl11Definition defaultWsdl11DefinitionCustomer(XsdSchema CustomerSchema)
    {
        DefaultWsdl11Definition definition=new DefaultWsdl11Definition();
        definition.setPortTypeName("CustomerPort");
        definition.setTargetNamespace("http://DummyBank/CustomerDetails");
        definition.setLocationUri("/ws");
        definition.setSchema(CustomerSchema);
        return definition;
    }
    @Bean
    public XsdSchema CustomerSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("customer.xsd"));

    }

}
