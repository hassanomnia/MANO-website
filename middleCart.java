/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author omniahassan
 */
public class middleCart extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        ArrayList<Product> getProducts = (ArrayList<Product>) session.getAttribute("product");
        String log = request.getParameter("check");

        if (request.getParameterMap().containsKey("decrement")) {
            System.out.println("decrement found");
            String productDetails = request.getParameter("decrement");
            String[] arrOfStr = productDetails.split(",");
            for (String a : arrOfStr) {
                System.out.println(a);
            }
            int idToDectrement = Integer.parseInt(arrOfStr[0]);
            int quantityToDectrement = Integer.parseInt(arrOfStr[1]);

            System.out.println("idToDectrement      " + idToDectrement + "quantityToDectrement      " + quantityToDectrement);

            Product toModifyProduct = new Product();
            Iterator<Product> it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
            while (it.hasNext()) {
                Product product = it.next();
                if (product.getID() == idToDectrement) {
                    toModifyProduct = product;
                }
            }

            //Product toModifyProduct = new Product(idToDectrement, quantityToDectrement);
            System.out.println("new product details      " + toModifyProduct.getID() + "quantityToDectrement      " + toModifyProduct.getQuantity());

            System.out.println("size before remove:    " + getProducts.size());
            System.out.println(getProducts.contains(toModifyProduct));
            //getProducts.add(toModifyProduct);
            getProducts.remove(toModifyProduct);
            System.out.println("size after remove:    " + getProducts.size());
            int NewQuantity = toModifyProduct.getQuantity() - 1;
            if (NewQuantity >= 0) {
                toModifyProduct.setQuantity(NewQuantity);
            } else {
                toModifyProduct.setQuantity(0);
            }
            getProducts.add(toModifyProduct);
            session.setAttribute("product", getProducts);

        }

        if (request.getParameterMap().containsKey("increment")) {
            System.out.println("increment found");
            String productDetails = request.getParameter("increment");
            String[] arrOfStr = productDetails.split(",");
            for (String a : arrOfStr) {
                System.out.println(a);
            }
            int idToIncrement = Integer.parseInt(arrOfStr[0]);
            int quantityToIncrement = Integer.parseInt(arrOfStr[1]);

            System.out.println("idToIncrement      " + idToIncrement + "quantityToIncrement      " + quantityToIncrement);

            Product toModifyProduct = new Product();
            Iterator<Product> it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
            while (it.hasNext()) {
                Product product = it.next();
                if (product.getID() == idToIncrement) {
                    toModifyProduct = product;
                }
            }

            //Product toModifyProduct = new Product(idToDectrement, quantityToDectrement);
            System.out.println("new product details      " + toModifyProduct.getID() + "quantityToIncrement      " + toModifyProduct.getQuantity());

            System.out.println("size before remove:    " + getProducts.size());
            System.out.println(getProducts.contains(toModifyProduct));
            //getProducts.add(toModifyProduct);
            getProducts.remove(toModifyProduct);
            System.out.println("size after remove:    " + getProducts.size());
            int NewQuantity = toModifyProduct.getQuantity() + 1;
            toModifyProduct.setQuantity(NewQuantity);
            getProducts.add(toModifyProduct);
            session.setAttribute("product", getProducts);

        }

        if (request.getParameterMap().containsKey("delete")) {
            System.out.println("delete found");
            String productDetails = request.getParameter("delete");

            int idToDelete = Integer.parseInt(productDetails);

            System.out.println("idToIncrement      " + idToDelete);

            Product toModifyProduct = new Product();
            Iterator<Product> it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
            while (it.hasNext()) {
                Product product = it.next();
                if (product.getID() == idToDelete) {
                    toModifyProduct = product;
                }
            }

            //Product toModifyProduct = new Product(idToDectrement, quantityToDectrement);
            System.out.println("new product details      " + toModifyProduct.getID() + "quantityToDelete     " + toModifyProduct.getQuantity());

            System.out.println("size before remove:    " + getProducts.size());
            System.out.println(getProducts.contains(toModifyProduct));
            //getProducts.add(toModifyProduct);
            getProducts.remove(toModifyProduct);
            System.out.println("size after remove:    " + getProducts.size());
            session.setAttribute("product", getProducts);

        }

        response.sendRedirect("cart.jsp?action=cart&check=" + log + "");
    }

}
