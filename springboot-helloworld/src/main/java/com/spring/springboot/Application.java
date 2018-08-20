package com.spring.springboot;

import com.spring.springboot.initializer.MyApplicationContextInitializer1;
import com.spring.springboot.initializer.MyApplicationContextInitializer2;
import com.spring.springboot.listener.*;
import com.spring.springboot.service.HelloAutoConfiguration;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcHypermediaManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.EndpointWebMvcManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.ManagementContextConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.logging.AutoConfigurationReportLoggingInitializer;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.autoconfigure.web.*;
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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.logging.LoggingApplicationListener;
import org.springframework.boot.context.event.*;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.context.event.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import javax.websocket.server.ServerEndpoint;
import java.util.ServiceLoader;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

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

        EndpointWebMvcManagementContextConfiguration erf2309230f923f;

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

        EnableAutoConfiguration aaa2323232112;
        CassandraAutoConfiguration ebqerbqerb2323;
        MongoAutoConfiguration d4gn3oi43o4ngoi34g;
        MongoDataAutoConfiguration qevqerbqerb23;
        MongoRepositoriesAutoConfiguration qoerinqeorbnoqerbno23902903;

        HelloAutoConfiguration aaaa23223;

        TransactionManagerCustomizers aaa232323;

        DataSourceAutoConfiguration erbeqb2223;


    }

}

