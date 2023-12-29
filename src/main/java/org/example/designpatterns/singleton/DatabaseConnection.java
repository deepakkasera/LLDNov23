package org.example.designpatterns.singleton;

public class DatabaseConnection {
    //public static DatabaseConnection dbc = new DatabaseConnection();
    public static DatabaseConnection dbc = null;
    String url;
    String username;
    String password;
    int portNumber;
    String privateKey;

    private DatabaseConnection() {

    }

//    public static synchronized DatabaseConnection getInstance() {
//        if (dbc == null) {
//            dbc = new DatabaseConnection();
//        }
//        return dbc;
//    }

    public static DatabaseConnection getInstance() {
        if (dbc == null) { // Check-1
            synchronized (DatabaseConnection.class) { // lock.lock();
                if (dbc == null) { // Check-2
                    dbc = new DatabaseConnection();
                }
            }
        }
        return dbc;
    }
}
