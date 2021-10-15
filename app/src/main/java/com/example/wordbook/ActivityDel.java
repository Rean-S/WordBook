package com.example.wordbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityDel extends AppCompatActivity {

    private ListView dellist;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        DatabaseHandler db = new DatabaseHandler(this);
        dellist = findViewById(R.id.lv_english);
        List<Contact> contacts = db.getAllContacts();
        List<String> cstring = new ArrayList<>();
        int i=0;
        try {
            while (true){
                cstring.add(contacts.get(i).getEnglish()+"\n"+contacts.get(i).getChinese());
                i++;
            }
        }
        catch (Exception e){

        }
        ArrayAdapter<String> data = new ArrayAdapter<String>(
                ActivityDel.this, android.R.layout.simple_list_item_1,cstring);
        dellist.setAdapter(data);
        dellist.setOnItemClickListener((parent, view, position, id) -> {
            String text=parent.getItemAtPosition(position).toString();
            String[] splitAddr=text.split("\n");
            db.deleteContact(splitAddr[0]);
            Toast.makeText( ActivityDel.this, splitAddr[0]+"删除成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityDel.class);
            startActivity(intent);
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivitySer.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
