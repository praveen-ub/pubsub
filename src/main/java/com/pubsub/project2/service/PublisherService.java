package com.pubsub.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pubsub.project2.dao.PublisherDao;
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.dto.Publisher;

@Service
public class PublisherService{
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private PublisherDao publisherDao;
	
	public Long register(Publisher publisher){
		
		Long publisherId = publisherDao.addPublisher(publisher);
		return publisherId;
	}
	
	public boolean publish(Message message, Long publisherId){
		
		messageService.publish(message, publisherId);
		return true;
		
	}
}