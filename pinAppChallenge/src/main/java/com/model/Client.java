package com.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Last Name is mandatory")
    private String lName;

    @Min(value = 0, message = "Age must be greater than or equal to 0")
    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotBlank(message = "Birth date is mandatory")
    private String birth;

    // Constructor vacío
    public Client() {
    }

    // Getters y setters
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
