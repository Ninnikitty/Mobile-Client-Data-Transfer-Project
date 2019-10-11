package com.example.mobiiliprojekti;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private TextView textView;

    public MyCustomAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //return list.get(pos).getId();
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        //Handle TextView and display string from your list
       textView = (TextView)view.findViewById(R.id.txtTitle);
       textView.setText(list.get(position));

        //Handle buttons and add onClickListeners
        ImageButton deleteBtn = (ImageButton)view.findViewById(R.id.imgbtnDelete);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Deletes row information
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        Button enterButton = (Button)view.findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String texti = textView.getText().toString();
                Uri uri = Uri.parse("http://" +texti);
                Intent intentti = new Intent(Intent.ACTION_VIEW, uri);
               // Intent linkkiLinkki = new Intent(android.content.Intent.ACTION_VIEW);
                //linkkiLinkki.setData(Uri.parse("http://" +textView.toString()));
                context.startActivity(intentti);
            }
        });

        return view;
    }
}

