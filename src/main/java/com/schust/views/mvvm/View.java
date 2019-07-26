package com.schust.views.mvvm;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component("mvvmView")
@Data
public class View {
	@Autowired
	private ViewModel viewModel;

	private StringProperty textProperty = new SimpleStringProperty();
	private BooleanProperty buttonPressedProperty = new SimpleBooleanProperty();

	@PostConstruct
	public void init() {
		this.textProperty.bindBidirectional(viewModel.getTextProperty());
		this.buttonPressedProperty.bindBidirectional(viewModel.getButtonPressedProperty());
	}

	public void buttonPress() {
		this.buttonPressedProperty.set(true);
		this.buttonPressedProperty.set(false);
	}
}
