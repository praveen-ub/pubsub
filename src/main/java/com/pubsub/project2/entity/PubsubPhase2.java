/*
 * This file is generated by jOOQ.
*/
package com.pubsub.project2.entity;


import com.pubsub.project2.entity.tables.Message;
import com.pubsub.project2.entity.tables.Publisher;
import com.pubsub.project2.entity.tables.Subscriber;
import com.pubsub.project2.entity.tables.Subscription;
import com.pubsub.project2.entity.tables.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class PubsubPhase2 extends SchemaImpl {

    private static final long serialVersionUID = 730904296;

    /**
     * The reference instance of <code>pubsub_phase2</code>
     */
    public static final PubsubPhase2 PUBSUB_PHASE2 = new PubsubPhase2();

    /**
     * The table <code>pubsub_phase2.message</code>.
     */
    public final Message MESSAGE = com.pubsub.project2.entity.tables.Message.MESSAGE;

    /**
     * The table <code>pubsub_phase2.publisher</code>.
     */
    public final Publisher PUBLISHER = com.pubsub.project2.entity.tables.Publisher.PUBLISHER;

    /**
     * The table <code>pubsub_phase2.subscriber</code>.
     */
    public final Subscriber SUBSCRIBER = com.pubsub.project2.entity.tables.Subscriber.SUBSCRIBER;

    /**
     * The table <code>pubsub_phase2.subscription</code>.
     */
    public final Subscription SUBSCRIPTION = com.pubsub.project2.entity.tables.Subscription.SUBSCRIPTION;

    /**
     * The table <code>pubsub_phase2.topic</code>.
     */
    public final Topic TOPIC = com.pubsub.project2.entity.tables.Topic.TOPIC;

    /**
     * No further instances allowed
     */
    private PubsubPhase2() {
        super("pubsub_phase2", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Message.MESSAGE,
            Publisher.PUBLISHER,
            Subscriber.SUBSCRIBER,
            Subscription.SUBSCRIPTION,
            Topic.TOPIC);
    }
}
