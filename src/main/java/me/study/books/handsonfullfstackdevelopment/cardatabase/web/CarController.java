package me.study.books.handsonfullfstackdevelopment.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.Car;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.CarRepository;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;
	@CrossOrigin()
    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
