package model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String phone;
	private String city;
	private String postalCode;
	private String street;

	   public Customer(int customerId, String firstName, String lastName, String dateOfBirth,
               String email, String phone, String city, String postalCode, String street) {
   this.customerId = customerId;
   this.firstName = firstName;
   this.lastName = lastName;
   this.dateOfBirth = dateOfBirth;
   this.email = email;
   this.phone = phone;
   this.city = city;
   this.postalCode = postalCode;
   this.street = street;
}


 public Customer( String firstName, String lastName, String dateOfBirth,
		               String email, String phone, String city, String postalCode, String street) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.email = email;
	this.phone = phone;
	this.city = city;
	this.postalCode = postalCode;
	this.street = street;
		}
	   
	   public Customer() {}
	   
	   

    // Getters and Setters (optional, for completeness)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Manually written toString() method
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
	

}
