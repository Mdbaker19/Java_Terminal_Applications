package website;

public class User {

    private String username;
    private String password;
    public String id;

    public User(String username, String password, String id){
        this.password = password;
        this.username = username;
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getId(){
        return this.id;
    }

}
