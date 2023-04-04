package com.example.wedding_planner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class CustomViewAdapter extends ArrayAdapter<String> {

    Context context;
    int[] foodImages;
    String[] foodList;
    int[] buttonPosition;

    public CustomViewAdapter(Context context, String[] foodList, int[] foodImages, int[] position) {
        super(context, R.layout.plan_dinner_menu, R.id.menu_list, foodList);
        this.context = context;
        this.foodImages = foodImages;
        this.foodList = foodList;
        this.buttonPosition = position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View singleItem = convertView;
        AdapterViewHolder holder = null;
        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.plan_dinner_menu, parent, false);
            holder = new AdapterViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            // Get the stored holder object
            holder = (AdapterViewHolder) singleItem.getTag();
        }
        // Set the values for your views in your item by accessing them through the holder
        holder.menuImage.setImageResource(foodImages[position]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, foodList);
        holder.menuList.setAdapter(arrayAdapter);
        holder.menuButton.setText(buttonPosition[position]);
        holder.menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked:"+ foodList[position], Toast.LENGTH_SHORT).show();
                //Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                //context.startActivity(openLinksIntent);
            }
        });
        return singleItem;
    }
}

//NOT USED.