package org.spring.springboot.filter;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RouteRuleFilter {
    
    public Map<String,Object> filter(Map<String,Object> input) {
    
        Binding binding = new Binding();
        binding.setVariable("input", input);
    
        GroovyShell shell = new GroovyShell(binding);
        
        String filterScript = "def field = input.get('field')\n"
                                      + "if (input.field == 'buyer') { return ['losDataBusinessName':'losESDataBusiness3', 'esIndex':'potential_goods_recommend1']}\n"
                                      + "if (input.field == 'seller') { return ['losDataBusinessName':'losESDataBusiness4', 'esIndex':'potential_goods_recommend2']}\n";
        Script script = shell.parse(filterScript);
        Object ret = script.run();
        System.out.println(ret);
        return (Map<String, Object>) ret;
    }
}
