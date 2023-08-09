/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class order {
    private int id;
    private String account;
    private String name;
    private String phone_number;
    private String address;
    private Date order_date;
    private int total_price;

    public order() {
    }

    public order(int id, String account, String name, String phone_number, String address, Date order_date, int total_price) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.order_date = order_date;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "order{" + "id=" + id + ", account=" + account + ", name=" + name + ", phone_number=" + phone_number + ", address=" + address + ", order_date=" + order_date + ", total_price=" + total_price + '}';
    }
    
    
}
