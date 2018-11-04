/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity.tables;


import com.pubsub.project2.entity.Indexes;
import com.pubsub.project2.entity.Keys;
import com.pubsub.project2.entity.PubsubPhase2;
import com.pubsub.project2.entity.tables.records.SubscriptionRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class Subscription extends TableImpl<SubscriptionRecord> {

    private static final long serialVersionUID = -1345527278;

    /**
     * The reference instance of <code>pubsub_phase2.subscription</code>
     */
    public static final Subscription SUBSCRIPTION = new Subscription();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SubscriptionRecord> getRecordType() {
        return SubscriptionRecord.class;
    }

    /**
     * The column <code>pubsub_phase2.subscription.id</code>.
     */
    public final TableField<SubscriptionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pubsub_phase2.subscription.subscriber_id</code>.
     */
    public final TableField<SubscriptionRecord, Long> SUBSCRIBER_ID = createField("subscriber_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>pubsub_phase2.subscription.topic_id</code>.
     */
    public final TableField<SubscriptionRecord, Long> TOPIC_ID = createField("topic_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>pubsub_phase2.subscription</code> table reference
     */
    public Subscription() {
        this(DSL.name("subscription"), null);
    }

    /**
     * Create an aliased <code>pubsub_phase2.subscription</code> table reference
     */
    public Subscription(String alias) {
        this(DSL.name(alias), SUBSCRIPTION);
    }

    /**
     * Create an aliased <code>pubsub_phase2.subscription</code> table reference
     */
    public Subscription(Name alias) {
        this(alias, SUBSCRIPTION);
    }

    private Subscription(Name alias, Table<SubscriptionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Subscription(Name alias, Table<SubscriptionRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SUBSCRIPTION_PRIMARY, Indexes.SUBSCRIPTION_SUBSCRIBER_ID, Indexes.SUBSCRIPTION_TOPIC_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SubscriptionRecord, Long> getIdentity() {
        return Keys.IDENTITY_SUBSCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SubscriptionRecord> getPrimaryKey() {
        return Keys.KEY_SUBSCRIPTION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SubscriptionRecord>> getKeys() {
        return Arrays.<UniqueKey<SubscriptionRecord>>asList(Keys.KEY_SUBSCRIPTION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<SubscriptionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SubscriptionRecord, ?>>asList(Keys.SUBSCRIPTION_IBFK_1, Keys.SUBSCRIPTION_IBFK_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subscription as(String alias) {
        return new Subscription(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Subscription as(Name alias) {
        return new Subscription(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscription rename(String name) {
        return new Subscription(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Subscription rename(Name name) {
        return new Subscription(name, null);
    }
}