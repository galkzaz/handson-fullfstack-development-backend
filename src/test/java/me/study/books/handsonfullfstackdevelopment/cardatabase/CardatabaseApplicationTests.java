package me.study.books.handsonfullfstackdevelopment.cardatabase;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.study.books.handsonfullfstackdevelopment.cardatabase.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {
	@Autowired
	private CarController controller;
	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
