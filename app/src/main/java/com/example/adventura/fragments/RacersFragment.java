package com.example.adventura.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adventura.R;
import com.example.adventura.databinding.FragmentRacersBinding;

public class RacersFragment extends Fragment {

    FragmentRacersBinding binding;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_racers, container, false);

        return view;
    }
}