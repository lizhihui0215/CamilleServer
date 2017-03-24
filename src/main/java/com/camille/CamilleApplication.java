package com.camille;

import com.camille.controller.TAnimalServices;
import com.camille.controller.TUserService;
import com.camille.model.TAnimal;
import com.camille.model.TDog;
import com.camille.model.TUser;
import com.camille.storage.StorageProperties;
import com.camille.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CamilleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamilleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Bean
	CommandLineRunner test(TUserService service, TAnimalServices animalServices){
		return (args) -> {
			TUser user = new TUser();
			user.username = "lizhihui0215";
			user.password = "dsn4cgwyA";

			TAnimal dog = new TAnimal();
			dog.name = "dog1";
			dog.age = "age1";

			TAnimal dog2 = new TAnimal();
			dog2.name = "dog2";
			dog2.age = "age2";


			TAnimal dog3 = new TAnimal();
			dog3.name = "dog3";
			dog3.age = "age3";

			user.dogs = new HashSet();
			animalServices.save(dog);
			animalServices.save(dog2);
			animalServices.save(dog3);


			user.dogs.add(dog);
			user.dogs.add(dog2);
			user.dogs.add(dog3);

			service.save(user);


		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**");
			}
		};
	}

}
