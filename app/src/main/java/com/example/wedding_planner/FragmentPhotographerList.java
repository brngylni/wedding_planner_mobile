package com.example.wedding_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentPhotographerList extends Fragment {

    ListView photographerListView;
    String[] photographerList = {"Photographer Option 1", "Photographer Option 2", "Photographer Option 3"};
    String[] subPhotographerList = {"Information 1", "Information 2", "Information 3"};
    ArrayList data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_photographer_list, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        photographerListView = (ListView) view.findViewById(R.id.photographer_listview);
        data = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < photographerList.length; i++){
            HashMap<String,String> datum = new HashMap<String, String>();
            datum.put("Dinner Option", photographerList[i]);
            datum.put("Content", subPhotographerList[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_single_choice, new String[] {"Dinner Option", "Content"}, new int[] {android.R.id.text1, android.R.id.text2});
        photographerListView.setAdapter(adapter);
        photographerListView.setItemsCanFocus(false);
        photographerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        photographerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Save the dinner option into database.
                Toast.makeText(getContext(), photographerList[position] + " is selected.", Toast.LENGTH_LONG).show();
            }
        });
        photographerListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Dinner Option");
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.alert_image_view, null);
                builder.setView(dialoglayout);
                builder.setMessage("Content 1 \nContent 2 \n...");
                builder.setPositiveButton("Ok", null);
                builder.show();
                return true;
            }
        });
    }


}
