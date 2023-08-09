/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.user;

/**
 *
 * @author Admin
 */
public class userDAO extends DBcontext{
    
    public user login(String xusername, String xpassword) {
        String sql = "SELECT [cart_id]\n"
                + "      ,[role_id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "  FROM [dbo].[account]\n"
                + "  WHERE username = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, xusername);
            preparedStatement.setString(2, xpassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int cart_id = resultSet.getInt("cart_id");
                int role_id = resultSet.getInt("role_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone_number = resultSet.getString("phone_number");
                return new user(cart_id, role_id, username, password, email, address, phone_number);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public user CheckUser(String xusername, String xemail) {
        String sql = "SELECT [cart_id]\n"
                + "      ,[role_id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "  FROM [dbo].[account]\n"
                + "  WHERE username = ? or email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, xusername);
            preparedStatement.setString(2, xemail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int cart_id = resultSet.getInt("cart_id");
                int role_id = resultSet.getInt("role_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone_number = resultSet.getString("phone_number");
                return new user(cart_id, role_id, username, password, email, address, phone_number);
            }

        } catch (Exception e) {

        }
        return null;
    }

    public void register(String username,int cart_id, String password, String email, String address, String phone_number) {
        String sql = "INSERT INTO [dbo].[account]\n"
                + "           ([username]\n"
                + "           ,[cart_id]\n"
                + "           ,[role_id]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[address]\n"
                + "           ,[phone_number])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, cart_id);
            preparedStatement.setInt(3, 2);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, phone_number);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }

    }

    public user getUserInformation(String account) {
        String sql = "SELECT * FROM [dbo].[account] WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new user(resultSet.getInt("cart_id"), resultSet.getInt("role_id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("phone_number"));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
}
