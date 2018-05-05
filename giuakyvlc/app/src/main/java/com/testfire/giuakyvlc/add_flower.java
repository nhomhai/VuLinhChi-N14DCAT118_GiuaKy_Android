package com.testfire.giuakyvlc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by vulinhchi on 4/19/18.
 */

public class add_flower extends AppCompatActivity{
    DatabaseReference ref;

    @Override
    protected  void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_flower);
        Intent i = this.getIntent();

        ref = FirebaseDatabase.getInstance().getReference("Flower");
    }

    public void showAlertDialog(String s)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("FlowerShop");
        builder.setMessage(s);
        builder.setCancelable(false);
        builder.setNegativeButton("OK!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void add_Click(View v)
    {
        EditText name = (EditText) findViewById(R.id.edittext_name_addflower);
        EditText price = (EditText) findViewById(R.id.edittext_price_addflower);
        EditText image = (EditText) findViewById(R.id.edittext_image_addflower);
        EditText status = (EditText) findViewById(R.id.edittext_status_addflower);
        EditText species = (EditText) findViewById(R.id.edittext_species_addflower);
        EditText detail = (EditText) findViewById(R.id.edittext_detail_addflower);

        String name_text = name.getText().toString();
        String price_text = price.getText().toString();
        String image_text = image.getText().toString();
        String status_text = status.getText().toString();
        String species_text = species.getText().toString();
        String detail_text = detail.getText().toString();

        final Flower f = new Flower();
        f.setFlowername(name_text);
        f.setImageFlower(image_text);
        f.setPrice(price_text);
        f.setStatus(status_text);
        f.setSpecies(species_text);
        f.setDetails(detail_text);

        if(name_text.isEmpty()==true||price_text.isEmpty()==true||image_text.isEmpty()==true||status_text.isEmpty()==true||species_text.isEmpty()==true)
        {
            showAlertDialog("bạn cần điền đầy đủ thông tin hoa!");
        }
        else
        {
            String id = ref.push().getKey();
            f.setId(id);
            ref.child(id).setValue(f);
            showAlertDialog("them hoa thanh cong");

            name.setText(null);
            price.setText(null);
            image.setText(null);
            species.setText(null);
            status.setText(null);
            detail.setText(null);
        }
    }

    public void back (View v)
    {
        this.onBackPressed();
    }
    public void list_hoa_click(View v)
    {
        Intent f = new Intent(add_flower.this,MainActivity.class);
        startActivity(f);

    }
}
