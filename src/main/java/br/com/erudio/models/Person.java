package br.com.erudio.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="person")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends ResourceSupport implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idPerson", nullable=false)
    private Long idPerson;
    
    @Column(name="firstName", nullable=false)
    private String firstName;
    
    @Column(name="lastName", nullable=false)
    private String lastName;
    
    @Column(name="address", nullable=false)
    private String address;
    
    public Person() {}

	public Long getIdPerson() {
        return idPerson;
    }
    
    public void setIdPerson(Long id) {
        this.idPerson = id;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (idPerson == null) {
			if (other.idPerson != null)
				return false;
		} else if (!idPerson.equals(other.idPerson))
			return false;
		return true;
	}
}