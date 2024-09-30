
import java.util.Scanner;

class Shop {


    private String shopName;
    private static Product productList[]= new Product[500];
    private Person owner;
    private String address;

    private static int productCount=0;

    private static double revenue;

    static {
        productList[productCount++] = new Product("Suuny Rocket", 1010, 10);
        productList[productCount++] = new Product("Mashroom Melt", 980, 8);
        productList[productCount++]= new Product("Smoked Beef Burger", 750, 5);
        productList[productCount++] = new Product("Meal (Drink+Fries)", 280, 12);
        productList[productCount++] = new Product("Additional Beef Patty", 300, 16);
        productList[productCount++] = new Product("Curly Fries", 320, 6);
        //productCount+=6;
    }


    public Shop(String shopName, Product[] productList, Person owner, String address) {
        this.shopName = shopName;
        this.productList = productList;
        this.owner = owner;
        this.address = address;
    }

    public Shop(Person owner, String address) {
        this.owner = owner;
        this.address = address;
        //this.productList = new Product[100];
    }

    public Shop(Person owner) {
        this.owner = owner;
    }

    public Shop(String shopName) {
        this.shopName = shopName;
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
        productList[productCount]=product;
        System.out.println(productCount);
        productCount++;
        System.out.println("Product added");

    }

    public void sale() {
        System.out.println("Sale Menu");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();


        /*

        for (int i = 0; i < productCount; i++) {

            if (productList[i] != null && productList[i].getId().equals(id)) {
                if (productList[i].getQuantity() > 0) {
                    productList[i].setQuantity(productList[i].getQuantity() - 1);
                    revenue += productList[i].getPrice();
                    System.out.println("Sale Successfully");

                    return;
                }

            }

        }
        System.out.println("Product not Available");


         */


        //here we use findProduct function to decrease redundancy

        int index = findProduct(id);

        if(index != -1){

            productList[index].setQuantity(productList[index].getQuantity() - 1);
            revenue += productList[index].getPrice();
            System.out.println("Sale Successfully");
        }
        else{
            System.out.println("Product Not Found");
        }


    }

    public void removeProduct() {
        System.out.println("Remove Menu");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = sc.nextLine();

        /*
                for (int i = 0; i < productCount; i++) {

            if (productList[i] != null && productList[i].getId().equals(id1)) {
                productList[i] = null;
                System.out.println("Product removed.");
                return;
            }


        }

        System.out.println("Product not found.");

         */

        int index = findProduct(id);
        if(index != -1){
            productList[index] = null;
            System.out.println("Product removed.");
        }
        else {
            System.out.println("Product Not Found");
        }


    }




    public void displayProducts() {
        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null) {
                System.out.println(productList[i]);
                System.out.println("__________________");
            }
        }
    }



    public void modifyProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product ID which has to be modified: ");
        String id = input.nextLine();

        /*
        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null && productList[i].getId().equals(id)) {


                System.out.println("Enter new name: ");
                productList[i].setName(input.nextLine());
                System.out.println("Enter new price: ");
                productList[i].setPrice(input.nextDouble());
                System.out.println("Enter new quantity: ");
                productList[i].setQuantity(input.nextInt());
                System.out.println("Modified Successfully");


            }

        }

         */

        int index = findProduct(id);
        if(index != -1){
            System.out.println("Enter new name: ");
            productList[index].setName(input.nextLine());
            System.out.println("Enter new price: ");
            productList[index].setPrice(input.nextDouble());
            System.out.println("Enter new quantity: ");
            productList[index].setQuantity(input.nextInt());
            System.out.println("Modified Successfully");
        }
        else{
            System.out.println("Product Not Found");
        }

    }



    public void searchProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Product ID to search: ");
        String id = input.nextLine();


        /*
        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null && productList[i].getId().equals(id)) {
                System.out.println(productList[i]);


                return;
            }



        }
        System.out.println("Product not found.");

         */

        int index = findProduct(id);
        if(index != -1){
            System.out.println(productList[index]);
        }
        else{
            System.out.println("Product Not Found");
        }

    }


    public int findProduct(String id){
        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null && productList[i].getId().equals(id)) {
                return i;

            }
        }
        return -1;
    }

    public void showRevenue(){
        System.out.println("Total Revenue : "+ revenue);
    }


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }


    public void OwnerDetails(){
        System.out.println("Owner Details | "+ new Person(owner.getName(), owner.getEmail()));


    }

    public void Address(){
        System.out.println("Address : "+ getAddress());
    }
}
