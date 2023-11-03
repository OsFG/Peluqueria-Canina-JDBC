package com.mycompany.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory (){
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/peluqeria_canina?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("456789");
        pooledDataSource.setMaxPoolSize(12);
        
        this.dataSource = pooledDataSource;
    }

    public Connection recuperaConexion(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
