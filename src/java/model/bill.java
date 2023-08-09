/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class bill {
    private String name;
    private String phone_number;
    private String address;
    private Date order_date;
    private int total_price;
    private ArrayList<product_ordered> listProduct;

    public bill(String name, String phone_number, String address, Date order_date, int total_price, ArrayList<product_ordered> listProduct) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.order_date = order_date;
        this.total_price = total_price;
        this.listProduct = listProduct;
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

    public ArrayList<product_ordered> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<product_ordered> listProduct) {
        this.listProduct = listProduct;
    }
    
}
