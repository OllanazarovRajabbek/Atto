package com.company.util;
import com.company.status.ProfileRole;
import com.company.status.ProfileStatus;

import java.sql.*;
import java.time.LocalDateTime;

public class DbUtil {
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                    "jdbc_user", "123456"); // <2>
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProfile() {
        try (Connection con = DbUtil.getConnection()) {
            Statement statement = con.createStatement();
            String sql = "create table if not exists profile (" +
                    "        id serial," +
                    "        name varchar(30) not null,   " +
                    "        surname varchar(30) not null," +
                    "        phone varchar(30) not null," +
                    "        password varchar(30)," +
                    "        status varchar(30)," +
                    "        role varchar(30)," +
                    "        created_date timestamp default now()," +
                    "        primary key(id,phone) " +
                    " )";
            statement.executeUpdate(sql);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {

        String sql = "insert into profile(name,surname,phone,password,status,role,created_date) values(?,?,?,?,?,?,?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, "admen");
            preparedStatement.setString(2, "admenjon");
            preparedStatement.setString(3, "123456789");
            preparedStatement.setString(4, "admen123");
            preparedStatement.setString(5, ProfileStatus.ACTIVE.name());
            preparedStatement.setString(6, ProfileRole.ADMEN.name());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean admenIsExists() {
        try {
            Connection con = DbUtil.getConnection();
            Statement statement = con.createStatement(); // <3>
            String sql = "select * from profile where role ='ADMEN'";
            ResultSet resultSet = statement.executeQuery(sql); // <4>
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
