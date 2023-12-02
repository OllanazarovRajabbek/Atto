package com.company.repository;

import com.company.dto.Card;
import com.company.status.CardStatus;
import com.company.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CardRepository {
    public void saveCard(Card cardDTO) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "insert into cards (id,numbers,exp_date,balance,status,phone) values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, cardDTO.getId());
            preparedStatement.setString(2, cardDTO.getNumber());
            preparedStatement.setString(3, cardDTO.getEx_date());
            preparedStatement.setDouble(4, cardDTO.getBalance());
            preparedStatement.setString(5, cardDTO.getStatus().name());
            preparedStatement.setString(6, cardDTO.getPhone());

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Card> getAllCard() {
        List<Card> cardDTOS = new LinkedList<>();

        Connection con = DbUtil.getConnection();
        try {
            String sql = "select * from cards";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Card card = new Card();
                card.setId(rs.getString("id"));
                card.setNumber((rs.getString("numbers")));
                card.setEx_date(rs.getString("exp_date"));
                card.setBalance(rs.getDouble("balance"));
                card.setStatus(CardStatus.valueOf(rs.getString("status")));
                card.setPhone(rs.getString("phone"));
                card.setLocalDateTime(rs.getTimestamp("created_date").toLocalDateTime());
                cardDTOS.add(card);

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardDTOS;
    }

    public void updateTaskList(String id, Card card) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set numbers = ? , exp_date=? where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, card.getNumber());
            preparedStatement.setString(2, card.getEx_date());
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeCardStatus(String id, Card card) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set status = ?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, card.getStatus().name());
            preparedStatement.setString(2,id);

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCard(String id) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "delete from cards where id=?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeCardForReFill(Card card) {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set balance = ?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, card.getBalance());
            preparedStatement.setString(2, card.getId());

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addBalanceCompanyCard() {
        Connection con = DbUtil.getConnection();
        try {
            String sql = "update cards set balance = ?  where id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setDouble(1, Fair.totalFair);
            preparedStatement.setString(2, "adminCard");

            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
