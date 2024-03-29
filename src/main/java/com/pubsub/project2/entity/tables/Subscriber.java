/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity.tables;


import com.pubsub.project2.entity.Indexes;
import com.pubsub.project2.entity.Keys;
import com.pubsub.project2.entity.PubsubPhase2;
import com.pubsub.project2.entity.tables.records.SubscriberRecord;

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
public class Subscriber extends TableImpl<SubscriberRecord> {

    private static final long serialVersionUID = -923170350;

    /**
     * The reference instance of <code>pubsub_phase2.subscriber</code>
     */
    public static final Subscriber SUBSCRIBER = new Subscriber();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SubscriberRecord> getRecordType() {
        return SubscriberRecord.class;
    }

    /**
     * The column <code>pubsub_phase2.subscriber.id</code>.
     */
    public final TableField<SubscriberRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pubsub_phase2.subscriber.webhook_url</code>.
     */
    public final TableField<SubscriberRecord, String> WEBHOOK_URL = createField("webhook_url", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>pubsub_phase2.subscriber.nick_name</code>.
     */
    public final TableField<SubscriberRecord, String> NICK_NAME = createField("nick_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>pubsub_phase2.subscriber.is_active</code>.
     */
    public final TableField<SubscriberRecord, Byte> IS_ACTIVE = createField("is_active", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>pubsub_phase2.subscriber</code> table reference
     */
    public Subscriber() {
        this(DSL.name("subscriber"), null);
    }

    /**
     * Create an aliased <code>pubsub_phase2.subscriber</code> table reference
     */
    public Subscriber(String alias) {
        this(DSL.name(alias), SUBSCRIBER);
    }

    /**
     * Create an aliased <code>pubsub_phase2.subscriber</code> table reference
     */
    public Subscriber(Name alias) {
        this(alias, SUBSCRIBER);
    }

    private Subscriber(Name alias, Table<SubscriberRecord> aliased) {
        this(alias, aliased, null);
    }

    private Subscriber(Name alias, Table<SubscriberRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SUBSCRIBER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SubscriberRecord, Long> getIdentity() {
        return Keys.IDENTITY_SUBSCRIBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SubscriberRecord> getPrimaryKey() {
        return Keys.KEY_SUBSCRIBER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SubscriberRecord>> getKeys() {
        return Arrays.<UniqueKey<SubscriberRecord>>asList(Keys.KEY_SUBSCRIBER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subscriber as(String alias) {
        return new Subscriber(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subscriber as(Name alias) {
        return new Subscriber(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscriber rename(String name) {
        return new Subscriber(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscriber rename(Name name) {
        return new Subscriber(name, null);
    }
}
