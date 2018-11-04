package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Topic.TOPIC;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
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
		
		return dsl.select().from(TOPIC).
				where(TOPIC.NAME.eq(topicName)).
				fetchOne().into(TopicRecord.class);
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
