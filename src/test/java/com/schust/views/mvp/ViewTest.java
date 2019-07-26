package com.schust.views.mvp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ViewTest {

	@InjectMocks
	View view;

	@Mock
	Presenter presenter;

	@Test
	@DisplayName("View exists")
	public void test1() {
		assertNotNull(view);
	}

	@Test
	@DisplayName("View has presenter")
	public void test2() {
		assertNotNull(view.getPresenter());
	}

	@Test
	@DisplayName("View has empty text")
	public void test3() {
		assertNull(view.getText());
	}

	@Test
	@DisplayName("Button press calls presenter")
	public void test4() {
		view.buttonPress();

		verify(presenter).buttonPress();
	}
}