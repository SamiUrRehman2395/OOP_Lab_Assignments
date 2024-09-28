import java.util.Scanner;

class Shop {


    private String shopName;
    private Product productList[]= new Product[500];
    private Person owner;
    private String address;
    private static int productCount=0;

    private static double revenue;

    public Shop(String shopName, Product[] productList, Person owner, String address) {
        this.shopName = shopName;
        this.productList = productList;
        this.owner = owner;
        this.address = address;
    }

    public Shop(Person owner, String address) {
        this.owner = owner;
        this.address = address;
        this.productList = new Product[100];
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
        productList[productCount++]=product;
        System.out.println("Product added");

    }

    public void sale() {
        System.out.println("Sale Menu");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

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
    }

    public void removeProduct() {
        System.out.println("Remove Menu");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id1 = sc.nextLine();

        for (int i = 0; i < productCount; i++) {

            if (productList[i] != null && productList[i].getId().equals(id1)) {
                productList[i] = null;
                System.out.println("Product removed.");
                return;
            }



        }

        System.out.println("Product not found.");

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
    }



    public void searchProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Product ID to search: ");
        String id = input.nextLine();

        for (int i = 0; i < productCount; i++) {
            if (productList[i] != null && productList[i].getId().equals(id)) {
                System.out.println(productList[i]);


                return;
            }



        }
        System.out.println("Product not found.");

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