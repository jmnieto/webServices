/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:51
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.POP.java
 * @description POP
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr POP complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="POP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nighttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Daytime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POP", propOrder = {
    "nighttime",
    "daytime"
})
public class POP {

    /** The nighttime. */
    @XmlElement(name = "Nighttime")
    protected String nighttime;
    
    /** The daytime. */
    @XmlElement(name = "Daytime")
    protected String daytime;

    /**
	 * Ruft den Wert der nighttime-Eigenschaft ab.
	 * 
	 * @return the nighttime possible object is {@link String }
	 */
    public String getNighttime() {
        return nighttime;
    }

    /**
     * Legt den Wert der nighttime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNighttime(String value) {
        this.nighttime = value;
    }

    /**
	 * Ruft den Wert der daytime-Eigenschaft ab.
	 * 
	 * @return the daytime possible object is {@link String }
	 */
    public String getDaytime() {
        return daytime;
    }

    /**
     * Legt den Wert der daytime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaytime(String value) {
        this.daytime = value;
    }

}
