package org.project.cbnu_museum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Frag_heritage1 extends Fragment {
    private View view;
    RecyclerView recyclerView;
    MyAdapter myAdapter;


    public static Frag_heritage1 newInstance(){

        Frag_heritage1 frag_heritage1 = new Frag_heritage1();
        return frag_heritage1;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_heritage1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(getContext(), getMylist());
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    private ArrayList<Heritage> getMylist() {
        ArrayList<Heritage> heritage = new ArrayList<>();

        DataAdapter mDbHelper = new DataAdapter(getContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        heritage = mDbHelper.getTableData1();

        // db 닫기
        mDbHelper.close();

        return heritage;
    }

}
