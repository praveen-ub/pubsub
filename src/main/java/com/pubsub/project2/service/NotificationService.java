package com.pubsub.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pubsub.project2.dto.Activity;
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.entity.tables.records.SubscriberRecord;

@Service
public class NotificationService{
	
	@Autowired
	private SimpMessagingTemplate template;
	
	public boolean notifySubscribers(Message message, List<SubscriberRecord> subscribers){
		
		for (SubscriberRecord subscriber : subscribers){
			
			System.out.println("Going to notify subsriber with id::"+subscriber.getId());
			String notificationUrl = subscriber.getWebhookUrl();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			RestTemplate restTemplate = new RestTemplate();
	    	HttpEntity<Object> requestEntity = new HttpEntity<Object>(message, headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(notificationUrl, HttpMethod.POST,
		            requestEntity, String.class);
			String response = responseEntity.getBody();
			System.out.println("Response is::"+response);
			Activity activity = new Activity();
			activity.setAction("Subscriber with id::"+subscriber.getId()+":: has been notified of message with topic::"+message.getTopic());
			template.convertAndSend("/topic/notifications",activity);
		}
		return true;
	}
}
