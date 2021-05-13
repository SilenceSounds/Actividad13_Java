/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jesgu
 */
@Entity
public class IMC_Data {
    
    private Long id;
    private String name;
    private String lastname;
    private String age;
    private String height;
    private String weight;
    private String imc;
    private String date;
    
    public IMC_Data(){}

    protected IMC_Data(Long id, String name, String lastname, String age, String height, String weight, String imc, String date) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.imc = imc;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImc() {
        Double weight = Double.parseDouble(this.weight);
        Double height = Double.parseDouble(this.height);
        Double imc = weight/(Math.pow(height, 2));
        Double result = Math.round(imc*100.0)/100.0;
        return result.toString();
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
    
}
