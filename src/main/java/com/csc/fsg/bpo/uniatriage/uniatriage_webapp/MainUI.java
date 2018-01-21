package com.csc.fsg.bpo.uniatriage.uniatriage_webapp;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MainUI extends UI implements ViewDisplay {

	private static final long serialVersionUID = -9095716009771537846L;

	private Panel springViewDisplay;

	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);

		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
		
		getUI().getNavigator().navigateTo(TriageView.VIEW_NAME);
	}

}
