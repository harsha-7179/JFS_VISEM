package com.skillnext1;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "HARSHA13548";

    // INSERT
    public void insert(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (name, sem, dept) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, stu.getName());
        stmt.setInt(2, stu.getSem());
        stmt.setString(3, stu.getDept());
        stmt.executeUpdate();
        conn.close();
    }

    // SELECT ALL
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setSem(rs.getInt("sem"));
            s.setDept(rs.getString("dept"));
            list.add(s);
        }

        conn.close();
        return list;
    }

    // UPDATE
    public void updateStudent(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE student SET name=?, sem=?, dept=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, stu.getName());
        stmt.setInt(2, stu.getSem());
        stmt.setString(3, stu.getDept());
        stmt.setInt(4, stu.getId());
        stmt.executeUpdate();
        conn.close();
    }

    // DELETE
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }
}
