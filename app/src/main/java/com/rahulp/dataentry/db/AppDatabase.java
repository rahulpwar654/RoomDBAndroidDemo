package com.rahulp.dataentry.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.rahulp.dataentry.db.dao.EmployeeDao;
import com.rahulp.dataentry.models.Employee;




@Database(entities = {Employee.class}, version = 1,exportSchema = false)
abstract public class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "UserDb";



   // public abstract UserDao userDao();
    public abstract EmployeeDao empDao();
}
