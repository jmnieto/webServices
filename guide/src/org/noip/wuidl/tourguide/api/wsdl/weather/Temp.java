/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:52
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.Temp.java
 * @description Temp
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr temp complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="temp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MorningLow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaytimeHigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temp", propOrder = {
    "morningLow",
    "daytimeHigh"
})
public class Temp {

    /** The morning low. */
    @XmlElement(name = "MorningLow")
    protected String morningLow;
    
    /** The daytime high. */
    @XmlElement(name = "DaytimeHigh")
    protected String daytimeHigh;

    /**
	 * Ruft den Wert der morningLow-Eigenschaft ab.
	 * 
	 * @return the morning low possible object is {@link String }
	 */
    public String getMorningLow() {
        return morningLow;
    }

    /**
     * Legt den Wert der morningLow-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMorningLow(String value) {
        this.morningLow = value;
    }

    /**
	 * Ruft den Wert der daytimeHigh-Eigenschaft ab.
	 * 
	 * @return the daytime high possible object is {@link String }
	 */
    public String getDaytimeHigh() {
        return daytimeHigh;
    }

    /**
     * Legt den Wert der daytimeHigh-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaytimeHigh(String value) {
        this.daytimeHigh = value;
    }

}
