package bg.softuni.armory.config;

import bg.softuni.armory.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LocaleChangeInterceptor localeChangeInterceptor;
    private final LoggingInterceptor loggingInterceptor;

    public WebConfig(LocaleChangeInterceptor localeChangeInterceptor, LoggingInterceptor loggingInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(loggingInterceptor);
    }
}
