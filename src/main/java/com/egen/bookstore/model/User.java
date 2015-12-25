package com.egen.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
 
/**
 * User entity
 */
@Entity
public class User {
 
    @Id
    @Column(name="Id")
	@GeneratedValue
    private Long id;
    
//    @NotEmpty
    private String firstName;
    
//    @NotEmpty
    private String lastName;
    private String middleName;
    
    @NotNull
    private Integer age;
    
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
    
    private String gender;
    
//    @NotNull
    private Long phone;
    
    private Integer zip;
    
    public User() {}
 
 
     
    public User(String firstName, String lastName, String middleName, int age, String gender, Long phone, int zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.zip = zip;
	}



	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", zip=" + zip + "]";
	}
  

}
