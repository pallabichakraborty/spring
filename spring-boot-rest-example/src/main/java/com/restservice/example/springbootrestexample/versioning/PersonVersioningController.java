package com.restservice.example.springbootrestexample.versioning;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	/*private final static String V1_LINK="/v1/person";
	private final static String V2_LINK="/v2/person";*/
	
	private final static String LINK="/person";
	
	
	//http://localhost:8080/person/param?version=1
	@RequestMapping(path=LINK+"/param", params="version=1", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonV1 personV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@RequestMapping(path=LINK+"/param", params="version=2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 personV2()
	{
		return new PersonV2("Bob", "Charlie");
	}
	
	//http://localhost:8080/person/header.. X-API-VERSION=1 in the header
	@RequestMapping(path=LINK+"/header", headers="X-API-VERSION=1", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonV1 headerV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@RequestMapping(path=LINK+"/header", headers="X-API-VERSION=2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PersonV2 headerV2()
	{
		return new PersonV2("Bob", "Charlie");
	}
	
	// http://localhost:8080/person/produces  Accept application/vnd.company.app-v1+json in the header
	@RequestMapping(path=LINK+"/produces", produces="application/vnd.company.app-v1+json", method=RequestMethod.GET)
	public PersonV1 producesV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@RequestMapping(path=LINK+"/produces", produces="application/vnd.company.app-v2+json", method=RequestMethod.GET)
	public PersonV2 producesV2()
	{
		return new PersonV2("Bob", "Charlie");
	}

}
