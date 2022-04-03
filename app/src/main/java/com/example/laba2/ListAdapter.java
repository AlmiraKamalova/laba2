package com.example.laba2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {


    public ListAdapter(Context context, ArrayList<User> userArrayList) {

        super(context,R.layout.list_item,userArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
       User user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView poroda = convertView.findViewById(R.id.poroda);
        TextView  group = convertView.findViewById(R.id.group);
        TextView color = convertView.findViewById(R.id.color);

        imageView.setImageResource(user.imageId);
        poroda.setText(user.poroda);
        group.setText(user.group);
        color.setText(user.color);
       return convertView;
    }


}
