package com.schust.views.mvvm;

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
	ViewModel viewModel;

	@Test
	@DisplayName("Context loads")
	public void test0() {
		assertNotNull(model);
		assertNotNull(view);
		assertNotNull(viewModel);
	}

	@Test
	@DisplayName("Button press is propagated")
	public void test1() {
		// precondition
		assertNull(view.getTextProperty().get());
		assertEquals(0, model.getState());

		// step
		view.buttonPress();

		// postcondition
		assertEquals("1", view.getTextProperty().get());
		assertEquals(1, model.getState());
	}

	@Test
	@DisplayName("Button press is propagated [5 more]")
	public void test2() {
		// precondition
		assertEquals("1", view.getTextProperty().get());
		assertEquals(1, model.getState());

		// step
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();
		view.buttonPress();

		// postcondition
		assertEquals("6", view.getTextProperty().get());
		assertEquals(6, model.getState());
	}
}
