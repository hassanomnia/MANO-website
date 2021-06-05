/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mayada
 */
@Path("/helloworld")
public class HelloWorld {

    @Context
    private UriInfo context;

    public HelloWorld() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "HelloWorld";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String test(@PathParam("id") String orderId) {
        String status = "";
        try {
            String url = "jdbc:postgresql://queenie.db.elephantsql.com:5432/egrcxdzs";
            String user = "egrcxdzs";
            String password = "o6B0efidppafA3FtpejNmzgbZBdHEFKE";
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection c = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Postgres is made successfully");
            status = getOrderStatus(c, Integer.parseInt(orderId));
           

        } catch (SQLException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(status);
        return status;
    }

    static public String getOrderStatus(Connection connection, int id) {
        String sqlCommand = "SELECT * from orders WHERE order_id ='" + id + "'";
        String status = "Order Code is not correct";
        try {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery(sqlCommand);
            while (result.next()) {
                status = result.getString(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
