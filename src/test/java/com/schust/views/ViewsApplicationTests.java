package com.schust.views;

import com.schust.views.mvc.Model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ViewsApplicationTests {

	@Test
	@DisplayName("Context loads")
	public void contextLoads() {
	}

	@Test
	@DisplayName("Service exists")
	public void helloWorldServiceExists(@Autowired Model model) {
		assertNotNull(model);
	}
}
