package com.example.macbook.lab1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.macbook.lab1.models.Note;
import com.example.macbook.lab1.storage.NotesStorage;
import com.example.macbook.lab1.tools.NotesAdapter;

public class NotesActivity extends AppCompatActivity {

    ListView listView;
    int selectedListItemPosition = -1;

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

        updateNoteList();

        registerForContextMenu(listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateNoteList();
    }

    private void updateNoteList() {
        NotesAdapter na = new NotesAdapter(this, NotesStorage.get());
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(na);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        this.selectedListItemPosition = info.position;
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Edit");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        Log.v("menuItemId:", ""+item.getItemId());
        if(item.getTitle()=="Edit"){
            if (selectedListItemPosition != -1){
                Intent intent = new Intent();
                intent.putExtra("id", selectedListItemPosition);
                intent.setClass(this, EditNoteActivity.class);
                startActivity(intent);
            }
        }
        else if(item.getTitle()=="Delete"){
            if(selectedListItemPosition != -1){
                NotesStorage.remove(selectedListItemPosition);
                updateNoteList();
            }
        }else{
            return false;
        }
        return true;
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
                Intent intent = new Intent();
                intent.putExtra("id", -1);
                intent.setClass(this, EditNoteActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
