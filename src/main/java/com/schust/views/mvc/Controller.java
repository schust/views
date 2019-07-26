package com.schust.views.mvc;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
@Data
public class Controller {
	@Autowired
	Model model;
	@Autowired
	View view;

	@PostConstruct
	public void setup() {
		this.model.addObserver(view);
	}

	public void update() {
		log.info("update");
		model.change();
	}
}
