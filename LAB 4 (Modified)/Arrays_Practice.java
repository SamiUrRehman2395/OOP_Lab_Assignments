
import java.util.Scanner;


public class Arrays_Practice {
    public static void main(String[] args) {

        //Shop shop= new Shop(new Person("John", "email"),"Lahore");

        Shop shop = new Shop(new Person("Ahmad Ali", "ahmadali@gmai.com"), "Khayaban-e-Firdousi, Phase 1 Johar Town, Lahore");
        //Shop shop2 = new Shop(new Person("Ahmad Ali", "ahmadali@gmai.com"));

        Shop shop1 = new Shop("Deli Deli Co.");

        System.out.println("Restaurant Name : " +shop1.getShopName());

        shop.OwnerDetails();

        shop.Address();

        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("-----------------------");
            System.out.println("         Menu          ");
            System.out.println("-----------------------");
            System.out.println("Press 1 to Add Product:");
            System.out.println("Press 2 to Sale Product:");
            System.out.println("Press 3 to Remove Product:");
            System.out.println("Press 4 to Display Product:");
            System.out.println("Press 5 to Modify Product");
            System.out.println("Press 6 to Search Product");
            System.out.println("Press 7 to View Revenue");
            System.out.println("_______________________\n");

            int choice= sc.nextInt();
            switch (choice) {
                case 1:
                    shop.addProduct();
                    break;
                case 2:
                    shop.sale();
                    break;
                case 3:
                    shop.removeProduct();
                    break;

                case 4:
                        shop.displayProducts();
                        break;

                case 5:
                            shop.modifyProduct();
                            break;

                case 6:
                    shop.searchProduct();
                    break;

                case 7:
                     shop.showRevenue();
                     break;


                case 0:
                    System.exit(0);
                    break;
                default:
            }


        }



    }
}
