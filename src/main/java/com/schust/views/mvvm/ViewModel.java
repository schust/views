package com.schust.views.mvvm;

import javafx.beans.property.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.Observer;

@Log4j2
@Component("mvvmViewModel")
@Data
public class ViewModel implements Observer {
	@Autowired
	private Model model;

	private StringProperty textProperty = new SimpleStringProperty();
	private BooleanProperty buttonPressedProperty = new SimpleBooleanProperty();

	@PostConstruct
	public void init() {
		this.model.addObserver(this);
		this.buttonPressedProperty.addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				model.change();
			}
		});
	}

	@Override
	public void update(Observable observable, Object o) {
		Integer newState = (Integer) o;
		textProperty.set(newState.toString());
	}
}
