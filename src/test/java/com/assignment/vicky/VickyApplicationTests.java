package com.assignment.vicky;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.vicky.controller.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class VickyApplicationTests {

	@Autowired
	private HomeController controller;

	
	@Test
	void contextLoads() {
	}

	@Test
	void testController() {
		assertThat(controller).isNotNull();  
	}

}
