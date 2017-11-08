package ReflectiveHenry;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeatherCrawler {
	private static String URL="https://www.accuweather.com/en/us/west-lafayette-in/47906/current-weather/2135952";
	
	public static void main(String[] args) throws IOException{
		crawlPage();
	}
	
	static void crawlPage() throws IOException {
		Document doc=Jsoup.connect(URL).get();
		Element elem=doc.getElementById("wrap");
		elem=elem.getElementById("wrap-content");
		elem=elem.getElementById("content");
		elem=elem.getElementById("detail-now");
		Elements elems=elem.getElementsByClass("temp");
		String text=elems.text();
		System.out.println(text);
		elems=elem.getElementsByClass("stats");
		text=elems.text();
		System.out.println(text);
	}
	
}
