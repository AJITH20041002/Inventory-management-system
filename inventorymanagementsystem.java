package inventorymanagementsystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Product {

    int id;
    String name;
    String category;
    double price;
    int quantity;
    
    Product(int id, String name, String category, double price, int quantity) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        
   }

}
public class inventorymanagementsystem {
	
	static ArrayList<Product> products = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int choice;
		
		do {
		System.out.println();
		System.out.println("---------Inventory Management System----------");
		

		System.out.println("1.Add product");
		System.out.println("2.View products");
		System.out.println("3.Search product");
		System.out.println("4.Update product");
		System.out.println("5.Delete product");
		System.out.println("6.Sort products by price");
		System.out.println("7.Show low Stock products");
		System.out.println("8.Exit");
		
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Enter your choice: ");
		try {
		    choice = sc.nextInt();
		} catch (InputMismatchException e) {
		    System.out.println("Invalid input. Please enter a number.");
		    sc.nextLine();
		    choice = 0;
		}
		
		switch (choice) {

		case 1:
		    addProduct();
		    break;

	    case 2:
	        viewProducts();
	        break;

	    case 3:
	        searchProduct();
	        break;
	        
	    case 4:
	        updateProduct();
	        break;
	        
	    case 5:
	        deleteProduct();
	        break;
	        
	    case 6:
	        sortProductsByPrice();
	        break;
	        
	    case 7:
	        showLowStockProducts();
	        break;
	        
	    case 8:
	    	System.out.println("exiting..");
	    	break;
	    default:
	    	System.out.println("invalid choice.enter 1 to 8.");
	    
	}
		}while(choice!=8);
			sc.close();
	}
		static void addProduct() {

		    System.out.print("product ID: ");
		    try {
			    int id = sc.nextInt();
			
		    for (Product p : products) {

		        if (p.id == id) {
		            System.out.println("product ID already exists.");
		            return;
		        }
		    }

		    sc.nextLine();

		    System.out.print("product Name: ");
		    String name = sc.nextLine();

		    System.out.print("category: ");
		    String category = sc.nextLine();

		    System.out.print("price: ");
		    
		    double price = sc.nextDouble();
		    if (price <= 0) {
		        System.out.println("Invalid price. Price must be greater than 0.");
		        return;
		    }

		    System.out.print("quantity: ");
		    
		    int quantity = sc.nextInt();
		    if (quantity < 0) {
		        System.out.println("Invalid quantity. Quantity cannot be negative.");
		        return;
		    }

		    Product p = new Product(id, name, category, price, quantity);

		    products.add(p);

		    System.out.println("Product added successfully!");
		    System.out.println("----------------------------------------------------------------------------");
		    } catch (InputMismatchException e) {
			    System.out.println("Invalid input. Please enter valid input.");
			    sc.nextLine();
			}
		}
		static void viewProducts() {

		    if (products.isEmpty()) {
		        System.out.println("No products available.");
		        return;
		    }

		    System.out.println("\n------------ Product List ------------");

		    System.out.printf("%-10s %-20s %-20s %-12s %-10s%n",
		            "ID", "Name", "Category", "Price", "Quantity");

		    System.out.println("--------------------------------------------------------------------------");

		    for (Product p : products) {

		        System.out.printf("%-10d %-20s %-20s %-12.2f %-10d%n",
		                p.id,
		                p.name,
		                p.category,
		                p.price,
		                p.quantity);
		    }
		    }
		static void searchProduct() {

		    System.out.print("Enter Product ID to search: ");
		    try {
		    int id = sc.nextInt();

		    for (Product p : products) {

		        if (p.id == id) {

		            System.out.println("\nProduct Found!");

		            System.out.println("------------------------------");
		            System.out.println("ID       : " + p.id);
		            System.out.println("Name     : " + p.name);
		            System.out.println("Category : " + p.category);
		            System.out.printf("Price    : %.2f%n", p.price);
		            System.out.println("Quantity : " + p.quantity);
		            System.out.println("------------------------------");

		            return;
		        }
		    }

		    System.out.println("Product not found.");
		    System.out.println("----------------------------------------------------------------------------");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter valid input.");
			sc.nextLine();
		}
		}
		static void updateProduct() {

		    System.out.print("Enter Product ID to update: ");
		    try {
		    int id = sc.nextInt();

		    for (Product p : products) {

		        if (p.id == id) {

		            sc.nextLine();

		            System.out.print("Enter new Product Name: ");
		            String name = sc.nextLine();

		            System.out.print("Enter new Category: ");
		            String category = sc.nextLine();

		            System.out.print("Enter new Price: ");
		            double price = sc.nextDouble();

		            if (price <= 0) {
		                System.out.println("Invalid price. Price must be greater than 0.");
		                return;
		            }

		            System.out.print("Enter new Quantity: ");
		            int quantity = sc.nextInt();

		            if (quantity < 0) {
		                System.out.println("Invalid quantity. Quantity cannot be negative.");
		                return;
		            }

		            p.name = name;
		            p.category = category;
		            p.price = price;
		            p.quantity = quantity;

		            System.out.println("Product updated successfully!");
		            System.out.println("----------------------------------------------------------------------------");
		            viewProducts();

		            return;
		        }
		    }

		    System.out.println("Product not found.");
		    
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter valid input.");
			sc.nextLine();
		}
		}
		static void deleteProduct() {

		    System.out.print("Enter Product ID to delete: ");
		    try {
		    int id = sc.nextInt();

		    for (int i = 0; i < products.size(); i++) {

		        if (products.get(i).id == id) {

		            products.remove(i);

		            System.out.println("Product deleted successfully!");
		            System.out.println("----------------------------------------------------------------------------");
		            viewProducts();
		            return;
		        }
		    }

		    System.out.println("Product not found.");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter valid input.");
			sc.nextLine();
		}
		}
		static void sortProductsByPrice() {

		    if (products.isEmpty()) {
		        System.out.println("No products available.");
		        return;
		    }

		    for (int i = 0; i < products.size() - 1; i++) {

		        for (int j = 0; j < products.size() - 1 - i; j++) {

		            if (products.get(j).price > products.get(j + 1).price) {

		                Product temp = products.get(j);
		                products.set(j, products.get(j + 1));
		                products.set(j + 1, temp);
		            }
		        }
		    }

		    System.out.println("Products sorted by price!");
		    System.out.println("----------------------------------------------------------------------------");
		    viewProducts();
		}
		static void showLowStockProducts() {

		    if (products.isEmpty()) {
		        System.out.println("No products available.");
		        return;
		    }

		    System.out.print("Enter low stock limit: ");
		    try {
		    int limit = sc.nextInt();

		    if (limit < 0) {
		        System.out.println("Invalid stock limit.");
		        return;
		    }

		    boolean found = false;

		    System.out.println("\n----------------------- Low Stock Products -----------------------");

		

		    System.out.printf("%-8s %-18s %-18s %-10s %-8s %n",
		            "ID", "Name", "Category", "Price", "Quantity");

		    System.out.println("----------------------------------------------------------------------------");

		    for (Product p : products) {

		        if (p.quantity <= limit) {

		            System.out.printf("%-8d %-18s %-18s %-10.2f %-8d %n",
		                    p.id,
		                    p.name,
		                    p.category,
		                    p.price,
		                    p.quantity);

		            found = true;
		        }
		    }


		    if (!found) {
		        System.out.println("No products found below the stock limit.");
		        System.out.println("----------------------------------------------------------------------------");
		    }
		    } catch (InputMismatchException e) {
				System.out.println("Invalid input.enter the valid number.");
				sc.nextLine();
			}
		}
		    
		}
	
		

