package net.ukrtel.ddns.ff.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
@ComponentScan(basePackages = {"net.ukrtel.ddns.ff"})
public class RootConfig {
	@Bean
	public HttpMessageConverter gsonConverter() {
		return new GsonHttpMessageConverter();
	}
}
