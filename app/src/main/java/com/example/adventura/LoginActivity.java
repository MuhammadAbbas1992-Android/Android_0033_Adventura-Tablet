package com.example.adventura;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adventura.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(view -> {
            showAPIDialog();
        });
    }
    private void showAPIDialog()
    {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_api_end_point);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView close=dialog.findViewById(R.id.tvClose);
        TextView done=dialog.findViewById(R.id.tvDone);

        close.setOnClickListener(view -> {
            dialog.dismiss();
        });
        done.setOnClickListener(view -> {
            dialog.dismiss();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        });

    }
}