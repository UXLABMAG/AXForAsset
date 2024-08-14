package com.example.labux;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ConditionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conditions, container, false);

        // Apply blur effect to the blurView
        View blurView = view.findViewById(R.id.blurView);
        if (blurView != null) {
            ShapeDrawable backgroundDrawable = new ShapeDrawable(new RectShape());
            backgroundDrawable.getPaint().setColor(0xB344D9E8);  // Adjust the color as needed
            backgroundDrawable.getPaint().setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
            blurView.setBackground(backgroundDrawable);
        }

        return view;
    }
}
