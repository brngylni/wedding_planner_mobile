package com.example.wedding_planner;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentDinnerMenu extends Fragment {

    ListView menuListView;
    String[] foodList = {"Dinner Option 1", "Dinner Option 2", "Dinner Option 3"};
    String[] subFoodList = {"Content 1", "Content 2", "Content 3"};
    ArrayList data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_dinner_menu_list, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuListView = (ListView) view.findViewById(R.id.menu_listview);
        data = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < foodList.length; i++){
            HashMap<String,String> datum = new HashMap<String, String>();
            datum.put("Dinner Option", foodList[i]);
            datum.put("Content", subFoodList[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_single_choice, new String[] {"Dinner Option", "Content"}, new int[] {android.R.id.text1, android.R.id.text2});
        menuListView.setAdapter(adapter);
        menuListView.setItemsCanFocus(false);
        menuListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Save the dinner option into database.
                Toast.makeText(getContext(), foodList[position] + " is selected.", Toast.LENGTH_LONG).show();

            }
        });

        menuListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setIcon(R.drawable.add_button_circ);
                builder.setMessage("Content 1 \nContent 2 \n...");
                builder.setPositiveButton("Ok", null);
                builder.show();
                return true;
            }
        });
    }
}
