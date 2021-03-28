package com.example.parstagram;
//package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

//import com.codepath.apps.restclienttemplate.models.SampleModel;
//import com.codepath.apps.restclienttemplate.models.SampleModelDao;
//import com.codepath.oauth.OAuthLoginActionBarActivity;


public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick Login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });
    }
    private void loginUser(String username, String password){
        Log.i(TAG, "Attempting to login user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    // TODO: better error handling
                    Log.e(TAG,"Issue with login",e);
                    Toast.makeText(LoginActivity.this,"Issue!", Toast.LENGTH_SHORT);
                    return;
                }
                // TODO: navigate to the main activity if the user has signed in properly
                goMainACtivity();
                Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT);
            }
        });
    }
    private void goMainACtivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
