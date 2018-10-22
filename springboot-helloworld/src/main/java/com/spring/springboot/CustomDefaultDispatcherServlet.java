@Configuration
public class CustomDefaultDispatherServlet {

    @Bean
    public DispatcherServlet dispatcherServlet()
    {
        DispatcherServlet servlet = new DispatcherServlet();

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setDisplayName("Self Administration Nx");

        // Registers the application configuration with the root context
        rootContext.setConfigLocation("com.xyz.mnp.config");
        BeanFactoryLocator locator = ContextSingletonBeanFactoryLocator.getInstance("classpath:beanRefContext.xml");
        BeanFactoryReference parentContextRef = locator.useBeanFactory("sharedContext");
        ApplicationContext parentContext = (ApplicationContext) parentContextRef.getFactory();
        rootContext.setParent(parentContext);
        rootContext.register(WebConfigurer.class);
        servlet.setApplicationContext(rootContext);
        return servlet;
    }

}
