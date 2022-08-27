package com.CredApI.CredApI.DBmanager;

import com.CredApI.CredApI.DAOs.User;
import com.CredApI.CredApI.requeste.CreateRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperation {
    private static volatile Connection connection;
    public static Connection getConnection() throws SQLException {
        if (connection==null)
        {
            synchronized (DBoperation.class)
            {
                if (connection==null)
                {
                    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Users","root","Ayush@123");
                }
            }
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if (connection!=null)
        {
            synchronized (DBoperation.class)
            {
                if (connection!=null)
                {
                    connection.close();
                }
            }
        }
    }
    public static void createTable(String name) throws SQLException {
        getConnection();
        Statement statement= connection.createStatement();
        boolean isCreated=statement.execute("CREATE TABLE "+name+" ( id INT primary key auto_increment,name VARCHAR(20),age INT,address VARCHAR(50));");
        if (isCreated)
        {
            System.out.println("Table is created...");
        }
        closeConnection();
    }
    public static void insertUser(CreateRequest request) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("INSERT into user values(null,?,?,?);");
        preparedStatement.setString(1,request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setString(3,request.getAdress());
        int affected= preparedStatement.executeUpdate();
        if (affected>0)
        {
            System.out.println("SucessFully record is Added.");
        }
        else {
            System.out.println("Unable to adding the record");
        }
        closeConnection();
    }
    public static List<User> getUser() throws SQLException {
        getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from user;");
        List<User> users=new ArrayList<>();
        while (resultSet.next())
        {
            String name= resultSet.getString(2);
            String add= resultSet.getString(4);
            int age=resultSet.getInt(3);
            int id=resultSet.getInt(1);
            User user=new User(id,name,age,add);
            users.add(user);
        }
        closeConnection();
        return users;
    }
    public static void deleteUser(int id) throws SQLException {
        getConnection();
        Statement statement=connection.createStatement();
        int affected= statement.executeUpdate("DELETE FROM user WHERE id="+id+";");
        closeConnection();
    }
    public static User getstudents(int id) throws SQLException {
        getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from user where id="+id+";");
        String n;
        int a;
        String add;
        int i;
        User user;
        if (resultSet.getInt(1)==id)
        {
            n= resultSet.getString(2);
            a=resultSet.getInt(3);
            add=resultSet.getString(4);
            i=resultSet.getInt(1);
            user=new User(i,n,a,add);
        }
        closeConnection();


        return null ;
    }


}
