package com.comsysto.wicketBoot.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Start-Page of the Web-Application.
 */
public class HomePage extends WebPage {

	public HomePage() {
		add(new Label("label", "It does work!"));
	}
}
