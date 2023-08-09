/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.category;


/**
 *
 * @author Admin
 */
public class categoryDAO extends DBcontext{
    
    public ArrayList<category> getAllCategory() {
        String sql = "SELECT * FROM [dbo].[category]";
        ArrayList<category> listC = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category s = new category(resultSet.getInt("id"), resultSet.getString("name"));
                listC.add(s);
            }
        } catch (Exception e) {
            System.out.println("err");
        }
        return listC;
    }
}
