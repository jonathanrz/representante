package br.prax.utils.resources;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class IconUtils {

	private static final int SMALL_ICON = 20;
	private static final int MEDIUM_ICON = 50;
	private static final int LARGE_ICON = 100;

	private static Map<String, ImageIcon> smallIcons = new HashMap<>();
	private static Map<String, ImageIcon> mediumIcons = new HashMap<>();
	private static Map<String, ImageIcon> largeIcons = new HashMap<>();

	private IconUtils() {
	}

	public static ImageIcon getSmallIcon(String icon) {
		return getIcon(smallIcons, SMALL_ICON, icon);
	}

	public static ImageIcon getMediumIcon(String icon) {
		return getIcon(mediumIcons, MEDIUM_ICON, icon);
	}

	public static ImageIcon getLargeIcon(String icon) {
		return getIcon(largeIcons, LARGE_ICON, icon);
	}

	// TODO: concurrency?
	private static ImageIcon getIcon(Map<String, ImageIcon> iconMap,
			int iconSize, String icon) {
		String key = icon.toLowerCase();
		ImageIcon value;
		if ((value = iconMap.get(key)) == null) {
			value = new ImageIcon(Toolkit
					.getDefaultToolkit()
					.getImage(key)
					.getScaledInstance(iconSize, iconSize,
							java.awt.Image.SCALE_SMOOTH));
			iconMap.put(key, value);
		}
		return value;
	}

}
