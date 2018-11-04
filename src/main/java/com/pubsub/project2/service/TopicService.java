package com.pubsub.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pubsub.project2.dao.TopicDao;
import com.pubsub.project2.dto.Topic;

@Service
public class TopicService{
	
	@Autowired
	private TopicDao topicDao;
	
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
}