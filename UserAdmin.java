
package com.tech.blog.entities;
import java.sql.*;
import java.util.Random;

public class UserAdmin {
    private String userId;
    private String password;
    
    public UserAdmin(){
        
    }

    public UserAdmin(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
