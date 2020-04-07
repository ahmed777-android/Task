package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Data extends AppCompatActivity {
   private EditText nameED,phoneED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initView();
        ////////////////////////////////////////////////////////////////
    }
    void initView() {
        nameED = findViewById(R.id.nameED);
        phoneED = findViewById(R.id.passwordED);


        FloatingActionButton fab = findViewById(R.id.fabd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = createUser(nameED.getText().toString(),phoneED.getText().toString());

                if (user != null) {
                    Intent intent = new Intent();
                    intent.putExtra("User", user);
                    setResult(Activity.RESULT_OK, intent);
                    finish();

                }
            }

        });
    }
    private  User createUser(String name,String phone) {
        boolean invalid = false;
        if ((name == null || name.isEmpty()) && (phone == null || phone.isEmpty())) {
            invalid = true;

            nameED.setError("لا يمكن إضافة مستحدم بدون اسم");
            phoneED.setError("لا يمكن إضافة مستخدم بدون رقم هاتف ");
        }
        else if (name == null || name.isEmpty()) {
            invalid = true;

            nameED.setError("لا يمكن إضافة مستحدم بدون اسم");
        }
        else if (phone == null || phone.isEmpty()) {
            invalid = true;

            phoneED.setError("لا يمكن إضافة مستحدم بدون رقم هاتف");
        }
        if(invalid) return null;
        else return new User(name, phone);
    }
}
// Intent intent= new Intent();
//   intent.putExtra("User", (Parcelable) user);