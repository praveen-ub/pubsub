/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity.tables;


import com.pubsub.project2.entity.Indexes;
import com.pubsub.project2.entity.Keys;
import com.pubsub.project2.entity.PubsubPhase2;
import com.pubsub.project2.entity.tables.records.TopicRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Topic extends TableImpl<TopicRecord> {

    private static final long serialVersionUID = -35752556;

    /**
     * The reference instance of <code>pubsub_phase2.topic</code>
     */
    public static final Topic TOPIC = new Topic();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TopicRecord> getRecordType() {
        return TopicRecord.class;
    }

    /**
     * The column <code>pubsub_phase2.topic.id</code>.
     */
    public final TableField<TopicRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pubsub_phase2.topic.name</code>.
     */
    public final TableField<TopicRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>pubsub_phase2.topic.is_deleted</code>.
     */
    public final TableField<TopicRecord, Byte> IS_DELETED = createField("is_deleted", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>pubsub_phase2.topic</code> table reference
     */
    public Topic() {
        this(DSL.name("topic"), null);
    }

    /**
     * Create an aliased <code>pubsub_phase2.topic</code> table reference
     */
    public Topic(String alias) {
        this(DSL.name(alias), TOPIC);
    }

    /**
     * Create an aliased <code>pubsub_phase2.topic</code> table reference
     */
    public Topic(Name alias) {
        this(alias, TOPIC);
    }

    private Topic(Name alias, Table<TopicRecord> aliased) {
        this(alias, aliased, null);
    }

    private Topic(Name alias, Table<TopicRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return PubsubPhase2.PUBSUB_PHASE2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TOPIC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TopicRecord, Long> getIdentity() {
        return Keys.IDENTITY_TOPIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TopicRecord> getPrimaryKey() {
        return Keys.KEY_TOPIC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TopicRecord>> getKeys() {
        return Arrays.<UniqueKey<TopicRecord>>asList(Keys.KEY_TOPIC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Topic as(String alias) {
        return new Topic(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Topic as(Name alias) {
        return new Topic(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Topic rename(String name) {
        return new Topic(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Topic rename(Name name) {
        return new Topic(name, null);
    }
}
