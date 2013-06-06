/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.ForecastReturn.java
 * @description ForecastReturn
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr ForecastReturn complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ForecastReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ResponseText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WeatherStationCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForecastResult" type="{http://ws.cdyne.com/WeatherWS/}ArrayOfForecast" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastReturn", propOrder = {
    "success",
    "responseText",
    "state",
    "city",
    "weatherStationCity",
    "forecastResult"
})
public class ForecastReturn {

    /** The success. */
    @XmlElement(name = "Success")
    protected boolean success;
    
    /** The response text. */
    @XmlElement(name = "ResponseText")
    protected String responseText;
    
    /** The state. */
    @XmlElement(name = "State")
    protected String state;
    
    /** The city. */
    @XmlElement(name = "City")
    protected String city;
    
    /** The weather station city. */
    @XmlElement(name = "WeatherStationCity")
    protected String weatherStationCity;
    
    /** The forecast result. */
    @XmlElement(name = "ForecastResult")
    protected ArrayOfForecast forecastResult;

    /**
	 * Ruft den Wert der success-Eigenschaft ab.
	 * 
	 * @return true, if is success
	 */
    public boolean isSuccess() {
        return success;
    }

    /**
	 * Legt den Wert der success-Eigenschaft fest.
	 * 
	 * @param value
	 *            the new success
	 */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
	 * Ruft den Wert der responseText-Eigenschaft ab.
	 * 
	 * @return the response text possible object is {@link String }
	 */
    public String getResponseText() {
        return responseText;
    }

    /**
     * Legt den Wert der responseText-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseText(String value) {
        this.responseText = value;
    }

    /**
	 * Ruft den Wert der state-Eigenschaft ab.
	 * 
	 * @return the state possible object is {@link String }
	 */
    public String getState() {
        return state;
    }

    /**
     * Legt den Wert der state-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
	 * Ruft den Wert der city-Eigenschaft ab.
	 * 
	 * @return the city possible object is {@link String }
	 */
    public String getCity() {
        return city;
    }

    /**
     * Legt den Wert der city-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
	 * Ruft den Wert der weatherStationCity-Eigenschaft ab.
	 * 
	 * @return the weather station city possible object is {@link String }
	 */
    public String getWeatherStationCity() {
        return weatherStationCity;
    }

    /**
     * Legt den Wert der weatherStationCity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeatherStationCity(String value) {
        this.weatherStationCity = value;
    }

    /**
	 * Ruft den Wert der forecastResult-Eigenschaft ab.
	 * 
	 * @return the forecast result possible object is {@link ArrayOfForecast }
	 */
    public ArrayOfForecast getForecastResult() {
        return forecastResult;
    }

    /**
     * Legt den Wert der forecastResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfForecast }
     *     
     */
    public void setForecastResult(ArrayOfForecast value) {
        this.forecastResult = value;
    }

}
