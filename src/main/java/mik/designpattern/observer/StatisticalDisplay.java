package mik.designpattern.observer;

public class StatisticalDisplay implements Observer, Display {
    private WeatherData weatherData;
    private float temp;
    private float humidity;


    public StatisticalDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void update(float temp, float humidity) {
        this.temp = temp;
        this.humidity = humidity;
        this.display();
    }
    public void unregister(){
        this.weatherData.removeObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Statistical temp - "+ this.temp + " and humidity - "+ this.humidity);
    }
}
