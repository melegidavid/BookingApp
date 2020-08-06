//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.20 at 08:54:37 PM CET 
//


package proj.xmlws.MessageModule.model.users;


import proj.xmlws.MessageModule.enums.Role;
import proj.xmlws.MessageModule.model.accommodation.Accommodation;
import proj.xmlws.MessageModule.model.reservation.Reservation;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://booking.uns.ac.rs/users}Address"/>
 *         &lt;element name="Bussines_registration_number" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Blocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://booking.uns.ac.rs/accommodation}Accommodation" minOccurs="0"/>
 *         &lt;element ref="{http://booking.uns.ac.rs/reservation}Reservation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://booking.uns.ac.rs/users}Role"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "name",
    "lastname",
    "email",
    "username",
    "password",
    "id",
    "enabled",
    "deleted",
    "address",
    "bussinesRegistrationNumber",
    "blocked",
    "agentOfAccommodation",
    "reservations",
    "role"
})
@Entity
public class User {

    @XmlElement(name = "Name", required = true)
    protected String name;

    @XmlElement(name = "Lastname", required = true)
    protected String lastname;

    @XmlElement(name = "Email", required = true)
    protected String email;

    @XmlElement(name = "Username", required = true)
    protected String username;

    @XmlElement(name = "Password", required = true)
    protected String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(name = "Id")
    protected long id;

    @XmlElement(name = "Enabled")
    protected boolean enabled;

    @XmlElement(name = "Deleted")
    protected boolean deleted;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", nullable = false, unique = true)
    @XmlElement(name = "Address", required = true)
    protected Address address;

    @XmlElement(name = "Bussines_registration_number")
    protected Long bussinesRegistrationNumber;

    @XmlElement(name = "Blocked")
    protected boolean blocked;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Accommodation agentOfAccommodation;

    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Reservation", namespace = "http://booking.uns.ac.rs/reservation")
    protected List<Reservation> reservations = new ArrayList<>();

    @XmlElement(name = "Role", required = true)
    protected Role role;


    public User() {

    }
    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the bussinesRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBussinesRegistrationNumber() {
        return bussinesRegistrationNumber;
    }

    /**
     * Sets the value of the bussinesRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBussinesRegistrationNumber(Long value) {
        this.bussinesRegistrationNumber = value;
    }

    /**
     * Gets the value of the blocked property.
     * 
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     */
    public void setBlocked(boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getAccommodation() {
        return agentOfAccommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setAccommodation(Accommodation value) {
        this.agentOfAccommodation = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getReservations() {
        if (reservations == null) {
            reservations = new ArrayList<Reservation>();
        }
        return this.reservations;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRole(Role value) {
        this.role = value;
    }

}