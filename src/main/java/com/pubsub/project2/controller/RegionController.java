package com.pubsub.project2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pubsub.project2.dto.AppResponse;

@RestController
@RequestMapping("/api/regions")
public class RegionController{
	
	@Value("${service.region}")
	private String region;
	
	@RequestMapping(value="/region",method=RequestMethod.GET)
	public AppResponse getRegion(){
		
		return new AppResponse(200,"Success",region);
	}
}