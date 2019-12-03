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

    /*
    Constructor
    */
    public Product(String name, String brand, String cost, String price, String stock) {
        this.name = name;
        this.brand = brand;
        this.cost = Double.parseDouble(cost);
        this.price = Double.parseDouble(price);
        this.stock = Integer.parseInt(stock);
    }
   
    public Product() {
    }
    public Product(String name, String brand, Supplier supplier, double cost, double price) {
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
        this.cost = cost;
        this.price = price;
    }

    public Product(String name, String brand, Supplier supplier) {
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
    }

    public Product(double cost, double price) {
        this.cost = cost;
        this.price = price;
    }
    
    /* 
    Methods
    */
    
    public double getProfit(){
    double profit = this.price - this.cost;
    return profit;
    }
    
}
