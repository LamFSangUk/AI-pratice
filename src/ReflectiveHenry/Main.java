package ReflectiveHenry;

import java.io.IOException;

public class Main {
	static Environment env;
	static ReactiveAgent eric;
	static WeatherCrawler cw;
	
	public static void main(String[] args) throws IOException{
		env=new Environment();
		eric = new ReactiveAgent(env);
		cw=new WeatherCrawler(env);
		
		Thread agentThread = new Thread(eric);
		Thread crawlerThread = new Thread(cw);
		
		agentThread.start();
		crawlerThread.start();
	}
}
