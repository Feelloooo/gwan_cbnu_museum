package org.project.cbnu_museum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Heritage> heritage;

    public MyAdapter(Context c, ArrayList<Heritage> heritage) {
        this.c = c;
        this.heritage = heritage;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.mTitle.setText(heritage.get(position).getName());
        holder.mDes.setText(heritage.get(position).getDescription());
        Glide.with(holder.mImaeView).load(heritage.get(position).getAddress()).into(holder.mImaeView);
//        holder.mImaeView.setImageResource(Glide.with(Activity_heritage.this).load(user.get(position).getAddress()));
//        Glide.with().load(userList.get(2).getAddress()).into(iv);

        //click event
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                String gTitle = heritage.get(position).getName();
                String gEra = heritage.get(position).getEra();
                String gPlace = heritage.get(position).getPlace();
                String gDesc = heritage.get(position).getDescription();
                String gDetail = heritage.get(position).getDetail();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImaeView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                //100Kbytes 까지만 전달 가능
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c, Activity_detail.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iEra",gEra);
                intent.putExtra("iPlace", gPlace);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iDetail", gDetail);
                intent.putExtra("iImage", bytes);

                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heritage.size();
    }
}
