package com.company.repository;

import com.company.dto.Card;
import com.company.dto.Profile;
import com.company.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProfileRepository {

    public void addCrd(Card card) {


    }

    public boolean login(String phone, String password) {
        String sql = "select * from profile where phone ='%s' and password='%s'";
        try (Connection connection =DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,phone);
            preparedStatement.setString(2,password);

            int result=preparedStatement.executeUpdate();
            connection.close();
            return result!=1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean registration(Profile profile) {
        String sql = "insert into profile(name,surname,phone,password,status,role,created_date) values(?,?,?,?,?,?,?)";
        try (Connection con = DbUtil.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setString(3, profile.getPhone());
            preparedStatement.setString(4, profile.getPassword());
            preparedStatement.setString(5, profile.getStatus().name());
            preparedStatement.setString(6, profile.getRole().name());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(profile.getCreated_date()));


            int effectedRows = preparedStatement.executeUpdate();
            con.close();
            return effectedRows == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
