package com.example.eduardosilvafinals;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {

    public List<Savings> display() throws ClassNotFoundException, SQLException;
    public Savings update(Savings sav, String custono) throws SQLException, ClassNotFoundException;

    Savings edit(Savings sav, String custno, String custname, Double cdep, Integer nyears, String savtype)
                    throws SQLException, ClassNotFoundException;

    public void delete(String custno) throws SQLException;

    public void add(Savings sav) throws ClassNotFoundException, SQLException;

}
