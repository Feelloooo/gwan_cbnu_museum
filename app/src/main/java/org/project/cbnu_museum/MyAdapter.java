package org.project.cbnu_museum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<Heritage> heritage_unfiltered;
    ArrayList<Heritage> heritage_filtered;

    public MyAdapter(Context c, ArrayList<Heritage> heritage) {
        this.c = c;
        this.heritage_unfiltered = heritage;
        this.heritage_filtered = heritage;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.mTitle.setText(heritage_filtered.get(position).getName());
        holder.mDes.setText(heritage_filtered.get(position).getDescription());
        Glide.with(holder.mImaeView).load(heritage_filtered.get(position).getAddress()).into(holder.mImaeView);

        //click event
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                String gTitle = heritage_filtered.get(position).getName();
                String gEra = heritage_filtered.get(position).getEra();
                String gPlace = heritage_filtered.get(position).getPlace();
                String gDesc = heritage_filtered.get(position).getDescription();
                String gDetail = heritage_filtered.get(position).getDetail();
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
        return heritage_filtered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    heritage_filtered = heritage_unfiltered;
                } else {
                    ArrayList<Heritage> filteringList = new ArrayList<>();
                    for (Heritage item : heritage_unfiltered) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (item.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(item);
                        }

                    }
//                    for(int i = 0; i<heritage.size(); i++){
//                        if(heritage.get(i).getName().toLowerCase().contentEquals(charString.toLowerCase())){
//                            filteredList.add(heritage.get(i));
//                        }
//                    }
                    heritage_filtered = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = heritage_filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                heritage_filtered = (ArrayList<Heritage>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
