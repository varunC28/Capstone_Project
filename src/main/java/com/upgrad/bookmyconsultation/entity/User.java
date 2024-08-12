package com.upgrad.bookmyconsultation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;




//Mark it with Data, Entity, Builder, NoArgsConstructor, AllArgsConstructor
//create a class named User
	//create firstName of type String
	//create lastName of type String
	//create dob of type String
	//create mobile of type String
	//create primary key 'emailId' of type String
	//create password of type String
	//create createdDate of type String
	//create salt of type String
	//all the mentioned members must be private

// When you apply the @Data annotation to a class, Lombok will automatically generate
// several methods for you: getters for all fields, setters for all non-final fields
@Data
@Entity
@NoArgsConstructor
public class User {

    private String firstName;

    private String lastName;
    private String dob;
    private String mobile;
    private String emailId;
    private String password;
    private String createDate;
    private String salt;
}