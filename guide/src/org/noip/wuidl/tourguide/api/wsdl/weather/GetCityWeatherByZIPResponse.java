/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:50
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.GetCityWeatherByZIPResponse.java
 * @description GetCityWeatherByZIPResponse
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCityWeatherByZIPResult" type="{http://ws.cdyne.com/WeatherWS/}WeatherReturn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCityWeatherByZIPResult"
})
@XmlRootElement(name = "GetCityWeatherByZIPResponse")
public class GetCityWeatherByZIPResponse {

    /** The get city weather by zip result. */
    @XmlElement(name = "GetCityWeatherByZIPResult", required = true)
    protected WeatherReturn getCityWeatherByZIPResult;

    /**
	 * Ruft den Wert der getCityWeatherByZIPResult-Eigenschaft ab.
	 * 
	 * @return the gets the city weather by zip result possible object is
	 *         {@link WeatherReturn }
	 */
    public WeatherReturn getGetCityWeatherByZIPResult() {
        return getCityWeatherByZIPResult;
    }

    /**
     * Legt den Wert der getCityWeatherByZIPResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WeatherReturn }
     *     
     */
    public void setGetCityWeatherByZIPResult(WeatherReturn value) {
        this.getCityWeatherByZIPResult = value;
    }

}
