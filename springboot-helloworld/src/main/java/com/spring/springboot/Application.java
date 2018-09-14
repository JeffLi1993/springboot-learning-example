package com.spring.springboot;

import ch.qos.logback.classic.servlet.LogbackServletContainerInitializer;
import com.spring.springboot.initializer.*;
import com.spring.springboot.appListener.*;
import com.spring.springboot.mvcConfigure.WebConfig;
import com.spring.springboot.mvcConfigure.WebConfig2;
import com.spring.springboot.saRunListener.MySprAppRunLsnr;
import com.spring.springboot.scListener.MyListener;
import com.spring.springboot.scListener.MyServletContextListener;
import com.spring.springboot.autocfg.HelloAutoConfiguration;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.WebappServiceLoader;
import org.apache.tomcat.websocket.server.WsContextListener;
import org.apache.tomcat.websocket.server.WsSci;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcChildContextConfiguration;
import org.springframework.boot.actuate.endpoint.mvc.JolokiaMvcEndpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.boot.autoconfigure.data.mongo.MongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.autoconfigure.websocket.JettyWebSocketContainerCustomizer;
import org.springframework.boot.autoconfigure.websocket.TomcatWebSocketContainerCustomizer;
import org.springframework.boot.autoconfigure.websocket.UndertowWebSocketContainerCustomizer;
import org.springframework.boot.autoconfigure.websocket.WebSocketContainerCustomizer;
import org.springframework.boot.builder.ParentContextCloserApplicationListener;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.boot.context.FileEncodingApplicationListener;
import org.springframework.boot.context.config.AnsiOutputApplicationListener;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.config.DelegatingApplicationContextInitializer;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.boot.context.embedded.*;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationBeanFactoryMetaData;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.boot.context.event.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.boot.web.support.ServletContextApplicationContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.*;
import org.springframework.context.event.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextCleanupListener;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.ServletContextAwareProcessor;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;
import org.springframework.web.util.WebAppRootListener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.websocket.server.ServerEndpoint;
import java.util.ServiceLoader;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
//@SpringBootApplication
//@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = Tomcat.class)
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);

        app.addListeners(
                new MyApplicationStartingListener(),
                new MyApplicationFailListener(),
                new MyApplicationReadyListener(),
                new MyApplicationPreparedListener(),
                new MyEnvReadyListener(),
                new MyContextClosedListener(),
                new MyContextRefreshedListener(),
                new MyContextStartedListener(),
                new MyContextStoppedListener());

        app.addInitializers(
                new MyApplicationContextInitializer1(),
                new MyApplicationContextInitializer2());

        app.run(args);
    }




    public void fwefwef() {

        ApplicationRunner apprnnr;

        ServletContextInitializer ewfwef;
        WebApplicationInitializer wefwefwef;
        ApplicationContextInitializer wefwefwefwef;

        SpringBootConfiguration wer;
        EnableAutoConfiguration wrwer23;

        EnableScheduling we3r;
        EnableCaching werwer;

        EnableWebMvc fwefwefwef;

        SpringFactoriesLoader wer2323r23r;

        SpringApplicationRunListener wewerl;
        ApplicationListener fwefwef;

        ParentContextCloserApplicationListener ewf;
        FileEncodingApplicationListener fwefwe;
        AnsiOutputApplicationListener fwef;
        ConfigFileApplicationListener fwefewf;
        DelegatingApplicationListener ddddergerd;
        LiquibaseServiceLocatorApplicationListener gwgwegweg;
        ClasspathLoggingApplicationListener fwefwewefwef;
        LoggingApplicationListener fwefweflwefl;


        //  1

        //  org.springframework.context
        ApplicationContextInitializer wefwefwwwef;
        AutoConfigurationReportLoggingInitializer vnbvg;
        ServerPortInfoApplicationContextInitializer fefwefewf;
        //  javax.servlet
        ServletContainerInitializer svltContIniter2;
        //  org.springframework.web
        WebApplicationInitializer webAppIniter;
        //  org.springframework.boot.web.servlet
        ServletContextInitializer svltCntxIniter;


        //  2

//        SpringApplicationRunListeners springAppRunLsnrs;
        SpringApplicationRunListener springAppRunLsnr;
        EventPublishingRunListener ergergerg;
        ApplicationEvent we135rwer;
        SpringApplicationEvent erger34234;
        ApplicationEnvironmentPreparedEvent ewrwer;
        ApplicationPreparedEvent fwefw221ef;
        ApplicationReadyEvent feefw2ef;
        ApplicationFailedEvent efwefeeeeew;
        ApplicationStartingEvent wefwefwef222333;
        ApplicationStartedEvent fewiioweirf;
        ApplicationContextEvent erfer324;
        ContextClosedEvent fwefwef234234;
        ContextRefreshedEvent owefionwef;
        ContextStoppedEvent voiwne;
        ContextStartedEvent ovwieobwefe;
        ApplicationEventMulticaster gergerg;
        AbstractApplicationEventMulticaster ewwefwef;
        SimpleApplicationEventMulticaster sdgweg;
        ApplicationListener lsnr;
//            rergerg ergerg;
//                rergerg ergerg;


        ConditionalOnBean gwgweg;

        ConfigurationPropertiesAutoConfiguration gfergerg;


        Profile wefwef;

        Condition regerg;
        Conditional fwefwewef;

    }
        //  3

        Conditional fwefwdedwe;
        ConditionalOnWebApplication fwhjfgjfgjefwef;

        DispatcherServlet dispSvlt;
        SpringFactoriesLoader spFacldr;

        //  657567

        JmxAutoConfiguration gegerg;

        ServiceLoader svcLdr;
        ClassLoader clsLdr;
        SpringFactoriesLoader spFacLdr;


        //  4

