package xmu.javaee.classmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomRestTemplate {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        List<HttpMessageConverter<?>> converters = template.getMessageConverters();
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                try {
                    List<MediaType> buf = new ArrayList<>();
                    buf.addAll(converter.getSupportedMediaTypes());
                    buf.add(MediaType.TEXT_PLAIN);
                    ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return template;
    }
}
