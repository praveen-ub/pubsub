/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity.tables.records;


import com.pubsub.project2.entity.tables.Subscriber;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class SubscriberRecord extends UpdatableRecordImpl<SubscriberRecord> implements Record4<Long, String, String, Byte> {

    private static final long serialVersionUID = 520056246;

    /**
     * Setter for <code>pubsub_phase2.subscriber.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscriber.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pubsub_phase2.subscriber.webhook_url</code>.
     */
    public void setWebhookUrl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscriber.webhook_url</code>.
     */
    public String getWebhookUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pubsub_phase2.subscriber.nick_name</code>.
     */
    public void setNickName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscriber.nick_name</code>.
     */
    public String getNickName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pubsub_phase2.subscriber.is_active</code>.
     */
    public void setIsActive(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>pubsub_phase2.subscriber.is_active</code>.
     */
    public Byte getIsActive() {
        return (Byte) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, String, String, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Subscriber.SUBSCRIBER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Subscriber.SUBSCRIBER.WEBHOOK_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Subscriber.SUBSCRIBER.NICK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Subscriber.SUBSCRIBER.IS_ACTIVE;
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
    public String component2() {
        return getWebhookUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNickName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
        return getIsActive();
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
    public String value2() {
        return getWebhookUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNickName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getIsActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriberRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriberRecord value2(String value) {
        setWebhookUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriberRecord value3(String value) {
        setNickName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriberRecord value4(Byte value) {
        setIsActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubscriberRecord values(Long value1, String value2, String value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SubscriberRecord
     */
    public SubscriberRecord() {
        super(Subscriber.SUBSCRIBER);
    }

    /**
     * Create a detached, initialised SubscriberRecord
     */
    public SubscriberRecord(Long id, String webhookUrl, String nickName, Byte isActive) {
        super(Subscriber.SUBSCRIBER);

        set(0, id);
        set(1, webhookUrl);
        set(2, nickName);
        set(3, isActive);
    }
}
