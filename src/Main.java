import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Restaurant restaurant = createRestaurant();

        while (restaurant.getRemainingSpace() > 0) {
            int peopleNumber = howManyPeopleInThegroup(restaurant);
            restaurant.createGroup(peopleNumber);

            System.out.println("Queden lliures" + restaurant.getRemainingSpace());
            System.out.println(restaurant.showTableStatus());
            goOutRestaurant(restaurant);


        }
    }

    private static void goOutRestaurant(Restaurant restaurant) throws Exception {
        if (askIfWantGoOut().equalsIgnoreCase("S")) {
            System.out.println("Introdueix el número de taula ");
            Scanner sc = new Scanner(System.in);
            int table = sc.nextInt();
            restaurant.removeTable(table);
            System.out.println("Queden lliures" + restaurant.getRemainingSpace());
        }
    }

    private static String askIfWantGoOut() {
        System.out.println("Alguna taula vol marxar? S/N");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static Restaurant createRestaurant() throws Exception {
        String restaurantName = askNameRestaurant();
        Restaurant restaurant = new Restaurant(restaurantName);
        return restaurant;
    }

    private static String askNameRestaurant() {
        System.out.println("Escriu el nom del restaurant ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    private static int howManyPeopleInThegroup(Restaurant restaurant) {
        System.out.println("Benvinguts,quantes persones son en el grup? ");
        Scanner sc = new Scanner(System.in);

        int peopleNumber = sc.nextInt();
        return peopleNumber;

    }

}
