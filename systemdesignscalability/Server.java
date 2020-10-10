package systemdesignscalability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
    static public class Machine {
        int personID;
        Map<Integer, Person> people = new HashMap<>();

        public Person getPersonWithID(int personID) {
            return people.get(personID);
        }
    }

    HashMap<Integer, Machine> machineMap = new HashMap<>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    Machine getMachineWithId(int machineID) {
        return machineMap.get(machineID);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) return null;

        Machine machine = getMachineWithId(machineID);
        if (machine == null) return null;

        return machine.getPersonWithID(personID);
    }
}


class Person {
    private final ArrayList<Integer> friends = new ArrayList<>();
    int personID;
    private String info;

    public Person(int id) {
        this.personID = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return personID;
    }

    public void addFriend(int id) {
        friends.add(id);
    }
}