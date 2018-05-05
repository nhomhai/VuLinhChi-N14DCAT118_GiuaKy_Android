package com.testfire.giuakyvlc;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vulinhchi on 4/19/18.
 */

public class adapter_hoa extends BaseAdapter {

    private List<Flower> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public adapter_hoa(Context aContext, List<Flower> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        adapter_hoa.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_hoa, null);
            holder = new adapter_hoa.ViewHolder();

            holder.imageview = (ImageView) convertView.findViewById(R.id.item_image);
            holder.flowername = (TextView) convertView.findViewById(R.id.Item_name);
            holder.price = (TextView) convertView.findViewById(R.id.item_price);
            holder.detail = (TextView) convertView.findViewById(R.id.item_detail);
            holder.status = (TextView) convertView.findViewById(R.id.item_status);
            holder.species = (TextView) convertView.findViewById(R.id.item_species);

            holder.btn_Del =(Button) convertView.findViewById(R.id.item_btn_delete);
            holder.btn_Edit = (Button) convertView.findViewById(R.id.item_btn_edit);


            convertView.setTag(holder);

        } else {
            holder = (adapter_hoa.ViewHolder) convertView.getTag();
        }

        holder.btn_Del.setTag((Integer)position);
        holder.btn_Edit.setTag((Integer)position);


        Flower flower = this.listData.get(position);
        // lay key ra (key firebase tu tao)
        holder.key = listData.get(position).getId();
        holder.flowername.setText(flower.getFlowername());
        holder.price.setText("Gia:  " + flower.getPrice());
        holder.species.setText("Loai:  "+flower.getSpecies());
        holder.status.setText("Tinh trang:  "+flower.getStatus());
        holder.detail.setText("Chi tiet:  "+flower.getDetails());

        // add anh:
        int imageId = this.getMipmapResIdByName(flower.getImageFlower());

        holder.imageview.setImageResource(imageId);

        return convertView;
    }
    public int getMipmapResIdByName(String resName)
    {
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }



    static class ViewHolder {
        String key;
        ImageView imageview;
        TextView flowername;
        TextView price;
        TextView detail;
        TextView species;
        TextView status;
        Button btn_Del;
        Button btn_Edit;


    }



}
