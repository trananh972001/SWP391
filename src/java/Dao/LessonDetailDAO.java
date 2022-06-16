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
import java.util.ArrayList;
import java.util.List;
import model.Lesson;

/**
 *
 * @author Admin
 */
public class LessonDetailDAO extends DBContext{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Lesson getLessonDetailByID(int id) {
        //List<Lesson> list = new ArrayList<>();
        String query = "select * from lesson where id = ?";
        try {
//            con = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                 return new Lesson(
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
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editLessonDetail( String title, int topicID, String type, String status, String videolink, String conent, int order) {
        String query = "UPDATE lesson SET title = ? , topicID = ?  , type = ? , status = ?, videolink = ? , content = ?, order = ? WHERE ID = ?;";
        try { 
//            con = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, topicID);
            ps.setString(3, type);
            ps.setString(4, status);
            ps.setString(5, videolink);
            ps.setString(6, conent);
            ps.setInt(7, order);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new LessonDetailDAO().getLessonDetailByID(1));
    }
}

