package com.example.macbook.lab1;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.macbook.lab1.models.Note;
import com.example.macbook.lab1.storage.NotesStorage;
import com.example.macbook.lab1.tools.NotesAdapter;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Note note1 = new Note();
        note1.setTitle("Note1");
        note1.setDescription("Description for note 1");

        Note note2 = new Note();
        note2.setTitle("Note2");
        note2.setDescription("Description for note 2");

        Note note3 = new Note();
        note3.setTitle("Note3");
        note3.setDescription("Description for note 3");

        NotesStorage.add(note1);
        NotesStorage.add(note2);
        NotesStorage.add(note3);

        NotesAdapter na = new NotesAdapter(this, NotesStorage.get());

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(na);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    final View view,
                                    int position, long id) {
                Log.v("t", "" + position);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_search:
                Log.v("v", "Search action clicked");
                return true;
            case R.id.action_add:
                Log.v("v", "New item clicked");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
