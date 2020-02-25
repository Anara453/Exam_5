package com.company;

import java.sql.*;

import static java.lang.System.currentTimeMillis;

public class News {
    public void CreateNews (String zagalov , String textt,Date  date_of_publication){
    String SQL = "insert into news(zagalov,textt) values (?,?)";
        try (Connection connection = SqlConnection.connect();
    PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
        preparedStatement.setString(1,zagalov);
        preparedStatement.setString(2,textt);
        preparedStatement.setDate(1,date_of_publication);
        Timestamp timestamp = new Timestamp(currentTimeMillis());
        preparedStatement.setTimestamp(2, timestamp);
        preparedStatement.execute();
    } catch (
    SQLException e) {
        System.out.println(e.getMessage());
    }
}
  public void showNews () {
      String SQL = "Select * from news";
      try (Connection connection = SqlConnection.connect();
           PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
          preparedStatement.setString(1, "NEws");
          ResultSet rs = preparedStatement.executeQuery();
          while (rs.next()) {
              System.out.println(rs.getString(1) + " : ");
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
  }
    public void deleteNews () {
        String SQL = "delete from news";
        try (Connection connection = SqlConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, "NEws");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " : ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void CheangeNews(){
        String SQL = "update table news set zagolov = ? , set textt = ?";
        try (Connection connection = SqlConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, "NEws");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " : ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
