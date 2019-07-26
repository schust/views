package com.schust.views.mvp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PresenterTest {

	@Mock
	View view;

	@Mock
	Model model;

	@InjectMocks
	Presenter presenter;

	@Test
	@DisplayName("Presenter exists")
	public void test1() {
		assertNotNull(presenter);
	}

	@Test
	@DisplayName("Presenter has view")
	public void test2() {
		assertNotNull(presenter.getView());
	}

	@Test
	@DisplayName("Presenter has model")
	public void test3() {
		assertNotNull(presenter.getModel());
	}

	@Test
	@DisplayName("Button press calls model")
	public void test4() {
		presenter.buttonPress();

		verify(model).change();
	}

	@Test
	@DisplayName("Update changes view")
	public void test5() {
		presenter.update(model, 1);

		verify(view).setText("1");
	}
}
