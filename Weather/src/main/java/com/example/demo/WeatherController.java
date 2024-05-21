package com.example.demo;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    @Value("${weather.api.key}")
    private String apiKey;

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @GetMapping("/weather")
    public String getWeather(@RequestParam String prefecture, Model model) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + prefecture + ",jp&appid=" + apiKey + "&units=metric";
        logger.info("リクエストURL: " + url);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        logger.info("レスポンス: " + response.getBody());

        if (response.getStatusCode().is2xxSuccessful()) {
            JSONObject weatherData = new JSONObject(response.getBody());
            String weatherDescription = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
            double temperature = weatherData.getJSONObject("main").getDouble("temp");
            int humidity = weatherData.getJSONObject("main").getInt("humidity");

            model.addAttribute("description", weatherDescription);
            model.addAttribute("temperature", temperature);
            model.addAttribute("humidity", humidity);
            model.addAttribute("prefecture", prefecture); // 都道府県名を追加

        } else {
            model.addAttribute("error", "エラー: 天気情報を取得できませんでした。");
        }
        return "weather";
    }
}
