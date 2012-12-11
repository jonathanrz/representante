package br.prax.utils.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

	private static ResourceManager instance = new ResourceManager();

	public static ResourceManager get() {
		return instance;
	}

	private Map<String, InputStream> resources = new HashMap<>();

	private ResourceManager() {
	}

	// TODO: concurrency?
	public InputStream getResource(String path) throws MalformedURLException,
			IOException {
		InputStream in = resources.get(path);
		if (in == null) {
			in = new URL(path).openStream();
			resources.put(path, in);
		}
		return in;
	}

}
