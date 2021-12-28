package com.webservice.webservice.soap.Bean;

import com.webservice.webservice.soap.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerData {

    @Autowired
    CustomerDetailsService service;

    private int id;
    private String name;
    private int Mobile;
    private String Address;
    private int Total_Balance;

    public CustomerDetailsService getService() {
        return service;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMobile() {
        return Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public int getTotal_Balance() {
        return Total_Balance;
    }



    public CustomerData( int id, String name, int mobile, String address, int total_Balance) {

        this.id = id;
        this.name = name;
        Mobile = mobile;
        Address = address;
        Total_Balance = total_Balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(int mobile) {
        Mobile = mobile;
    }

    public void setService(CustomerDetailsService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "service=" + service +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", Mobile=" + Mobile +
                ", Address='" + Address + '\'' +
                ", Total_Balance=" + Total_Balance +
                '}';
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setTotal_Balance(int total_Balance) {
        Total_Balance = total_Balance;
    }
}
