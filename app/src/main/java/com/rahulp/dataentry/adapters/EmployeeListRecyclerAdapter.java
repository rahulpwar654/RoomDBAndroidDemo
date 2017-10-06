package com.rahulp.dataentry.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rahulp.dataentry.R;
import com.rahulp.dataentry.models.Employee;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by warlord on 8/30/2017.
 */

public class EmployeeListRecyclerAdapter extends RecyclerView.Adapter<EmployeeListRecyclerAdapter.EmployeeDataViewHolder>
         {

    private List<Employee> mEmployees;
    private Context mContext;



    public EmployeeListRecyclerAdapter(Context mContext, List<Employee> mEmployees ) {
        this.mEmployees = mEmployees;
        this.mContext = mContext;

    }

    @Override
    public EmployeeDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_clip_view, parent, false);
        return new EmployeeDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EmployeeDataViewHolder holder, final int position) {

    //holder.txtdata.setText(mEmployees.get(position).getData().trim());
    //holder.txttime.setText(mClipBoardDataModels.get(position).getTimeStamp());



        holder.txtdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if(mAdapterToParentInterface!=null)
                {
                    mAdapterToParentInterface.ItemClicked(position);
                }*/
            }
        });




    }

    @Override
    public int getItemCount() {
        if (mEmployees != null) {
            return mEmployees.size();
        } else {
            return 0;
        }
    }


    public Employee getItem(int pos){
        return mEmployees.get(pos);

    }




    /**
 * EmployeeDataViewHolder
 */
public class EmployeeDataViewHolder extends RecyclerView.ViewHolder {

        TextView txttime  ;
        TextView txtdata  ;
        View     flagview ;

    public EmployeeDataViewHolder(View itemView) {
        super(itemView);

        txttime    = (TextView) itemView.findViewById(R.id.txt_time);
        txtdata    = (TextView) itemView.findViewById(R.id.txt_data);
        flagview   = (View) itemView.findViewById(R.id.flagview);
    }
}
}
