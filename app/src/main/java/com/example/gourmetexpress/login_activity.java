package com.example.gourmetexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {

    private ViewSwitcher viewSwitcher;
    private Button loginTabButton;
    private Button signUpTabButton;
    private Button buttonSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        viewSwitcher = findViewById(R.id.viewSwitcher);
        loginTabButton = findViewById(R.id.buttonLoginTab);
        signUpTabButton = findViewById(R.id.buttonSignUpTab);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        // Initially, set the Login tab active
        setActiveTab(loginTabButton, signUpTabButton);

        // Switch to Sign-Up tab
        signUpTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSwitcher.showNext(); // Show the next view
                setActiveTab(signUpTabButton, loginTabButton); // Update active tab
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login_activity.this,Home.class);
                startActivity(i);
            }
        });
        // Switch to Login tab
        loginTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSwitcher.showPrevious(); // Show the previous view
                setActiveTab(loginTabButton, signUpTabButton); // Update active tab
            }
        });
    }
    private void setActiveTab(Button activeTab, Button inactiveTab) {
        // Set colors for the active tab
        activeTab.setBackgroundTintList(getResources().getColorStateList(R.color.red));
        activeTab.setTextColor(getResources().getColor(android.R.color.white));

        // Set colors for the inactive tab
        inactiveTab.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray));
        inactiveTab.setTextColor(getResources().getColor(android.R.color.black));
    }
}