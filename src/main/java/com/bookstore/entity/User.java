package com.bookstore.entity;

import java.io.Serializable;

public class User implements Serializable {
    public static int USER_TYPE_ORDINARY = 1;
    public static int USER_TYPE_ADMIN = 2;
    private String userid;
    private String username;
    private String userpwd;
    private String useremail;
    private String usernumber;
    private String usersex;
    private String usersite;
    private String type;

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public static int getUserTypeOrdinary() {
        return USER_TYPE_ORDINARY;
    }

    public static void setUserTypeOrdinary(int userTypeOrdinary) {
        USER_TYPE_ORDINARY = userTypeOrdinary;
    }

    public static int getUserTypeAdmin() {
        return USER_TYPE_ADMIN;
    }

    public static void setUserTypeAdmin(int userTypeAdmin) {
        USER_TYPE_ADMIN = userTypeAdmin;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUsersite() {
        return usersite;
    }

    public void setUsersite(String usersite) {
        this.usersite = usersite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", usernumber='" + usernumber + '\'' +
                ", usersex='" + usersex + '\'' +
                ", usersite='" + usersite + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
