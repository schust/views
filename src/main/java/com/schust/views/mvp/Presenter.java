package com.schust.views.mvp;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.Observer;

@Log4j2
@Component("mvpPresenter")
@Data
public class Presenter implements Observer {
	@Autowired
	private View view;
	@Autowired
	private Model model;

	@PostConstruct
	public void setup() {
		this.model.addObserver(this);
	}

	public void buttonPress() {
		model.change();
	}

	@Override
	public void update(Observable observable, Object o) {
		Integer newState = (Integer) o;
		view.setText(newState.toString());
	}
}
