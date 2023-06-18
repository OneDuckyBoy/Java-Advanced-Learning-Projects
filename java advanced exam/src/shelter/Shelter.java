package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void add(Animal animal){
        // adds an entity to the data if there is an empty cell for the animal
        if (data.size()<capacity){
            data.add(animal);
        }
    }
    public boolean remove(String name){
        //removes the animal by given name, if such exists, and returns boolean
        return data.removeIf(a -> a.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker){
        //returns the animal with the given name and caretaker or null if no such animal exists
        return data.stream()
                .filter(p ->p.getName().equals(name) && p.getCaretaker().equals(caretaker))
                .findAny()
                .orElse(null);
    }
    public Animal getOldestAnimal(){
        return Collections.max(data, (f, s) -> Integer.compare(f.getAge(),s.getAge()));
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder(String.format("The shelter has the following animals:%n"));
        for (Animal animal : data) {
            sb.append(String.format("%s %s%n",animal.getName(),animal.getCaretaker()));
        }
        return sb.toString();
    }

}
