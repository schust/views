package com.schust.views.mvp;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component("mvpView")
@Data
public class View {
	@Autowired
	private Presenter presenter;
	private String text;

	public void buttonPress() {
		log.info("buttonPress");
		presenter.buttonPress();
	}
}
