/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

//    public ArrayList<Category> getAllCategory() {
////        ArrayList<Category> list = new ArrayList<>();
////        try {
////            String sql = "select * from Category";
////            PreparedStatement stm = connection.prepareStatement(sql);
////            ResultSet rs = stm.executeQuery();
////            while (rs.next()) {
////                Category category = new Category(rs.getInt("ID"),
////                        rs.getString("Name"));
////
////                list.add(category);
////
////            }
////        } catch (Exception ex) {
////            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return list;
//    }

//    public static void main(String[] args) {
//     /   ArrayList<Category> list = new CategoryDAO().getAllCategory();
//        System.out.println(list);
//    }

}


