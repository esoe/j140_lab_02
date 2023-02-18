package ru.molokoin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Реализация подключения к базе данных для работы с таблицами
 * - чтение настроек подключения из файла assess.prop
 * 
 */
public class Base {
    private Access access = new Access("property\\access.prop");//путь к файлу настроек
    public boolean granted = false;//права пользователя подтверждены
    public Base(User user){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select * from users";
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                // System.out.println("Сравниваем данные указанные пользователем с сожержимым базы данных ...");
                if (user.equals(new User(rs.getString(2), rs.getString(3)))){
                    granted = true;
                    System.out.println("Доступ предоставлен ...");
                }else{
                    granted = false;
                    System.out.println("В доступе отказано ...");
                    System.out.println("Попробуйте еще раз ...");
                }
                // if ((user.getName().equals(rs.getString(2))) & (user.getPassword().equals(rs.getString(3)))){
                //     granted = true;
                //     System.out.println("Доступ предоставлен ...");
                // }else{
                //     granted = false;
                //     System.out.println("В доступе отказано ...");
                //     System.out.println("Попробуйте еще раз ...");
                // }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
