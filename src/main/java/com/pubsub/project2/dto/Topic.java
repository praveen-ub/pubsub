package com.pubsub.project2.dto;

public class Topic{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object that){
		
		if(that == null || !(that instanceof Topic))
			return false;
		
		Topic thatTopic = (Topic) that;
		if(this.name.equals(thatTopic.name)){
			return true;
		}
		else{
			return false;
		}
	}
}
