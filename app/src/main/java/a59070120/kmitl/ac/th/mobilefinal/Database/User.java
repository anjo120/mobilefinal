package a59070120.kmitl.ac.th.mobilefinal.Database;

import android.provider.BaseColumns;

public class User {
    public static final String DATABASE_NAME = "final_users.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "user";


    private String id;
    private String user;
    private String name;
    private String age;
    private String password;

    public User(){ }

    User(String user,String name,String age,String password){
        this.user = user;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String USERNAME = "username";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String PASSWORD = "password";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
