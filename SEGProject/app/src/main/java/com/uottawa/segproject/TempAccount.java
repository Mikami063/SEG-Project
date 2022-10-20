package com.uottawa.segproject;

public class TempAccount {
    String name,password,role;
    public TempAccount(String name,String password, String role){
        this.name=name;
        this.password=password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole(){return role;}
}
