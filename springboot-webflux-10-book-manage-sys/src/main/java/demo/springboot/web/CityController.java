package demo.springboot.web;

import demo.springboot.domain.City;
import demo.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

/**
 * city 控制层
 * <p>
 * Created by bysocket
 */
@Controller
@RequestMapping(value = "/city")
public class CityController {

    private static final String CITY_FORM_PATH_NAME = "cityForm";
    private static final String CITY_LIST_PATH_NAME = "cityList";
    private static final String REDIRECT_TO_CITY_URL = "redirect:/city";

    @Autowired
    CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCityList(final Model model) {
        model.addAttribute("cityList", cityService.findAll());
        return CITY_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCityForm(final Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("action", "create");
        return CITY_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCity(@ModelAttribute City city) {
        cityService.insertByCity(city);
        return REDIRECT_TO_CITY_URL;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getCity(@PathVariable Long id, final Model model) {
        final Mono<City> city = cityService.findById(id);
        model.addAttribute("city", city);
        model.addAttribute("action", "update");
        return CITY_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBook(@ModelAttribute City city) {
        cityService.update(city);
        return REDIRECT_TO_CITY_URL;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCity(@PathVariable Long id) {
        cityService.delete(id);
        return CITY_LIST_PATH_NAME;
    }

}
