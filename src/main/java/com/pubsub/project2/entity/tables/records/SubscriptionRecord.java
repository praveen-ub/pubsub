/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity.tables.records;


import com.pubsub.project2.entity.tables.Subscription;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SubscriptionRecord extends UpdatableRecordImpl<SubscriptionRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 465693595;

    /**
     * Setter for <code>pubsub_phase2.subscription.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscription.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pubsub_phase2.subscription.subscriber_id</code>.
     */
    public void setSubscriberId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscription.subscriber_id</code>.
     */
    public Long getSubscriberId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>pubsub_phase2.subscription.topic_id</code>.
     */
    public void setTopicId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscription.topic_id</code>.
     */
    public Long getTopicId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Subscription.SUBSCRIPTION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Subscription.SUBSCRIPTION.SUBSCRIBER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Subscription.SUBSCRIPTION.TOPIC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getSubscriberId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getTopicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getSubscriberId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getTopicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriptionRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriptionRecord value2(Long value) {
        setSubscriberId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriptionRecord value3(Long value) {
        setTopicId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriptionRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SubscriptionRecord
     */
    public SubscriptionRecord() {
        super(Subscription.SUBSCRIPTION);
    }

    /**
     * Create a detached, initialised SubscriptionRecord
     */
    public SubscriptionRecord(Long id, Long subscriberId, Long topicId) {
        super(Subscription.SUBSCRIPTION);

        set(0, id);
        set(1, subscriberId);
        set(2, topicId);
    }
}
