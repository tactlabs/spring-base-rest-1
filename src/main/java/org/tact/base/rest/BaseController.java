

/**
 * 
 * 
 * Source:
 * 		https://www.baeldung.com/spring-request-param
 * 		https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
 */

package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseController {
	
	// camelCase
	
	/**
	 * 
	 * @param <T>
	 * @return
	 * 
	 * Possible URLs:
	 * 		http://0.0.0.0:7826/
	 */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", 1);
        map.put("three", 2.2);
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param <T>
     * @return
     * 
     * Possible URLs:
	 * 		http://0.0.0.0:7826/city
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "city", method = RequestMethod.GET)
    public <T> T listCities() {
    	
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        
    	List<String> onCities = new ArrayList<>();
    	onCities.add("Toronto");
    	onCities.add("Ottawa");
    	map.put("Ontario", onCities);
        
    	List<String> qcCities = new ArrayList<>();
    	qcCities.add("Quebec");
    	qcCities.add("Montreal");
    	map.put("Quebec", qcCities);
    	
        return (T) map;
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "reverse", method = RequestMethod.GET)
    public <T> T reverseName(
    	@RequestParam(name = "name") String name
    ) {
    	
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	map.put("name", name);
    	
    	// reverse
    	String reveseName = new StringBuilder(name).reverse().toString();
    	map.put("reverse_name", reveseName);
    	
    	// make first lette capital
    	String cap = reveseName.substring(0, 1).toUpperCase() + reveseName.substring(1);
    	map.put("reverse_name_with_cap", cap);
    	
        return (T) map;
    }
    
    /**
     * 
     * @param <T>
     * @param name
     * @return
     * 
     * Possible URLs:
	 * 		http://0.0.0.0:7826/reverse/optional
     * 
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "reverse/optional", method = RequestMethod.GET)
    public <T> T reverseNameOptional(
    	@RequestParam(defaultValue = "python") String name
    ) {
    	
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	map.put("name", name);
    	
    	// reverse
    	String reveseName = new StringBuilder(name).reverse().toString();
    	map.put("reverse_name", reveseName);
    	
    	// make first letter capital
    	String cap = reveseName.substring(0, 1).toUpperCase() + reveseName.substring(1);
    	map.put("reverse_name_with_cap", cap);
    	
        return (T) map;
    }
    
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "city/{prov}", method = RequestMethod.GET)
    public <T> T listProvCities(@PathVariable("prov") String prov) {
    	
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	if(prov.toUpperCase().equals("ON"))
    	{
	    	List<String> onCities = new ArrayList<>();
	    	onCities.add("Toronto");
	    	onCities.add("Ottawa");
	    	map.put("Ontario", onCities);
    	}
    	
    	if(prov.toUpperCase().equals("QC"))
    	{
	    	List<String> qcCities = new ArrayList<>();
	    	qcCities.add("Quebec");
	    	qcCities.add("Montreal");
	    	map.put("Quebec", qcCities);
    	}
    	
        return (T) map;
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/all/params", method = RequestMethod.GET)
    public <T> T getAllParams(
    	@RequestParam Map<String,String> allParams
    ) {
        Map<String, Object> allParamMap = new LinkedHashMap<String, Object>();
        allParamMap.put("given_params", allParams);  
        
        print(allParams.getClass().getName());
        print(allParams.entrySet().getClass().getName());
        
        return (T) allParamMap;
    }
    
    private static void print(Object content) {
    	System.out.println(content);
    }

    @RequestMapping(value = "x/", method = RequestMethod.GET)
    public <T> T listProvCitiesReq(@RequestParam Map<String, String> req) {
    	
    	//Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
//    	if(prov.toUpperCase().equals("ON"))
//    	{
//	    	List<String> onCities = new ArrayList<>();
//	    	onCities.add("Toronto");
//	    	onCities.add("Ottawa");
//	    	map.put("Ontario", onCities);
//    	}
//    	
//    	if(prov.toUpperCase().equals("QC"))
//    	{
//	    	List<String> qcCities = new ArrayList<>();
//	    	qcCities.add("Quebec");
//	    	qcCities.add("Montreal");
//	    	map.put("Quebec", qcCities);
//    	}
    	
        return (T) req;
    }

}
