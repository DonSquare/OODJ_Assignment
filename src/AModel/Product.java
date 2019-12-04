/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

/**
 *
 * @author Jaydon
 */
public class Product implements java.io.Serializable{
    
    private Identification ID;
    public  String name;
    public  String brand;
    private Supplier supplier;
    private double cost,price;
    public int stock;
    public static final long serialVersionUID=2L;

    public String getSupplier() {
        return supplier.name;
    }

    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost){
        this.cost=cost;
    }

    public double getPrice() {
        return price;
    }
    
    public String getCostString(){
        return Double.toString(cost);
    }
    
    public String getPriceString(){
        return Double.toString(price);
    }
    
    public String getStockString(){
        return Integer.toString(stock);
    }
    
    public Identification getID(){
        return this.ID;
    }
    
    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    public Product(Identification ID, String name, String brand, Supplier supplier, double cost, double price, int stock) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
        this.cost = cost;
        this.price = price;
        this.stock = stock;
    }

   
    
    
    /* 
    Methods
    */
    
    public double getProfit(){
    double profit = this.price - this.cost;
    return profit;
    }
    
}
