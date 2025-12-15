package com.skillnext1;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/skillnext_db",
            "root",
            "pranithasri"
        );
    }

    // INSERT
    public void addStudent(Student s) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO student(name, sem, dept) VALUES (?, ?, ?)");
        ps.setString(1, s.getName());
        ps.setInt(2, s.getSem());
        ps.setString(3, s.getDept());
        ps.executeUpdate();
        con.close();
    }

    // UPDATE by ID
    public void updateStudent(int id, String name, int sem, String dept) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps =
            con.prepareStatement("UPDATE student SET name=?, sem=?, dept=? WHERE id=?");
        ps.setString(1, name);
        ps.setInt(2, sem);
        ps.setString(3, dept);
        ps.setInt(4, id);
        ps.executeUpdate();
        con.close();
    }

    // DELETE by ID
    public void deleteStudent(int id) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // SELECT all students
    public List<Student> getAllStudents() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("sem"),
                rs.getString("dept")
            ));
        }
        con.close();
        return list;
    }
}
