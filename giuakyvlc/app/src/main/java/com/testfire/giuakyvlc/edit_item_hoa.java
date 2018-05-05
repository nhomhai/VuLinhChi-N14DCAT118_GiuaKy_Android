package com.testfire.giuakyvlc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by vulinhchi on 4/21/18.
 */

public class edit_item_hoa extends AppCompatActivity {
    DatabaseReference ref;
    String key;
    private String img, name, price, status, detail, species;
    private EditText ten, gia, tinhtrang, chitiet;
    ImageView hinhanh;
    EditText loai;
    Intent intent;
    Flower f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_item_hoa);


        hinhanh = this.findViewById(R.id.item_edit_image);
        ten = this.findViewById(R.id.Item_edit_name);
        gia = this.findViewById(R.id.item_edit_price);
        tinhtrang = this.findViewById(R.id.item_edit_status);
        chitiet = this.findViewById(R.id.item_edit_detail);
        loai = this.findViewById(R.id.item_edit_species);

        // nhan intent tu adapter_hoa
        intent = getIntent();
        f = (Flower) intent.getSerializableExtra("flower");
        img = f.getImageFlower();
        name = f.getFlowername();
        price = String.valueOf(f.getPrice());
        status = f.getStatus();
        detail = f.getDetails();
        species = f.getSpecies();
        key = f.getId();

        // set gia tri len exittext
        int index = this.getMipmapResIdByName(img);
        hinhanh.setImageResource(index);
        ten.setText(name);
        gia.setText(price);
        tinhtrang.setText(status);
        chitiet.setText(detail);
        loai.setText(species);


    }

    public void item_save_click(View v) {

        // lay gia tri tu edittext  sau khi sua
        String text1 = ten.getText().toString().trim();
        String text2 = gia.getText().toString().trim();

        //String text1 = hinhanh.getText().toString().trim();

        String text3 = chitiet.getText().toString().trim();

        String text4 = tinhtrang.getText().toString().trim();
        String text5 = loai.getText().toString().trim();

        f.setFlowername(text1);
        f.setPrice(text2);
        f.setImageFlower(img);
        f.setDetails(text3);
        f.setStatus(text4);
        f.setSpecies(text5);

        ref = FirebaseDatabase.getInstance().getReference("Flower");

        ref.child(key).setValue(f);

        Intent i = new Intent(edit_item_hoa.this, MainActivity.class);
        startActivity(i);

    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName) {
        String pkgName = getApplicationContext().getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = getApplicationContext().getResources().getIdentifier(resName, "mipmap", pkgName);
        Log.i("adapter_hoa", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}

