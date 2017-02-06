package mt.edu.um.cs.rv.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import mt.edu.um.cs.rv.demo.valour.external_triggers.SpringMVCInterceptorExternalTrigger;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Autowired 
	SpringMVCInterceptorExternalTrigger springMVCInterceptorExternalTrigger;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(springMVCInterceptorExternalTrigger);
	}
	
	@Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }

}
