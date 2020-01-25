package com.canemreayar.bookshop;

import com.canemreayar.bookshop.service.BookService;
import com.canemreayar.bookshop.service.BookServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookShopApplication {

	@Bean
	public BookService bookService(){ return new BookServiceImpl(); }

	@Bean
	public RestTemplate restTemplate(){ return new RestTemplate();}




	public static void main(String[] args) {
		SpringApplication.run(BookShopApplication.class, args);
	}
}
