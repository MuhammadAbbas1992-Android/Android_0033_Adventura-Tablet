package com.example.adventura.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adventura.R;
import com.example.adventura.utils.HelperUtils;

public class InnerRacersDataAdapter extends RecyclerView.Adapter<InnerRacersDataAdapter.MyViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private ProgressDialog progressDialog;
    public InnerRacersDataAdapter(Context context)
    {
        this.context=context;
        this.inflater=LayoutInflater.from(this.context);
        progressDialog=new ProgressDialog(this.context);
        progressDialog.setMessage("Loading... ");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.row_view_racers_inner,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        HelperUtils.lapNoList.get(position);
//        HelperUtils.lapTimeList.get(position);
        holder.lapNo.setText(position+"");

        String[] splitDateTime=HelperUtils.lapTimeList.get(position).split(" ");
        String[] time=splitDateTime[1].split(":");
        holder.lapTime.setText(time[0]+"h:"+time[1]+"m:"+time[2]+"s:");
    }

    @Override
    public int getItemCount() {
        return HelperUtils.lapNoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lapNo,lapTime,lapDelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lapNo =itemView.findViewById(R.id.tvLapNo);
            lapTime =itemView.findViewById(R.id.tvLapTime);
            lapDelete =itemView.findViewById(R.id.tvLapDelete);
        }
    }
}
