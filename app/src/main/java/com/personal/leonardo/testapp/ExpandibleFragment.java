
package com.personal.leonardo.testapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpandibleFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;

    public ExpandibleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_expandible, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        init();

        return rootView;
    }

    private void init() {
        List<ParentModel> list = new ArrayList<>();

        ParentAdapter adapter = new ParentAdapter(list);

        for (int i = 0; i < 10; i++) {
            list.add(new ParentModel("Parent " + i, i + 1));
        }

        recyclerView.setAdapter(adapter);
    }

}
