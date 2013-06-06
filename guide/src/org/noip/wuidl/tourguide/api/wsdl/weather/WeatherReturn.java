/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.WeatherReturn.java
 * @description WeatherReturn
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr WeatherReturn complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WeatherReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ResponseText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WeatherStationCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WeatherID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelativeHumidity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pressure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Visibility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WindChill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeatherReturn", propOrder = {
    "success",
    "responseText",
    "state",
    "city",
    "weatherStationCity",
    "weatherID",
    "description",
    "temperature",
    "relativeHumidity",
    "wind",
    "pressure",
    "visibility",
    "windChill",
    "remarks"
})
public class WeatherReturn {

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
    
    /** The weather id. */
    @XmlElement(name = "WeatherID")
    protected short weatherID;
    
    /** The description. */
    @XmlElement(name = "Description")
    protected String description;
    
    /** The temperature. */
    @XmlElement(name = "Temperature")
    protected String temperature;
    
    /** The relative humidity. */
    @XmlElement(name = "RelativeHumidity")
    protected String relativeHumidity;
    
    /** The wind. */
    @XmlElement(name = "Wind")
    protected String wind;
    
    /** The pressure. */
    @XmlElement(name = "Pressure")
    protected String pressure;
    
    /** The visibility. */
    @XmlElement(name = "Visibility")
    protected String visibility;
    
    /** The wind chill. */
    @XmlElement(name = "WindChill")
    protected String windChill;
    
    /** The remarks. */
    @XmlElement(name = "Remarks")
    protected String remarks;

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
	 * Ruft den Wert der weatherID-Eigenschaft ab.
	 * 
	 * @return the weather id
	 */
    public short getWeatherID() {
        return weatherID;
    }

    /**
	 * Legt den Wert der weatherID-Eigenschaft fest.
	 * 
	 * @param value
	 *            the new weather id
	 */
    public void setWeatherID(short value) {
        this.weatherID = value;
    }

    /**
	 * Ruft den Wert der description-Eigenschaft ab.
	 * 
	 * @return the description possible object is {@link String }
	 */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
	 * Ruft den Wert der temperature-Eigenschaft ab.
	 * 
	 * @return the temperature possible object is {@link String }
	 */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Legt den Wert der temperature-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemperature(String value) {
        this.temperature = value;
    }

    /**
	 * Ruft den Wert der relativeHumidity-Eigenschaft ab.
	 * 
	 * @return the relative humidity possible object is {@link String }
	 */
    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    /**
     * Legt den Wert der relativeHumidity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativeHumidity(String value) {
        this.relativeHumidity = value;
    }

    /**
	 * Ruft den Wert der wind-Eigenschaft ab.
	 * 
	 * @return the wind possible object is {@link String }
	 */
    public String getWind() {
        return wind;
    }

    /**
     * Legt den Wert der wind-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWind(String value) {
        this.wind = value;
    }

    /**
	 * Ruft den Wert der pressure-Eigenschaft ab.
	 * 
	 * @return the pressure possible object is {@link String }
	 */
    public String getPressure() {
        return pressure;
    }

    /**
     * Legt den Wert der pressure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPressure(String value) {
        this.pressure = value;
    }

    /**
	 * Ruft den Wert der visibility-Eigenschaft ab.
	 * 
	 * @return the visibility possible object is {@link String }
	 */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Legt den Wert der visibility-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibility(String value) {
        this.visibility = value;
    }

    /**
	 * Ruft den Wert der windChill-Eigenschaft ab.
	 * 
	 * @return the wind chill possible object is {@link String }
	 */
    public String getWindChill() {
        return windChill;
    }

    /**
     * Legt den Wert der windChill-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindChill(String value) {
        this.windChill = value;
    }

    /**
	 * Ruft den Wert der remarks-Eigenschaft ab.
	 * 
	 * @return the remarks possible object is {@link String }
	 */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Legt den Wert der remarks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
