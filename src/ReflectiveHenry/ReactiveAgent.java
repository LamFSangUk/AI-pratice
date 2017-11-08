package ReflectiveHenry;

import java.io.IOException;
import java.util.Scanner;

public class ReactiveAgent implements Runnable{
	private Environment env;
	
	public ReactiveAgent(Environment env){
		this.env=env;
	}
  public static void sensoring(Environment env){

    if(env.w.temperature>100)
      env.heater.turn_on();
    else
      env.heater.turn_off();
    if(env.w.moisture>100)
      env.moisturizer.turn_on();
    else
      env.moisturizer.turn_off();
    if(env.w.rain > 50)
      env.window.close();
    else
      env.window.open();
  }
@Override
	public void run() {
	// TODO Auto-generated method stub
		while(true){
			sensoring(env);
		  try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
}
