/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class cart {
    private int cart_id;
    private int total_price;

    public cart() {
    }

    public cart(int cart_id, int total_price) {
        this.cart_id = cart_id;
        this.total_price = total_price;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "cart{" + "cart_id=" + cart_id + ", total_price=" + total_price + '}';
    }
    
    
}
