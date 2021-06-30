package org.project.cbnu_museum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_heritage1 extends Fragment {
    private View view;

    public static Frag_heritage1 newInstance(){

        Frag_heritage1 frag_heritage1 = new Frag_heritage1();
        return frag_heritage1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_heritage1, container, false);

        return view;
    }

}