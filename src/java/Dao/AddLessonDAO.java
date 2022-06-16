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

/**
 *
 * @author Admin
 */
public class AddLessonDAO extends DBContext{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertLesson(String title, int topicID, String type, String status, String video, String conent, int order) {
        String query = "insert into lesson(title, topicID , type, status, videolink, content, order) values(?,?,?,?,?,?,?,?);";
        try {
//            con = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ps.setInt(2, topicID);
            ps.setString(3, type);
            ps.setString(4, status);
            ps.setString(5, video);
            ps.setString(6, conent);
            ps.setInt(7, order);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
