package com.ede.client.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AccessDb - interface which contains from 2 methods. getCurrentConnection() and getResultSetOfQuery().
 * @author WalkCat
 * @version 0.1
 * */
public interface AccessDb {

    /**
     * Method which return new connection
     * @return Connection
     * @throws SQLException
     * */
    Connection getCurrentConnection() throws SQLException;

    /**
     * Method which return ResultSet of query in database.
     * @param connection - current connection with database
     * @param sql - sql language query to database
     * @return ResultSet
     * @exception java.io.IOException
     * */
    ResultSet getResultSetOfQuery(Connection connection, String sql);
}
