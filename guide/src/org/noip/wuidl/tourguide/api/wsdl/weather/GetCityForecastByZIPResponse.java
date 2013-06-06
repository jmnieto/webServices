/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.GetCityForecastByZIPResponse.java
 * @description GetCityForecastByZIPResponse
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
 *         &lt;element name="GetCityForecastByZIPResult" type="{http://ws.cdyne.com/WeatherWS/}ForecastReturn" minOccurs="0"/>
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
    "getCityForecastByZIPResult"
})
@XmlRootElement(name = "GetCityForecastByZIPResponse")
public class GetCityForecastByZIPResponse {

    /** The get city forecast by zip result. */
    @XmlElement(name = "GetCityForecastByZIPResult")
    protected ForecastReturn getCityForecastByZIPResult;

    /**
	 * Ruft den Wert der getCityForecastByZIPResult-Eigenschaft ab.
	 * 
	 * @return the gets the city forecast by zip result possible object is
	 *         {@link ForecastReturn }
	 */
    public ForecastReturn getGetCityForecastByZIPResult() {
        return getCityForecastByZIPResult;
    }

    /**
     * Legt den Wert der getCityForecastByZIPResult-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastReturn }
     *     
     */
    public void setGetCityForecastByZIPResult(ForecastReturn value) {
        this.getCityForecastByZIPResult = value;
    }

}
