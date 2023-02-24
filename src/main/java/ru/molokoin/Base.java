package ru.molokoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Реализация подключения к базе данных для работы с таблицами
 * - чтение настроек подключения из файла assess.prop
 * 
 */
public class Base {
    private static Access access = new Access("property\\access.prop");//путь к файлу настроек
    public boolean granted = false;//права пользователя подтверждены
    /**
     * проверка учетных данных пользователя
     * @param user
     * @return
     */
    public static Boolean checkAccess(User user){
        Boolean OK = false;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select * from users";
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if (user.equals(new User(rs.getString(2), rs.getString(3)))){
                    OK = true;
                    System.out.println("Доступ предоставлен ...");
                }else{
                    OK = false;
                    System.out.println("В доступе отказано ...");
                    System.out.println("Попробуйте еще раз ...");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return OK;
    }
    /**
     * 
     * @return
     */
    public static List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        //лучше читать запрос из файла, но тут незачем ...
        String query = "SELECT person.id, person.jobtitle, person.firstnamelastname, person.phone, person.email, COUNT(domains.personid) as domainsCount FROM person INNER JOIN domains ON domains.personid = person.id GROUP BY person.id";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Person current = new Person(rs.getInt("id"),
                                            rs.getString("jobtitle"),
                                            rs.getString("firstnamelastname"),
                                            rs.getString("phone"),
                                            rs.getString("email"),
                                            rs.getInt("domainsCount"));
                persons.add(current);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static List<Domain> getDomains(int personid){
        List<Domain> domains = new ArrayList<>();
        String query = "SELECT domains.id, domains.webname, domains.domainname, domains.ip, domains.datereg, domains.countryreg, domains.personid FROM domains WHERE domains.personid=" + personid;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String webname = rs.getString("webname");
                String domainname = rs.getString("domainname");
                String ip = rs.getString("ip");
                /**
                 * обработка поля время
                 */
                Date time;
                SimpleDateFormat pattern;
                time = rs.getDate("datereg");
                pattern = new SimpleDateFormat("dd.MM.yyyy");
                String datereg = pattern.format(time); //получили время, преобразованное в строку

                String countryreg = rs.getString("countryreg");
                int pid = rs.getInt("personid");
                Domain domain = new Domain(id, webname, domainname, ip, datereg, countryreg, pid);
                domains.add(domain);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return domains;
    }
}
