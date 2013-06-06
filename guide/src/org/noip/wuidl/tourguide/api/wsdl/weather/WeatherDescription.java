/**
 * @author Walter Gugenberger
 * @date 06.06.2013 19:18:50
 * @version
 * @name guide.org.noip.wuidl.tourguide.api.wsdl.weather.WeatherDescription.java
 * @description WeatherDescription
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f\u00fcr WeatherDescription complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WeatherDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WeatherID" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PictureURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeatherDescription", propOrder = {
    "weatherID",
    "description",
    "pictureURL"
})
public class WeatherDescription {

    /** The weather id. */
    @XmlElement(name = "WeatherID")
    protected short weatherID;
    
    /** The description. */
    @XmlElement(name = "Description")
    protected String description;
    
    /** The picture url. */
    @XmlElement(name = "PictureURL")
    protected String pictureURL;

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
	 * Ruft den Wert der pictureURL-Eigenschaft ab.
	 * 
	 * @return the picture url possible object is {@link String }
	 */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * Legt den Wert der pictureURL-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureURL(String value) {
        this.pictureURL = value;
    }

}
