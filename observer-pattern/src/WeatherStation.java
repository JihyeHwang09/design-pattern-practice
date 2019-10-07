public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions(weatherData);
//        StaticsDisplay staticsDisplay = new StaticsDisplay(weatherData);
//        ForecastDisplay  forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeaurementsChanged(85, 62, 37.7f);


    }
}
