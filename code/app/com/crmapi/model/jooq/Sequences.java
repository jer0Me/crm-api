/*
 * This file is generated by jOOQ.
*/
package com.crmapi.model.jooq;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in crm
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>crm.user_id_seq</code>
     */
    public static final Sequence<Long> USER_ID_SEQ = new SequenceImpl<Long>("user_id_seq", Crm.CRM, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
