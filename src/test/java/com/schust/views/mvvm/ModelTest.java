package com.schust.views.mvvm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ModelTest {

	Model model = new Model();

	@Test
	@DisplayName("Model exists")
	public void test1() {
		assertNotNull(model);
	}

	@Test
	@DisplayName("State is changed")
	public void test2() {
		assertEquals(0, model.getState());

		model.change();

		assertEquals(1, model.getState());
	}

	@Test
	@DisplayName("Change calls observers")
	public void test3() {
		Observer mockObserver = mock(Observer.class);
		model.addObserver(mockObserver);
		model.change();

		verify(mockObserver).update(model, model.getState());
	}
}