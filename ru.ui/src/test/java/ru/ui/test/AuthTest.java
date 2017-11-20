package ru.ui.test;
import static ru.ui.OpenApplication.start;
import java.io.IOException;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

	@RunWith(SerenityRunner.class)
	@WithTagValuesOf({"Regress", "Auth"})
	public class AuthTest {

		@Steps
		Actor manager = new Actor("manager");
		
		@Managed(driver = "iexplorer", uniqueSession = true)
		private WebDriver hisBrowser;

		@Before
		public void before() throws IOException {
			System.setProperty("webdriver.ie.driver",
					"src/test/recourse/webdriver/IEDriverServer.exe");
			manager.can(BrowseTheWeb.with(hisBrowser));

		}

		@Test
		public void shouldBeAbleToLoginAsADMIN() throws IOException {
			manager.attemptsTo(start("http://www.google.com"));
    		
		}

		@After
		public void afterTest() {
			hisBrowser.close();
			hisBrowser.quit();
		}
	}
