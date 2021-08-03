import java.util.Scanner;

public class PizzashopMain {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
       while(true){
           System.out.println("========= Food Menu ============");
           System.out.println("            1. Beef Pizza with French fry.");
           System.out.println("            2. Veggi Pizza with onion rings.");
           System.out.println("            3. A combo meal with Veggi Pizza, French Fry and Coke.");
           System.out.println("            4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
           System.out.println("            5.A Beef Pizza only.");
           System.out.println("            >=6. Exit . ");
           System.out.print("Enter your choice: ");
           int input = Integer.parseInt(scanner.nextLine());
           if(input==1){
               Pizza pizza = new FrenchFries((Pizza)new BeefPizza());
               System.out.println("Item Price ==> "+ pizza.price());
           }else if(input==2){
               Pizza pizza = new OnionRings((Pizza)new VeggiPizza());
               System.out.println("Item Price ==> "+ pizza.price());
           }else if(input==3){
               Pizza pizza = new Coke(new FrenchFries((Pizza)new VeggiPizza()));
               System.out.println("Item Price ==> "+ pizza.price());
           }else if(input==4){
               Pizza pizza = new Coffee(new OnionRings((Pizza)new VeggiPizza()));
               System.out.println("Item Price ==> "+ pizza.price());
           }else if(input==5){
               Pizza pizza = new BeefPizza();
               System.out.println("Item Price ==> "+ pizza.price());
           }else if(input>=6) break;
           else{
               System.out.println("Enter a number.");
           }
       }
    }
}
