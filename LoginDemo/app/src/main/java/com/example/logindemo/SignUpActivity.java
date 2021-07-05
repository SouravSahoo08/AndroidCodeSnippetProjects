package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText idNumber;
    Button signUp;
    /*FirebaseDatabase rootNode;
    DatabaseReference reference;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.newUsername);
        password = findViewById(R.id.newPassword);
        idNumber = findViewById(R.id.Id);
        signUp = findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("Working");

                String uName = username.getText().toString();
                String pass = password.getText().toString();
                String id = idNumber.getText().toString();
                UserHelperClass data = new UserHelperClass(uName, pass, id);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("users");
                databaseReference.child(id).setValue(data);
            }
        });
    }
}
