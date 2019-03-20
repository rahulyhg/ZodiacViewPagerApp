package com.example.zodiacsigns.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zodiacsigns.R;
import com.squareup.picasso.Picasso;

public class ZodiacDisplayFragment extends Fragment {


    private static final String NAME_KEY = "params1";
    private static final String DATERANGE_KEY = "params2";
    private static final String IMAGE_KEY = "params3";

    private String params1;
    private String params2;
    private String params3;

    public ZodiacDisplayFragment getInstance(String zodiacName, String zodiacDateRange, String zodiacImage) {
        ZodiacDisplayFragment fragment = new ZodiacDisplayFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, params1);
        args.putString(DATERANGE_KEY, params2);
        args.putString(IMAGE_KEY, params3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            params1 = getArguments().getString(NAME_KEY);
            params2 = getArguments().getString(DATERANGE_KEY);
            params3 = getArguments().getString(IMAGE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zodiac_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView zodiacNameView = view.findViewById(R.id.fragment_zodiacname);
        TextView zodiacNumberView = view.findViewById(R.id.fragment_zodiacdaterange);
        ImageView zodiacImageView = view.findViewById(R.id.fragment_zodiacimage);

        zodiacNameView.setText(params1);
        zodiacNumberView.setText(params2);
        Picasso.get().load(params3).into(zodiacImageView);

    }
}
