package com.example_utp.demo_utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class PostgresqlController {
    @Autowired
    private DataSource datasource;

    @GetMapping("/prueba")
    public String connection(){
        try(Connection connection= datasource.getConnection()){

            return "Si se conecto: "+connection.getMetaData().getDatabaseProductName();
        }catch (SQLException e){
            e.printStackTrace();
            return "Error en la conexion de java con postgresql :"+ e.getMessage();
        }
    }
}
