package fr.railcommandeer.app.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Pierre
 * Date: 22/02/14
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */

public class
        User implements Serializable {
    Long id;
    String password;
    String lastName;
    String firstName;
    String email;
    //@JsonSerialize(using = CustomJsonDateSerializer.class)
            Date signinDate;
    double participation;


    //@OneToMany(mappedBy="user")
    //private Collection<Project> projet;
	/*@OneToMany(mappedBy="user_fund", orphanRemoval = true)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private Collection<Fund> funds;*/


    public User()
    {
        signinDate = new Date();
        participation = 0;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getSigninDate() {
        return signinDate;
    }
    public void setSigninDate(Date signinDate) {
        this.signinDate = signinDate;
    }
    public double getParticipation() {
        return participation;
    }
    public void setParticipation(double participation) {
        this.participation = participation;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
