/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.product;

/**
 *
 * @author Admin
 */
public class productDAO extends DBcontext {

    public ArrayList<product> getAllProduct() {
        String sql = "SELECT * FROM [dbo].[product]";
        ArrayList<product> listP = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product s = new product(resultSet.getString("title"), resultSet.getString("image"), resultSet.getDouble("price"), resultSet.getString("description"), resultSet.getInt("quantity"), resultSet.getInt("id"));
                listP.add(s);
            }
        } catch (Exception e) {
            System.out.println("err");
        }
        return listP;
    }

    public void insertProduct(int category_id, String title, String img, double price, String description, int quantity) {
        String sql = "INSERT INTO [dbo].[product]\n"
                + "           ([category_id]\n"
                + "           ,[title]\n"
                + "           ,[image]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, img);
            preparedStatement.setDouble(4, price);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, quantity);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int id, int quantity, int category_id, String title, double price, String description) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET [category_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[quantity] = ?\n"
                + " WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            preparedStatement.setString(2, title);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, quantity);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM [dbo].[product]\n"
                + "      WHERE [id] = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public product getProductbyId(int id) {
        product s = null;
        String sql = "SELECT [id],[category_id]\n"
                + "      ,[title]\n"
                + "      ,[image]\n"
                + "      ,[price]\n"
                + "      ,[description]\n"
                + "      ,[quantity]\n"
                + "  FROM [dbo].[product] WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                s = new product(resultSet.getInt("id"), resultSet.getInt("quantity"), resultSet.getInt("category_id"), resultSet.getString("title"), resultSet.getString("image"), resultSet.getDouble("price"), resultSet.getString("description"));
            }
        } catch (Exception e) {
        }
        return s;
    }

    public int checkProductQuan(int id) {
        String sql = "SELECT [quantity]\n"
                + "  FROM [PRJ301].[dbo].[product]\n"
                + "  where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("quantity");
            }
        } catch (Exception e) {

        }
        return -1;
    }

    public void updateQuantity(int quantity, int id) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET [quantity] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public ArrayList<product> getLastedProduct(){
        String sql = "SELECT *\n"
                + "FROM [PRJ301].[dbo].[product]\n"
                + "ORDER BY id DESC\n"
                + "OFFSET 0 ROWS FETCH NEXT 3 ROWS ONLY;";
        ArrayList<product> lasted = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                lasted.add(new product(resultSet.getString("title"), resultSet.getString("image"), resultSet.getDouble("price"), resultSet.getString("description"), resultSet.getInt("quantity"), resultSet.getInt("id")));
            }
        } catch (Exception e) {
        }
        return lasted;
    }

}
