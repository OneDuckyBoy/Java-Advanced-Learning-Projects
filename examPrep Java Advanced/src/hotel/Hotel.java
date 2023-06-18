package hotel;


import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }
    public void add(Person person){
        if (roster.size()<capacity){
            roster.add(person);
        }
    }
    public boolean remove(String name){

        return roster.removeIf(person -> person.getName().equals(name));
    }
    public int getCount(){

        return roster.size();
    }
    public Person getPerson(String name, String hometown){
        return roster.stream().filter(person -> person.getName().equals(name)&&person.getHometown().equals(hometown))
                .findAny()
                .orElse(null);
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder(String.format("The people in the hotel %s are:%n",name));
        roster.forEach(person -> sb.append(person.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
