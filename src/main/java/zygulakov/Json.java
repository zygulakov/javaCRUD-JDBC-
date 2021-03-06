package zygulakov;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json { 
	private final String fileName = "settings.json";
	private Settings set;

	public Json() {
		// setting up all settings checking possibility of connection
		try {
			set = set();
			check();
		} catch (Exception e) {
		}

	}

	// method for checking possibility of connection
	private void check() {
		try {
			Connection conn = DriverManager.getConnection(set.getUrl(), set.getName(), set.getPassword());
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("check settings,wrong username or password");
			System.out.println("Exiting...");
			System.exit(0);

		}

	}

	// setup settings and get the settings obj
	private Settings set() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(fileName);
		// create sample settings file for user to customize
		// else get the settings from json file
		if (!file.exists()) {
			file.createNewFile();
			set = new Settings();
			set.setName("USERNAME HERE");
			set.setPassword("PASSWORD HERE");
			set.setUrl("URL OF YOUR DATABASE HERE");
			mapper.writeValue(file, set);
			System.out.println("\nplease setup setting.json file in your root directory of an app  and restart app\n"
					+ file.getAbsolutePath());
			return set;
		}

		// Json file to java object
		set = mapper.readValue(file, Settings.class);
		// set.setReady(true);
		return set;

	}

	public Settings getSettings() {
		return set;
	}
}
