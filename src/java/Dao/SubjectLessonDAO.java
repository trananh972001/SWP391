/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;

/**
 *
 * @author Admin
 */
public class SubjectLessonDAO extends DBContext{

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Lesson> getLesson() {
        ArrayList<Lesson> list = new ArrayList<>();
        String query = "select * from lesson";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson llist = new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
                list.add(llist);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Lesson> getLessonBySubID(int id) {
        List<Lesson> list = new ArrayList<>();
        String query = "select * from Lesson where subjectID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Lesson> getLessonByID(int id) {
        List<Lesson> list = new ArrayList<>();
        try {
            String query = "select * from lesson where ID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Lesson(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void editStatus(int id, String status) {
        String query = "UPDATE lesson SET status = ? WHERE ID = ?;";
        try {
//            con = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
      //System.out.println(new SubjectLessonDAO().getLessonBySubID().size());
    }
}
