package com.schust.views.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IntegrationTest {
	@Autowired
	Model model;

	@Autowired
	View view;

	@Autowired
	Controller controller;

	@Test
	@DisplayName("Context loads")
	public void test0() {
		assertNotNull(model);
		assertNotNull(view);
		assertNotNull(controller);
	}

	@Test
	@DisplayName("Button press is propagated")
	public void test1() {
		// precondition
		assertNull(view.getText());
		assertEquals(0, model.getState());

		// step
		view.buttonPress();

		// postcondition
		assertEquals("1", view.getText());
		assertEquals(1, model.getState());
	}

	@Test
	@DisplayName("Button press is propagated [5 more]")
	public void test2() {
		// precondition
		assertEquals("1", view.getText());
		assertEquals(1, model.getState());

		// step
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();

		// postcondition
		assertEquals("6", view.getText());
		assertEquals(6, model.getState());
	}
}
