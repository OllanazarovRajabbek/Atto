package com.company.service;

import com.company.container.ComponentContainer;
import com.company.dto.Card;
import com.company.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public void addCardForUser(Card cardDTO) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set phone = ?, status=?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ComponentContainer.currentUser.getPhone());
            preparedStatement.setString(2, cardDTO.getStatus().name());
            preparedStatement.setString(3, cardDTO.getId());

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void changeCardStatus(Card cardDTO) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set status=?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cardDTO.getStatus().name());
            preparedStatement.setString(2, cardDTO.getId());

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCard(Card cardDTO) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set number=?, phone=?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cardDTO.getNumber());
            preparedStatement.setString(2,null);
            preparedStatement.setString(3, cardDTO.getId());


            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
