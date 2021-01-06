package mik.designpattern.observer;


import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    List<Observer> observerList;
    private float temp;
    private float humidity;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = this.observerList.indexOf(o);
        if(index >= 0) {
            this.observerList.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o :
                this.observerList) {
            o.update(this.temp, this.humidity);
        }
    }

    public void setMeasurements(float temp, float humidity) {
        this.temp = temp;
        this.humidity = humidity;
        notifyObserver();
    }

}
