package io.github.lonelyMrZhang;

import java.sql.*;

/**
 * @description: 程序耦合事例
 * @author: lonely.mr.zhang
 * @date: 2020/6/11 8:42 下午
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        1、注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Class.forName("com.mysql.jdbc.Driver");
//        2、获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.31.254:3306/coupling_code", "root", "2486");

//        3、获取操作数据库的预处理对象
        PreparedStatement preparedStatement = con.prepareStatement("select * from account");

//        4、执行sql，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
//        5、遍历结果
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
//        6、释放资源
        resultSet.close();
        preparedStatement.close();
        con.close();
    }
}
