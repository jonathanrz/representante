package br.prax.representative;

import org.eclipse.swt.widgets.Display;

import br.prax.representative.ux.MainUX;

public class Main {
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		try {
			MainUX window = new MainUX();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
