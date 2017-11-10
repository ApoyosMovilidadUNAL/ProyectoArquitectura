package co.unal.sm.servicios;

import java.io.FileInputStream;
import java.util.Properties;

public class App {
	
	private static Properties properties = new Properties();
	
	private static String sysvar = "SMARTHOMESERVER_HOME";
	
	public static String getSYSVAR(){
		return sysvar;
	}
	
	public static void init() {
		
		try {
			properties.load(new FileInputStream(System.getenv(sysvar) + "/config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}
	
}
