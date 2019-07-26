package com.schust.views.mvc;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Log4j2
@Component("mvcModel")
@Data
public class Model extends Observable {
	private int state;

	public void change() {
		log.info("change");
		state++;
		this.setChanged();
		this.notifyObservers(state);
	}
}
