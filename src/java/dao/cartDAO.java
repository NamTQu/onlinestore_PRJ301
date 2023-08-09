/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.cart;
import model.total;

/**
 *
 * @author Admin
 */
public class cartDAO extends DBcontext {

    public void addtoproduct_cart(int cart_id, int product_id) {
        try {
            String sql = "INSERT INTO [dbo].[product_cart]\n"
                    + "           ([product_id]\n"
                    + "           ,[cart_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product_id);
            preparedStatement.setInt(2, cart_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addtocartdetails(int cart_id, int product_id, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[cart_details]\n"
                    + "           ([product_id]\n"
                    + "           ,[quantity]\n"
                    + "           ,[cart_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product_id);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, cart_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addtocart() {
        try {
            String sql = "UPDATE cart\n"
                    + "SET total_price = (\n"
                    + "  SELECT SUM(d.quantity * p.price)\n"
                    + "  FROM cart_details d\n"
                    + "  JOIN product p ON d.product_id = p.id\n"
                    + "  WHERE d.cart_id = cart.cart_id\n"
                    + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addnewcart() {
        try {
            String sql = "INSERT INTO [dbo].[cart]\n"
                    + "           ([total_price])\n"
                    + "     VALUES\n"
                    + "           (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int takecartID() {
        try {
            String sql = "SELECT MAX(cart_id) AS lastid\n"
                    + "FROM [dbo].[cart]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("lastid");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Integer> getProductID(int cart_id) {
        List<Integer> s = new ArrayList<>();
        try {
            String sql = "SELECT [product_id]\n"
                    + "  FROM [PRJ301].[dbo].[product_cart]\n"
                    + "  Where cart_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s.add(resultSet.getInt("product_id"));
            }
        } catch (Exception e) {
        }
        return s;
    }

    public List<total> getTotal() {
        String sql = "SELECT product.price,cart_details.quantity\n"
                + "FROM [PRJ301].[dbo].[product],[cart_details]\n"
                + "WHERE product.id = cart_details.product_id";
        List<total> total = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                total t = new total(resultSet.getDouble("price"), resultSet.getInt("quantity"));
                total.add(t);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int checkProduct(int product_id, int cart_id) {
        try {
            String sql = "SELECT [quantity]\n"
                    + "  FROM [PRJ301].[dbo].[cart_details]\n"
                    + "  Where cart_id = ? and product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart_id);
            preparedStatement.setInt(2, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("quantity");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void updateQuantity(int quantity, int cart_id, int product_id) {
        try {
            String sql = "UPDATE [dbo].[cart_details]\n"
                    + "   SET [quantity] = ?\n"
                    + "WHERE product_id = ? and cart_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, product_id);
            preparedStatement.setInt(3, cart_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getTotalPrice(int cart_id) {
        try {
            String sql = "SELECT [total_price]\n"
                    + "  FROM [dbo].[cart]\n"
                    + "  WHERE cart_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("total_price");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void RemoveProduct_details(int cart_id, int product_id) {
        try {
            String sql = "DELETE FROM [dbo].[cart_details]\n"
                    + "      WHERE cart_id = ? and product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart_id);
            preparedStatement.setInt(2, product_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void RemoveProduct_Cart(int cart_id, int product_id) {
        String sql = "DELETE FROM [dbo].[product_cart]\n"
                + "      WHERE cart_id = ? and product_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, cart_id);
            preparedStatement.setInt(cart_id, product_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updatecart(int cart_id) {
        String sql = "UPDATE cart \n"
                + "SET total_price = (\n"
                + "    SELECT SUM(product.price * cart_details.quantity) \n"
                + "    FROM cart_details\n"
                + "    JOIN product ON cart_details.product_id = product.id \n"
                + "    WHERE cart_details.cart_id = cart.cart_id\n"
                + ")\n"
                + "WHERE cart.cart_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct_cart(int cart_id, List<Integer> product_id) {
        String sql = "DELETE FROM [dbo].[product_cart]\n"
                + "      WHERE cart_id = ? and product_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Integer id : product_id) {
                preparedStatement.setInt(1, cart_id);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public void deleteCart_details(int cart_id, List<Integer> product_id) {
        String sql = "DELETE FROM [dbo].[cart_details]\n"
                    + "      WHERE cart_id = ? and product_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Integer id : product_id) {
                preparedStatement.setInt(1, cart_id);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
    
    
    

}
