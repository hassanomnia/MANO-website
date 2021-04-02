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
public class Product {
    private int id;
    private int quantity;
    public Product(){
        
    }
    public Product(int id, int quantity){
        this.id = id;
        this.quantity = quantity;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getID(){
        return id;
    }
    public int getQuantity(){
        return quantity;
    }
}
