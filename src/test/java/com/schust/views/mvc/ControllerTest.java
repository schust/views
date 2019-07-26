package com.schust.views.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ControllerTest {

	@Mock
	Model model;

	@Mock
	View view;

	@InjectMocks
	Controller controller;

	@BeforeEach
	public void init() {
		controller.setup();
	}

	@Test
	@DisplayName("Controller exists")
	public void test1() {
		assertNotNull(controller);
	}

	@Test
	@DisplayName("Update changes model")
	public void test2() {
		controller.update();

		verify(model).change();
	}

	@Test
	@DisplayName("Controller registers view at model")
	public void test3() {
		verify(model).addObserver(view);
	}
}