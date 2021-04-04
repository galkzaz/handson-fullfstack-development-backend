package me.study.books.handsonfullfstackdevelopment.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.Car;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.CarRepository;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.Owner;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.OwnerRepository;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.User;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
    @Autowired
    private CarRepository repository;
    @Autowired
    private OwnerRepository orepository;
    @Autowired
    private UserRepository urepository;

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }
    /*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");;
			}
		};
	} */
    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            orepository.save(owner1);
            orepository.save(owner2);

            // Add car object with link to owners and save these to db.
            Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
            repository.save(car);
            car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
            repository.save(car);
            car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
            repository.save(car);
            //
            // username: user password: user
            
            urepository.save(new User("user", new BCryptPasswordEncoder().encode("user"), "USER"));
            // username: admin password: admin
            urepository
                    .save(new User("admin", new BCryptPasswordEncoder().encode("admin"), "ADMIN"));
        };
    }
}
