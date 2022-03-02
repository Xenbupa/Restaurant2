public class Group {
    private int peopleNumber;

    public Group(int person) throws Exception {
        checkPerson(person);
        this.peopleNumber = person;
    }

    private void checkPerson(int peopleNumber) throws Exception {
        if (peopleNumber <= 0) throw new Exception();

    }

    public int getPeopleNum() {
        return peopleNumber;
    }

    @Override
    public String toString() {
        return
                ": " + peopleNumber + " personas.";
    }


}
