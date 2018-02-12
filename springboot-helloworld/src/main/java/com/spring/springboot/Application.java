package com.spring.springboot;

import com.spring.springboot.initializer.MyApplicationContextInitializer1;
import com.spring.springboot.initializer.MyApplicationContextInitializer2;
import com.spring.springboot.listener.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.ManagementContextConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
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
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.boot.context.event.*;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.event.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.util.ServiceLoader;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
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


    public void fwefwef(){

        ServletContextInitializer ewfwef;
        WebApplicationInitializer wefwefwef;
        ApplicationContextInitializer wefwefwefwef;

        SpringBootConfiguration wer;
        EnableAutoConfiguration wrwer23;

        EnableScheduling we3r;
        EnableCaching werwer;

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


        //  3

        Condition ergerg;
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

        SpringApplicationAdminJmxAutoConfiguration fwe2323f;


//        AutoConfigureWebMvc fwef575466wef;
        MessageSourceAutoConfiguration gergerge456245645rg;

        WebMvcAutoConfiguration fewfwefwef;
        GroovyTemplateAutoConfiguration ggwegweg;

        WebMvcAutoConfiguration wefwefwe1340941309143f;

        ConfigurationWarningsApplicationContextInitializer wevwevwev;
        ContextIdApplicationContextInitializer gwegweg;
        DelegatingApplicationContextInitializer grgrgrg;
        ServerPortInfoApplicationContextInitializer fwefepfpe;


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


        MongoDataAutoConfiguration vczvzxvzxcv;
        AutoConfigurationImportFilter gwefwef;
        AutoConfigurationImportListener fwefwe3513451435;
        ApplicationContextInitializer fwefwefwef;


        WebMvcAutoConfiguration fwef234234324;
        SpringApplicationAdminJmxAutoConfiguration ergqhqrhqrh;


        //  6

        EmbeddedServletContainer fwef123123wef;
            JettyEmbeddedServletContainer r23r23r23r;
            TomcatEmbeddedServletContainer gqgerg43g34g;
            UndertowEmbeddedServletContainer gergergo090qergqrg;


        EmbeddedServletContainerFactory r23r23r2333452345r;
            AbstractEmbeddedServletContainerFactory fwefwef0203f;
                TomcatEmbeddedServletContainerFactory gwg4343t134twegweg;
                UndertowEmbeddedServletContainerFactory ggergeqrge314t143tqrg;
                JettyEmbeddedServletContainerFactory fwefqg34g341g;


        AbstractApplicationContext fwe090we0fw0ef;
            GenericApplicationContext fwfwefwef;
                GenericWebApplicationContext fwef092f023f;
                    EmbeddedWebApplicationContext fwefwef234234234;
                        AnnotationConfigEmbeddedWebApplicationContext wef0090wefwef;
                        XmlEmbeddedWebApplicationContext ergergpeorpogperg0909erg;



        EmbeddedServletContainerAutoConfiguration fwefoiwef989we89f;
        DispatcherServletAutoConfiguration fwefwef9090209f23f;


        ServletContextInitializer fwefwefwef23452435345;



    }

}

