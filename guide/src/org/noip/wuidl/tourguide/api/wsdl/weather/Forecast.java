/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.Forecast.java
 * @description Forecast
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse f\u00fcr Forecast complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Forecast">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="WeatherID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Desciption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Temperatures" type="{http://ws.cdyne.com/WeatherWS/}temp"/>
 *         &lt;element name="ProbabilityOfPrecipiation" type="{http://ws.cdyne.com/WeatherWS/}POP"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Forecast", propOrder = {
    "date",
    "weatherID",
    "desciption",
    "temperatures",
    "probabilityOfPrecipiation"
})
public class Forecast {

    /** The date. */
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    
    /** The weather id. */
    @XmlElement(name = "WeatherID")
    protected short weatherID;
    
    /** The desciption. */
    @XmlElement(name = "Desciption")
    protected String desciption;
    
    /** The temperatures. */
    @XmlElement(name = "Temperatures", required = true)
    protected Temp temperatures;
    
    /** The probability of precipiation. */
    @XmlElement(name = "ProbabilityOfPrecipiation", required = true)
    protected POP probabilityOfPrecipiation;

    /**
	 * Ruft den Wert der date-Eigenschaft ab.
	 * 
	 * @return the date possible object is {@link XMLGregorianCalendar }
	 */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
	 * Ruft den Wert der desciption-Eigenschaft ab.
	 * 
	 * @return the desciption possible object is {@link String }
	 */
    public String getDesciption() {
        return desciption;
    }

    /**
     * Legt den Wert der desciption-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesciption(String value) {
        this.desciption = value;
    }

    /**
	 * Ruft den Wert der temperatures-Eigenschaft ab.
	 * 
	 * @return the temperatures possible object is {@link Temp }
	 */
    public Temp getTemperatures() {
        return temperatures;
    }

    /**
     * Legt den Wert der temperatures-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Temp }
     *     
     */
    public void setTemperatures(Temp value) {
        this.temperatures = value;
    }

    /**
	 * Ruft den Wert der probabilityOfPrecipiation-Eigenschaft ab.
	 * 
	 * @return the probability of precipiation possible object is {@link POP }
	 */
    public POP getProbabilityOfPrecipiation() {
        return probabilityOfPrecipiation;
    }

    /**
     * Legt den Wert der probabilityOfPrecipiation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link POP }
     *     
     */
    public void setProbabilityOfPrecipiation(POP value) {
        this.probabilityOfPrecipiation = value;
    }

}
