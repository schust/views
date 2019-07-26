package com.schust.views.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ViewTest {

	@Mock
	Model model;

	@InjectMocks
	View view;

	@Mock
	Controller controller;

	@Test
	@DisplayName("View exists")
	public void test1() {
		assertNotNull(view);
	}

	@Test
	@DisplayName("View has model")
	public void test2() {
		assertNotNull(view.getModel());
	}

	@Test
	@DisplayName("View has controller")
	public void test3() {
		assertNotNull(view.getController());
	}

	@Test
	@DisplayName("Button press calls controller")
	public void test4() {
		view.buttonPress();

		verify(controller).update();
	}

	@Test
	@DisplayName("View update changes state")
	public void test5() {
		view.update(model, 0);

		assertEquals("0", view.getText());
	}
}