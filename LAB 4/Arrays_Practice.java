import java.util.Objects;
import java.util.Scanner;


public class Arrays_Practice {
    public static void main(String[] args) {

        Shop shop= new Shop(new Person("John", "email"),"Lahore");
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("_______________________");
            System.out.println("         Menu          ");
            System.out.println("_______________________");
            System.out.println("Press 1 to Add Product:");
            System.out.println("Press 2 to Sale Product:");
            System.out.println("Press 3 to Remove Product:");
            System.out.println("Press 4 to Display Product:");
            System.out.println("Press 5 to Modify Product");
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



                case 0:
                    System.exit(0);
                    break;
                default:
            }



        }



    }
}
