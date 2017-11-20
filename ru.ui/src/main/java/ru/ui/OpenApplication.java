package ru.ui;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class OpenApplication implements Task {

	private String url;

	public OpenApplication(String url) {
		this.url = url;
		
	}

	@Step("Open the application on login page")
	public <D extends Actor> void performAs(D actor) {
	
			BrowseTheWeb.as(actor).getDriver().get(url);
		
	}

	public static <T> Performable start(String url) {
		// TODO Auto-generated method instruments
		return Instrumented.instanceOf(OpenApplication.class).withProperties(
				url);
	}

}
