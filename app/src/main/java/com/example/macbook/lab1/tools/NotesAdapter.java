package com.example.macbook.lab1.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbook.lab1.R;
import com.example.macbook.lab1.models.Note;

public class NotesAdapter extends BaseAdapter {

    private final Context context;
    private final Note[] notes;

    public NotesAdapter(Context context, Note[] notes) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return notes.length;
    }

    @Override
    public Object getItem(int i) {
        return notes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.note_raw, parent, false);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.note_title);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.note_description);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.note_image);

        titleView.setText(notes[position].getTitle());
        descriptionView.setText(notes[position].getDescription());


        return convertView;
    }
}
