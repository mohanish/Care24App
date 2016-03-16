package com.care24;

import android.databinding.BindingAdapter;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by mohanish on 3/15/16.
 */
public class AppImageBinding {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String uri) {
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        Picasso.with(view.getContext()).load(uri)
                .resize(metrics.widthPixels, metrics.heightPixels / 2)
                .into(view);
    }
}
