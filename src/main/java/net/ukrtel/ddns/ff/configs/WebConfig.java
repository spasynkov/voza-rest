package net.ukrtel.ddns.ff.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"net.ukrtel.ddns.ff.web"})
public class WebConfig {
}
