package com.haze.calculator_gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.xml.sax.DTDHandler;

import java.util.ArrayList;
import java.util.Objects;

public class ListDataActivity extends AppCompatActivity {


    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;


    LinearLayout backlin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        backlin = (LinearLayout) findViewById(R.id.backlin);

        mDatabaseHelper = new DatabaseHelper(this);
        Objects.requireNonNull(getSupportActionBar()).setTitle("History");


        populateListView();
    }

    private void populateListView() {

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));

            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            mListView.setAdapter(adapter);
        }
    }


    public void retrocolor(){
        mListView.setBackgroundColor((ContextCompat.getColor(this, R.color.retroText)));
        backlin.setBackgroundColor((ContextCompat.getColor(this, R.color.retroBack)));


    }

    public void blingcolor(){
        mListView.setBackgroundColor((ContextCompat.getColor(this, R.color.blingText)));
        backlin.setBackgroundColor((ContextCompat.getColor(this, R.color.blingBack)));


    }

    public void darkcolor(){
        mListView.setBackgroundColor((ContextCompat.getColor(this, R.color.darkText)));
        backlin.setBackgroundColor((ContextCompat.getColor(this, R.color.darkBack)));


    }


}