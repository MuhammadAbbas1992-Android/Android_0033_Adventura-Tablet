package com.example.adventura.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adventura.R;
import com.example.adventura.listeners.LapHitDataListener;
import com.example.adventura.listeners.TrackDataListener;
import com.example.adventura.models.LapHitDataRequest;
import com.example.adventura.models.LapHitDataResponse;
import com.example.adventura.models.TrackData;
import com.example.adventura.repository.DataHelper;
import com.example.adventura.utils.HelperUtils;

import java.util.List;

public class TrackDataAdapter extends RecyclerView.Adapter<TrackDataAdapter.MyViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private ProgressDialog progressDialog;
    public TrackDataAdapter(Context context)
    {
        this.context=context;
        this.inflater=LayoutInflater.from(this.context);
        progressDialog=new ProgressDialog(this.context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.row_view_track,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TrackData trackData= HelperUtils.trackDataList.get(position);

        if(trackData.getKart_no().length()==1)
        {
            holder.kartNo.setText("0"+trackData.getKart_no());
        }
        else
        {
            holder.kartNo.setText(trackData.getKart_no());
        }

        holder.completedLaps.setText(trackData.getCompleted_laps());
        holder.sLaps.setText(trackData.getS_laps());
        holder.lapsHit.setOnClickListener(view -> lapHits(trackData));

    }

    @Override
    public int getItemCount() {
        return HelperUtils.trackDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView kartNo,completedLaps,sLaps;
        Button lapsHit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            kartNo =itemView.findViewById(R.id.tvKartNo);
            completedLaps =itemView.findViewById(R.id.tvCompletedLaps);
            sLaps =itemView.findViewById(R.id.tvSLaps);
            lapsHit =itemView.findViewById(R.id.btnLapsHit);
        }
    }

    private void lapHits(TrackData trackData)
    {
        LapHitDataRequest lapHitDataRequest=new LapHitDataRequest(trackData.getCurrent_session_id(),trackData.getKart_id());
        try
        {
            DataHelper.sendLapHitsCountData(lapHitDataRequest, new LapHitDataListener() {
                @Override
                public void onLapHitDataLoaded(LapHitDataResponse lapHitDataResponses) {
                    if (lapHitDataResponses !=null)
                    {
                        progressDialog.dismiss();
//                        HelperUtils.trackDataList=trackDataList;
//                        HelperUtils.kartNoList.add("Select Kart");
//
//                        for (KartsData kart: HelperUtils.mykartsDataList) {
//                            HelperUtils.kartNoList.add("Kart "+kart.getKart_no());
//                        }
//                        loadRecyclerView();
                        Toast.makeText(context, "Lap hit successfully", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(context, "Failed to Hit Lap", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onLapHitDataLoadFailed(String exception) {
                    progressDialog.dismiss();
                    Toast.makeText(context, "Error: \n"+exception, Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e)
        {
            progressDialog.dismiss();
            Toast.makeText(context, "Exception:\n"+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
