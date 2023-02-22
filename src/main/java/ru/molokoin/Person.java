package ru.molokoin;

public class Person {
    private int id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;
    private int domainsCount;

    /**
     * Основной конструктор:
     * - инициируем все поля модели данных для отображения в таблице
     * @param id
     * @param jobtitle
     * @param firstnamelastname
     * @param phone
     * @param email
     */
    public Person(int id, String jobtitle, String firstnamelastname, String phone, String email, int domainsCount){
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
        this.domainsCount = domainsCount;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the jobtitle
     */
    public String getJobtitle() {
        return jobtitle;
    }
    /**
     * @return the firstnamelastname
     */
    public String getFirstnamelastname() {
        return firstnamelastname;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the domainsCount
     */
    public int getDomainsCount() {
        return domainsCount;
    }
}
