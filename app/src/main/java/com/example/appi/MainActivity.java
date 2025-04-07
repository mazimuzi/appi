package com.example.appi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView myTextView = findViewById(R.id.textView);
        Button hideButton = findViewById(R.id.button);
        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextViewVisibility();
            }
        });
    }
    private void toggleTextViewVisibility() {
        TextView myTextView = findViewById(R.id.textView);
        Button hideButton = findViewById(R.id.button);
        // Check the current visibility state
        if (myTextView.getVisibility() == View.VISIBLE) {
            // If visible, hide it
            myTextView.setVisibility(View.GONE);
        } else {
            // If hidden, show it
            myTextView.setVisibility(View.VISIBLE);
        }
    }
}