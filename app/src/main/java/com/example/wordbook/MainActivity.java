package com.example.wordbook;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_alllogin;
    private EditText et_english;
    private TextView tx_sorting;
    private ListView lv_english;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteAll();
        btn_login = findViewById(R.id.btn_login);
        btn_alllogin = findViewById(R.id.btn_alllogin);
        et_english = (EditText)findViewById(R.id.et_english);
        tx_sorting = findViewById(R.id.tx_sorting);
        lv_english = findViewById(R.id.lv_english);
        db.addContact(new Contact("English", "英语，英国人，英国的"));
        db.addContact(new Contact("Chinese", "中文，中国人，中国的"));
        db.addContact(new Contact("Hello", "你好"));
        db.addContact(new Contact("Would", "世界"));
        btn_login.setOnClickListener(view -> {
            String val_e =  String.valueOf(et_english.getText());
            try {
                Contact contacts = db.getContact(val_e);
                tx_sorting.setText(val_e+"\n"+contacts.getChinese());
            }
            catch (Exception e){
                tx_sorting.setText("不存在此单词");
            }
        });
        btn_alllogin.setOnClickListener(view -> {
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
                    MainActivity.this, android.R.layout.simple_list_item_1,cstring);
            lv_english.setAdapter(data);
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
            intent.setClass(MainActivity.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ActivitySer.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
