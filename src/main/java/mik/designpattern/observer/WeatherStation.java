package mik.designpattern.observer;

public class WeatherStation {
        public static void main(String[] args) {
            WeatherData weatherData = new WeatherData();
            CurrentConditionsDisplay currentDisplay =
                    new CurrentConditionsDisplay(weatherData);
            StatisticalDisplay statisticsDisplay = new StatisticalDisplay(weatherData);

            weatherData.setMeasurements(80, 65);
            weatherData.setMeasurements(82, 70);
            weatherData.setMeasurements(78, 90);
        }
    }
