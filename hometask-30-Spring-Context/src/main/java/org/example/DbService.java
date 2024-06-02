package org.example;

public class DbService {
    private String dbName;

    public DbService(String dbName) {
        this.dbName = dbName;
        System.out.println("Database Name is " + this.dbName);
    }

    public void init(){
        System.out.println("INIT " + this.dbName );
    }
}
