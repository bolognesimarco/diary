package com.mb.skuldyree.spring.be;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mb.skuldyree.spring.be.dao.SchoolClassRepository;
import com.mb.skuldyree.spring.be.dao.UserRepository;
import com.mb.skuldyree.spring.be.mvc.HibernateAwareObjectMapper;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	@Autowired
	private static UserRepository userRepository;

	@Autowired
	private static SchoolClassRepository schoolClassRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJacksonHttpMessageConverter.setObjectMapper(new HibernateAwareObjectMapper());
        mappingJacksonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(mappingJacksonHttpMessageConverter);
	}

}
