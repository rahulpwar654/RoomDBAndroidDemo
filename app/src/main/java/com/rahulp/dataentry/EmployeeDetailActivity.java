package com.rahulp.dataentry;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rahulp.dataentry.db.AppDatabase;
import com.rahulp.dataentry.db.dao.EmployeeDao;
import com.rahulp.dataentry.models.Employee;

public class EmployeeDetailActivity extends AppCompatActivity {

    EditText mEdtName,mEdtId,mEdtDesignation,mEdtAddress;
    Button add;
    AppDatabase appDatabase;
    //UserDao userDao;
    EmployeeDao EmpDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        appDatabase = Room.databaseBuilder(EmployeeDetailActivity.this, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        //userDao = appDatabase.userDao();
        EmpDao = appDatabase.empDao();

        mEdtName=findViewById(R.id.name);
        mEdtId=findViewById(R.id.empid);
        mEdtDesignation=findViewById(R.id.empdesignation);
        mEdtAddress=findViewById(R.id.empaddress);
        add=findViewById(R.id.btn_empadd);


add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        addToDataBase();

    }
});




    }


    public void addToDataBase()
    {

        Employee employee=new Employee();

        employee.emp_socialno   =mEdtId.getText().toString();
        employee.empName        =mEdtName.getText().toString();
        employee.empDesignation =mEdtDesignation.getText().toString();
        employee.empaddress     =mEdtAddress.getText().toString();

        //EmpDao.insert(employee);


        new AddEmpTask(employee,true).execute((Object[]) null);


    }



    class AddEmpTask extends AsyncTask{

        Employee employee;
        boolean isAdd;

        public AddEmpTask(Employee employee, boolean isAdd) {
            this.employee = employee;
            this.isAdd = isAdd;
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            EmpDao.insert(employee);
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            Toast.makeText(EmployeeDetailActivity.this, "Entry Added Sucesfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


}
