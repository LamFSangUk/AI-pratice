package ReflectiveHenry;
import java.io.IOException;

import ReflectiveHenry.WeatherCrawler;

public class Environment{
	Moisturizer moisturizer;
	Heater heater;
	Window window;
	Weather w;
	
	public Environment() throws IOException{
		w = new Weather(0,0,0);
		moisturizer = new Moisturizer();
		heater = new Heater();
		window = new Window();
	}
	  
}