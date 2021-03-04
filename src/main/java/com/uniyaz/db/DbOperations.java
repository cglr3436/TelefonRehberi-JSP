package com.uniyaz.db;

import com.uniyaz.domian.Rehber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 3.3.2021.
 */
public class DbOperations {

    public void rehbbereEkle(String isim, String telefon) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO REHBER (ISIM, TELEFON) VALUE ('%s', '%s')";
        sql = String.format(sql, isim, telefon);

        try (
                //Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "deneme", "1Qaz2wsx!!");

                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caglar?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Caglar");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void KisiGuncelle(String isim, String telefon,String ID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE  REHBER SET ISIM='%s',TELEFON='%s' WHERE ID="+ID;
        sql = String.format(sql, isim, telefon);

        try (
                //Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "deneme", "1Qaz2wsx!!");

                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caglar?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Caglar");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void KisiSil(String ID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM REHBER WHERE ID="+ID;


        try (
                //Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "deneme", "1Qaz2wsx!!");

                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caglar?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Caglar");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Rehber KisiGetir(String ID) {

        Rehber rehber = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM REHBER WHERE ID="+ID;

        try (
                //  Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "deneme", "1Qaz2wsx!!");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caglar?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Caglar");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isim = resultSet.getString("ISIM");
                String telefon = resultSet.getString("TELEFON");
                 rehber = new Rehber(id, isim, telefon);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rehber;
    }

    public List<Rehber> rehberiGetir() {

        List<Rehber> rehberList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM REHBER";

        try (
              //  Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.50:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "deneme", "1Qaz2wsx!!");
              Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caglar?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Caglar");
              PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isim = resultSet.getString("ISIM");
                String telefon = resultSet.getString("TELEFON");
                Rehber rehber = new Rehber(id, isim, telefon);
                rehberList.add(rehber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rehberList;
    }
}