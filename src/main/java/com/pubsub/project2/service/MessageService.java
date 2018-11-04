package com.pubsub.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pubsub.project2.dao.MessageDao;
import com.pubsub.project2.dto.Message;
import com.pubsub.project2.entity.tables.records.MessageRecord;
import com.pubsub.project2.entity.tables.records.SubscriberRecord;

@Service
public class MessageService{
	
	@Autowired
	private SubscriberService subscriberService;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private NotificationService notificationService;
	
	public boolean publish(Message message, Long publisherId){
		
		MessageRecord messageRecord = messageDao.create(message, publisherId);
		List<SubscriberRecord> subscribers = subscriberService.getTopicSubscribers(message.getTopic());
		notificationService.notifySubscribers(message, subscribers);
		return true;
	}
}