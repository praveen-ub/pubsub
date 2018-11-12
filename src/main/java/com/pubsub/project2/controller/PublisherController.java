package com.pubsub.project2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.dto.Publisher;
import com.pubsub.project2.dto.Topic;
import com.pubsub.project2.service.PublisherService;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController{
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public AppResponse register(@RequestBody Publisher publisher){
		
		System.out.println("Incoming Publisher for registration");
		Long publisherId = publisherService.register(publisher);
		System.out.println("Registration done::"+publisherId);
		Activity activity = new Activity();
		activity.setAction("Publisher with endpoint::"+publisher.getWebHookUrl()+" has joined from "+publisher.getRegion());
		template.convertAndSend("/topic/registrations",activity);
		HashMap dataMap = new HashMap();
		dataMap.put("id", publisherId);
		return new AppResponse(200, "Success", dataMap);
	}
	

	@RequestMapping(value="/{id}/advertise",method=RequestMethod.POST)
	public AppResponse advertise(@RequestBody JsonNode topicsData, @PathVariable("id") Long publisherId){
		
		JsonNode topics = topicsData.get("topics");
		List<Topic> topicsList = new ArrayList<Topic>();
		for (JsonNode topicNode : topics){
			String topicName = topicNode.asText();
			Topic topic = new Topic();
			topic.setName(topicName);
			topicsList.add(topic);
		}
		publisherService.advertise(topicsList);
		return new AppResponse(200,"Success");
	}
	
	@RequestMapping(value="/{id}/publish",method=RequestMethod.POST)
	public AppResponse publish(@RequestBody Message message, @PathVariable("id") Long publisherId){
		
		System.out.println("Publisher with id::"+publisherId+"wants to publish the message with topic::"+message.getTopic());
		publisherService.publish(message, publisherId);
		Activity activity = new Activity();
		activity.setActivityType("Publishing");
		activity.setAction("Publisher with id::"+publisherId+"published a message with topic::"+message.getTopic());
		template.convertAndSend("/topic/publishing",activity);
		return new AppResponse(200, "Success");
	}
	
}