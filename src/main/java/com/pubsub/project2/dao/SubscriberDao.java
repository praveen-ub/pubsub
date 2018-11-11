package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Publisher.PUBLISHER;
import static com.pubsub.project2.entity.tables.Subscriber.SUBSCRIBER;
import static com.pubsub.project2.entity.tables.Subscription.SUBSCRIPTION;
import static com.pubsub.project2.entity.tables.Topic.TOPIC;

import java.util.ArrayList;
import java.util.List;

import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubsub.project2.dto.Subscriber;
import com.pubsub.project2.entity.tables.records.PublisherRecord;
import com.pubsub.project2.entity.tables.records.SubscriberRecord;
import com.pubsub.project2.entity.tables.records.TopicRecord;

@Component
public class SubscriberDao{
	
	@Autowired 
	private DSLContext dsl;
	
	@Autowired
	private TopicDao topicDao;
	
	public Long addSubscriber(Subscriber subscriber){
		
		SubscriberRecord record = findSubscriberByWebhookUrl(subscriber.getWebHookUrl());
		if(record == null){
			dsl.insertInto(SUBSCRIBER,SUBSCRIBER.WEBHOOK_URL)
			.values(subscriber.getWebHookUrl()).execute();
			record = dsl.select().from(SUBSCRIBER).where(SUBSCRIBER.WEBHOOK_URL.eq(subscriber.getWebHookUrl())).fetchOne().into(SubscriberRecord.class);
			System.out.println("Inserted subscriber with webhook::"+subscriber.getWebHookUrl());
		}
		return record.getId();
	}
	
	public boolean updateSubscriber(Long subscriberId, String webHookUrl){
		
//		Subscriber subscriber = findSubscriberById(subscriberId);
//		subscriber.setWebHookUrl(webHookUrl);
//		subscriber.setActive(true);
//		
//		Session session = sessionFactory.getCurrentSession();
//		session.update(subscriber);
		return true;
	}
	
	public SubscriberRecord findSubscriberById(Long subscriberId){
		
		return dsl.select().from(SUBSCRIBER).where(SUBSCRIBER.ID.eq(subscriberId)).fetchOne().into(SubscriberRecord.class);
	}
	
	public SubscriberRecord findSubscriberByWebhookUrl(String webHookUrl){
		
		Record record = dsl.select().from(SUBSCRIBER).where(SUBSCRIBER.WEBHOOK_URL.eq(webHookUrl)).fetchOne(); 
		if(record !=null){
			return record.into(SubscriberRecord.class);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<SubscriberRecord> findAllSubscribers(){
		
		return dsl.select().from(SUBSCRIBER).fetch().into(SubscriberRecord.class);
	}
	
	public List<SubscriberRecord> findAllSubscribersByTopic(String topicName){
		
		Result<?> result = dsl.select().from(TOPIC.join(SUBSCRIPTION).on(TOPIC.ID.eq(SUBSCRIPTION.TOPIC_ID))).where(TOPIC.NAME.eq(topicName)).fetch();
		List<Long> subscriberIds = new ArrayList<Long>();
		for (Record record: result){
			subscriberIds.add(record.get(SUBSCRIPTION.SUBSCRIBER_ID));
		}
		return dsl.select().from(SUBSCRIBER)
				.where(SUBSCRIBER.ID.in(subscriberIds))
				.fetchInto(SubscriberRecord.class);
	}
	
	public boolean updateSubscription(Long subscriberId, List<String> topics, String action){
		
		List<TopicRecord> topicRecords = topicDao.findAllTopics(topics);
		if("SUBSCRIBE".equals(action)){
			BatchBindStep batch = dsl.batch(dsl.insertInto(SUBSCRIPTION,SUBSCRIPTION.SUBSCRIBER_ID, SUBSCRIPTION.TOPIC_ID).values((Long)null,(Long)null));
			for (TopicRecord topic: topicRecords){
				batch.bind(subscriberId,topic.getId());
			}
			batch.execute();
		}
		else if("UNSUBSCRIBE".equals(action)){
			List<Long> topicIds = new ArrayList<Long>();
			for (TopicRecord record : topicRecords){
				topicIds.add(record.getId());
			}
			dsl.delete(SUBSCRIPTION).where(SUBSCRIPTION.SUBSCRIBER_ID.eq(subscriberId)).and(SUBSCRIPTION.TOPIC_ID.in(topicIds)).execute();
		}
		return true;
	}
	
}
