import java.util.*;
class Product {
    //Defining product names and its prices for prototype
    private String product_name;
    private double product_price;
    public Product(String product_name, double product_price) {
        //this keyword is used for accesing it as current object
        this.product_name = product_name;
        this.product_price = product_price;
    }
    public String getName() {
        return product_name;
    }
    public double getPrice() {
        return product_price;
    }
}
class ShoppingCart {
    //Adding the selected items to the shopping cart
    private List<Product> selected_items;
    public ShoppingCart() {
        selected_items = new ArrayList<>();
    }
    public void addItem(Product product) {
        selected_items.add(product);
    }
    //Calculating total amount to pay
    public double calculateTotal() {
        double total = 0;
        for (Product item : selected_items) {
            total += item.getPrice();
        }
        return total;
    }
    //Getting all selcted items 
    public List<Product> getItems() {
        return selected_items;
    }
}
//Defining a main class for our e-commerce website
public class ECommerceWebsite {
    //Initializing the private produts,cart to made them not to use in other classes rather than E-Commerce Website
    private static List<Product> products = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        initializeProducts();
        //Runs while it is true only..
        while (true) {
            System.out.println("1. Browse Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    checkout();
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!Visit again..!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    //Intializing the products for our website prototype
    private static void initializeProducts() {
        products.add(new Product("Phone",50000));
        products.add(new Product("Laptop",100000));
        products.add(new Product("Tablet",80000));
	    products.add(new Product("Computer",90000));
	    products.add(new Product("Groceries",5000));
	    products.add(new Product("Headsets",1999));
	    products.add(new Product("Clothes",2000));
    }
    //Displays Available Products
    private static void browseProducts() {
        System.out.println("Available Products:");
        //Loops until it gets all available products which are instantiated in above method
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }
        System.out.print("Enter the product number to add to cart (0 to go back): ");
        int choice = sc.nextInt();
        //Checks that we choosen the correct choice or not
        if (choice > 0 && choice <= products.size()) {
            Product selectedProduct = products.get(choice - 1);
            cart.addItem(selectedProduct);
            System.out.println(selectedProduct.getName() + " added to cart.");
        }
    }
    //Displays your cart of selected items and the total money
    private static void viewCart() {
        List<Product> selected_items = cart.getItems();
        if (selected_items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } 
        else {
            System.out.println("Your Cart:");
            for (Product item : selected_items) {
                System.out.println("- " + item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total: $" + cart.calculateTotal());
        }
    }
    //Checks out by showing total money
    private static void checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
        } 
        else {
            System.out.println("Total: $" + cart.calculateTotal());
            System.out.println("Thank you for shopping with us! Your order has been placed.Visit again");
            cart = new ShoppingCart(); // Reset cart after checkout
        }
    }
}
