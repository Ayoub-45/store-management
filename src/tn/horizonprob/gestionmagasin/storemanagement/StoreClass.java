package tn.horizonprob.gestionmagasin.storemanagement;

import java.util.ArrayList;

public class StoreClass {
    private long id;
    private String address;
    private int storeCapacity;
    private ArrayList<ProductClass> products;

    public StoreClass(long id, String address, int storeCapacity, ArrayList<ProductClass> products) {

        this.id = id;
        this.address = address;
        this.storeCapacity = storeCapacity;
        this.products = products;
        System.out.println("Store created ! Congratualtions 😁😁😁");
    }

    public static boolean checkCapacityProducts(long numProducts) {
        return numProducts > 0 && numProducts <= 50;
    }

    public void displayProducts() {
        for (ProductClass product : products) {
            product.display();
        }
    }

    public int getStoreCapacity() {
        return storeCapacity;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setStoreCapacity(int storeCapacity) {
        this.storeCapacity = storeCapacity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProducts(ArrayList<ProductClass> products) {
        this.products = products;
    }

    public boolean compare(ProductClass product1, ProductClass product2) {
        return product1.getId() == product2.getId() &&
                product1.getLabel().equals(product2.getLabel()) &&
                product1.getPrice() == product2.getPrice() &&
                product1.getBrand().equals(product2.getBrand());
    }

    public boolean compare(ProductClass product) {
        for (ProductClass prod : products) {
            if (this.compare(product, prod)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFound(ProductClass product) {
        for (ProductClass prod : products) {
            if (product.getLabel().equals(prod.getLabel())) {
                return true;
            }

        }
        return false;
    }

    public void addProduct(ProductClass product) {
        if (this.compare(product)) {
            if (products.size() < storeCapacity) {
                products.add(product);
                System.out.println("Product added: " + product.getLabel());
            } else {
                System.out.println("Store is full! Cannot add more products.");
            }
        } else

        {
            System.out.println("Product already exists in the store.");
        }
    }

    public void removeProduct(ProductClass prod) {
        products.remove(prod);
    }

    public StoreClass compareStoreProductCount(StoreClass otherStore) {

        if (this.products.size() > otherStore.products.size()) {
            return this;
        } else if (this.products.size() < otherStore.products.size()) {
            return otherStore;
        } else {
            System.out.println("Both stores have the same number of products.");
            return null;
        }
    }

    public ArrayList<ProductClass> getProducts() {
        return products;
    }

}
