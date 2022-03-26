package com.esprit.pidevbackend.API;


import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.OneCallResultOptions;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.Coordinate;
import com.github.prominence.openweathermap.api.model.onecall.current.CurrentWeatherData;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final Environment env;

    @Autowired
    public WeatherService(final Environment env) {
        this.env = env;
    }

    public CurrentWeatherData getWeatherData(String city) {
        OpenWeatherMapClient openWeatherClient = new OpenWeatherMapClient(env.getProperty("OWM_API_KEY"));

        // To be able to get coordinates from the given city
        final Weather weather = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.RUSSIAN)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();
        Coordinate c = weather.getLocation().getCoordinate();

        // return current weather and next 7 days forecast
        return openWeatherClient
                .oneCall()
                .current()
                .byCoordinate(Coordinate.of(c.getLatitude(), c.getLongitude()))
                .unitSystem(UnitSystem.METRIC)
                .language(Language.ENGLISH)
                .exclude(OneCallResultOptions.ALERTS, OneCallResultOptions.MINUTELY, OneCallResultOptions.HOURLY)
                .retrieve()
                .asJava();
    }

}
