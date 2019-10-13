/*
 * This file is generated by jOOQ.
 */
package org.ghilardi.newsreader;


import javax.annotation.Generated;

import org.ghilardi.newsreader.tables.News;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_2 = Indexes0.PRIMARY_KEY_2;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_2 = Internal.createIndex("PRIMARY_KEY_2", News.NEWS, new OrderField[] { News.NEWS.ID }, true);
    }
}