package com.example.tareasql;

public class ClienteModel {
    private String rfc, name, email;
    private int phone;

    public ClienteModel(){

    }

    public ClienteModel(String rfc, String name, int phone, String email) {
        this.rfc = rfc;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getRfc() {
        return rfc;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
