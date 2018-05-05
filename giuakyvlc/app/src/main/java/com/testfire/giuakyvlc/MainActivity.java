package com.testfire.giuakyvlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference ref, refcart;
    ArrayList<Flower> list_hoa = new ArrayList<>();
    @Override
    protected void onStart() {
        super.onStart();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot flower_snapshot : dataSnapshot.getChildren())
                {
                    Flower flower = flower_snapshot.getValue(Flower.class);
                    list_hoa.add(flower);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref = FirebaseDatabase.getInstance().getReference("Flower");
        ListView listView = (ListView) findViewById(R.id.list_view_hoa);
        listView.setAdapter(new adapter_hoa(MainActivity.this, list_hoa));

    }

    public void show_click(View v) {

        ListView listView = (ListView) findViewById(R.id.list_view_hoa);
        listView.setAdapter(new adapter_hoa(MainActivity.this, list_hoa));


    }
    public void themmoi_click(View v)
    {

        Intent f = new Intent(MainActivity.this,add_flower.class);
        startActivity(f);
    }
    public void item_delete_click(View v)// DONE ahihi
    {
        Integer index ;
        index = (Integer)v.getTag();

        // ArrayList<Flower> data = list_hoa;
        Flower f = list_hoa.get(index);

        //list_hoa.remove(f);
        ref.child(f.getId()).removeValue();

        Intent i = new Intent(MainActivity.this,MainActivity.class);

        startActivity(i);
    }
    public  void item_edit_click(View v)
    {
        Integer index;
        index = (Integer)v.getTag();
        Intent intent = new Intent(getBaseContext(),edit_item_hoa.class);

        Flower f = list_hoa.get(index);
        intent.putExtra("flower",f);
        startActivity(intent);

    }
}
