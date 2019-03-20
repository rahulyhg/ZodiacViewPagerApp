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
    private static final String NAME_KEY = "name";
    private static final String DATERANGE_KEY = "dateRange";
    private static final String IMAGE_KEY = "image";

    private static String name;
    private static String dateRange;
    private static String image;

    public static ZodiacDisplayFragment getInstance(String zodiacName, String zodiacDateRange, String zodiacImage) {
        ZodiacDisplayFragment fragment = new ZodiacDisplayFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, zodiacName);
        args.putString(DATERANGE_KEY, zodiacDateRange);
        args.putString(IMAGE_KEY, zodiacImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME_KEY);
            dateRange = getArguments().getString(DATERANGE_KEY);
            image = getArguments().getString(IMAGE_KEY);
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

        zodiacNameView.setText(name);
        zodiacNumberView.setText(dateRange);
        Picasso.get().load(image).into(zodiacImageView);
    }
}
