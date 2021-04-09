package com.example.retrofitpagination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpagination.Moddel.Medicine;
import com.example.retrofitpagination.Moddel.Response;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {


    //  Initialize Variable

     private ArrayList<Medicine>mdataArrayList;
    private Context context;

    public MainAdapter(ArrayList<Medicine> mdataArrayList, Context context) {
        this.mdataArrayList = mdataArrayList;
        this.context = context;
    }




     // Create Constructor





    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Initialize View

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main,parent,false);

        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        //Initialize Response

        Medicine  medicine = mdataArrayList.get(position);

     holder.textView_medicinename.setText(medicine.getDrugs().toString());


    }

    @Override
    public int getItemCount() {
        return mdataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Initialize Variable
        TextView textView_drugicon,textView_medicinename,textView_rightarrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);



            textView_drugicon = itemView.findViewById(R.id.drugicontv_id);
            textView_medicinename = itemView.findViewById(R.id.medicinenameid);
            textView_rightarrow = itemView.findViewById(R.id.right_arrowid);


        }
    }
}
