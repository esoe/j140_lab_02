package ru.molokoin;

public class Domain {
    private int id;
    private String webname;
    private String domainname;
    private String ip;
    private String datereg;
    private String countryreg;
    private int personid;
    
    public Domain(int id, String webname, String domainname, String ip, String datereg, String countryreg, int personid) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
        this.personid = personid;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the webname
     */
    public String getWebname() {
        return webname;
    }
    /**
     * @return the domainname
     */
    public String getDomainname() {
        return domainname;
    }
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }
    /**
     * @return the datereg
     */
    public String getDatereg() {
        return datereg;
    }
    /**
     * @return the countryreg
     */
    public String getCountryreg() {
        return countryreg;
    }
    /**
     * @return the personid
     */
    public int getPersonid() {
        return personid;
    }
    
}
