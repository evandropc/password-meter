package br.com.cavichioli.passwordmeter;


import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Application.class, scopedProxy = ScopedProxyMode.TARGET_CLASS, excludeFilters = @ComponentScan.Filter(Controller.class))
@Import(EmbeddedServletContainerAutoConfiguration.class)
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.showBanner(false);
        return application.sources(Application.class).web(true);
    }

}
