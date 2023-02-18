package ru.molokoin;

public class User {
    private String name;
    private String password;
    public User (String name, String password){
        this.name = name;
        this.password = password;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    public boolean equals(User user){
        boolean b = false;
        if ((this.name.equals(user.getName())) & this.password.equals(user.getPassword())){
            b = true;
        }else{
            b = false;
        }
        return b;
    }
}
