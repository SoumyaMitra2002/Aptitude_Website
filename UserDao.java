package com.tech.blog.dao;
import com.tech.blog.entities.QuestionTake;
import com.tech.blog.entities.User;
import com.tech.blog.entities.UserAdmin;
import java.sql.*;
public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con=con;
    }
    public boolean saveUser(User user){
        boolean t=false;
        try{
            String query="insert into new_table(name,email,password,gender,about) values (?,?,?,?,?)";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());
            pstmt.executeUpdate();
            t=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return t;
    }
    
    public User getUserEmailAndPassword(String email,String password){
        User user=null;
        try{
            String query="select * from new_table where email=? and password=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            ResultSet set=pstmt.executeQuery();
            if(set.next()){
                user=new User();
                
                String name=set.getString("name");
                user.setName(name);
                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setGender(set.getString("gender"));
                user.setAbout(set.getString("about"));
                user.setDataTime(set.getTimestamp("rdate"));
                user.setProfile(set.getString("profile"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean updateUser(User user){
        boolean f=false;
        try{
            String query="update new_table set name=?,email=?,password=?,gender=?,about=?,profile=? where id=?";
            PreparedStatement psmt=con.prepareStatement(query);
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getEmail());
            psmt.setString(3, user.getPassword());
            psmt.setString(4, user.getGender());
            psmt.setString(5, user.getAbout());
            psmt.setString(6,user.getProfile());
            psmt.setInt(7,user.getId());
            
            psmt.executeUpdate();
            f=true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public UserAdmin getUserIdAndPassword(String userId,String password){
        UserAdmin useradmin=null;
        try{
            String query="select * from admin where UserId=? and Password=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            
            ResultSet set=pstmt.executeQuery();
            if(set.next()){
                useradmin=new UserAdmin();
                useradmin.setUserId(set.getString("userId"));
                useradmin.setPassword(set.getString("password"));
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return useradmin;
    }
    public boolean addQuestion(QuestionTake q){
        boolean x=false;
        try{
            String query="insert into question_table(question,a,b,c,d,answer) values (?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1, q.getQuestion());
            pstmt.setString(2, q.getA());
            pstmt.setString(3, q.getB());
            pstmt.setString(4, q.getC());
            pstmt.setString(5, q.getD());
            pstmt.setString(6, q.getAnswer());
            pstmt.executeUpdate();
            x=true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }

}

