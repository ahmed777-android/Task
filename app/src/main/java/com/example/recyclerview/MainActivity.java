package com.example.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    final int ADD_REQUEST_CODE = 1;
    private ArrayList<User> myDataset= new ArrayList<>();
    AdapterView adapter = new AdapterView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        adapter.users= myDataset;

    }
    void initViews(){
          recyclerView=findViewById(R.id.recyclerView);
          recyclerView.setAdapter(adapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Data.class);
                startActivityForResult(intent,ADD_REQUEST_CODE);
            }
        });

    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ADD_REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            myDataset.add((User) data.getSerializableExtra("User"));
            adapter.notifyDataSetChanged();

        }

    }
}
