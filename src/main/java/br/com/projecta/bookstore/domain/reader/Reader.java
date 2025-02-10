package br.com.projecta.bookstore.domain.reader;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;

import java.util.Calendar;

@Table(name="READER")
@Entity(name="READER")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String cpf;

    private String address;

    private String neighborhood;

    private String zipcode;

    private String city;

    private String state;

    private String telephone;

    private String cellphone;

    private String email;

    private Calendar birth;

    private Calendar registration;

    public Reader( RequestReader data ) {
        this.name           = data.name();
        this.cpf            = data.cpf();
        this.address        = data.address();
        this.neighborhood   = data.neighborhood();
        this.birth          = data.birth();
        this.city           = data.city();
        this.email          = data.email();
        this.cellphone      = data.cellphone();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAddress() {
        return address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getBirth() {
        return birth;
    }

    public Calendar getRegistration() {
        return registration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth(Calendar birth) {
        this.birth = birth;
    }

    public void setRegistration(Calendar registration) {
        this.registration = registration;
    }

    public Reader() {}

    public Reader(Integer id, String name, String cpf, String address, String neighborhood, String zipcode, String city, String state, String telephone, String cellphone, String email, Calendar birth, Calendar registration) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.email = email;
        this.birth = birth;
        this.registration = registration;
    }


}