//        AutoConfigureWebMvc sfsdff;
        WebMvcAutoConfiguration wefeeewefwef;

        WebApplicationInitializer fwefw2123123e;
        ApplicationContextInitializer vervwr324234;

        MessageSourceAutoConfiguration fef92309020934234;

        ApplicationListener gergergerg;
        ParentContextCloserApplicationListener grgergergerg;
        FileEncodingApplicationListener wgwegweg;
        DelegatingApplicationListener wefwe23423424fwef;

        MessageSourceAutoConfiguration ge23454325rgergerg;

        WebMvcAutoConfiguration grgweg;

        /*

            # AutoConfigureWebMvc auto-configuration imports
            org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc=\
            org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration,\
            org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
            org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration,\
            org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,\
            org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration,\
            org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration,\
            org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration

            # Application Listeners
            org.springframework.context.ApplicationListener=\
            org.springframework.boot.ClearCachesApplicationListener,\
            org.springframework.boot.builder.ParentContextCloserApplicationListener,\
            org.springframework.boot.context.FileEncodingApplicationListener,\
            org.springframework.boot.context.config.AnsiOutputApplicationListener,\
            org.springframework.boot.context.config.ConfigFileApplicationListener,\
            org.springframework.boot.context.config.DelegatingApplicationListener,\
            org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener,\
            org.springframework.boot.logging.ClasspathLoggingApplicationListener,\
            org.springframework.boot.logging.LoggingApplicationListener

            # AutoConfigureWebClient auto-configuration imports
            org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient=\
            org.springframework.boot.test.autoconfigure.web.client.WebClientRestTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
            org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration

        */

        ApplicationListener fw21111e;
        AutoConfigurationImportFilter gwrgwegweg;

        BackgroundPreinitializer gwegwegweg;

        SpringBootConfiguration fwefwe5367537357;

        ServletComponentScan fwefwef2443634613;
        ComponentScan fwefwefwe3214134f;
        ComponentScans fwefwefwefw451345351e;

        EnableAutoConfiguration feef242342343ef;
        EnableMBeanExport egwegwegweg;
        EnableScheduling gewrgwegweg;
        EnableWebMvc fwefwefwef133123123123;

        SpringApplicationAdminJmxAutoConfiguration fwe2323f;


//        AutoConfigureWebMvc fwef575466wef;
        MessageSourceAutoConfiguration gergerge456245645rg;

        WebMvcAutoConfiguration fewfwefwef;
        GroovyTemplateAutoConfiguration ggwegweg;

        ConfigurationWarningsApplicationContextInitializer wevwevwev;
        ContextIdApplicationContextInitializer gwegweg;
        DelegatingApplicationContextInitializer grgrgrg;
        ServerPortInfoApplicationContextInitializer fwefepfpe;

        CacheAutoConfiguration gerger56u356u356u;
        ApplicationContextInitializer gergerg34g34g34;

        /*

            # Application Context Initializers
            org.springframework.context.ApplicationContextInitializer=\
            org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer,\
            org.springframework.boot.context.ContextIdApplicationContextInitializer,\
            org.springframework.boot.context.config.DelegatingApplicationContextInitializer,\
            org.springframework.boot.context.embedded.ServerPortInfoApplicationContextInitializer

            # AutoConfigureCache auto-configuration imports
            org.springframework.boot.test.autoconfigure.core.AutoConfigureCache=\
            org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration

            # AutoConfigureDataJpa auto-configuration imports
            org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa=\
            org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration,\
            org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,\
            org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration

            # AutoConfigureDataMongo auto-configuration imports
            org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo=\
            org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration,\
            org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration

            # AutoConfigureJdbc auto-configuration imports
            org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc=\
            org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration,\
            org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration

            # Auto Configure
            org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
            org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,\
            org.springframework.boot.autoconfigure.aop.AopAutoConfiguration,\
            org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,\
            org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration,\
            org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration,\
            org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration,\
            org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration,\
            org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,\
            org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,\
            org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration,\
            org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.couchbase.CouchbaseRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.ldap.LdapDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.ldap.LdapRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.neo4j.Neo4jRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration,\
            org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration,\
            org.springframework.boot.autoconfigure.elasticsearch.jest.JestAutoConfiguration,\
            org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration,\
            org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
            org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration,\
            org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration,\
            org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration,\
            org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration,\
            org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,\
            org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration,\
            org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.JndiDataSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration,\
            org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
            org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration,\
            org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration,\
            org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration,\
            org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration,\
            org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration,\
            org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration,\
            org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration,\
            org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration,\
            org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration,\
            org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration,\
            org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration,\
            org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration,\
            org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration,\
            org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration,\
            org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration,\
            org.springframework.boot.autoconfigure.mobile.DeviceResolverAutoConfiguration,\
            org.springframework.boot.autoconfigure.mobile.DeviceDelegatingViewResolverAutoConfiguration,\
            org.springframework.boot.autoconfigure.mobile.SitePreferenceAutoConfiguration,\
            org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration,\
            org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration,\
            org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration,\
            org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,\
            org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration,\
            org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration,\
            org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration,\
            org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration,\
            org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration,\
            org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration,\
            org.springframework.boot.autoconfigure.session.SessionAutoConfiguration,\
            org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration,\
            org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration,\
            org.springframework.boot.autoconfigure.social.LinkedInAutoConfiguration,\
            org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration,\
            org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration,\
            org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration,\
            org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration,\
            org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration,\
            org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration,\
            org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration,\
            org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration,\
            org.springframework.boot.autoconfigure.websocket.WebSocketMessagingAutoConfiguration,\
            org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration

        */

        FlywayAutoConfiguration gergergergerg;

        MongoDataAutoConfiguration vczvzxvzxcv;
        AutoConfigurationImportFilter gwefwef;
        AutoConfigurationImportListener fwefwe3513451435;
        ApplicationContextInitializer fwefwefwef234234;

        SpringApplicationAdminJmxAutoConfiguration ergqhqrhqrh;


        //  6

        EmbeddedServletContainerAutoConfiguration fwefoiwef989we89f;
        DispatcherServletAutoConfiguration fwefwef9090209f23f;

        ConfigurableEmbeddedServletContainer gerg345354345;
        AbstractConfigurableEmbeddedServletContainer reer4545;
        EmbeddedServletContainerFactory r23r23r2333452345r;
        AbstractEmbeddedServletContainerFactory fwefwef0203f;
        TomcatEmbeddedServletContainerFactory gwg4343t134twegweg;
        UndertowEmbeddedServletContainerFactory ggergeqrge314t143tqrg;
        JettyEmbeddedServletContainerFactory fwefqg34g341g;

        EmbeddedServletContainer fwef123123wef;
        JettyEmbeddedServletContainer r23r23r23r;
        TomcatEmbeddedServletContainer gqgerg43g34g;
        UndertowEmbeddedServletContainer gergergo090qergqrg;

        DispatcherServlet ds;

        AbstractApplicationContext fwe090we0fw0ef;
        GenericApplicationContext fwfwefwef;
        GenericWebApplicationContext fwef092f023f;
        EmbeddedWebApplicationContext fwefwef234234234;
        AnnotationConfigEmbeddedWebApplicationContext wef0090wefwef;
        XmlEmbeddedWebApplicationContext ergergpeorpogperg0909erg;

        EnableWebMvc wefwefwef430143901490;
        WebMvcConfigurer vfdvf122323;
        WebMvcConfigurerAdapter erobeqribnoiqerbqerb;
        WebMvcConfigurationSupport vv2390923confi;
        DelegatingWebMvcConfiguration greogioeirg;
        WebMvcAutoConfiguration.EnableWebMvcConfiguration rogioerigerg;
        WebServlet df;
        WebListener egerg;
        WebFilter fwef23;
        WebInitParam eropowe;


        ServletContextInitializer fwefwefwef23452435345;

        SpringBootCondition erververv;

