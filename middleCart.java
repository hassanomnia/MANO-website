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
        String productDetails = "";
        String[] arrOfStr;
        int idToModify = -1;
        int quantityToModify;
        Product toModifyProduct = new Product();
        Iterator<Product> it;
        int NewQuantity;
        int indx = 0;

        if (request.getParameterMap().containsKey("decrement")) {
            System.out.println("decrement found");
            productDetails = request.getParameter("decrement");
        } else if (request.getParameterMap().containsKey("increment")) {
            System.out.println("increment found");
            productDetails = request.getParameter("increment");
        } else if (request.getParameterMap().containsKey("delete")) {
            System.out.println("delete found");
            productDetails = request.getParameter("delete");
        }
        
        
        if (request.getParameterMap().containsKey("decrement") || request.getParameterMap().containsKey("increment")) {
            arrOfStr = productDetails.split(",");
            for (String a : arrOfStr) {
                System.out.println(a);
            }
            idToModify = Integer.parseInt(arrOfStr[0]);

            quantityToModify = Integer.parseInt(arrOfStr[1]);

            System.out.println("idToModify      " + idToModify + "quantityToModify       " + quantityToModify);
        } else if (request.getParameterMap().containsKey("delete")) {
            idToModify = Integer.parseInt(productDetails);
            System.out.println("idToModify      " + idToModify);
        }
        
        it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getID() == idToModify) {
                toModifyProduct = product;
                indx = getProducts.indexOf(toModifyProduct);
            }
        }

        System.out.println("new product details      " + toModifyProduct.getID() + "quantityToModify    " + toModifyProduct.getQuantity());

        System.out.println("size before remove:    " + getProducts.size());
        System.out.println("does product object exist?    " + getProducts.contains(toModifyProduct));

        getProducts.remove(toModifyProduct);
        
        System.out.println("size after remove:    " + getProducts.size());

        if (request.getParameterMap().containsKey("decrement")) {
            NewQuantity = toModifyProduct.getQuantity() - 1;
            if (NewQuantity >= 0) {
                toModifyProduct.setQuantity(NewQuantity);
            } else {
                toModifyProduct.setQuantity(0);

            }
            getProducts.add(indx,toModifyProduct);
        } else if (request.getParameterMap().containsKey("increment")) {
            NewQuantity = toModifyProduct.getQuantity() + 1;
            toModifyProduct.setQuantity(NewQuantity);
            getProducts.add(indx,toModifyProduct);
        }

        session.setAttribute("product", getProducts);

        response.sendRedirect("cart.jsp?action=cart&check=" + log + "");
    }
}
