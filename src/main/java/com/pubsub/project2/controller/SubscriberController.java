package com.pubsub.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.pubsub.project2.dto.Activity;
import com.pubsub.project2.dto.AppResponse;
import com.pubsub.project2.dto.Subscriber;
import com.pubsub.project2.service.SubscriberService;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController{
	
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public AppResponse register(@RequestBody Subscriber subscriber){
		
		System.out.println("Incoming subscriber for registration");
		Long subscriberId = subscriberService.register(subscriber);
		System.out.println("Regisration done::"+subscriberId);
		Activity activity = new Activity();
		activity.setAction("Publisher with endpoint::"+subscriber.getWebHookUrl()+" has joined");
		template.convertAndSend("/topic/registrations",activity);
		return new AppResponse(200, "Success",subscriberId);
	}
	
	@RequestMapping(value="/{id}/subscribe",method=RequestMethod.POST)
	public AppResponse subscribe(@RequestBody JsonNode request, @PathVariable("id") Long subscriberId ){
		
		JsonNode topics= request.get("topic");
		for (JsonNode topic: topics){
			System.out.println(topic+"::Intersted");
		}
		subscriberService.subscribe(subscriberId, topics);
		Activity activity = new Activity();
		activity.setAction("Subscriber with id::"+subscriberId+" has subscribed to the topics::"+topics);
		template.convertAndSend("/topic/subscriptions",activity);
		return new AppResponse(200,"Success");	
	}
	
	@RequestMapping(value="/{id}/unsubscribe",method=RequestMethod.POST)
	public AppResponse unsubscribe(@RequestBody JsonNode request, @PathVariable("id") Long subscriberId ){
		
		JsonNode topics= request.get("topic");
		for (JsonNode topic: topics){
			System.out.println(topic+"::Intersted");
		}
		subscriberService.unsubscribe(subscriberId, topics);
		Activity activity = new Activity();
		activity.setAction("Subscriber with id::"+subscriberId+" has unsubscribed from the topics::"+topics);
		template.convertAndSend("/topic/subscriptions",activity);
		return new AppResponse(200,"Success");	
	}
	
}