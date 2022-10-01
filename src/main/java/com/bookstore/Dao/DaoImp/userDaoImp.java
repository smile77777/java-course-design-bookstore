package com.bookstore.Dao.DaoImp;

import com.bookstore.Dao.userDao;
import com.bookstore.Database.database;
import com.bookstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userDaoImp implements userDao{
    database db=new database();
    @Override
    public User login(String name, String password) throws Exception {
        User user=null;
        try{
                String sql="select * from user where user_name=? and user_pwd=?";
                Connection con=db.getCon();
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setObject(1,name);
                ps.setObject(2,password);
                ResultSet rs=ps.executeQuery();
                if(rs.next()) {
                   user=new User();
                   user.setUsername(rs.getString("user_name"));
                   user.setUsernumber(rs.getString("user_number"));
                   user.setUseremail(rs.getString("user_email"));
                   user.setUsersex(rs.getString("user_sex"));
                   user.setUsersite(rs.getString("user_site"));
                   user.setUserpwd(rs.getString("user_pwd"));
                   user.setType(rs.getString("user_type"));
                }
            }catch (Exception ex) {
            throw ex;
            }
        return user;
    }

    @Override
    public User findById(String userId) throws Exception {
        User user=null;
        try{
            String sql="select * from user where user_id=?";
            Connection con=db.getCon();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setObject(1,userId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUsername(rs.getString("user_name"));
                user.setUsernumber(rs.getString("user_number"));
                user.setUseremail(rs.getString("user_email"));
                user.setUsersex(rs.getString("user_sex"));
                user.setUsersite(rs.getString("user_site"));
                user.setUserpwd(rs.getString("user_pwd"));
            }
        }
        catch (Exception e){
            throw e;
        }
        return user;
    }

    @Override
    public int register(User user) throws Exception {
        int r=-1;
        try {
            String sql = "insert into user (user_name,user_email,user_sex,user_site,user_pwd) values(?,?,?,?,?)";
            r = db.executeUpdate(sql, user.getUsername(), user.getUseremail(), user.getUsersex(),user.getUsersite(),user.getUserpwd());
        }catch (Exception e){
            throw e;
        }
        return r;
    }

    @Override
    public List<User> getUsers() throws Exception {
        List<User> list=new ArrayList<>();
        try
        {
            String sql="select * from user";

            Connection conn=db.getCon();

            PreparedStatement ps=conn.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                User user=new User();
                user.setUserid(rs.getString("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setUsernumber(rs.getString("user_number"));
                user.setUseremail(rs.getString("user_email"));
                user.setUsersex(rs.getString("user_sex"));
                user.setUsersite(rs.getString("user_site"));
                user.setUserpwd(rs.getString("user_pwd"));
                list.add(user);
            }
            db.closeConnection(rs,ps,conn);
        }catch (Exception ex)
        {
            throw ex;
        }

        return list;
    }

    @Override
    public int manageSave(User user) throws Exception {
        return 0;
    }

    @Override
    public int update(User user, String userId) throws Exception {
        int r=-1;
        try
        {
            String sql="update user set user_name=?,user_email=?,user_sex=?,user_site=?,user_number=? where user_id=?";

            r=db.executeUpdate(sql,user.getUsername(),user.getUseremail(),user.getUsersex(),user.getUsersite(),user.getUsernumber(),userId);

        }catch (Exception ex)
        {
            throw ex;
        }

        return r;
    }

    @Override
    public int delete(String userId) throws Exception {
        int r=-1;
        try
        {
            String sql="delete from  user  where user_id=?";

            r=db.executeUpdate(sql,userId);

        }catch (Exception ex)
        {
            throw ex;
        }

        return r;
    }

    @Override
    public User findByLoginname(String loginname) throws Exception {
        User user=null;
        try
        {
            String sql="select * from user where user_name=? ";

            Connection conn=db.getCon();

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setObject(1,loginname);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
            {
                user=new User();
                user.setUsername(rs.getString("user_name"));
                user.setUsernumber(rs.getString("user_number"));
                user.setUseremail(rs.getString("user_email"));
                user.setUsersex(rs.getString("user_sex"));
                user.setUsersite(rs.getString("user_site"));
                user.setUserpwd(rs.getString("user_pwd"));
            }
        }catch (Exception ex)
        {
            throw ex;
        }
        return user;
    }
}
