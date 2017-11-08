package ReflectiveHenry;

public class Weather {
	int temperature;
	int moisture;
	int rain;
	
	public Weather(int temperature, int moisture, int rain){
		  this.temperature = temperature;
		  this.moisture = moisture;
		  this.rain = rain;
	  }
	public void Update(int temp,int mois, int rain){
		this.temperature = temp;
		  this.moisture = mois;
		  this.rain = rain;
	}
}
