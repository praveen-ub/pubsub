package com.pubsub.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pubsub.project2.dto.AppResponse;
import com.pubsub.project2.dto.Topic;
import com.pubsub.project2.service.TopicService;

@RestController
@RequestMapping("/api/topics")
public class TopicsController{
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public AppResponse addTopic(@PathVariable("id") Long publisherId, @RequestBody Topic topic){
		
		topicService.addTopic(topic.getName());
		return new AppResponse(200,"Success");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	//Delete has no request body!!!
	public AppResponse deleteTopic(@PathVariable("id") Long publisherId,@RequestBody Topic topic){
		
		topicService.deleteTopic(topic.getName());
		return new AppResponse(200,"Success");
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public AppResponse getTopics(){
		
		List<Topic> topics = topicService.getAllTopics();
		return new AppResponse(200,"Success",topics);
	}
}