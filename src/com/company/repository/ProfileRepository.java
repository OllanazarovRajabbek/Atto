package com.company.repository;

import com.company.dto.Card;
import com.company.dto.Profile;
import com.company.status.ProfileRole;
import com.company.status.ProfileStatus;
import com.company.util.DbUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProfileRepository {

    public void addCrd(Card card) {


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

    public List<Profile> profileList(String phone) {
        List<Profile> profileList = new LinkedList<>();
        try {
            Connection con = DbUtil.getConnection();
            String sqlQuery = "select * from profile where lower(phone) = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setString(1,phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profile profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setPassword(resultSet.getString("password"));
                profile.setStatus(ProfileStatus.valueOf(resultSet.getString("status")));
                profile.setRole(ProfileRole.valueOf(resultSet.getString("role")));
                profile.setCreated_date(resultSet.getTimestamp("created_date").toLocalDateTime());

                profileList.add(profile);
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profileList;
    }
}
