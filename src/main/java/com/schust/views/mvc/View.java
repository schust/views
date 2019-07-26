package com.schust.views.mvc;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

@Log4j2
@Component
@Data
public class View implements Observer {
	@Autowired
	Model model;
	@Autowired
	Controller controller;

	String text;

	@Override
	public void update(Observable observable, Object o) {
		int newValue = (int) o;
		log.info("update: " + newValue);

		this.text = Integer.toString(newValue);
	}

	public void buttonPress() {
		log.info("buttonPress");
		this.controller.update();
	}
}
