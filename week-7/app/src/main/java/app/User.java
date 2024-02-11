package app;

public class User {
    private String _username;
    private String _password;
    public String personalName;
    public int personalAge = 21;
    public double personalWeight = 145.5;
    public Height personalHeight = new Height(5, 5);

    public User(String username, String password) {
        this._username = username;
        this._password = password;
        this.personalName = username;
    }

    public String getUsername() {
        return this._username;
    }

    public void setUsername(String value) {
        this._username = value;
    }

    public String getPassword() {
        return this._password;
    }

    public void setPassword(String value) {
        this._password = value;
    }
}
