package com.pubsub.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pubsub.project2.dto.Activity;
import com.pubsub.project2.dto.AppResponse;
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.dto.Publisher;
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
		
		System.out.println("Incoming subscriber for registration");
		Long publisherId = publisherService.register(publisher);
		System.out.println("Registration done::"+publisherId);
		Activity activity = new Activity();
		activity.setAction("Publisher with endpoint::"+publisher.getWebHookUrl()+" has joined");
		template.convertAndSend("/topic/registrations",activity);
		return new AppResponse(200, "Success", publisherId);
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