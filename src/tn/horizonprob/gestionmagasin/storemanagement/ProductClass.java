package tn.horizonprob.gestionmagasin.storemanagement;

import java.time.LocalDate;

public class ProductClass {
    private long id;
    private String label;
    private String brand;
    private double price;
    LocalDate expirationDate;

    public ProductClass() {

    }

    public ProductClass(long id, String label, String brand, LocalDate expirationDate) {
        this.id = id;
        this.label = label;
        this.brand = brand;
        this.expirationDate = expirationDate;

    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    public ProductClass(long id, String label, String brand, double price) {
        this.id = id;
        this.label = label;
        this.brand = brand;
        if (price > 0)
            this.price = price;

    }

    public void display() {
        System.out.println("Product " + id + ":");
        System.out.println("label: " + label);
        System.out.println("brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Expired: " + isExpired());
        System.out.println("ExpirationDate: " + expirationDate);
    }

    // In case we want to display meaningful data about each object
    /*
     * 
     * @Override
     * public String toString() {
     * return "Product:{id:" + id + "\n label:" + label + "\nbrand:" + brand +
     * "\nprice:" + price + "}";
     * }
     */
    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getLabel() {
        return label;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else
            System.out.println("We cannot set a negative price !");
    }
}
