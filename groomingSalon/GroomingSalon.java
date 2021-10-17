package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	" The grooming salon has the following clients:
    //{name} {owner}

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
            data.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
