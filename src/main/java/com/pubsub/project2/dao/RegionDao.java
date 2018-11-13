package com.pubsub.project2.dao;

import static com.pubsub.project2.entity.tables.Region.REGION;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pubsub.project2.entity.tables.records.RegionRecord;

@Component
public class RegionDao{
	
	@Autowired
	private DSLContext dsl;
		
	public boolean addRegion(String regionName){
		
		dsl.insertInto(REGION,REGION.NAME).values(regionName).execute();
		return true;
	}
	
	public RegionRecord findRegionByName(String regionName){
		
		Record record = dsl.select().from(REGION).
				where(REGION.NAME.eq(regionName)).
				fetchOne();
		if(record!=null){
			return record.into(RegionRecord.class);
		}
		return null;
	}

	public List<RegionRecord> findAllRegions(){
		
		return dsl.select().from(REGION).fetch().into(RegionRecord.class);
		
	}

}
