package zygulakov;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.*;
@JsonAutoDetect
public class Settings {
	private String name;
	private String password;
	private String url;
	//check whether the settings are set by the user 
	private boolean ready;
	public boolean getReady() {
		return ready;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	public void setReady(boolean state) {
		ready = state;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
