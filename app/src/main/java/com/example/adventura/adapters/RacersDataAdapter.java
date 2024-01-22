package com.example.adventura.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adventura.R;
import com.example.adventura.models.LapTimesData;
import com.example.adventura.models.RacersData;
import com.example.adventura.utils.HelperUtils;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Map;

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

        holder.serialNo.setText((position+1)+"");
        holder.userName.setText(racersData.getUsername());
        holder.totalLaps.setText(racersData.getTotal_laps());

        //Replace whitespace to : to get Hours:Mints:Seconds
        String time=racersData.getTotal_lap_time().replace(" ",":");
        holder.totalTime.setText(time.toLowerCase());
        holder.kartType.setText(racersData.getType());
        holder.kartNo.setText(racersData.getKart_no());
        holder.arrowSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(holder.layoutSlider.getVisibility() == View.VISIBLE)
                {
                    holder.arrowSlider.setImageResource(R.drawable.ic_arrow_down);
                    holder.layoutSlider.setVisibility(View.GONE);
                }
                else
                {
                    holder.arrowSlider.setImageResource(R.drawable.ic_arrow_up);
                    holder.layoutSlider.setVisibility(View.VISIBLE);


                    if (HelperUtils.racersDataList.size()>0) {
                        HelperUtils.lapNoList.clear();
                        HelperUtils.lapTimeList.clear();
//                        String jsonString = "{\"s_laps_time\":{\"lap_0\":\"2024-01-22 18:54:04\",\"lap_1\":\"2024-01-22 19:10:45\",\"lap_2\":\"2024-01-22 19:10:52\"}}";
//
                        String jsonString = "{\"lap_0\":\"2024-01-22 00:00:29\",\"lap_1\":\"2024-01-22 00:42:38\",\"lap_2\":\"2024-01-22 00:46:54\",\"lap_3\":\"2024-01-22 00:47:00\",\"lap_4\":\"2024-01-22 00:47:12\",\"lap_5\":\"2024-01-22 00:47:20\"}";

                        Gson gson = new Gson();
                        Type mapType = new com.google.gson.reflect.TypeToken<Map<String, String>>() {
                        }.getType();
                        Map<String, String> lapTimes = gson.fromJson(jsonString, mapType);

                        // Now you can use lapTimes map as needed
                        for (Map.Entry<String, String> entry : lapTimes.entrySet()) {
                            HelperUtils.lapNoList.add(entry.getKey());
                            HelperUtils.lapTimeList.add(entry.getValue());
                        }
                        loadInnerRecyclerView(holder.rvInnerRacers);
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HelperUtils.racersDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView serialNo,userName,totalLaps,totalTime,kartType,kartNo;
        ImageView arrowSlider;
        LinearLayout layoutSlider;
        RecyclerView rvInnerRacers;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            serialNo =itemView.findViewById(R.id.tvSerialNo);
            userName =itemView.findViewById(R.id.tvUserName);
            totalLaps =itemView.findViewById(R.id.tvTotalLaps);
            totalTime =itemView.findViewById(R.id.tvTotalTime);
            kartType =itemView.findViewById(R.id.tvKartType);
            kartNo =itemView.findViewById(R.id.tvKartNumber);
            arrowSlider =itemView.findViewById(R.id.ivSlider);
            layoutSlider =itemView.findViewById(R.id.ll_Laps_Time_Slider);
            rvInnerRacers =itemView.findViewById(R.id.rv_Inner_Racers);
        }
    }

    private void loadInnerRecyclerView(RecyclerView rvInnerRacers)
    {
        InnerRacersDataAdapter innerRacersDataAdapter =new InnerRacersDataAdapter(context);
        rvInnerRacers.setLayoutManager(new LinearLayoutManager(context));
        rvInnerRacers.setAdapter(innerRacersDataAdapter);
//        progressDialog.dismiss();
    }
}
