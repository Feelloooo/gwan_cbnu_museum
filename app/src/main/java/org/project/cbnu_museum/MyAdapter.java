package org.project.cbnu_museum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClickListener(View view, int position) {
//
//                String gTitle = models.get(position).getTitle();
//                String gDesc = models.get(position).getDescription();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImaeView.getDrawable();
//                String gNumber = models.get(position).getPhonenumber();
//
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//                //100Kbytes 까지만 전달 가능
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//
//                byte[] bytes = stream.toByteArray();
//
//                Intent intent = new Intent(c, AnotherActivity.class);
//                intent.putExtra("iTitle", gTitle);
//                intent.putExtra("iDesc", gDesc);
//                intent.putExtra("iImage", bytes);
//                intent.putExtra("iNumber", gNumber);
//                c.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return heritage.size();
    }
}
