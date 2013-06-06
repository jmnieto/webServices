/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.WeatherHttpPost_WeatherHttpPost_Client.java
 * @description WeatherHttpPost_WeatherHttpPost_Client
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2013-06-05T19:20:32.816+02:00
 * Generated source version: 2.7.4
 * 
 */
public final class WeatherHttpPost_WeatherHttpPost_Client {

    /** The Constant SERVICE_NAME. */
    private static final QName SERVICE_NAME = new QName("http://ws.cdyne.com/WeatherWS/", "Weather");

    /**
	 * Instantiates a new weather http post_ weather http post_ client.
	 */
    private WeatherHttpPost_WeatherHttpPost_Client() {
    }

    /**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = Weather.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        Weather ss = new Weather(wsdlURL, SERVICE_NAME);
        WeatherHttpPost port = ss.getWeatherHttpPost();  
        
        {
        System.out.println("Invoking getWeatherInformation...");
        org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfWeatherDescription _getWeatherInformation__return = port.getWeatherInformation();
        System.out.println("getWeatherInformation.result=" + _getWeatherInformation__return);


        }
        {
        System.out.println("Invoking getCityWeatherByZIP...");
        java.lang.String _getCityWeatherByZIP_zip = "_getCityWeatherByZIP_zip1745666373";
        org.noip.wuidl.tourguide.api.wsdl.weather.WeatherReturn _getCityWeatherByZIP__return = port.getCityWeatherByZIP(_getCityWeatherByZIP_zip);
        System.out.println("getCityWeatherByZIP.result=" + _getCityWeatherByZIP__return);


        }
        {
        System.out.println("Invoking getCityForecastByZIP...");
        java.lang.String _getCityForecastByZIP_zip = "_getCityForecastByZIP_zip697683993";
        org.noip.wuidl.tourguide.api.wsdl.weather.ForecastReturn _getCityForecastByZIP__return = port.getCityForecastByZIP(_getCityForecastByZIP_zip);
        System.out.println("getCityForecastByZIP.result=" + _getCityForecastByZIP__return);


        }

        System.exit(0);
    }

}
