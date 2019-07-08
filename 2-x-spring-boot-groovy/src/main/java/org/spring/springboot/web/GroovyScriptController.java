package org.spring.springboot.web;

import org.spring.springboot.filter.RouteRuleFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/groovy/script")
public class GroovyScriptController {

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter() {
        
        RouteRuleFilter routeRuleFilter = new RouteRuleFilter();
    
        Map<String, Object> input = new HashMap<>();
        input.put("field", "seller");
    
        Map<String, Object> output = routeRuleFilter.filter(input);
        return "true";
        
    }
    
    public static void main(String[] args) {
        GroovyScriptController groovyScriptController = new GroovyScriptController();
        groovyScriptController.filter();
    }
}