//        EndpointWebMvcManagementContextConfiguration erf2309230f923f;

        SpringApplicationAdminJmxAutoConfiguration grgergwg0909g23g;

        FreeMarkerTemplateAvailabilityProvider gergergerg93148951485915;
        ConditionalOnClass ergerg0314901943014;
        ConditionalOnBean gregergerg2039023;


        EnableScheduling fwef01092;
        ApplicationContextInitializer fwefwefwef1203910293;

        BeanPostProcessor gregeg013409014;

        ConfigurationProperties tohijioqehr;
        EnableConfigurationProperties eroignoinerng;

        ApplicationContext ac;
        RequestMapping reqMap;

        EnableAutoConfiguration foweio23;
        DataSourceAutoConfiguration ewoi2o3io2i3of;

        WebMvcConfigurerAdapter weadpt;

        HttpMessageConverter wewwe;
        ServletRegistrationBean wqqwq232323;

        //  start
        EmbeddedServletContainerCustomizer fwefwe2323;

        EmbeddedServletContainerFactory wewewe23232;
        ConfigurableEmbeddedServletContainer conownow;
        AbstractConfigurableEmbeddedServletContainer fwf23f23;
        AbstractEmbeddedServletContainerFactory wewe2322323;
        TomcatEmbeddedServletContainerFactory tomcatfs;
        UndertowEmbeddedServletContainerFactory undertowfs;
        JettyEmbeddedServletContainerFactory jettyfs;

        EmbeddedServletContainer cont;
        UndertowEmbeddedServletContainer wewe23f23f;
        TomcatEmbeddedServletContainer weiuifu23;
        JettyEmbeddedServletContainer gooi43gnoi2323;

        GenericApplicationContext gac;
        EmbeddedWebApplicationContext eac;
        AnnotationConfigEmbeddedWebApplicationContext aaa23223;
        XmlEmbeddedWebApplicationContext xmleac;

        //  end

        AnnotationConfigApplicationContext ac121;
        AnnotationConfigEmbeddedWebApplicationContext eac11231;

        EnvironmentAware wefwef;
        Environment wefwef23f23;

        JdbcTemplateAutoConfiguration auorooro;
        ServerProperties rweoiwnoeb;

        ApplicationListener al;
        ApplicationContextInitializer acInit;
        ParentContextCloserApplicationListener a23223;
        ServletContextListener scl;
        EmbeddedServletContainerInitializedEvent aa232323;

        ServerEndpoint se;
        WebMvcProperties www;
        WebMvcConfigurer aa22323;
        WebMvcAutoConfiguration abwbe232323;
        WebMvcRegistrations eger4334;

        WebApplicationInitializer wainit;
        SpringBootServletInitializer sbsinit;
        AbstractContextLoaderInitializer weoiow23;
        AbstractDispatcherServletInitializer absdispsvlinit;
        AbstractAnnotationConfigDispatcherServletInitializer a2oinoi23;

        ServletContext sc;
        org.apache.catalina.servlet4preview.ServletContext g34g304ijg09340g9;


        ImportBeanDefinitionRegistrar g34g98j9834g98h98h9;
        EnableAutoConfiguration aaa2323232112;
        CassandraAutoConfiguration ebqerbqerb2323;
        MongoAutoConfiguration d4gn3oi43o4ngoi34g;
        MongoDataAutoConfiguration qevqerbqerb23;
        MongoRepositoriesAutoConfiguration qoerinqeorbnoqerbno23902903;

        HelloAutoConfiguration aaaa23223;

        TransactionManagerCustomizers aaa232323;

        DataSourceAutoConfiguration erbeqb2223;


        //  ############################ WebMVC 相关 AutoConfiguration

        DispatcherServletAutoConfiguration erbqerbqeb323;
        HttpMessageConvertersAutoConfiguration g3g34g43;
        ServerPropertiesAutoConfiguration gr34go3ini3o4g;
        WebClientAutoConfiguration vrebe43g34g;
        EmbeddedServletContainerAutoConfiguration lnoienrboerb34g;

        //  ############################ Initializer -1

        org.apache.catalina.startup.ContextConfig gg245gweqreg34gg;
        org.apache.catalina.startup.EngineConfig g34go0930g94;
        org.apache.catalina.startup.HostConfig g3g3049gj0340g9;
        org.apache.catalina.startup.UserConfig gg0394jg0934g09;
        /**
         * 下面的 ServletContainerInitializer 有 上述 xxxConfig 相关 Listener 触发！
         * */

        //  ############################ Initializer 0

        /**
         * 类 ServletContainerInitializer 的 子类的 onStartup 方法是一个web应用中，我们的代码可以控制到的最早时间点。
         * 其 子类 SpringServletContainerInitializer 专门处理各种 WebApplicationInitializer；
         * 循环地 调起 各个 WebApplicationInitializer 的子类 的 方法 onStartup。
         *
         * 简单地说，SpringServletContainerInitializer 负责将 ServletContext 实例化并委托
         * 给用户定义的 WebApplicationInitializer 实现。
         * 然后每个 WebApplicationInitializer 负责完成初始化 ServletContext 的实际工作。
         * */

        //  ############################ ServiceLoader
        /**
         * responsible for loading SpringServletContainerInitializer
         * (implementation of ServletContainerInitializer) from that file
         *
         * Tomcat Startup Procedure:
         * 1, Tomcat initialize the ServletContext
         * 2, ContextConfig is notified with this context startup event
         * 3, service-loading is delegated to WebappServiceLoader<ServletContainerInitializer>
         * 4, WebappServiceLoader scans in WEB-INF/lib jars for the file
         *      META-INF/services/javax.servlet.ServletContainerInitializer inorder to load the implementation
         * 5, Once loaded return to step 3 and, ContextConfig will call implementation's
         *      (here SpringServletContainerInitializer) onStartup method which will do rest of the things.
         * */
        WebappServiceLoader eovenoribnoierb;

        /**
         * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
         * 总而言之，可以总结一下：
         * 0， 始祖级的 Tomcat 的方法 org.apache.catalina.core.StandardContext#startInternal() 调用各个 ServletContainerInitializer 的 onStartup；
         * 1， 其中一个 Initializer --- SpringServletContainerInitializer，启动 各个 WebApplicationInitializer（似乎 ContextLoaderListener 有同样的功效）；
         * 2， 接口 WebApplicationInitializer 的 方法onStartup 的参数是 ServletContext；
         * 2b, 其中 子类 SpringBootServletInitializer 有点特殊功能：拉起 ContextLoaderListener；
         *
         * 5， 接口 ApplicationContextInitializer 相关执行（在 SpringApplication 的 方法run，或者 @EnableAutoConfiguration），
         *     其 方法onStartup 的 参数是 ? extends ConfigurableApplicationContext。
         * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
         *
         * 补充，上面的说法 关于 WebApplicationInitializer 和 ContextLoaderListener 完全正确。
         * programmatic declaration and registration of servlet, filter and listener components，
         * these methods from within ServletContextListener#contextInitialized method
         * or ServletContainerInitializer#onStartup method.
         *
         * 各个 WebApplicationInitializer/ServletContextInitializer 是为了 "丰富" ServletContext，
         * 而 ServletContextListener（ContextLoaderListener）的功效也是 "找机会" "丰富" ServletContext。
         * 
         * TODO 这里说的“丰富”，是否就是 Root ApplicationContext 的初始化呢？
         * 
         * 再补充：上面的说法 关于 WebApplicationInitializer 和 ContextLoaderListener 完全错误！
         * WebApplicationInitializer 与 ContextLoaderListener 没有任何对等关系！
         * 其实 ContextLoaderListener 比较简单，监听容器的某个事件，然后触发执行 initWebApplicationContext，没有其他逻辑；
         * 而 WebApplicationInitializer 并不简单，首先，它是一个接口，可以有多个子类，这些子类都会被 SpringServletContainerInitializer
         * 唤起；而且 WebApplicationInitializer 职责稍有不同，包括不限于
         * [ContextLoaderListener 和] DispatcherServlet，主要是配置 DispatcherServlet。
         * 
         * 由此可见，ContextLoaderListener 的作用时间很靠前，而 WebApplicationInitializer 作用时间比较靠后。
         * */

        /**
         * TODO 有个问题：
         * 接口 ServletContainerInitializer 的 实现类 设置在 某个文本文件中，由 某个 Listener 获取并且实例化。
         * 这个 Listener 是什么？--- ContextConfig ！
         *
         * Tomcat has LifecycleListeners those will listen to lifecycle events like start, stop etc.
         * org.apache.catalina.startup.ContextConfig is such a startup event listener for a
         * ServletContext that configures the properties of that ServletContext, and the associated defined servlets.
         * */

        ServletContainerInitializer rthr34oi;
            WsSci swioeowie;
            SpringServletContainerInitializer noin340h89034;
            LogbackServletContainerInitializer aaa34g09340g9j09;
            MyServletContainerInitializer g3ig039g093k4g0k; //   No Recognized

        /**
         * Spring WebApplicationInitializer provides a programatic way to configure the
         * Spring DispatcherServlet and ContextLoaderListener in Servlet 3.0+ compliant
         * servlet containers , rather than adding this configuration through a web.xml file.
         * */
        WebApplicationInitializer niog340;
            SpringBootServletInitializer noi3480384g;
            AbstractContextLoaderInitializer n03n4g083490n;
                AbstractDispatcherServletInitializer n034ng03409g;
                    AbstractAnnotationConfigDispatcherServletInitializer aaa0394g0934g;
            JerseyAutoConfiguration.JerseyWebApplicationInitializer gbgbg098hg34g34;
            MyWebApplicationInitializer f3gi3ng3o4igno3in4ogi3o4gio;    //  No Recognized
            MyWebApplicationInitializer2 f3gg3498j9g834984ogi3o4gio;    //  No Recognized

        /**
         * 注册Servlet、Filter、Listener的方法，两种：
         *
         * 1， （war）注册到 WebApplicationInitializer 的实现类中：
         *      servletContext.addListener()
         *      servletContext.addFilter()
         *      servletContext.addServlet()
         * 2， （jar）注册到任意一个 @Configuration 配置类中：
         *      ServletRegistrationBean
         *      FilterRegistrationBean
         *      ServletListenerRegistrationBean
         * 3，  使用注解：
         *      WebServlet
         *      WebListener
         *      WebFilter
         * */

        /**
         * WebApplicationInitializer 与 web.xml 重叠部分
         *
         <servlet>
           <servlet-name>dispatcher</servlet-name>
           <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
                    </servlet-class>
           <init-param>
             <param-name>contextConfigLocation</param-name>
             <param-value>/WEB-INF/spring/dispatcher-config.xml</param-value>
           </init-param>
           <load-on-startup>1</load-on-startup>
         </servlet>

         <servlet-mapping>
           <servlet-name>dispatcher</servlet-name>
           <url-pattern>/</url-pattern>
         </servlet-mapping>

         public class MyWebAppInitializer implements WebApplicationInitializer {
            @Override
            public void onStartup(ServletContext container) {
                XmlWebApplicationContext appContext = new XmlWebApplicationContext();
                appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

                ServletRegistration.Dynamic dispatcher =
                    container.addServlet("dispatcher", new DispatcherServlet(appContext));
                dispatcher.setLoadOnStartup(1);
                dispatcher.addMapping("/");
            }
         }
         * */

        //  ############################ AutoConfiguration 2 EmbeddedServletContainerAutoConfiguration

        /**
         * 这里有个问题：
         * ServletContextInitializer 与 ContextLoaderListener 有什么关系？
         *
         * 一系列 ServletContextInitializer 的 处理起点 在 EnableAutoConfiguration，并且是其中一个类型：EmbeddedServletContainerAutoConfiguration。
         *
         * 而 ContextLoaderListener 的 起点似乎很早，早在 Servlet 容器 启动时，由 ServletContainerInitializer（SpringServletContainerInitializer）
         * 开始，到 WebApplicationInitializer（SpringBootServletInitializer），然后就是 ContextLoaderListener。
         *
         * */

        /**
         * 还可以对比 ServletContainerInitializer 和 WebApplicationInitializer ？
         * 根和茎茎的关系
         *
         * 还可以对比 ServletContainerInitializer 和 ServletContextInitializer ？
         * 根和茎茎的关系
         *
         * 还可以对比 ServletContextInitializer 和 WebApplicationInitializer ？
         * 功效相同，用法不同
         *
         * 还可以对比 WebApplicationInitializer 和 ApplicationContextInitializer ?
         * 完全没有相似性
         * */

        /**
         * ServletContextInitializer 与 WebApplicationInitializer 有什么关系？
         *
         * 应该拿 ServletContextInitializer 与 WebApplicationInitializer 对比，二者的成员方法的参数都是 ServletContext；
         * 类 SpringServletContainerInitializer 会 自动识别 到 WebApplicationInitializer，但 不会 自动识别 ServletContextInitializer。
         *
         * 注解如下：
         * Interface used to configure a Servlet 3.0+ context programmatically. Unlike WebApplicationInitializer,
         * classes that implement this interface (and do not implement WebApplicationInitializer) will not be
         * detected by SpringServletContainerInitializer and hence will not be automatically bootstrapped by
         * the Servlet container.
         *
         * 可见，ServletContextInitializer 和 WebApplicationInitializer 功效是相同的，估计仅仅是用法不同。
         * */

        /**
         * WebApplicationInitializer is used by a Servlet Container at startup of the web application
         * and provides a way for programmatic creating a web application(replacement for a web.xml file),
         * （可以说在 MVC 之前）
         * ApplicationContextInitializer provides a hook to configure the Spring application context
         * before it gets fully created
         * （可以说在 AC 过程中）
         * */


        EmbeddedServletContainerAutoConfiguration g43g34;

        EmbeddedServletContainerFactory g30g93094g0934;
            AbstractEmbeddedServletContainerFactory g34g03409gk3049gk09;
                JettyEmbeddedServletContainerFactory g34j0394g0349gk09;
                TomcatEmbeddedServletContainerFactory g30g304gk09;
                UndertowEmbeddedServletContainerFactory g3049gk0394kg09;

        ServletContextInitializer g30g90394g09;
            RegistrationBean g3gergp;
            ServletRegistrationBean g340j3094g;
            ServletListenerRegistrationBean g34gj03j4g09;
                FilterRegistrationBean g34gj0394g034gk09;
                DelegatingFilterProxyRegistrationBean g0349gj3094g09;

        /**
         * TODO 搞搞清楚
         * 有些 Listener 监控 Servlet 容器 的生命(Tomcat内部)；
         * 有些 Listener 监控 [Web]ApplicationContext 的生命 --- ServletContextListener；
         * 有些 Listener 监控 Application 的生命 --- ApplicationListener;
         *
         * 有些 Initializer 初始化 ServletContainer --- ServletContainerInitializer(SC + WebApplicationInitializer[])；
         * 有些 Initializer 初始化 WebApplication --- WebApplicationInitializer(SC);
         * 有些 Initializer 初始化 ServletContext --- ServletContextInitializer(SC)；
         * 有些 Initializer 初始化 [Web]ApplicationContext --- ApplicationContextInitializer(AC)；
         *
         * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
         * 上面的顺序，对应很正确
         * */

        //  ############################ Servlet Listener
        ServletContextListener oieoivoir34g34g;
            ContextLoaderListener vr3robinoi3bnio;
            WebAppRootListener j0923jf02093;
            ContextCleanupListener fff34ogin3oigo43i;
            WsContextListener aaa3gpompopo;
            IntrospectorCleanupListener fgogoi34goi;
            MyServletContextListener gg34g09j093jg904;  // Recognized
            MyListener jf293f982j3f9823;    // Recognized

        ServletContextEvent g34oinoi3n4ogi3no4ig;
            ServletContextAttributeEvent g3goim3oin4go3in4goin6;

        /**
         * 接口 ServletContextListener 可以实现，做一些 定制性 的事情；
         * 类 ContextLoaderListener 已经实现了 接口 ServletContextListener，
         * 借助 "工具类" ContextLoader 完成了一些事情了，算是一个输出性的东西，不容置喙。
         *
         * 接口 ContextLoaderListener 绝对不是“输出性的东西”，而且非常重要！
         * 监控了 [Root] WebApplicationContext 从无到有再到无 过程中的 重要节点！
         * 在此之前 一直在收集配置；再此之后，开始使用配置（初始化 WebApplicationContext），形成具有完整层级和正确功能的 AC！
         * 这个过程由 "某个事件" 触发，再由接口 ServletContextListener 的实现类 ContextLoaderListener 的某个成员方法 完成 ！
         */

        /**
         * SpringBoot 启动中，会查找 ApplicationContextInitializer 的子类，
         * 调起 其中的 各个 方法initialize。
         * */
        ApplicationContextInitializer verver34gj03g093j940;
            ServletContextApplicationContextInitializer g3oi3oi4gnoi;
            DelegatingApplicationContextInitializer g3o4g039g409;
            ServerPortInfoApplicationContextInitializer g34og34g09340g9;
            ContextIdApplicationContextInitializer g34ing034g093j4gj9;
            ConfigurationWarningsApplicationContextInitializer g34n0934g09j0;
            AutoConfigurationReportLoggingInitializer g34oin304g09340g9;
            MyApplicationContextInitializer1 init34f23f09j091;  //  Recognized
            MyApplicationContextInitializer2 init34f23f09j092;  //  Recognized
        /*
            ## springboot
            # Application Context Initializers
            org.springframework.context.ApplicationContextInitializer=\
            org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer,\
            org.springframework.boot.context.ContextIdApplicationContextInitializer,\
            org.springframework.boot.context.config.DelegatingApplicationContextInitializer,\
            org.springframework.boot.context.embedded.ServerPortInfoApplicationContextInitializer

            ## springboot-autoconfigure
            # Initializers
            org.springframework.context.ApplicationContextInitializer=\
            org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer,\
            org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer
        */


    //  ############################ PostProcessor

        BeanPostProcessor wepnip23p0g092;
            ServletContextAwareProcessor g34onoi3n4ogi34;
                WebApplicationContextServletContextAwareProcessor g3gon3oi4g;
            AbstractAdvisingBeanPostProcessor g34gpm03m094g;
                AbstractBeanFactoryAwareAdvisingPostProcessor g3009304g9;
                    AsyncAnnotationBeanPostProcessor g30j0394jg0934;
            BeanValidationPostProcessor g34ogn0934g;
            InstantiationAwareBeanPostProcessor g340j09g3409g34g;
                CommonAnnotationBeanPostProcessor gerg34g0934g09;
            EmbeddedServletContainerCustomizerBeanPostProcessor g34j093j4g093j4g0934g;
        //  ApplicationContextAwareProcessor
        EmbeddedServletContainerAutoConfiguration.BeanPostProcessorsRegistrar o34ig0m0384g;
        BeanFactoryPostProcessor g3g0934g09304;
        //  ServletComponentRegisteringPostProcessor aaa3og4in3ogino34;
            BeanDefinitionRegistryPostProcessor ff39h0394jg0934;
                ConfigurationClassPostProcessor g340g3n09gn0934jg034;
            ConfigurationBeanFactoryMetaData h0394g0934;
            PropertyResourceConfigurer a0g390g93j04;
                PlaceholderConfigurerSupport g3o4gin3oigo3i4;
                    PropertySourcesPlaceholderConfigurer aa3goi3nogi34;
            AbstractDependsOnBeanFactoryPostProcessor oi34ngo3n4oig3io4;
                EntityManagerFactoryDependsOnPostProcessor jg093j409g34;
                MongoClientDependsOnBeanFactoryPostProcessor g3gj09j039g4;


        //  ############################ Listener

        /**
         * 类 SpringApplicationRunListener 通过 自动配置被调起，
         * 其 子类 EventPublishingRunListener 专门处理 各种 ApplicationListener；
         * 循环地 调起 各个 ApplicationListener 的子类。
         * */

        SpringApplicationRunListener aprlsnr;
            EventPublishingRunListener g303049jg09;
            MySprAppRunLsnr g340g309g039k4g09;  //  Recognized


        //  All Recognized
        ApplicationListener allal;
            MyEnvReadyListener gj09j0934g;
            MyApplicationPreparedListener g30034g;
            MyApplicationStartingListener gj093jg90j3904g;
            MyApplicationFailListener gj039j4g093049g;
            MyApplicationReadyListener gj03j4g093j40g9;
            MyContextRefreshedListener g309j039g40934;
            MyContextClosedListener gj039jg093409g;
            MyContextStartedListener gj03jg903049j;
            MyContextStoppedListener gj039g03940g934g;
        /*
            ## springboot
            # Application Listeners
            org.springframework.context.ApplicationListener=\
            org.springframework.boot.ClearCachesApplicationListener,\
            org.springframework.boot.builder.ParentContextCloserApplicationListener,\
            org.springframework.boot.context.FileEncodingApplicationListener,\
            org.springframework.boot.context.config.AnsiOutputApplicationListener,\
            org.springframework.boot.context.config.ConfigFileApplicationListener,\
            org.springframework.boot.context.config.DelegatingApplicationListener,\
            org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener,\
            org.springframework.boot.logging.ClasspathLoggingApplicationListener,\
            org.springframework.boot.logging.LoggingApplicationListener

            ## springboot-autoconfigure
            # Application Listeners
            org.springframework.context.ApplicationListener=\
            org.springframework.boot.autoconfigure.BackgroundPreinitializer
        */

        ApplicationEvent g3ig30g0934gk09k;
            SpringApplicationEvent g3g34g34g;
                ApplicationEnvironmentPreparedEvent f3409309g4;
                ApplicationFailedEvent verver340gm09;
                ApplicationReadyEvent g34090934gj0j;
                ApplicationStartingEvent g3409093kg0934;
            ApplicationContextEvent g3m09m34g09;
                ContextRefreshedEvent g30m093jg0934;
                ContextStartedEvent go3ig093094gk;
                ContextStoppedEvent go3i4g093049g0k;

        //  ############################ Servlet Configure

        ContextLoader gregerg34gj093j409g;
        ServiceLoader oinepirg0394jg03j94;
        ClassLoader grg0934g0j3094g09;

        //  ############################ AutoConfiguration 1 WebMvc

        EnableWebMvc afef2232323;
        WebMvcAutoConfiguration fwefweg34ginoi3n4g;
        WebMvcConfigurer rbqebrqe43g;
            WebMvcConfigurerAdapter ewgtwrth3223;
                WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter g34g4hnoi42nho24ohi;
                JolokiaMvcEndpoint gj9034jg0394jg09;
                WebConfig g304gj093j4g;
                WebConfig2 g9384g9834hg98h;
