package com.example.adventura.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adventura.adapters.TrackDataAdapter;
import com.example.adventura.databinding.FragmentTrackBinding;
import com.example.adventura.listeners.TrackDataListener;
import com.example.adventura.models.TrackData;
import com.example.adventura.repository.DataHelper;
import com.example.adventura.utils.HelperUtils;

import java.util.List;

public class TrackFragment extends Fragment {

    private FragmentTrackBinding binding;
    private ProgressDialog progressDialog;
    private TrackDataAdapter trackDataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentTrackBinding.inflate(inflater, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading... ");
        progressDialog.show();

        loadTrackData();
        return binding.getRoot();
    }

    private void loadTrackData() {
        try {
            DataHelper.getTrackData(new TrackDataListener() {
                @Override
                public void onTrackDataLoaded(List<TrackData> trackDataList) {
                    if (trackDataList != null) {
                        HelperUtils.trackDataList.clear();
//                        progressDialog.dismiss();
                        HelperUtils.trackDataList = trackDataList;
                        loadRecyclerView();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), "No Track data found", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onTrackDataLoadFailed(String exception) {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Error: \n" + exception, Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            progressDialog.dismiss();
            Toast.makeText(getContext(), "Exception:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void loadRecyclerView() {
        trackDataAdapter = new TrackDataAdapter(getActivity());
        binding.rvTrack.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.rvTrack.setAdapter(trackDataAdapter);
        progressDialog.dismiss();
    }
}