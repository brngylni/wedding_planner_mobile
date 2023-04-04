package com.example.wedding_planner;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class AdapterViewHolder {

    AppCompatButton menuButton;
    ImageView menuImage;
    ListView menuList;

    AdapterViewHolder(View view) {
        menuButton = view.findViewById(R.id.menu_button);
        menuImage = view.findViewById(R.id.menu_image);
        menuList = view.findViewById(R.id.menu_list);
    }
}


//NOT USED.