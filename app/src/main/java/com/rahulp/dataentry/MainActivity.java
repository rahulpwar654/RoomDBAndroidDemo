package com.rahulp.dataentry;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rahulp.dataentry.adapters.EmployeeListRecyclerAdapter;
import com.rahulp.dataentry.db.AppDatabase;
import com.rahulp.dataentry.db.dao.EmployeeDao;
import com.rahulp.dataentry.models.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    //UserDao userDao;
    EmployeeDao EmpDao;
    Button addEntry;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appDatabase = Room.databaseBuilder(MainActivity.this, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        //userDao = appDatabase.userDao();
        EmpDao = appDatabase.empDao();


        addEntry = findViewById(R.id.btn_add);


        recyclerView = findViewById(R.id.userlist);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


       /* EmployeeListRecyclerAdapter employeeListRecyclerAdapter=new EmployeeListRecyclerAdapter(this,EmpDao.employeesByFirstName());

        recyclerView.setAdapter(employeeListRecyclerAdapter);*/


        getAllUser(appDatabase);

        addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EmployeeDetailActivity.class));
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void getAllUser(final AppDatabase appDatabase) {
       // final DatabaseCreator databaseCreator = new DatabaseCreator();
        new AsyncTask<Void, Void, List<Employee>>() {
            @Override
            protected List<Employee> doInBackground(Void... voids) {
                return appDatabase.empDao().employeesByFirstName();
               // return null;
            }


            @Override
            protected void onPostExecute(List<Employee> employees) {
                //super.onPostExecute(employees);
                if(employees!=null ) {
                    Log.e("",""+employees.size());
                    EmployeeListRecyclerAdapter employeeListRecyclerAdapter = new EmployeeListRecyclerAdapter(MainActivity.this, employees);
                    recyclerView.setAdapter(employeeListRecyclerAdapter);
                }
            }
        }.execute();
    }
}
