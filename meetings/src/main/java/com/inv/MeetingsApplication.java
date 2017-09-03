package com.inv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@EntityScan(basePackageClasses = {MeetingsApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class MeetingsApplication {
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {

		return new HibernateJpaSessionFactoryBean();
	}

	public static void main(String[] args) {

		SpringApplication.run(MeetingsApplication.class, args);
	}
}
