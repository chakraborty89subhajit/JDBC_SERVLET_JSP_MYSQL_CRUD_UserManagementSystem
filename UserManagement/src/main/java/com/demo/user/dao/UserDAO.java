package com.demo.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAO {

    private String jdbcURL="jdbc:mysql://localhost:3306/mydb";
    private String jdbcUserName="root";
    private String jdbcPassword="project";

    private static final String INSERT_USER_SQL="insert into users"+"(name,email,country) values"+"(?,?,?);";
    private static final String SELECT_USER_BY_ID="select id,name,email,country from users where id=?";
    private static final String SELCT_ALL_USERS="selct * from users";

    private static final String DELETE_USER_SQL="delete from users where id=?";
    private static final String UPDATE_USERS_SQL="update users set name=?, email=?,country=? where id=?";


    public UserDAO(){

    }

    protected Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e ){
            e.printStackTrace();

        }
    return con;
    }

}
