package org.xigua.study.database.mysql;

import java.sql.*;

/**
 * @author xigua
 */
public class TestDataBase {
    public static void main(String[] args) {
        Connection connection = null;

        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/xigua_study";

        String user = "root";

        String password = "!qaz@wsx";

        String sql = "select * from xs_user";

        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(url, user, password);


            if (!connection.isClosed()) {
                System.out.println("Succeeded connecting to the Database");
            }

            //获得声明
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("user_id"));
            }

            resultSet.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
