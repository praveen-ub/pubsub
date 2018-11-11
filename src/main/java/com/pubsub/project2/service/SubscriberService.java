package com.pubsub.project2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.pubsub.project2.dao.SubscriberDao;
import com.pubsub.project2.dao.TopicDao;
import com.pubsub.project2.dto.Subscriber;
import com.pubsub.project2.dto.Topic;
import com.pubsub.project2.entity.tables.records.SubscriberRecord;

@Service
public class SubscriberService{
	
	
	@Autowired
	private SubscriberDao subscriberDao;
	
	@Autowired
	private TopicDao topicDao;
	
	
	
	public Long register(Subscriber subscriber){
		
		Long subscriberId = subscriberDao.addSubscriber(subscriber);
		return subscriberId;
	}
	
	public boolean subscribe(Long subscriberId, JsonNode topics){
		
		List<String> topicsList = new ArrayList<String>();
		for (JsonNode topic: topics){
			topicsList.add(topic.asText());
		}
		subscriberDao.updateSubscription(subscriberId, topicsList, "SUBSCRIBE");
		return true;
	}
	
	public boolean unsubscribe(Long subscriberId, JsonNode topics){
		
		List<String> topicsList = new ArrayList<String>();
		for (JsonNode topic: topics){
			topicsList.add(topic.asText());
		}
		subscriberDao.updateSubscription(subscriberId, topicsList, "UNSUBSCRIBE");
		return true;
	}
	
	public List<Topic> getSubsribedTopics(Long subscriberId){
		
		return topicDao.findAllTopicsBySubscriberId(subscriberId);
		
	}
	
	public List<SubscriberRecord> getTopicSubscribers(String topicName){
		
		return subscriberDao.findAllSubscribersByTopic(topicName);
	}
}