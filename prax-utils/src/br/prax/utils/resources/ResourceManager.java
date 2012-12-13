package br.prax.utils.resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class ResourceManager {

	private static ResourceManager instance = new ResourceManager();

	public static ResourceManager get() {
		return instance;
	}

	private Map<String, byte[]> resources = new HashMap<>();

	private ResourceManager() {
	}

	public byte[] getResource(String path) throws MalformedURLException, IOException {
		byte[] bts = null;
		if ( (bts = resources.get(path)) == null) {
			bts = IOUtils.toByteArray(getClass().getClassLoader().getResource(path));
			resources.put(path, bts);
		}
		return bts;
	}
	
	public InputStream getResourceAsStream(String path) throws MalformedURLException, IOException {
		return new ByteArrayInputStream(getResource(path));
	}

}
