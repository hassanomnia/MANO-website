/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

/**
 *
 * @author Nihal
 */
import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.json.*;

public class DataBaseManagement {

    static PreparedStatement preparedStatment = null;
    static ResultSet result = null;
    static PreparedStatement pstat;
    static String sqlCommand;
    static String sqlCommand1;
    static char[] ch = null;
    static Statement state;
    static String nme = "";
    static boolean checkname = true;

    static public ResultSet selectAllProduct(Connection connection) {
        try {
            state = connection.createStatement();
            sqlCommand = "select * from product;";
            sqlCommand = "select * from product order by product_id; ";
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectAllProducts(Connection connection) {
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from product";
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectAllMobiles(Connection connection) {
        try {
            state = connection.createStatement();
            sqlCommand = "select * from (select row_number() over(order by code) as row_number,* from product)as sub where row_number>5 and row_number<10;";
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectMobiles(Connection connection, int start, int end) {
        try {
            if (end != 0) {
                preparedStatment = connection.prepareStatement("select * from (select row_number() over(order by code) as row_number,* from product where category='Mobile')as sub where row_number>=? and row_number<=?;");
                preparedStatment.setInt(1, start);
                preparedStatment.setInt(2, end);
            } else {
                preparedStatment = connection.prepareStatement("select * from (select row_number() over(order by code) as row_number,* from product where category='Mobile')as sub where row_number>=?");
                preparedStatment.setInt(1, start);
            }
            result = preparedStatment.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectSingleProduct(Connection connection, int id) {
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id =" + id;
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // This function return admin if user in admin table, 
    // return customer if user in customer table and 
    // return false if not exist
    static public String checkSiginIn(Connection connection, String name, String password) {
        String checkFlag = "";
        if (!(name.equals(null)) && !(password.equals(null))) {
            try {
                state = connection.createStatement();
                sqlCommand = "SELECT * from admin";
                result = state.executeQuery(sqlCommand);
                while (result.next()) {
                    if (result.getString(2).equals(name) && result.getString(3).equals(password)) {
                        checkFlag = "admin";
                    }
                }
                state = connection.createStatement();
                sqlCommand = "SELECT * from customer";
                result = state.executeQuery(sqlCommand);
                while (result.next()) {
                    if (result.getString(7).equals(name) && result.getString(9).equals(password)) {
                        checkFlag = "customer";
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!(checkFlag.equals("customer")) && !(checkFlag.equals("admin"))) {
                checkFlag = "false";
            }
        }

        return checkFlag;
    }
    // This function return true if username is not exist, 
    // else return false 

    static public String checkSiginUp(Connection connection, String name) {
        String checkFlag = "true";
        if (name != null) {
            try {
                state = connection.createStatement();
                sqlCommand = "SELECT * from admin";
                result = state.executeQuery(sqlCommand);
                while (result.next()) {
                    if (result.getString(2).equals(name)) {
                        checkFlag = "false";
                    }
                }
                state = connection.createStatement();
                sqlCommand = "SELECT * from customer";
                result = state.executeQuery(sqlCommand);
                while (result.next()) {
                    if (result.getString(7).equals(name)) {
                        checkFlag = "false";
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            return checkFlag;
        }
        return "false";
    }

    static public void insertUser(Connection connection, int cart_id, String credit_info, String birthday, String username, String email, String password, String job) {
        try {

            pstat = connection.prepareStatement("INSERT INTO customer(customer_id,cart_id, credit_info,birthday,username,email,password,job)VALUES (?,?,?,?,?,?,?)");
            pstat.setString(1, "DEFAULT");
            pstat.setInt(2, cart_id);
            pstat.setString(3, credit_info);
            pstat.setString(4, birthday);
            pstat.setString(4, username);
            pstat.setString(4, email);
            pstat.setString(4, password);
            pstat.setString(4, job);
            int rows = pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static ResultSet selectSingleProduct(Connection c, String idField) {
        try {
            //state = c.createStatement();
            state = c.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id =" + idField;
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectAllCustomers(Connection connection) {
        try {
            state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlCommand = "SELECT * from customer order by customer_id;";
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet selectCertainCustomers(Connection connection, String toSearch) {
        try {
            state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlCommand = "select * from customer where username LIKE'%" + toSearch + "%' order by customer_id;";
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    static public int updateQuantity(Connection connection, int id, int para) {

        int i = -1;
        try {
            System.out.println("*******before update************id: " + id + "******quantity: " + para);
            pstat = connection.prepareStatement("update product set total_quantity=? where product_id=?;");
            pstat.setInt(1, para);
            pstat.setInt(2, id);
            i = pstat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    static public int updatePrice(Connection connection, int id, int para) {

        int i = -1;
        try {
            System.out.println("*******before update************id: " + id + "******quantity: " + para);
            pstat = connection.prepareStatement("update product set price=? where product_id=?;");
            pstat.setInt(1, para);
            pstat.setInt(2, id);
            i = pstat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    static public void deleteProduct(Connection connection, int id) {
        try {
            System.out.println("*******before delete************id: " + id);
            pstat = connection.prepareStatement("DELETE FROM product where product_id=?;");
            pstat.setInt(1, id);
            pstat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void deleteProfile(Connection connection, int id) {
        try {
            System.out.println("*******before delete************id: " + id);
            pstat = connection.prepareStatement("DELETE FROM customer where customer_id=?;");
            pstat.setInt(1, id);
            pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public String insertCart_includes(Connection connection) {
        String cart_id = "";
        try {
            pstat = connection.prepareStatement("insert into cart_includes(product_id,quantity) values(?,?);");
            pstat.setInt(1, 1);
            pstat.setInt(2, 0);
            int rows = pstat.executeUpdate();
            state = connection.createStatement();
            sqlCommand = "SELECT cart_id FROM cart_includes where cart_id = (select max(cart_id) from cart_includes)";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                cart_id = result.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart_id;
    }

    static public String insertCustomer(Connection connection, int cartId, String image, int credit_info, String birthday, String address, String username, String email, String password, String job) {
        String customer_id = "";
        try {
            pstat = connection.prepareStatement("insert into customer(cart_id,image,credit_info,birthday,address,username,email,password,job)values(?,?,?,?,?,?,?,?,?);");
            pstat.setInt(1, cartId);
            pstat.setString(2, image);
            pstat.setInt(3, credit_info);
            pstat.setString(4, birthday);
            pstat.setString(5, address);
            pstat.setString(6, username);
            pstat.setString(7, email);
            pstat.setString(8, password);
            pstat.setString(9, job);
            int rows = pstat.executeUpdate();
            state = connection.createStatement();
            sqlCommand = "SELECT * from customer where cart_id='" + cartId + "'";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                customer_id = result.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_id;
    }

    static public void insertUserInterests(Connection connection, int customer_id, String interest1, String interest2) {

        try {
            pstat = connection.prepareStatement("INSERT INTO user_interests VALUES (?,?)");
            if (interest1 == null) {
                pstat.setInt(1, customer_id);
                pstat.setString(2, interest2);
                int rows = pstat.executeUpdate();
            } else if (interest2 == null) {
                pstat.setInt(1, customer_id);
                pstat.setString(2, interest1);
                int rows = pstat.executeUpdate();
            } else {
                pstat.setInt(1, customer_id);
                pstat.setString(2, interest1);
                int rows = pstat.executeUpdate();
                pstat.setInt(1, customer_id);
                pstat.setString(2, interest2);
                rows = pstat.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static public String getImageURL(Connection connection, String name) {
        String image = "";
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from customer WHERE username ='" + name + "'";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                image = result.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    static public String getCustomerId(Connection connection, String name) {
        String product_id = "";
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from customer WHERE username ='" + name + "'";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                product_id = result.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_id;
    }

    static public String getProductName(Connection connection, int id) {
        String name = "";
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id =" + id;
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                name = result.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    static public float getProductPrice(Connection connection, int id) {
        float price = 0;
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id =" + id;
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                price = Float.parseFloat(result.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }

    static public String checkCreditInfo(Connection connection, String name, float totalPrice) {
        String credit = "false";
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from customer WHERE username ='" + name + "'";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (Float.parseFloat(result.getString(4)) >= totalPrice) {
                    credit = "true";
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return credit;
    }

    static public float checkProductQuantity(Connection connection, int productId, int quantity) {
        float totalPrice = 0;
        try {
            state = connection.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id =" + productId;
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (Integer.parseInt(result.getString(7)) >= quantity) {
                    totalPrice = Float.parseFloat(result.getString(2)) * quantity;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPrice;
    }

    static public int updateProductAterSale(Connection connection, int productId, int quantity) {
        int rows = 0;
        try {
            state = connection.createStatement();
            pstat = connection.prepareStatement("UPDATE product SET  total_quantity = total_quantity - ?  WHERE product_id = ? ");
            pstat.setInt(1, quantity);
            pstat.setInt(2, productId);
            rows = pstat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public int updateCustomerAterSale(Connection connection, String customerName, float totalprice) {
        int rows = 0;
        try {
            state = connection.createStatement();
            pstat = connection.prepareStatement("UPDATE customer SET  credit_info = credit_info - ?  WHERE username = ? ");
            pstat.setFloat(1, totalprice);
            pstat.setString(2, customerName);
            rows = pstat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public void insertProductHistory(Connection connection, String name, int product) {
        try {
//            String strArray[] = new String[array.length];
//            for (int i = 0; i < array.length; i++)
//            strArray[i] = String.valueOf(array[i]);
//            Array arrayHistory = connection.createArrayOf("text", strArray);
            state = connection.createStatement();
            pstat = connection.prepareStatement("UPDATE customer SET  product_history =  array_append(product_history, ?)  WHERE username = ? ");
            pstat.setInt(1, product);
            pstat.setString(2, name);
            int rows = pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void insertQuantityHistory(Connection connection, String name, int product) {
        try {
            state = connection.createStatement();
            pstat = connection.prepareStatement("UPDATE customer SET  quantity_history =  array_append(quantity_history, ?)  WHERE username = ? ");
            pstat.setInt(1, product);
            pstat.setString(2, name);
            int rows = pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public ResultSet searchProduct(Connection connection, String type, float price_product) {
        try {
            float range1 = price_product - 3000;
            float range2 = price_product + 3000;
            state = connection.createStatement();
            if (!type.equals("all")) {
                sqlCommand = "SELECT * from product where (price BETWEEN " + range1 + " AND " + range2 + ") and (category = '" + type + "');";
            } else {
                sqlCommand = "SELECT * from product where price BETWEEN " + range1 + " AND " + range2;
            }
            result = state.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet getCustomerInfo(Connection connection, int id) {
        try {
            System.err.println(id);
            preparedStatment = connection.prepareStatement("select * from customer where customer_id = ?");
            preparedStatment.setInt(1, id);
            result = preparedStatment.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public void insertProduct(Connection connection, int id, String name, String category, String code, float price, float oldPrice, String description, int quantity, String imgURL) {
        try {
            preparedStatment = connection.prepareStatement("insert into product values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatment.setInt(1, id);
            preparedStatment.setFloat(2, price);
            preparedStatment.setString(3, category);
            preparedStatment.setString(4, code);
            preparedStatment.setString(5, name);
            preparedStatment.setString(6, description);
            preparedStatment.setInt(7, quantity);
            preparedStatment.setString(8, imgURL);
            preparedStatment.setFloat(9, oldPrice);
            preparedStatment.execute();
            System.err.println("heeeeeeeeeeeeeeeeeeeeeeeeere");
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public ResultSet selectInterests(Connection connection, int id) {
        try {
            preparedStatment = connection.prepareStatement("select * from user_interests where customer_id = ?");
            preparedStatment.setInt(1, id);
            result = preparedStatment.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public ResultSet getCartInfo(Connection connection, int id) {
        try {
            preparedStatment = connection.prepareStatement("select * from cart_includes where cart_id = (select cart_id from customer where customer_id=?)");
            preparedStatment.setInt(1, id);
            preparedStatment.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public void UpdateCartInfo(Connection connection, int id, float quantity) {
        try {
            preparedStatment = connection.prepareStatement("update customer set credit_info = ? where customer_id = ?");
            preparedStatment.setFloat(1, quantity);
            preparedStatment.setInt(2, id);
            preparedStatment.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void insertDateHistory(Connection connection, String name) {
        try {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            state = connection.createStatement();
            System.out.println(strDate);
            pstat = connection.prepareStatement("UPDATE customer SET  date_history =  date_history || ?::text  WHERE username = ? ");
            pstat.setString(1, strDate);
            pstat.setString(2, name);
            int rows = pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static public void updateProduct(Connection connection, String hiddenId,String productName, String productCategory, String productCode, String productDescription, Float productPrice, int productQuantity) {
        try {
            
            preparedStatment = connection.prepareStatement("UPDATE product SET price=? ,category=? ,code=? ,name=? ,description=? ,total_quantity=? WHERE product_id="+hiddenId);
            preparedStatment.setFloat(1, productPrice);
            preparedStatment.setString(2, productCategory);
            preparedStatment.setString(3, productCode);
            preparedStatment.setString(4, productName);
            preparedStatment.setString(5, productDescription);
            preparedStatment.setInt(6, productQuantity);
            preparedStatment.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static public void insertReviewMongo(MongoDatabase database, int productID, String customerName, int rate, String comment) {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        MongoCollection collection = database.getCollection("reviews");

        Document insertDocument = new Document();
        insertDocument.append("productID", productID)
                .append("customerName", customerName)
                .append("rate", rate)
                .append("comment", comment)
                .append("date", strDate);
        try {
            collection.insertOne(insertDocument);
            System.out.println("Successfully inserted documents. \n");
        } catch (MongoWriteException mwe) {
            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                System.out.println("Document with that id already exists");
            }
        }
    }

    static public MongoCursor retriveReviewMongo(MongoDatabase database, int id) {
        JSONObject obj = null;
        MongoCollection collection = database.getCollection("reviews");

        MongoCursor<Document> cursor = collection.find(Filters.eq("productID", id)).iterator();
        try {
            while (cursor.hasNext()) {
                obj = new JSONObject(cursor.next().toJson());
                // System.out.println("productID: "+obj.getInt("productID"));   
            }
        } finally {
            //cursor.close();
        }
        return cursor;
    }
}
