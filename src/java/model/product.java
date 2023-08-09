/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class product {
    private int id;
    private int quantity;
    private int category_id;
    private String title;
    private String image;
    private double price;
    private String description;

    public product() {
    }

    public product(String title, String image, double price, String description, int quantity,int id) {
        this.id = id;
        this.quantity = quantity;
        this.title = title;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public product(int category_id, String title, String image, double price, String description, int quantity) {
        this.quantity = quantity;
        this.category_id = category_id;
        this.title = title;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public product(int id, int quantity, int category_id, String title, String image, double price, String description) {
        this.id = id;
        this.quantity = quantity;
        this.category_id = category_id;
        this.title = title;
        this.image = image;
        this.price = price;
        this.description = description;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "product{" + "quantity=" + quantity + ", category_id=" + category_id + ", title=" + title + ", image=" + image + ", price=" + price + ", description=" + description + '}';
    }
    
    
}
