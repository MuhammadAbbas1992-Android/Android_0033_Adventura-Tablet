package com.example.adventura.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adventura.adapters.RacersDataAdapter;
import com.example.adventura.databinding.FragmentRacersBinding;
import com.example.adventura.listeners.RacersDataListener;
import com.example.adventura.models.RacersData;
import com.example.adventura.repository.DataHelper;
import com.example.adventura.utils.HelperUtils;

import java.util.List;

public class RacersFragment extends Fragment {

    private FragmentRacersBinding binding;
   
    private ProgressDialog progressDialog;
    private RacersDataAdapter racersDataAdapter;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentRacersBinding.inflate(inflater, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading... ");
        progressDialog.show();

        loadRacersData();
        return binding.getRoot();
    }

    private void loadRacersData() {
        try {
            DataHelper.getRacersData(new RacersDataListener() {
                @Override
                public void onRacersDataLoaded(List<RacersData> racersDataList) {
                    if (racersDataList != null && !racersDataList.isEmpty()) {
                        progressDialog.dismiss();
                        HelperUtils.racersDataList.clear();
                        HelperUtils.racersDataList = racersDataList;

                        loadRecyclerView();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), "No Racers data found", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onRacersDataLoadFailed(String exception) {
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
        racersDataAdapter = new RacersDataAdapter(getActivity());
        binding.rvRacers.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvRacers.setAdapter(racersDataAdapter);
        progressDialog.dismiss();


    }
}