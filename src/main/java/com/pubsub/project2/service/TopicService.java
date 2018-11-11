package com.pubsub.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pubsub.project2.dao.TopicDao;
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.dto.Topic;

@Service
public class TopicService{
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private NotificationService notificationService;
	
	public boolean addTopic(String topicName){
		
		topicDao.addTopic(topicName);
		return true;
	}
	
	public boolean deleteTopic(String topicName){
		
		topicDao.deleteTopic(topicName);
		return true;
	}
	
	public List<Topic> getAllTopics(){
		
		return topicDao.findAllTopics();
	}
	
	public boolean advertise(List<Topic> topics){
		
		for (Topic topic: topics){
			
			String topicName = topic.getName();
			if(topicDao.findTopicByName(topicName) == null){
				topicDao.addTopic(topicName);
				Message newTopicMessage = new Message();
				newTopicMessage.setContent("New Topic '"+topic.getName()+"' has been added");
				newTopicMessage.setTopic(topicName);
				newTopicMessage.setNotificationType("topicUpdate");
				notificationService.notifySubscribers(newTopicMessage, null);
			}
		}
		return true;
	}
}