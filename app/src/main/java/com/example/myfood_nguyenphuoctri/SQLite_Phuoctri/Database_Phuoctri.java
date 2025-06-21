package com.example.myfood_nguyenphuoctri.SQLite_Phuoctri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database_Phuoctri extends SQLiteOpenHelper {
    public static final String DB_NAME = "Food_Tri.db";
    public static final int DB_VERSION = 1;

    public Database_Phuoctri(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE User ("+"UserID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Gender TEXT, Dateofbirth TEXT,Phone TEXT, Username TEXT, Password TEXT)");

        db.execSQL("CREATE TABLE `Order` ("+"OrderID INTEGER PRIMARY KEY AUTOINCREMENT,Address TEXT, Date_Order TEXT, Total_value REAL, Status TEXT, UserID INTEGER, FOREIGN KEY(UserID) REFERENCES User(UserID))");

        db.execSQL("CREATE TABLE Restaurant ("+"ResID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Address TEXT, Phone TEXT, Image TEXT)");

        db.execSQL("CREATE TABLE Food ("+"FoodID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Type TEXT, Description TEXT, Image TEXT,ResID INTEGER, FOREIGN KEY(ResID) REFERENCES Restaurant(ResID))");

        db.execSQL("CREATE TABLE OrderDetail ("+"OrderID INTEGER, FoodID INTEGER, Size TEXT, Food TEXT, Quantity INTEGER,PRIMARY KEY(OrderID, FoodID),FOREIGN KEY(OrderID) REFERENCES 'Order'(OrderID),FOREIGN KEY(FoodID) REFERENCES Food(FoodID))");

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
