//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.20 at 08:54:37 PM CET 
//


package proj.xmlws.MessageModule.model.accommodation;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.booking.accommodation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.booking.accommodation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccommodationType }
     * 
     */


    /**
     * Create an instance of {@link AccommodationUnit }
     * 
     */
    public AccommodationUnit createAccommodationUnit() {
        return new AccommodationUnit();
    }

    /**
     * Create an instance of {@link AccommodationUnitType }
     * 
     */
    public AccommodationUnitType createAccommodationUnitType() {
        return new AccommodationUnitType();
    }

    /**
     * Create an instance of {@link PeriodPrice }
     * 
     */
    public PeriodPrice createPeriodPrice() {
        return new PeriodPrice();
    }

    /**
     * Create an instance of {@link Accommodation }
     * 
     */
    public Accommodation createAccommodation() {
        return new Accommodation();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

}
