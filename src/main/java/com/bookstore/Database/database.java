package com.bookstore.Database;

import com.bookstore.utils.PropertiesUtil;


import java.sql.*;

public class database {
    /**
     * 驱动类
     */
    private final String driverclass= PropertiesUtil.getProperty("dd.properties","driver");
    /**
     * 连接字符串
     */
    private final String url=PropertiesUtil.getProperty("dd.properties","url");

    /**
     * 连接数据用户名
     */
    private final String name=PropertiesUtil.getProperty("dd.properties","user");
    /**
     * 连接数据库密码
     */
    private final String pwd=PropertiesUtil.getProperty("dd.properties","password");

    public Connection getCon() throws Exception{
        Connection con=null;
        try {
            Class.forName(driverclass);
            con= DriverManager.getConnection(url,name,pwd);
        } catch (Exception e) {
            throw e;
        }
        return con;
    }

    /**
     * 通用增、删、改
     * @param sql
     * @param parms
     * @return
     */
    public int executeUpdate(String sql,Object...parms)throws  Exception
    {
        int r=-1;
        try {

            Connection connection=getCon();

            PreparedStatement ps=connection.prepareStatement(sql);

            if(parms!=null&&parms.length>0)
            {
                int index=1;

                for(Object p:parms)
                {
                    ps.setObject(index,p);
                    index++;
                }
            }
            r=ps.executeUpdate();
            closeConnection(null,ps,connection);
        }catch (Exception ex)
        {
            throw ex;
        }
        return  r;

    }
    /**
    * 通用查询
    * */
    protected ResultSet rs=null;
    public ResultSet executeQuery(String sql,Object...args)throws  Exception{
        try {
            Connection connection=getCon();

            PreparedStatement ps=connection.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     * @throws Exception
     */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn)throws  Exception
    {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }catch (Exception ex)
        {
            throw ex;
        }
    }

}
