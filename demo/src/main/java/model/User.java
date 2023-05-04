package model;

public class User {
    
    String userName;
    int key;
    int id;

    public User(String userName, int key){
        setUserName(userName);
        setKey(key);
    }
    public User(int id, String userName, int key){
        setUserName(userName);
        setKey(key);
        setId(id);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public int getKey() {
        return key;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
}
