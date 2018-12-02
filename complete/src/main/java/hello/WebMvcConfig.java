package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:/home/knightingal/download/linux1000/source/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:static/fromEnd/dist/");
        registry.addResourceHandler("/lib/**").addResourceLocations("classpath:static/fromEnd/node_modules/");
        registry.addResourceHandler("/frontEnd/**").addResourceLocations("classpath:static/fromEnd/");
    }
}
