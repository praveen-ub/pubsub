package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Topic.TOPIC;
import static com.pubsub.project2.entity.tables.Subscription.SUBSCRIPTION;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubsub.project2.dto.Topic;
import com.pubsub.project2.entity.tables.records.TopicRecord;

@Component
public class TopicDao{
	
	@Autowired
	private DSLContext dsl;
		
	public boolean addTopic(String topicName){
		
		dsl.insertInto(TOPIC,TOPIC.NAME).values(topicName).execute();
		return true;
	}
	
	public TopicRecord findTopicByName(String topicName){
		
		Record record = dsl.select().from(TOPIC).
				where(TOPIC.NAME.eq(topicName)).
				fetchOne();
		if(record!=null){
			return record.into(TopicRecord.class);
		}
		return null;
	}
	
	public TopicRecord findTopicById(Long topicId){
		
		return dsl.select().from(TOPIC).
				where(TOPIC.ID.eq(topicId)).
				fetchOne().into(TopicRecord.class);
	}
	
	public boolean deleteTopic(String topicName){
		
		dsl.delete(TOPIC).where(TOPIC.NAME.eq(topicName));
		return true;
	}
	
	public List<Topic> findAllTopicsBySubscriberId(Long subscriberId){
		
		Result<?> result = dsl.select().from(TOPIC.join(SUBSCRIPTION).on(TOPIC.ID.eq(SUBSCRIPTION.TOPIC_ID))).where(SUBSCRIPTION.SUBSCRIBER_ID.eq(subscriberId)).fetch();
		List<Topic> topicsList = new ArrayList<Topic>();
		for (Record record: result){
			Topic topic = new Topic();
			topic.setName(record.get(TOPIC.NAME));
			topicsList.add(topic);
		}
		return topicsList;
	}
	
	public List<Topic> findAllTopics(){
		
		List<TopicRecord> records =  dsl.select().from(TOPIC).fetch().into(TopicRecord.class);
		List<Topic> topics = new ArrayList<Topic>();
		for (TopicRecord record: records){
			Topic topic = new Topic();
			topic.setName(record.getName());
			topics.add(topic);
		}
		return topics;
	}
	
	public List<TopicRecord> findAllTopics(List<String> topicNames){
		
		List<TopicRecord> records =  dsl.select().from(TOPIC).where(TOPIC.NAME.in(topicNames)).fetch().into(TopicRecord.class);
		List<Topic> topics = new ArrayList<Topic>();
		for (TopicRecord record: records){
			Topic topic = new Topic();
			topic.setName(record.getName());
			topics.add(topic);
		}
		return records;
	}
}
