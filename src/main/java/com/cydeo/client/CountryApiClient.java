package com.cydeo.client;


import com.cydeo.dto.country.CountryDto;
import com.cydeo.dto.weather.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://restcountries.com/v3.1",name = "COUNTRY-CLIENT")
public interface CountryApiClient {

//    https://restcountries.com/v3.1
//    /name/deutschland

    @GetMapping("/name/{countryName}")
    List<CountryDto> getCountryInfo(@PathVariable("countryName") String country);


}
