package me.study.books.handsonfullfstackdevelopment.cardatabase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.Car;
import me.study.books.handsonfullfstackdevelopment.cardatabase.domain.CarRepository;
import me.study.books.handsonfullfstackdevelopment.cardatabase.web.CarController;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository repository;

    @Test
    public void saveCar() {
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
        // entityManager.persistAndFlush(car);
        repository.save(car);
        assertNotNull(car.getId());
    }
    @Test
  public void deleteCars() {;
    
    repository.deleteAll();
    assertFalse(repository.findAll().iterator().hasNext());
  } 
}
