package com.rahulp.dataentry.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by warlord on 10/5/2017.
 */

@Entity
public class Employee {


   /* public static DiffCallback<Employee> EMPDIFF_CALLBACK = new DiffCallback<Employee>() {
        @Override
        public boolean areItemsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.empid == newItem.empid;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.equals(newItem);
        }
    };*/


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "emp_id")
    public long empid;
    @ColumnInfo(name = "social_no")
    public String emp_socialno;
    @ColumnInfo(name = "emp_name")
    public String empName;
    @ColumnInfo(name = "designation")
    public String empDesignation;
    @ColumnInfo(name = "empaddress")
    public String empaddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (empid != employee.empid) return false;
        if (emp_socialno != null ? !emp_socialno.equals(employee.emp_socialno) : employee.emp_socialno != null)
            return false;
        if (empName != null ? !empName.equals(employee.empName) : employee.empName != null)
            return false;
        if (empDesignation != null ? !empDesignation.equals(employee.empDesignation) : employee.empDesignation != null)
            return false;
        return empaddress != null ? empaddress.equals(employee.empaddress) : employee.empaddress == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (empid ^ (empid >>> 32));
        result = 31 * result + (emp_socialno != null ? emp_socialno.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (empDesignation != null ? empDesignation.hashCode() : 0);
        result = 31 * result + (empaddress != null ? empaddress.hashCode() : 0);
        return result;
    }
}
