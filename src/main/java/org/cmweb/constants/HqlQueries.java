package org.cmweb.constants;

public class HqlQueries {
    public final static String DEACTIVATE_ALL_TOKENS_BY_USER = "DEACTIVATE_ALL_TOKENS_BY_USER";
    public final static String DEACTIVATE_ALL_TOKENS_BY_USER_QUERY = "update CustomerTokenEntity ct set ct.status=? where ct.customer=?";

    public final static String CHANGE_TOKEN_STATUS = "CHANGE_TOKEN_STATUS";
    public final static String CHANGE_TOKEN_STATUS_QUERY = "update CustomerTokenEntity ct set ct.status=? where ct.token=?";
}
