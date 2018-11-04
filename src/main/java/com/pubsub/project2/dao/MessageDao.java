package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Message.MESSAGE;

import java.util.UUID;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubsub.project2.dto.Message;
import com.pubsub.project2.entity.tables.records.MessageRecord;

@Component
public class MessageDao{
	
	@Autowired 
	private DSLContext dsl;
	
	@Autowired
	private TopicDao topicDao;
	
	public MessageRecord create(Message message, Long publisherId){
		
		//set UUID on message
		Long topicId = topicDao.findTopicByName(message.getTopic()).getId();
		return dsl.insertInto(MESSAGE,MESSAGE.CONTENT,MESSAGE.PUBLISHER_ID, MESSAGE.TOPIC_ID, MESSAGE.MESSAGE_ID)
			.values(message.getContent(),publisherId,topicId, UUID.randomUUID().toString()).returning(MESSAGE.ID).fetchOne();
	}
	
}