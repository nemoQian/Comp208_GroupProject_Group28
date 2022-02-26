package com.group28.pojo;

/**
 * The type User.
 *
 * @author Yihan Qian
 */
public class User {

    private String user_Name;
    private String user_Password;
    private String user_Email;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param user_Name     the user name
     * @param user_Password the user password
     * @param user_Email    the user email
     */
    public User(String user_Name, String user_Password, String user_Email) {
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Email = user_Email;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUser_Name() {
        return user_Name;
    }

    /**
     * Sets user name.
     *
     * @param user_Name the user name
     */
    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     */
    public String getUser_Password() {
        return user_Password;
    }

    /**
     * Sets user password.
     *
     * @param user_Password the user password
     */
    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUser_Email() {
        return user_Email;
    }

    /**
     * Sets user email.
     *
     * @param user_Email the user email
     */
    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_Name='" + user_Name + '\'' +
                ", user_Password='" + user_Password + '\'' +
                ", user_Email='" + user_Email + '\'' +
                '}';
    }
}
