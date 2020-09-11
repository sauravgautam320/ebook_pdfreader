package com.examplecompany.ebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.examplecompany.ebook.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private com.examplecompany.ebook.myAdapter mMyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //to get fullscreen app
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mRecyclerView = (RecyclerView) findViewById(R.id.recView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //to get firebase ref to your documnets directory
        //if your directory doesnt read 'documents' then change the below path to exactly what your directory is named
        FirebaseRecyclerOptions<com.examplecompany.ebook.Book> options = new FirebaseRecyclerOptions.Builder<com.examplecompany.ebook.Book>()
                .setQuery(FirebaseDatabase.getInstance().getReference("documents"), com.examplecompany.ebook.Book.class)
                .build();

        //puts the file contents through adapter to main menu view
        mMyAdapter = new com.examplecompany.ebook.myAdapter(options);
        mRecyclerView.setAdapter(mMyAdapter);



    }

    @Override
    protected void onStart(){
        super.onStart();
        mMyAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        mMyAdapter.stopListening();
    }
}