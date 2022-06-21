package com.example.cs4520_inclass.inClass3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.cs4520_inclass.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectAvatarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectAvatarFragment extends Fragment {

    ImageButton f1, f2, f3, m1, m2, m3;

    public SelectAvatarFragment() {
        // Required empty public constructor
    }

    public static SelectAvatarFragment newInstance(String param1, String param2) {
        SelectAvatarFragment fragment = new SelectAvatarFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ic3_select_avatar, container, false);

        f1 = rootView.findViewById(R.id.ic03_f1);
        f2 = rootView.findViewById(R.id.ic03_f2);
        f3 = rootView.findViewById(R.id.ic03_f3);
        m1 = rootView.findViewById(R.id.ic03_m1);
        m2 = rootView.findViewById(R.id.ic03_m2);
        m3 = rootView.findViewById(R.id.ic03_m3);

        f1.setOnClickListener(onClick(R.drawable.avatar_f_2));
        f2.setOnClickListener(onClick(R.drawable.avatar_f_3));
        f3.setOnClickListener(onClick(R.drawable.avatar_f_1));
        m1.setOnClickListener(onClick(R.drawable.avatar_m_3));
        m2.setOnClickListener(onClick(R.drawable.avatar_m_2));
        m3.setOnClickListener(onClick(R.drawable.avatar_m_1));



        return rootView;
    }

    private View.OnClickListener onClick(int drawableID) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((InClass03Activity) getActivity()).toEditActivity(drawableID);
            }
        };
    }
}