package com.example.programmer.rockpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference Rootref = db.getReference();
    DatabaseReference gameref = Rootref.child("game");


   TextView textView;
   Button rock,paper,scissor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Rootref.child("users").child("01").child("email").setValue("arunsks@gmail.com");
//        Rootref.child("users").child("01").child("name").setValue("arunkumar");



        textView = (TextView) findViewById(R.id.textView);

        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissor = (Button) findViewById(R.id.scissor);


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameref.setValue("Rock");

            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameref.setValue("paper");

            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameref.setValue("scissor");

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        gameref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String text = dataSnapshot.getValue().toString();
                textView.setText(text);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.i("TAG","something went wrong");

            }
        });

    }
}



