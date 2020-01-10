package zygulakov;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	private final String fileName =	"settings.json";
	
	public void set() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(fileName);
		if(!file.exists())
			file.createNewFile();
		
		Settings set = new Settings();
		
		set.setName("zy");
		set.setPassword("123");
		set.setUrl("jdbc:mysql://localhost:3306/test");
		mapper.writeValue(file, set);
		
		
		
	}
	
}
