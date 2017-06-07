package applications.temperature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;


public class TempMonitor implements Observer {
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	private String observedTemp;
	private String serviceName; 
	
	
	public TempMonitor(String sn) {
		serviceName = sn;
		observedTemp = "";
	}
	
	@Override
	public void update(Observable s, Object arg) {
		observedTemp = ((TempSensor) s).getState(); 
	}
	
	public String generateReport() {
		String str = serviceName + ": " + "Temperature Report at :" + now() +
				     " :: " + observedTemp + " Celsius";
		return str; 
	}

	private String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
    }
}
