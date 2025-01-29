import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private List<ProductInCart> shoppingcart = new ArrayList<>();

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.initialize();
        cart.run();
    }

    private void initialize() {
        products.add(new Product(1, "Laptop", "High-performance laptop", 1000, 10));
        products.add(new Product(2, "Smartphone", "Latest model smartphone", 500, 20));
        products.add(new Product(3, "Headphones", "Noise-cancelling headphones", 150, 30));
        products.add(new Product(4, "Smartwatch", "Stylish and functional smartwatch", 200, 15));
        products.add(new Product(5, "Keyboard", "Mechanical gaming keyboard", 80, 25));
    }

    private void run() {
        Scanner s = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n----- Your Cart -----\n");
            System.out.println("1. View Available Products");
            System.out.println("2. View my cart");
            System.out.println("3. Add to Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Update product count in cart");
            System.out.println("6. Calculate Total Price");
            System.out.println("7. Exit");
            System.out.println("\nChoose an Option: ");

            int c = s.nextInt();
            s.nextLine();

            switch(c) {
                case 1:
                viewAllProducts();
                break;

                case 2:
                viewCart();
                break;

                case 3:
                viewAllProducts();
                addToCart(s);
                break;

                case 4:
                viewCart();
                removeFromCart(s);
                break;

                case 5:
                updateCart(s);
                break;

                case 6:
                totalPrice();
                break;

                case 7:
                running = false;
                break;

                default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
        s.close();
    }

    private void viewAllProducts() {
        if (products.size() != 0 ) {
            System.out.println("\n-----PRODUCTS-----\n");
            for (Product p : products) {
                System.out.println("ID: " + p.getProductId());
                System.out.println(p.getName());
                System.out.println("PRODUCT DESCRIPTION" + p.getDescription());
                System.out.println("PRICE: " + p.getPrice());
                System.out.println("STOCK REMAINING: " + p.getStock());
                System.out.println("\n---------------\n");
            }
        }

        else {
            System.out.println("No Products Available to Display\n");
        }
    }

    private void viewCart() {
        if (shoppingcart.size() != 0) {
            for (ProductInCart p : shoppingcart) {
                System.out.println("\n-----PRODUCTS IN CART-----\n");
                System.out.println("ID NO: " + p.getId());
                System.out.println("PRODUCT: " + p.getProduct().getName());
                System.out.println("QUANTITY: " + p.getQuantity());
                System.out.println("\n");
            }
            
        }

        else {
            System.out.println("No Product Available in Cart\n");
        }
    }

    private void addToCart(Scanner s) {
        System.out.println("Enter Product ID to add to cart:");
        int id = s.nextInt();
        System.out.println("Enter Quantity: ");
        int quantity = s.nextInt();
    
        for (Product p : products) {
            if (p.getProductId() == id) {
                if (p.getStock() >= quantity) {
                    for (ProductInCart pic : shoppingcart) {
                        if (pic.getId() == id) {
                            System.out.println("Already in cart, update count instead.");
                            return; 
                        }
                    }
    

                    ProductInCart pic = new ProductInCart(id, p, quantity);
                    shoppingcart.add(pic);
                    p.setStock(p.getStock() - quantity);
                    System.out.println("Product added to cart.");
                } else {
                    System.out.println("Quantity entered is higher than available stock.");
                }
            }
        }
    }
    

    private void removeFromCart(Scanner s) {
        System.out.println("\nEnter Product ID to remove from cart:");
        int id = s.nextInt();
        
        for (int i = shoppingcart.size() - 1; i >= 0; i--) {
            ProductInCart pic = shoppingcart.get(i);
            if (pic.getId() == id) {
                shoppingcart.remove(i); 
                System.out.println("Product removed from the cart.");
                return; 
            }
        }
    
        System.out.println("Product not found in the cart.");
    }
    

    private void updateCart(Scanner s) {
        System.out.println("\nEnter the ID of the product for which count must be updated: ");
        int pid = s.nextInt();
        System.out.println("Enter New Quantity: ");
        int q = s.nextInt();
    
        for (Product p : products) {
            if (p.getProductId() == pid) {
                for (ProductInCart pic : shoppingcart) {
                    if (pic.getProduct().getProductId() == pid) {
                        int currentCartQuantity = pic.getQuantity();
                        int stockAdjustment = q - currentCartQuantity;
                        if (p.getStock() >= stockAdjustment) {
                            p.setStock(p.getStock() - stockAdjustment);
                            pic.setQuantity(q);
                            System.out.println("Cart updated.");
                        } else {
                            System.out.println("Quantity entered is higher than available stock.");
                        }
                        return;
                    }
                }
            }
        }
    }

    private void totalPrice() {
        int total = 0;
        for (ProductInCart p : shoppingcart) {
            total += p.getProduct().getPrice() * p.getQuantity();
        }
        System.out.println("\nTOTAL PRICE: " + total);
    }
    

    public class Product {
        private int productId;
        private String name;
        private String description;
        private int price;
        private int stock;

        public Product (
            int productId,
            String name,
            String description,
            int price,
            int stock) {
                this.productId = productId;
                this.name = name;
                this.description = description;
                this.price = price;
                this.stock = stock;
        }

        public int getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getPrice() {
            return price;
        }

        public int getStock() {
            return stock;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void getPrice(int price) {
            this.price = price;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
    }

    public class ProductInCart {
        private int Id;
        private Product product;  
        private int quantity;
    
        public ProductInCart(int Id, Product product, int quantity) {
            this.Id = Id;
            this.product = product;
            this.quantity = quantity;
            
        }
    
        public int getId() {
            return Id;
        }
    
        public void setId(int Id) {
            this.Id = Id;
        }
        
        public Product getProduct() {
            return product;
        }
    
        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
  
}
