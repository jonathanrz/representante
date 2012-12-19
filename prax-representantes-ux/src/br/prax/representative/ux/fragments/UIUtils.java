package br.prax.representative.ux.fragments;

public class UIUtils {

	public static Integer getInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}
	}
	
}
