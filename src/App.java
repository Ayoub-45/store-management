import java.util.ArrayList;
import java.util.Scanner;
import tn.horizonprob.gestionmagasin.storemanagement.ProductClass;
import tn.horizonprob.gestionmagasin.storemanagement.StoreClass;

public class App {
    public static final int STORE_CAPACITY = 50;

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            boolean shallContinue = true;
            System.out.println("Welcome We are establishing your store ...");
            System.out.println();
            System.out.println("******************************************");
            System.out.print("Store id: ");
            int id = sc.nextInt();
            System.out.println();
            System.out.print("Store address: ");
            String address = sc.next();
            System.out.println();
            System.out.print("Store maximum capacity: ");
            int storeCapacity = sc.nextInt();
            if (StoreClass.checkCapacityProducts(storeCapacity)) {
                ArrayList<ProductClass> products = new ArrayList<>();
                System.out.println("Importing products...");
                String yesOrNo;
                while (shallContinue)
                    for (int i = 0; i < storeCapacity; i++) {
                        System.out.println("********************");
                        ProductClass product = new ProductClass();
                        System.out.print("id: ");
                        long idProduct = sc.nextLong();
                        System.out.print("label: ");
                        String label = sc.next();
                        System.out.print("brand: ");
                        String brand = sc.next();
                        System.out.print("price: ");
                        double price = sc.nextDouble();
                        product.setId(idProduct);
                        product.setLabel(label);
                        product.setBrand(brand);
                        product.setPrice(price);
                        System.out.println("********************");
                        System.out.print("Would you like to add more products?[y/n]->");
                        yesOrNo = sc.next();
                        products.add(product);
                        if (yesOrNo.equals("n")) {
                            shallContinue = false;
                            break;
                        }

                    }
                StoreClass store = new StoreClass(id, address, storeCapacity, products);
                System.out.println("number of products in store: " + store.getProducts().size());
            } else {
                if (storeCapacity < 0) {
                    System.out.println("Store capacity is negative! please Enter a positive one");
                }
                if (storeCapacity > STORE_CAPACITY) {
                    System.out.println("Invalid store capacity as It exceeds " + STORE_CAPACITY);
                }

            }

        }

    }
}
