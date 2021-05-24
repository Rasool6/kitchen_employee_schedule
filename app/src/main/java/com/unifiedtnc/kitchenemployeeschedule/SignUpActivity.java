package com.unifiedtnc.kitchenemployeeschedule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {


    EditText firstName, lastName, email, password,conFirmpassword;
    Button signUp_btn;
    TextView btnsignup,btnsignin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);


        getSupportActionBar().hide();
        firstName = findViewById(R.id.editTextTextPersonName4);
        lastName = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.etemail);
        password = findViewById(R.id.editTextTextPersonName2);
        conFirmpassword = findViewById(R.id.editTextTextPersonName5);
        progressBar = findViewById(R.id.progressbaar);
        btnsignup = findViewById(R.id.button);
        btnsignin=findViewById(R.id.button2);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_username = firstName.getText().toString() + "\t" + lastName.getText().toString();
                String str_email = email.getText().toString().trim();
                String str_password = password.getText().toString().trim();
                String str_conFirmpassword = conFirmpassword.getText().toString().trim();

                if (TextUtils.isEmpty(firstName.getText().toString())) {

                    firstName.setError("Empty Field..!");
                    return;

                } else if (TextUtils.isEmpty(lastName.getText().toString())) {

                    lastName.setError("Empty Field..!");
                    return;

                } else if (TextUtils.isEmpty(str_email)) {

                    email.setError("Empty Field..!");
                    return;

                } else if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
                    email.requestFocus();
                    email.setError("Wrong Email Format...!");
                    return;
                } else
                    if (TextUtils.isEmpty(str_password)){
                        password.setError("Empty Field...!");
                        return;
                    }
                    else
                    if (TextUtils.isEmpty(str_conFirmpassword)){
                        conFirmpassword.setError("Empty Field...!");
                        return;
                    }else
                    if (str_password.length()<6){
                        password.setError("Password Length must be greater than 6..!");
                        return;
                    }else
                    if (!str_password.equals(str_conFirmpassword)){
                        conFirmpassword.setError("Password not matched..!");
                        return;
                    }else

                    {

                    ///code for signUp///
                    progressBar.setVisibility(View.VISIBLE);
                    Call<RegisterResponse> call = RetrofitClient.getInstance()
                            .getApi()
                            .register(str_username, str_email, str_password);
                    call.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                            RegisterResponse registerResponse = response.body();

                            if (response.isSuccessful()) {
                                progressBar.setVisibility(View.GONE);

                                Toast.makeText(SignUpActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                finish();


                            }

                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });

    }
}