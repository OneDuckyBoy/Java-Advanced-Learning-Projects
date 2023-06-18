package dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car){
        //adds an entity to the data if there is an empty cell for the car.
        if (data.size()<capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        //removes the car by given manufacturer and model, if such exists, and returns boolean

        //        return roster.removeIf(p -> p.getName().equals(name));
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model));
    }
    public Car getLatestCar(){
        //returns the latest car (by year) or null if have no cars

        //return Collections.max(data, (f,s)-> Integer.compare(f.getAge(),s.getAge()));
        return Collections.max( data,(f,s) -> Integer.compare(f.getYear(), f.getYear()));
    }
    public Car getCar(String manufacturer, String model){
        //        return data.stream()
//                .filter(p ->p.getName().equals(name) && p.getOwner().equals(owner))
//                .findAny()
//                .orElse(null);

        return data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer)&& c.getModel().equals(model))
                .findAny().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder(String.format("The cars are in a car dealership %s:%n",name));
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
