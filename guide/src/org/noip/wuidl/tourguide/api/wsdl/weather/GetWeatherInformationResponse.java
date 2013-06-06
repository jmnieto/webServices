/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:50
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.GetWeatherInformationResponse.java
 * @description GetWeatherInformationResponse
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
 *         &lt;element name="GetWeatherInformationResult" type="{http://ws.cdyne.com/WeatherWS/}ArrayOfWeatherDescription" minOccurs="0"/>
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
    "getWeatherInformationResult"
})
@XmlRootElement(name = "GetWeatherInformationResponse")
public class GetWeatherInformationResponse {

    /** The get weather information result. */
    @XmlElement(name = "GetWeatherInformationResult")
    protected ArrayOfWeatherDescription getWeatherInformationResult;

    /**
	 * Ruft den Wert der getWeatherInformationResult-Eigenschaft ab.
	 * 
	 * @return the gets the weather information result possible object is
	 *         {@link ArrayOfWeatherDescription }
	 */
    public ArrayOfWeatherDescription getGetWeatherInformationResult() {
        return getWeatherInformationResult;
    }

    /**
     * Legt den Wert der getWeatherInformationResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeatherDescription }
     *     
     */
    public void setGetWeatherInformationResult(ArrayOfWeatherDescription value) {
        this.getWeatherInformationResult = value;
    }

}
