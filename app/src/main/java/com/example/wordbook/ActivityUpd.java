package com.example.wordbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityUpd extends AppCompatActivity {
    private Button btn_uplogin;
    private EditText et_upenglish;
    private EditText et_upsorting;
    private TextView tx_sorting;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd);
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteAll();
        btn_uplogin = findViewById(R.id.btn_uplogin);
        et_upenglish = (EditText)findViewById(R.id.et_upenglish);
        et_upsorting = (EditText)findViewById(R.id.et_upchinese);
        tx_sorting = findViewById(R.id.tx_sorting);
        btn_uplogin.setOnClickListener(view -> {
            String val_e =  String.valueOf(et_upenglish.getText());
            String val_s =  String.valueOf(et_upsorting.getText());
            db.updateContact(val_e,val_s);
            tx_sorting.setText(val_e+"修改成功");
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
            intent.setClass(ActivityUpd.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(ActivityUpd.this,ActivitySer.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(ActivityUpd.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(ActivityUpd.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
