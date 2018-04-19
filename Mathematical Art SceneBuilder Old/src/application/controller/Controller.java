package application.controller;

import application.Model;
import application.view.View;

public class Controller {

	private Model m;
	private View v;
	
	public Controller(Model m, View v) {
		this.m = m;
		this.v = v;
	}
}
