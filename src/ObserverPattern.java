// DERIN BULDANLI - 20210601012
// AYSE OZER - 20200601040
// MEHMET TASOGLU - 20210601059
// BERYKAY ISIK - 20190601204
// LIVESTOCK FARM

import java.util.*;

// ---- Observer Pattern ----

// Observer interface
interface Observer {
    void update(String state); // Push method: Subject sends data directly
}

// Subject abstract class
abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();
    protected String subjectState;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(subjectState); // send state to all observers
        }
    }

    public String getState() {
        return subjectState;
    }

    public void setState(String state) {
        this.subjectState = state;
    }
}

// Concrete Observer: Farmer
class Farmer implements Observer {
    private String name;

    public Farmer(String name) {
        this.name = name;
    }

    @Override
    public void update(String state) {
        System.out.println("ALERT: Farmer " + name + " is notified = " + state);
    }
}
