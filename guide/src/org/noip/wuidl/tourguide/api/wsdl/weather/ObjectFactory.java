/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:49
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.ObjectFactory.java
 * @description ObjectFactory
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.noip.wuidl.tourguide.api.wsdl.weather package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    /** The Constant _WeatherReturn_QNAME. */
    private final static QName _WeatherReturn_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherReturn");
    
    /** The Constant _ArrayOfWeatherDescription_QNAME. */
    private final static QName _ArrayOfWeatherDescription_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "ArrayOfWeatherDescription");
    
    /** The Constant _ForecastReturn_QNAME. */
    private final static QName _ForecastReturn_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "ForecastReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.noip.wuidl.tourguide.api.wsdl.weather
     * 
     */
    public ObjectFactory() {
    }

    /**
	 * Create an instance of {@link GetCityForecastByZIPResponse }.
	 * 
	 * @return the gets the city forecast by zip response
	 */
    public GetCityForecastByZIPResponse createGetCityForecastByZIPResponse() {
        return new GetCityForecastByZIPResponse();
    }

    /**
	 * Create an instance of {@link ForecastReturn }.
	 * 
	 * @return the forecast return
	 */
    public ForecastReturn createForecastReturn() {
        return new ForecastReturn();
    }

    /**
	 * Create an instance of {@link ArrayOfWeatherDescription }.
	 * 
	 * @return the array of weather description
	 */
    public ArrayOfWeatherDescription createArrayOfWeatherDescription() {
        return new ArrayOfWeatherDescription();
    }

    /**
	 * Create an instance of {@link GetWeatherInformationResponse }.
	 * 
	 * @return the gets the weather information response
	 */
    public GetWeatherInformationResponse createGetWeatherInformationResponse() {
        return new GetWeatherInformationResponse();
    }

    /**
	 * Create an instance of {@link WeatherReturn }.
	 * 
	 * @return the weather return
	 */
    public WeatherReturn createWeatherReturn() {
        return new WeatherReturn();
    }

    /**
	 * Create an instance of {@link GetCityWeatherByZIP }.
	 * 
	 * @return the gets the city weather by zip
	 */
    public GetCityWeatherByZIP createGetCityWeatherByZIP() {
        return new GetCityWeatherByZIP();
    }

    /**
	 * Create an instance of {@link GetCityForecastByZIP }.
	 * 
	 * @return the gets the city forecast by zip
	 */
    public GetCityForecastByZIP createGetCityForecastByZIP() {
        return new GetCityForecastByZIP();
    }

    /**
	 * Create an instance of {@link GetWeatherInformation }.
	 * 
	 * @return the gets the weather information
	 */
    public GetWeatherInformation createGetWeatherInformation() {
        return new GetWeatherInformation();
    }

    /**
	 * Create an instance of {@link GetCityWeatherByZIPResponse }.
	 * 
	 * @return the gets the city weather by zip response
	 */
    public GetCityWeatherByZIPResponse createGetCityWeatherByZIPResponse() {
        return new GetCityWeatherByZIPResponse();
    }

    /**
	 * Create an instance of {@link Temp }.
	 * 
	 * @return the temp
	 */
    public Temp createTemp() {
        return new Temp();
    }

    /**
	 * Create an instance of {@link Forecast }.
	 * 
	 * @return the forecast
	 */
    public Forecast createForecast() {
        return new Forecast();
    }

    /**
	 * Create an instance of {@link POP }.
	 * 
	 * @return the pop
	 */
    public POP createPOP() {
        return new POP();
    }

    /**
	 * Create an instance of {@link WeatherDescription }.
	 * 
	 * @return the weather description
	 */
    public WeatherDescription createWeatherDescription() {
        return new WeatherDescription();
    }

    /**
	 * Create an instance of {@link ArrayOfForecast }.
	 * 
	 * @return the array of forecast
	 */
    public ArrayOfForecast createArrayOfForecast() {
        return new ArrayOfForecast();
    }

    /**
	 * Create an instance of {@link JAXBElement }{@code <}{@link WeatherReturn }
	 * {@code >} .
	 * 
	 * @param value
	 *            the value
	 * @return the JAXB element< weather return>
	 */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "WeatherReturn")
    public JAXBElement<WeatherReturn> createWeatherReturn(WeatherReturn value) {
        return new JAXBElement<WeatherReturn>(_WeatherReturn_QNAME, WeatherReturn.class, null, value);
    }

    /**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ArrayOfWeatherDescription }{@code >} .
	 * 
	 * @param value
	 *            the value
	 * @return the JAXB element< array of weather description>
	 */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "ArrayOfWeatherDescription")
    public JAXBElement<ArrayOfWeatherDescription> createArrayOfWeatherDescription(ArrayOfWeatherDescription value) {
        return new JAXBElement<ArrayOfWeatherDescription>(_ArrayOfWeatherDescription_QNAME, ArrayOfWeatherDescription.class, null, value);
    }

    /**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ForecastReturn }
	 * {@code >} .
	 * 
	 * @param value
	 *            the value
	 * @return the JAXB element< forecast return>
	 */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "ForecastReturn")
    public JAXBElement<ForecastReturn> createForecastReturn(ForecastReturn value) {
        return new JAXBElement<ForecastReturn>(_ForecastReturn_QNAME, ForecastReturn.class, null, value);
    }

}
