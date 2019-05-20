package club.zudianlv;

import club.zudianlv.config.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yinren
 * @date 2019/5/2
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ResourceConfig resourceConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //"file:C:/Users/lenovo/Pictures/zudianlv/"
        String location = "file:" + resourceConfig.getFileSpace() + "/";
        registry.addResourceHandler("/**")
                .addResourceLocations(location);
    }
}
