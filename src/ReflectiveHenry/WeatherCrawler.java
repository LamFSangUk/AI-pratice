package ReflectiveHenry;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherCrawler implements Runnable{

	private static String URL="https://www.accuweather.com/en/us/west-lafayette-in/47906/current-weather/2135952";
	private Environment env;
	
	public WeatherCrawler(Environment env){
		this.env=env;
	}
	
	public static void main(String[] args) throws IOException{
		crawlPage();
	}
	
	static String crawlPage() throws IOException {
		String result;
		
		Document doc=Jsoup.connect(URL).get();
		Element elem=doc.getElementById("wrap");
		elem=elem.getElementById("wrap-content");
		elem=elem.getElementById("content");
		elem=elem.getElementById("detail-now");
		Elements elems=elem.getElementsByClass("temp");
		String text=elems.text();
		
		result = text.split(" ")[0];
		result = result.replaceAll("\\D+","");
		//System.out.println(result);
		
		elems=elem.getElementsByClass("stats");
		String[] parts=elems.text().split(" ");
		String hum=parts[7];
		String cloud=parts[17];
		
		result=result+'\n'+hum+'\n'+cloud;
		
		System.out.println(result);
		
		return result;
	}
	
	void update(Environment env) throws IOException{
		String result = this.crawlPage();

		String[] results = result.split("\n");
		for(int i=0;i<results.length;i++){
			results[i] = results[i].replaceAll("\\D+","");
			System.out.println(results[i]);
		}

		env.w.Update(Integer.parseInt(results[0]), Integer.parseInt(results[1]),Integer.parseInt(results[2]));
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				update(env);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
