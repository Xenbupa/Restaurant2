import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private String restaurantName;
    private static int capacity;
    private List<Group> groups = new ArrayList<>();


    public Restaurant(String restaurantName) throws Exception {
        checkRestaurantName(restaurantName);
        this.restaurantName = restaurantName;
        this.capacity = 24;

    }

    public  Group createGroup( int peopleNumber) throws Exception {
        Group group = new Group(peopleNumber);
        return group;

    }

    public void removeTable(int table) throws Exception {
        groups.remove(table);
        if (table>groups.size()) throw new Exception("nº de taula invàlida.");

    }

    private void checkRestaurantName(String restaurantName) throws Exception {
        if (restaurantName == null || restaurantName.equals(""))
            throw new Exception("Nom invàlid.");
    }

    public String showTableStatus() {
        String text = "";
        for (int i = 0; i < groups.size(); i++) {
            text += "Taula " + (i) + groups.get(i);
        }

        return text;
    }

    public String getRestaurantName() {
        return restaurantName;
    }


    public static int getCapacity() {
        return capacity;
    }


    public void addGroup(Group group) throws Exception {
        if (getRemainingSpace() < group.getPeopleNum()) throw new Exception("No queden places lliures");

        this.groups.add(group);
    }

    public int getRemainingSpace() {
        int people = 0;
        for (Group current : groups) {
            people += current.getPeopleNum();

        }
        return capacity - people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(restaurantName, that.restaurantName) && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantName, groups);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", groups=" + groups.size() + '.';
    }
}
