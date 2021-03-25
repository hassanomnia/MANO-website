/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Nihal
 */
public class DatabaseConnection implements ServletContextListener {

    private static final String url = "jdbc:postgresql://queenie.db.elephantsql.com:5432/egrcxdzs";
    private static final String user = "egrcxdzs";
    private static final String password = "o6B0efidppafA3FtpejNmzgbZBdHEFKE";
    private static Connection c = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is made successfully");
            ServletContext servletContext = sce.getServletContext();
            servletContext.setAttribute("getConnection", c);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            c.close();
            System.out.println("Connection is closed successfully");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
