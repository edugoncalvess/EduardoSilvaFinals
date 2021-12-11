package com.example.eduardosilvafinals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;
    public DatabaseService(Connection con) {
        this.con = con;
    }


    @Override
    public List<Savings> display() throws ClassNotFoundException, SQLException {


        List<Savings> Savingslist = new ArrayList<Savings>();

        String query1 = "Select * from savings";
        PreparedStatement query = con.prepareStatement(query1);
        ResultSet rs = query.executeQuery();

        Savings object1;

        //display records if there is data;

        while (rs.next()) {

            object1 = new Savings(rs.getString("custno"), rs.getString("custname"),
                        rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));

            Savingslist.add(object1);
        }

        return Savingslist;
    }

    @Override
    public Savings update(Savings sav, String custono) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Savings edit(Savings sav, String custno, String custname, Double cdep, Integer nyears, String savtype)
                    throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        query = con.prepareStatement("Update savings set custno=?, custname=?, cdep=?, nyears=?, savtype=? where catcode = ?");
        query.setString(1, sav.getCustno());
        query.setString(2, sav.getCustname());
        query.setDouble(3, sav.getCdep());
        query.setInt(4, sav.getNyears());
        query.setString(5, sav.getSavtype());
        query.setString(6, custno);

        query.executeUpdate();

        return sav;

    }

    @Override
    public void delete(String custno) throws SQLException {

        String query1 = "Delete from savings where custno = ?";
        PreparedStatement query = con.prepareStatement(query1);
        query.setString(1, custno);
        query.executeUpdate();

    }

    @Override
    public void add(Savings sav) throws ClassNotFoundException, SQLException {

        String query1 = "INSERT INTO savings VALUES ( ?, ?, ?, ?, ? )";
        PreparedStatement query = con.prepareStatement(query1);


        query.setString(1, sav.getCustno());
        query.setString(2, sav.getCustname());
        query.setDouble(3, sav.getCdep());
        query.setInt(4, sav.getNyears());
        query.setString(5, sav.getSavtype());

        query.executeUpdate();

    }


    public Savings search(String custno) throws SQLException,ClassNotFoundException {



        String quer1 = "Select * from savings where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);

        ResultSet rs = query.executeQuery();

        if(!rs.first()){

            System.out.print("The record you are trying to add is already existing. Choose a different customer number");
            return null;
        }


        Savings obj1=null;




        obj1 = new Savings(rs.getString("custno"), rs.getString("custname"),
                rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));

        return obj1;






    }

}
