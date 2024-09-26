import java.util.Scanner;

class Shop {


    private Product productList[]= new Product[500];
    private Person owner;
    private String address;
    private static int productCount=0;

    private static double revenue;

    public Shop(Person owner, String address) {
        this.owner = owner;
        this.address = address;
        this.productList = new Product[100];
    }



    public void addProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Product details");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Price: ");
        double price = input.nextDouble();
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        Product product = new Product(name, price, quantity);
        productList[productCount++]=product;
        System.out.println("Product added");


    }

    public void sale() {
        System.out.println("Sale Menu");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        for (int i = 0; i < productCount; i++) {

            if (productList[i].getId().equals(id)) {
                productList[i].setQuantity(productList[i].getQuantity() - 1);
                revenue += productList[i].getPrice();
                System.out.println("Sale successful");
            } else {
                System.out.println("Product not found");
            }

        }
    }

    public void removeProduct() {
        System.out.println("Remove Menu");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = sc.nextLine();

        for (int i = 0; i < productCount; i++) {

            if (productList[i].getId().equals(id)) {
                productList[i].setQuantity(productList[i].getQuantity() - 1);
                revenue += productList[i].getPrice();
                System.out.println("Removal successful");
            } else {
                System.out.println("Product not found");
            }

        }
    }



    public void displayProducts() {
        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null) {
                System.out.println(productList[i].toString());
            }
        }
    }



    public void modifyProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product ID which has to be modified: ");
        String id = input.nextLine();
        for (int i = 0; i < productCount; i++) {
            if (productList[i].getId().equals(id)) {

                System.out.println("Enter product name to modify: ");
                productList[i].setName(input.nextLine());


                // System.out.println("Product added");


                System.out.println("Modify successful");
            }

        }
    }


}