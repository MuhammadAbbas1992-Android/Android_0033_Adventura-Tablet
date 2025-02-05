package com.example.adventura.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adventura.R;
import com.example.adventura.app.SharedPref;
import com.example.adventura.databinding.ActivityLoginBinding;
import com.example.adventura.listeners.UserLoginDataListener;
import com.example.adventura.models.UserLoginData;
import com.example.adventura.models.UserTokenData;
import com.example.adventura.repository.DataHelper;
import com.example.adventura.repository.Service;
import com.example.adventura.utils.HelperUtils;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private Dialog dialog;
    private ProgressDialog progressDialog;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Login... ");

        binding.ivAPI.setOnClickListener(view -> {
            showAPIDialog();
        });
        binding.btnLogin.setOnClickListener(view -> {
            confirmCredentials();
        });
        binding.etEmailId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginBtnEnabled();
            }
        });
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginBtnEnabled();
            }
        });
        binding.ivEye.setOnClickListener(v -> {
            togglePassVisible();
        });
    }

    private void togglePassVisible() {
        String pass = binding.etPassword.getText().toString();

        if (isPasswordVisible) {
            binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            binding.ivEye.setImageResource(R.drawable.ic_eye_hide);
        } else {
            binding.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            binding.ivEye.setImageResource(R.drawable.ic_eye_show);
        }

        binding.etPassword.setText(pass);
        binding.etPassword.setSelection(pass.length());
        isPasswordVisible = !isPasswordVisible;
    }

    private void confirmCredentials() {
        if (binding.etEmailId.getText().toString().isEmpty()
                || binding.etPassword.getText().toString().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
        } else {
            progressDialog.show();
            UserLoginData userLoginData = new UserLoginData(
                    binding.etEmailId.getText().toString().trim(),
                    binding.etPassword.getText().toString().trim()
            );

            try {
                DataHelper.sendUserLoginData(userLoginData, new UserLoginDataListener() {
                    @Override
                    public void onUsersLoginDataLoaded(UserTokenData userTokenData) {

                        if (userTokenData != null) {
                            progressDialog.dismiss();
                            HelperUtils.trackDataList.clear();
//                        //Save Token in SharedPref to Avoid Login again and again
                            SharedPref.write(SharedPref.KEY_TOKEN, userTokenData.getToken());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            progressDialog.dismiss();
                            showLoginFailDialog();
                        }
                    }

                    @Override
                    public void onUsersLoginDataLoadFailed(String exception) {
                        progressDialog.dismiss();
                        showLoginFailDialog();
                    }
                });

            } catch (Exception e) {
                progressDialog.dismiss();
                showLoginFailDialog();
            }
        }
    }

    private void loginBtnEnabled() {
        if (!binding.etEmailId.getText().toString().equals("")
                && !binding.etPassword.getText().toString().equals("")) {
            binding.btnLogin.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.red));
            binding.btnLogin.setTextColor(LoginActivity.this.getResources().getColor(R.color.white));
            binding.btnLogin.setEnabled(true);
        } else {
            binding.btnLogin.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.light_white));
            binding.btnLogin.setTextColor(LoginActivity.this.getResources().getColor(R.color.light_blur));
            binding.btnLogin.setEnabled(false);
        }

    }

    private void showAPIDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_api_end_point);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView baseAPI = dialog.findViewById(R.id.etAPI);
        TextView close = dialog.findViewById(R.id.tvClose);
        TextView done = dialog.findViewById(R.id.tvDone);

        baseAPI.setText(SharedPref.read(SharedPref.KEY_BASE_API, "https://wallofjobs.com/"));

        close.setOnClickListener(view -> {
            dialog.dismiss();
        });
        done.setOnClickListener(view -> {
            if (baseAPI.getText().toString().equals("")
                    || baseAPI.getText().toString().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please write Base API", Toast.LENGTH_LONG).show();
            } else {
                SharedPref.write(SharedPref.KEY_BASE_API, baseAPI.getText().toString());
                Service.removeInstance();
                dialog.dismiss();
            }
        });

    }

    private void showLoginFailDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login_fail);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView close = dialog.findViewById(R.id.tv_close);
        TextView tryAgain = dialog.findViewById(R.id.tvTryAgain);

        close.setOnClickListener(view -> {
            dialog.dismiss();
        });
        tryAgain.setOnClickListener(view -> {
            dialog.dismiss();
        });

    }
}