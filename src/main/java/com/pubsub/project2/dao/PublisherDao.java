package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Publisher.PUBLISHER;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubsub.project2.dto.Publisher;
import com.pubsub.project2.entity.tables.records.PublisherRecord;

@Component
public class PublisherDao{
	
	@Autowired
	private DSLContext dsl;
	
	public Long addPublisher(Publisher publisher){
		
		dsl.insertInto(PUBLISHER,PUBLISHER.WEBHOOK_URL)
			.values(publisher.getWebHookUrl()).execute();
		PublisherRecord record = dsl.select().from(PUBLISHER).where(PUBLISHER.WEBHOOK_URL.eq(publisher.getWebHookUrl())).fetchOne().into(PublisherRecord.class);
		System.out.println("Inserted record");
		return record.getId();
	}
	
	public boolean updatePublisher(Long publisherId, String webHookUrl){
		
//		Publisher publisher = findPublisherById(publisherId);
//		publisher.setWebHookUrl(webHookUrl);
//		publisher.setActive(true);
//		
//		Session session = sessionFactory.getCurrentSession();
//		session.update(publisher);
		return true;
	}
	
//	public Publisher findPublisherById(Long publisherId){
//		
//		Session session = sessionFactory.getCurrentSession();
//		return session.get(Publisher.class, publisherId);
//	}
	

//	public List<Publisher> findAllPublishers(){
//		
//		Session session = sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(Publisher.class);
//		return (List<Publisher>)crit.list();
//	}
}
