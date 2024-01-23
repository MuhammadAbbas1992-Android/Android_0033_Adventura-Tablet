package com.example.adventura.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        holder.lapNo.setText((position+1)+"");

        String[] time=HelperUtils.lapTimeList.get(position).split(":");
        holder.lapTime.setText(time[0]+"h:"+time[1]+"m:"+time[2]+"s:");

        if((position%2)==0)
        {
            holder.layoutRacersInner.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return HelperUtils.lapNoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lapNo,lapTime,lapDelete;
        LinearLayout layoutRacersInner;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lapNo =itemView.findViewById(R.id.tvLapNo);
            lapTime =itemView.findViewById(R.id.tvLapTime);
            lapDelete =itemView.findViewById(R.id.tvLapDelete);
            layoutRacersInner =itemView.findViewById(R.id.ll_racers_inner);
        }
    }
}
