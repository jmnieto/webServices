/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.Weather.java
 * @description Weather
 */
package org.noip.wuidl.tourguide.api.wsdl.weather;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2013-06-05T19:20:33.014+02:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "Weather", 
                  wsdlLocation = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL",
                  targetNamespace = "http://ws.cdyne.com/WeatherWS/") 
public class Weather extends Service {

    /** The Constant WSDL_LOCATION. */
    public final static URL WSDL_LOCATION;

    /** The Constant SERVICE. */
    public final static QName SERVICE = new QName("http://ws.cdyne.com/WeatherWS/", "Weather");
    
    /** The Constant WeatherHttpPost. */
    public final static QName WeatherHttpPost = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpPost");
    
    /** The Constant WeatherHttpGet. */
    public final static QName WeatherHttpGet = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherHttpGet");
    
    /** The Constant WeatherSoap12. */
    public final static QName WeatherSoap12 = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap12");
    
    /** The Constant WeatherSoap. */
    public final static QName WeatherSoap = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap");
    static {
        URL url = null;
        try {
            url = new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Weather.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");
        }
        WSDL_LOCATION = url;
    }

    /**
	 * Instantiates a new weather.
	 * 
	 * @param wsdlLocation
	 *            the wsdl location
	 */
    public Weather(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    /**
	 * Instantiates a new weather.
	 * 
	 * @param wsdlLocation
	 *            the wsdl location
	 * @param serviceName
	 *            the service name
	 */
    public Weather(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
	 * Instantiates a new weather.
	 */
    public Weather() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    /**
	 * Instantiates a new weather.
	 * 
	 * @param features
	 *            the features
	 */
    public Weather(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    /**
	 * Instantiates a new weather.
	 * 
	 * @param wsdlLocation
	 *            the wsdl location
	 * @param features
	 *            the features
	 */
    public Weather(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    /**
	 * Instantiates a new weather.
	 * 
	 * @param wsdlLocation
	 *            the wsdl location
	 * @param serviceName
	 *            the service name
	 * @param features
	 *            the features
	 */
    public Weather(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
	 * Gets the weather http post.
	 * 
	 * @return the weather http post returns WeatherHttpPost
	 */
    @WebEndpoint(name = "WeatherHttpPost")
    public WeatherHttpPost getWeatherHttpPost() {
        return super.getPort(WeatherHttpPost, WeatherHttpPost.class);
    }

    /**
	 * Gets the weather http post.
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return the weather http post returns WeatherHttpPost
	 */
    @WebEndpoint(name = "WeatherHttpPost")
    public WeatherHttpPost getWeatherHttpPost(WebServiceFeature... features) {
        return super.getPort(WeatherHttpPost, WeatherHttpPost.class, features);
    }
    
    /**
	 * Gets the weather http get.
	 * 
	 * @return the weather http get returns WeatherHttpGet
	 */
    @WebEndpoint(name = "WeatherHttpGet")
    public WeatherHttpGet getWeatherHttpGet() {
        return super.getPort(WeatherHttpGet, WeatherHttpGet.class);
    }

    /**
	 * Gets the weather http get.
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return the weather http get returns WeatherHttpGet
	 */
    @WebEndpoint(name = "WeatherHttpGet")
    public WeatherHttpGet getWeatherHttpGet(WebServiceFeature... features) {
        return super.getPort(WeatherHttpGet, WeatherHttpGet.class, features);
    }
    
    /**
	 * Gets the weather soap12.
	 * 
	 * @return the weather soap12 returns WeatherSoap
	 */
    @WebEndpoint(name = "WeatherSoap12")
    public WeatherSoap getWeatherSoap12() {
        return super.getPort(WeatherSoap12, WeatherSoap.class);
    }

    /**
	 * Gets the weather soap12.
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return the weather soap12 returns WeatherSoap
	 */
    @WebEndpoint(name = "WeatherSoap12")
    public WeatherSoap getWeatherSoap12(WebServiceFeature... features) {
        return super.getPort(WeatherSoap12, WeatherSoap.class, features);
    }
    
    /**
	 * Gets the weather soap.
	 * 
	 * @return the weather soap returns WeatherSoap
	 */
    @WebEndpoint(name = "WeatherSoap")
    public WeatherSoap getWeatherSoap() {
        return super.getPort(WeatherSoap, WeatherSoap.class);
    }

    /**
	 * Gets the weather soap.
	 * 
	 * @param features
	 *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
	 *            on the proxy. Supported features not in the
	 *            <code>features</code> parameter will have their default
	 *            values.
	 * @return the weather soap returns WeatherSoap
	 */
    @WebEndpoint(name = "WeatherSoap")
    public WeatherSoap getWeatherSoap(WebServiceFeature... features) {
        return super.getPort(WeatherSoap, WeatherSoap.class, features);
    }

}
