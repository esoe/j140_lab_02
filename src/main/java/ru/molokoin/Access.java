package ru.molokoin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс хранит данные, для подключения к базе данных
 * 
 */
public class Access {
    private String link;
    private String login;
    private String password;
    public Access(String path){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(path));
            setLink (properties.getProperty("db.url"));
            setLogin(properties.getProperty("db.user"));
            setPassword(properties.getProperty("db.password"));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка - файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    public static void main(String[] args) {
        Access acc = new Access("property\\access.prop");
        System.out.println(acc.getLink());
        System.out.println(acc.getLogin());
        System.out.println(acc.getPassword());
    }

}
