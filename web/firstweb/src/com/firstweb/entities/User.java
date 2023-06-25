package web.firstweb.src.com.firstweb.entities;

import java.sql.Timestamp;

public class User {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String password;
    private Timestamp datetime;

    public User(int id, String name, String email, String gender, String password, Timestamp datetime) {

    }

    public User() {
    }

    public User(String name, String email, String gender, String password, Timestamp datetime) {

    }

}
