package com.example.adventura.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adventura.R;
import com.example.adventura.models.RacersData;
import com.example.adventura.models.TrackData;
import com.example.adventura.utils.HelperUtils;

public class RacersDataAdapter extends RecyclerView.Adapter<RacersDataAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ProgressDialog progressDialog;

    public RacersDataAdapter(Context context)
    {
        this.context=context;
        this.inflater=LayoutInflater.from(this.context);
        progressDialog=new ProgressDialog(this.context);
        progressDialog.setMessage("Loading... ");
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.row_view_racers,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RacersData racersData= HelperUtils.racersDataList.get(position);
    }

    @Override
    public int getItemCount() {
        return HelperUtils.racersDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
