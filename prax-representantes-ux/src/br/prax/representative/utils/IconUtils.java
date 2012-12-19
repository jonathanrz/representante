package br.prax.representative.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import br.prax.utils.resources.ResourceManager;

public class IconUtils {

	private static final int SMALL_ICON = 20;
	private static final int MEDIUM_ICON = 50;
	private static final int LARGE_ICON = 100;

	private static Map<String, Image> smallIcons = new HashMap<>();
	private static Map<String, Image> mediumIcons = new HashMap<>();
	private static Map<String, Image> largeIcons = new HashMap<>();

	private IconUtils() {
	}

	public static Image getSmallIcon(String icon) {
		return getIconSafe(smallIcons, SMALL_ICON, icon);
	}

	public static Image getSmallIcon(String name, Image systemImage) {
		Image img = smallIcons.get(name);
		if (img == null) {
			img = new Image(Display.getCurrent(), systemImage.getImageData().scaledTo(SMALL_ICON, SMALL_ICON));
			smallIcons.put(name, img);
		}
		return img;
	}
	
	public static Image getMediumIcon(String icon) {
		return getIconSafe(mediumIcons, MEDIUM_ICON, icon);
	}

	public static Image getLargeIcon(String icon) {
		return getIconSafe(largeIcons, LARGE_ICON, icon);
	}

	// TODO: concurrency?
	private static Image getIconSafe(Map<String, Image> iconMap, int iconSize,
			String icon) {
		try {
			return getIcon(iconMap, iconSize, icon);
		} catch (Exception e) {
			// TODO: ?
		}
		return null;
	}

	private static Image getIcon(Map<String, Image> iconMap, int iconSize,
			String icon) throws MalformedURLException, IOException {
		Image img = null;
		if ((img = iconMap.get(icon)) == null) {
			InputStream res = ResourceManager.get().getResourceAsStream(icon);
			ImageData dt = new ImageData(res).scaledTo(iconSize, iconSize);
			img = new Image(Display.getCurrent(), dt);
		}
		return img;
	}


}
