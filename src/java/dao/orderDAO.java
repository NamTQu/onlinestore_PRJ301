/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.order;
import model.product_ordered;
import model.total;

/**
 *
 * @author Admin
 */
public class orderDAO extends DBcontext {

    public void InsertOrder(String username, String name, String phone_number, String address, Date order_date, int total_price) {
        String sql = "INSERT INTO [dbo].[order]\n"
                + "           ([account]\n"
                + "           ,[name]\n"
                + "           ,[phone_number]\n"
                + "           ,[address]\n"
                + "           ,[order_date]\n"
                + "           ,[total_price])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phone_number);
            preparedStatement.setString(4, address);
            preparedStatement.setDate(5, order_date);
            preparedStatement.setInt(6, total_price);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getOrder_id() {
        String sql = "SELECT MAX(id) AS order_id\n"
                + "FROM [dbo].[order]";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("order_id");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void addProduct_order(int order_id, List<Integer> product_id) {
        String sql = "INSERT INTO [dbo].[product_order]\n"
                + "           ([product_id]\n"
                + "           ,[order_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Integer id : product_id) {
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, order_id);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public void addOrder_details(int order_id, List<Integer> product_id, List<total> total) {
        String sql = "INSERT INTO [dbo].[order_details]\n"
                + "           ([order_id]\n"
                + "           ,[product_id]\n"
                + "           ,[price]\n"
                + "           ,[num])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < product_id.size(); i++) {
                preparedStatement.setInt(1, order_id);
                preparedStatement.setInt(2, product_id.get(i));
                preparedStatement.setDouble(3, total.get(i).getPrice());
                preparedStatement.setInt(4, total.get(i).getQuantity());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<order> getOrder(String account) {
        String sql = "SELECT *\n"
                + "  FROM [PRJ301].[dbo].[order]\n"
                + "  where account = ?";
        ArrayList<order> orders = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                orders.add(new order(resultSet.getInt("id"), resultSet.getString("account"), resultSet.getString("name"), resultSet.getString("phone_number"),
                        resultSet.getString("address"), resultSet.getDate("order_date"), resultSet.getInt("total_price")));
            }
            return orders;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<product_ordered> getOrderedProduct(int order_id){
        String sql = "SELECT product.title,order_details.price,order_details.num\n"
                + "                FROM [PRJ301].[dbo].[product],[order_details]\n"
                + "                WHERE product.id = order_details.product_id and order_details.order_id = ?";
        ArrayList<product_ordered> ordered = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ordered.add(new product_ordered(resultSet.getString("title"), resultSet.getDouble("price"), resultSet.getInt("num")));
            }
            return ordered;
        } catch (Exception e) {
        }
        return null;
    }

}
