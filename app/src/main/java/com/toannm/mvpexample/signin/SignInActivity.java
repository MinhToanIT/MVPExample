package com.toannm.mvpexample.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toannm.mvpexample.R;
import com.toannm.mvpexample.main.MainActivity;
import com.toannm.mvpexample.signup.SignUpActivity;

/**
 * Created by Minh Toan on 14/03/2018.
 */

public class SignInActivity extends AppCompatActivity implements SignInContract.View,
        View.OnClickListener {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnSignIn;
    private TextView btnSignUp;
    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initView();
        registerListener();
        initPresenter();
    }

    private void initView() {
        edtUsername = findViewById(R.id.text_username);
        edtPassword = findViewById(R.id.text_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
    }

    private void registerListener() {
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private void initPresenter() {
        signInPresenter = new SignInPresenter();
        signInPresenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                login();
                break;
            case R.id.btn_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            default:
                break;
        }
    }

    private void login() {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,
                    "Username or Password is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        signInPresenter.handleSignIn(username, password);
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Sign In Success!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
