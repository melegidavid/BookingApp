package proj.xmlws.MessageModule.dto;

import proj.xmlws.UserModule.enums.Role;

public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private boolean deleted;
    private Role role;
    private Long bussinesRegistrationNumber;
    private boolean blocked;
    private AddressDTO address;
    private AccommodationDTO accommodation;

    public UserDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getBussinesRegistrationNumber() {
        return bussinesRegistrationNumber;
    }

    public void setBussinesRegistrationNumber(Long bussinesRegistrationNumber) {
        this.bussinesRegistrationNumber = bussinesRegistrationNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public AccommodationDTO getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationDTO accommodation) {
        this.accommodation = accommodation;
    }
}
