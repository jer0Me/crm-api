/*
 * This file is generated by jOOQ.
*/
package model.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;

import model.jooq.Crm;
import model.jooq.Indexes;
import model.jooq.Keys;
import model.jooq.tables.records.LoginRecord;

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
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Login extends TableImpl<LoginRecord> {

    private static final long serialVersionUID = -235425824;

    /**
     * The reference instance of <code>crm.login</code>
     */
    public static final Login LOGIN = new Login();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LoginRecord> getRecordType() {
        return LoginRecord.class;
    }

    /**
     * The column <code>crm.login.id</code>.
     */
    public final TableField<LoginRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('crm.login_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>crm.login.username</code>.
     */
    public final TableField<LoginRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>crm.login.password</code>.
     */
    public final TableField<LoginRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>crm.login.password_salt</code>.
     */
    public final TableField<LoginRecord, UUID> PASSWORD_SALT = createField("password_salt", org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>crm.login.active</code>.
     */
    public final TableField<LoginRecord, Boolean> ACTIVE = createField("active", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("true", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>crm.login.user_id</code>.
     */
    public final TableField<LoginRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('crm.login_user_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>crm.login</code> table reference
     */
    public Login() {
        this(DSL.name("login"), null);
    }

    /**
     * Create an aliased <code>crm.login</code> table reference
     */
    public Login(String alias) {
        this(DSL.name(alias), LOGIN);
    }

    /**
     * Create an aliased <code>crm.login</code> table reference
     */
    public Login(Name alias) {
        this(alias, LOGIN);
    }

    private Login(Name alias, Table<LoginRecord> aliased) {
        this(alias, aliased, null);
    }

    private Login(Name alias, Table<LoginRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Crm.CRM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LOGIN_PKEY, Indexes.LOGIN_USERNAME_UINDEX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LoginRecord, Long> getIdentity() {
        return Keys.IDENTITY_LOGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LoginRecord> getPrimaryKey() {
        return Keys.LOGIN_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LoginRecord>> getKeys() {
        return Arrays.<UniqueKey<LoginRecord>>asList(Keys.LOGIN_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LoginRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LoginRecord, ?>>asList(Keys.LOGIN__LOGIN_USER_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Login as(String alias) {
        return new Login(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Login as(Name alias) {
        return new Login(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Login rename(String name) {
        return new Login(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Login rename(Name name) {
        return new Login(name, null);
    }
}
