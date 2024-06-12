package org.example.dao;

import org.example.models.Jobs;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO
{
    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\Day9\\src\\main\\java\\org\\example\\hr.db";
    private  static final String SELECT_ALL_JOBS = "select * from jobs";
    private static final String SELECT_ONE_JOBS = "select * from jobs where job_id = ?";
    private static final String SELECT_JOB_WITH_MIN_SALARY_PAGINATION = "select * from jobs where min_salary = ?";
    private static final String INSERT_JOB = "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_JOB = "update jobs set job_title = ?, min_salary = ?, max_salary ? = where job_id = ?";
    private static final String DELETE_JOB = "delete from job where job_id = ?";



    public void insertJob(Jobs d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOB);
        st.setInt(1, d.getJob_id());
        st.setString(2, d.getJob_title());
        st.setDouble(3, d.getMin_salary());
        st.setDouble(4, d.getMax_salary());
        st.executeUpdate();
    }

    public void updateJob(Jobs d) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOB);
        st.setInt(1, d.getJob_id());
        st.setString(2, d.getJob_title());
        st.setDouble(3, d.getMin_salary());
        st.setDouble(4, d.getMax_salary());
        st.executeUpdate();
    }

    public void deleteJob(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOB);
        st.setInt(1, job_id);
        st.executeUpdate();
    }

    public Jobs selectJob(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOBS);
        st.setInt(1, job_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Jobs(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Jobs> SELECT_ALL_JOBS(Double min_salary) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st ;
        if(min_salary != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_MIN_SALARY_PAGINATION);
            st.setDouble(1, min_salary);

        }
        else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }

        ResultSet rs = st.executeQuery();
        ArrayList<Jobs> Jobs = new ArrayList<>();
        while (rs.next()) {
            Jobs.add(new Jobs(rs));
        }

        return Jobs;
    }

}