//          WebMvcConfigurerComposite fff340gj3904gj9;

        /**
         * + @Configuration
         * 1， extends WebMvcConfigurationSupport           ：会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置
         * 2， extends DelegatingWebMvcConfiguration        ：会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置
         * 3， implements WebMvcConfigurer                  ：不会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置
         * 4， implements WebMvcConfigurer + @EnableWebMvc  ：会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置
         *
         * 第 3 种情况适用于，想保留 Spring-Boot 默认 MVC 配置 并仅想 补充一些 其他配置，可以只 继承 WebMvcConfigurer；
         * 同时，最好不使用使用 注解@Configuration，而应该使用 @Component。
         *
         * Important !
         * To customize the configuration imported by @EnableWebMvc, we should extend
         * the class WebMvcConfigurerAdapter and override the methods we want to do
         * related customization with. Our extended WebMvcConfigurerAdapter methods are
         * called back from WebMvcConfigurationSupport during configuration stage.
         * */

        /*
        * https://www.youtube.com/watch?v=uDl1qlJWE7A
        * https://www.youtube.com/watch?v=viP3VCx1X6w
        * */

        ServletListenerRegistrationBean onionoi34343;
        FilterRegistrationBean eroinoi23224;
        ServletRegistrationBean oeqrinboi45981450801;

        ImportBeanDefinitionRegistrar lknlknlk3434;
        ImportSelector g34g34;
        AutoConfigurationImportSelector greon3o4i;




        //  ############################ AutoConfiguration 3


        //  ############################ AutoConfiguration 4


        //  ############################ AutoConfiguration 5


        //  ############################ AutoConfiguration 6


        /*
        * spring.factories 文件有很多个，而且其中不止有 AutoConfigure 一种，
        * 还有 其他十多种，是否 所有的这些，都是通过 EnableAutoConfiguration 拉入？
        * 具体拉入逻辑需要研究研究，搞搞清楚。
        *
        *
        * spring.factories 文件的类型：
        *
        * （默认情况下，springboot 启动时，SpringFactoriesLoader 拉入的类型的顺讯如下，某几个多次出现）
        * ApplicationContextInitializer
        * ApplicationListener
        * SpringApplicationRunListener
        * EnvironmentPostProcessor
        * PropertySourceLoader
        * BeanInfoFactory
        * FailureAnalyzer
        * EnableAutoConfiguration
        * AutoConfigurationImportFilter
        * AutoConfigurationImportListener
        * TemplateAvailabilityProvider
        * ManagementContextConfiguration
        *
        * FailureAnalysisReporter
        * SpringDataJacksonModules
        * RepositoryFactorySupport
        * RepositoryFactorySupport
        * RepositoryFactorySupport
        * TestExecutionListener
        * ContextCustomizerFactory
        *
        * 应该是这样，spring-boot 启动，有一个繁复的过程；
        * 在这个过程中，有很多个阶段，不同的阶段，会需要不同的"配置"。
        *
        * 比如 ApplicationContextInitializer 相关阶段，需要 从 spring.factories 获取 "类型"ApplicationContextInitializer 的配置；
        * 而 ApplicationListener 相关阶段，需要 从 spring.factories 获取 "类型"ApplicationListener 的配置。
        * 然后 AutoConfiguration 相关阶段，需要 从 spring.factories 获取 "类型"AutoConfiguration 的配置。
        *
        * 大概情况应该就是这样的逻辑。
        *
        * 最重要的东西 就是 类 SpringFactoriesLoader，接受 类型 作为 参数key，获取对应类型的 配置。
        * */

        //  ############################ EnableXXX Anno

        EnableScheduling enSchd;
        EnableAspectJAutoProxy enAspJ;
        EnableAutoConfiguration enAuCfg;
        EnableWebMvc enWmvc;
        EnableCaching enCach;
        EnableLoadTimeWeaving enLdtmwv;
        EnableMBeanExport enMbn;
        EnableOAuth2Sso enOA;
        EnableConfigurationProperties enCfgPrp;

        /**
         * Enable 就是 "识别"功能 的开关；打开开关，就开始识别，关上开关，就不再识别。
         *
         * 比如， 使用了 注解@EnableScheduling，就开始满世界找 @Scheduled；如果没有使用，就忽略 @Scheduled。
         * 比如， 使用了 注解@EnableWebMvc，就开始满世界找 MVC 相关注解，比如各种 HandlerXXX，Controller，XXXAdapter之类。
         * */

        //  ############################ EnableXXX Anno Customize

        /**
         * 使用 AutoConfiguration 有两种做法
         * 1， 把 @Configuration 的类，加入 *.factories，作为 key EnableAutoConfiguration 的 value；
         *      这样的话，EnableAutoConfiguration 的 Importer 会 以 EnableAutoConfiguration 为类型 load 这个 类。
         * 2， 创建一个 注解 @EnableXXX；其定义本身 具有 注解 Import，把 @Configuration 的类 作为参数。
         *
         *
         * 接口 ImportSelector 声明了 一个方法 selectImports；
         *
         * 注解 Import 可以接受 三种类型的参数（可以被加载的类型）：
         *  ImportSelector 实现类 （ @EnableAutoConfiguration）
         *  Configuration 注解 （其他 @EnableXXX）
         *  ImportBeanDefinitionRegistrar 实现类 （其他。。。）
         *
         * */

        // TODO ApplicationListener 和 SpringApplicationRunListener 的处理顺序？

        EmbeddedServletContainerCustomizer wef029j3f02j30f9;
            ServerProperties g34g03j0934g;
            WebSocketContainerCustomizer gj0349gj034jg0934;
                TomcatWebSocketContainerCustomizer gg3409gj093;
                UndertowWebSocketContainerCustomizer gj0394jg0394jg;
                JettyWebSocketContainerCustomizer fg0943jg0394g;

        // TODO 以及 各种 其他 Customizer

        /**
         *
         * Spring Boot Initialization Steps:
         1, SpringApplication.run() creates EmbeddedWebApplicationContext application context;
         2, Calls its refresh() method;
         3, Refresh process reads annotations of the starting class TestSpring. It looks for import annotations.
         EnableAutoConfiguration is one of them. For an import annotation the refresh process gets the corresponding
         class from the annotation value and invokes its selectImports() method;
         4, In case of @EnableAutoConfiguration the corresponding class is EnableAutoConfigurationImportSelector
         whose selectImports() loads tons of other import selectors from the META-INF/spring.factories;
         5, This process continues recursively. Also, all bean definitions, that are inside these import selectors,
         are read. I.e. it includes beans defined by a method with the @Bean annotation, i.e. beans that require
         the Spring context to call the corresponding method automatically to instantiate them;
         6, The resfresh() continues and reaches onRefresh(), the createEmbeddedServletContainer() method is called inside;
         7, Among read bean defitions at the previous step, beans implementing ServletContextInitializer are
         searched for and instantiated. One of them is the bean, defined by the
         DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration#dispatcherServletRegistration()
         method of ServletRegistrationBean type that extends ServletContextInitializer. As you can guess from the
         name of the class, such initializers add a given servlet (in this case DispatcherServlet) to a given
         ServletContext, when their onStartup() method is invoked;
         8, A tomcat embedded server is created (not started completely yet). All found ServletContextInitializers
         at the previous step are passed to this tomcat initialization - this is where the onStartup() methods of
         those ServletContextInitializers are called and DispatcherServlet gets created and registered as servlet;
         9, End of onRefresh() of application context;
         10,The finishRefresh() is called where tomcat is finally started by TomcatEmbeddedServletContainer.start();
         11,End of refresh() of application context and other final initialization steps;
         12,The app is running.
         * */

}

