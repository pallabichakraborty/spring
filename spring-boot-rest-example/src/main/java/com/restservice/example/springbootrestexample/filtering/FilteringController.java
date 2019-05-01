package com.restservice.example.springbootrestexample.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	private static final String FILTER="/filtering";
	private static final String FILTER_LIST="/filtering_list";
	
	@RequestMapping(path=FILTER, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MappingJacksonValue retrieveSomeBean()
	{
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomebeanFilter",
				filter);
		
		
		Somebean somebean=new Somebean("value1","value2","value3");
		MappingJacksonValue mapping=new MappingJacksonValue(somebean);
		
		mapping.setFilters(filters);
		return mapping;
	}
	
	@RequestMapping(path=FILTER_LIST, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public MappingJacksonValue retrieveListSomeBean()
	{
SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomebeanFilter",
				filter);
		
		List<Somebean> list =Arrays.asList(new Somebean("value1","value2","value3"),
				new Somebean("value11","value22","value31"));
		
MappingJacksonValue mapping=new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		return mapping;
	}

}
