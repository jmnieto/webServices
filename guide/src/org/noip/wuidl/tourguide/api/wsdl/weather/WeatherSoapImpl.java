
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.noip.wuidl.tourguide.api.wsdl.weather;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2013-06-05T19:20:32.956+02:00
 * Generated source version: 2.7.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "Weather",
                      portName = "WeatherSoap12",
                      targetNamespace = "http://ws.cdyne.com/WeatherWS/",
                      wsdlLocation = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL",
                      endpointInterface = "org.noip.wuidl.tourguide.api.wsdl.weather.WeatherSoap")
                      
public class WeatherSoapImpl implements WeatherSoap {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(WeatherSoapImpl.class.getName());

    /* (non-Javadoc)
     * @see org.noip.wuidl.tourguide.api.wsdl.weather.WeatherSoap#getWeatherInformation(*
     */
    public org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfWeatherDescription getWeatherInformation() { 
        LOG.info("Executing operation getWeatherInformation");
        try {
            org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfWeatherDescription _return = new org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfWeatherDescription();
            java.util.List<org.noip.wuidl.tourguide.api.wsdl.weather.WeatherDescription> _returnWeatherDescription = new java.util.ArrayList<org.noip.wuidl.tourguide.api.wsdl.weather.WeatherDescription>();
            org.noip.wuidl.tourguide.api.wsdl.weather.WeatherDescription _returnWeatherDescriptionVal1 = new org.noip.wuidl.tourguide.api.wsdl.weather.WeatherDescription();
            _returnWeatherDescriptionVal1.setWeatherID((short)25330);
            _returnWeatherDescriptionVal1.setDescription("Description1639118383");
            _returnWeatherDescriptionVal1.setPictureURL("PictureURL1099507728");
            _returnWeatherDescription.add(_returnWeatherDescriptionVal1);
            _return.getWeatherDescription().addAll(_returnWeatherDescription);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.noip.wuidl.tourguide.api.wsdl.weather.WeatherSoap#getCityWeatherByZIP(java.lang.String  zip )*
     */
    public org.noip.wuidl.tourguide.api.wsdl.weather.WeatherReturn getCityWeatherByZIP(java.lang.String zip) { 
        LOG.info("Executing operation getCityWeatherByZIP");
        System.out.println(zip);
        try {
            org.noip.wuidl.tourguide.api.wsdl.weather.WeatherReturn _return = new org.noip.wuidl.tourguide.api.wsdl.weather.WeatherReturn();
            _return.setSuccess(true);
            _return.setResponseText("ResponseText-1811902254");
            _return.setState("State1808856542");
            _return.setCity("City561450459");
            _return.setWeatherStationCity("WeatherStationCity913593275");
            _return.setWeatherID((short)10389);
            _return.setDescription("Description-593507527");
            _return.setTemperature("Temperature-1271933697");
            _return.setRelativeHumidity("RelativeHumidity1807536066");
            _return.setWind("Wind-2121463998");
            _return.setPressure("Pressure1249313547");
            _return.setVisibility("Visibility-1411059526");
            _return.setWindChill("WindChill1678347033");
            _return.setRemarks("Remarks1091392598");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.noip.wuidl.tourguide.api.wsdl.weather.WeatherSoap#getCityForecastByZIP(java.lang.String  zip )*
     */
    public org.noip.wuidl.tourguide.api.wsdl.weather.ForecastReturn getCityForecastByZIP(java.lang.String zip) { 
        LOG.info("Executing operation getCityForecastByZIP");
        System.out.println(zip);
        try {
            org.noip.wuidl.tourguide.api.wsdl.weather.ForecastReturn _return = new org.noip.wuidl.tourguide.api.wsdl.weather.ForecastReturn();
            _return.setSuccess(true);
            _return.setResponseText("ResponseText2111891576");
            _return.setState("State-243738030");
            _return.setCity("City-388870973");
            _return.setWeatherStationCity("WeatherStationCity-1524723984");
            org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfForecast _returnForecastResult = new org.noip.wuidl.tourguide.api.wsdl.weather.ArrayOfForecast();
            java.util.List<org.noip.wuidl.tourguide.api.wsdl.weather.Forecast> _returnForecastResultForecast = new java.util.ArrayList<org.noip.wuidl.tourguide.api.wsdl.weather.Forecast>();
            org.noip.wuidl.tourguide.api.wsdl.weather.Forecast _returnForecastResultForecastVal1 = new org.noip.wuidl.tourguide.api.wsdl.weather.Forecast();
            _returnForecastResultForecastVal1.setDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-06-05T19:20:32.968+02:00"));
            _returnForecastResultForecastVal1.setWeatherID((short)-15243);
            _returnForecastResultForecastVal1.setDesciption("Desciption1514262787");
            org.noip.wuidl.tourguide.api.wsdl.weather.Temp _returnForecastResultForecastVal1Temperatures = new org.noip.wuidl.tourguide.api.wsdl.weather.Temp();
            _returnForecastResultForecastVal1Temperatures.setMorningLow("MorningLow-657704389");
            _returnForecastResultForecastVal1Temperatures.setDaytimeHigh("DaytimeHigh1531916199");
            _returnForecastResultForecastVal1.setTemperatures(_returnForecastResultForecastVal1Temperatures);
            org.noip.wuidl.tourguide.api.wsdl.weather.POP _returnForecastResultForecastVal1ProbabilityOfPrecipiation = new org.noip.wuidl.tourguide.api.wsdl.weather.POP();
            _returnForecastResultForecastVal1ProbabilityOfPrecipiation.setNighttime("Nighttime-814407514");
            _returnForecastResultForecastVal1ProbabilityOfPrecipiation.setDaytime("Daytime-825613090");
            _returnForecastResultForecastVal1.setProbabilityOfPrecipiation(_returnForecastResultForecastVal1ProbabilityOfPrecipiation);
            _returnForecastResultForecast.add(_returnForecastResultForecastVal1);
            _returnForecastResult.getForecast().addAll(_returnForecastResultForecast);
            _return.setForecastResult(_returnForecastResult);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}