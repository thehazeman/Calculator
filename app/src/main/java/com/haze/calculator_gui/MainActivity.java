package com.haze.calculator_gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.NavigationViewKt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    double add, sub, mult, div, scs, dot, counter;
    double lock, lock2, lock3;


    TextView textView, textView2;

    private DrawerLayout drawer;

    ConstraintLayout backdrop;

    double result1, result2, result3;
    DatabaseHelper mDatabaseHelper;

    ListDataActivity mListData;

    String entry1, entry2, entry3, TAG;

    Button button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;
    Button button12, button13, button14, button15, button16, button17;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //declarations
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12); //equal
        button13 = (Button) findViewById(R.id.button13); //decimal
        button14 = (Button) findViewById(R.id.button14); //division
        button15 = (Button) findViewById(R.id.button15); //multipl
        button16 = (Button) findViewById(R.id.button16); //subtract
        button17 = (Button) findViewById(R.id.button17); //addition


        backdrop = findViewById(R.id.backdrop);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);



        drawer.addDrawerListener(toggle);
        toggle.syncState();
/*
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new History_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_history);
        }
*/



        mDatabaseHelper = new DatabaseHelper(this);
        DarkTheme();




        dot = 1;
        lock = 1;
        lock2 = 1;
        counter = 0;

        textView2.setText("0");

        Objects.requireNonNull(getSupportActionBar()).setTitle("Calculator");
       // DarkTheme();
        //loadSharedPreferences();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("0");
                add = 0;
                mult = 0;
                sub = 0;
                div = 0;
                counter = 0;
                dot = 1;
                lock = 1;
                lock2 = 1;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(lock == 1)
                {
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "7");

                    }
                    else{
                        textView2.setText(textView2.getText() + "7");
                    }


                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }
                }

                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "8");

                    }
                    else{
                        textView2.setText(textView2.getText() + "8");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "9");

                    }
                    else{
                        textView2.setText(textView2.getText() + "9");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }

                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }


            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "4");

                    }
                    else{
                        textView2.setText(textView2.getText() + "4");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "5");

                    }
                    else{
                        textView2.setText(textView2.getText() + "5");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "6");

                    }
                    else{
                        textView2.setText(textView2.getText() + "6");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "1");

                    }
                    else{
                        textView2.setText(textView2.getText() + "1");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "2");

                    }
                    else{
                        textView2.setText(textView2.getText() + "2");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }

                }


                if (counter >= 1){
                    counter = counter + 1;
                }
                if (counter == 8){
                    toastMessage("Decimal limit reached");
                    lock = 0;
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock == 1){
                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "3");

                    }
                    else{
                        textView2.setText(textView2.getText() + "3");
                    }

                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }


                    if (counter >= 1){
                        counter = counter + 1;
                    }
                    if (counter == 8){
                        toastMessage("Decimal limit reached");
                        lock = 0;
                    }

                }
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock == 1){

                    if (textView2.getText() == "0")
                    {
                        textView2.setText("");
                        textView2.setText(textView2.getText() + "0");

                    }
                    else{
                        textView2.setText(textView2.getText() + "0");
                    }


                    if (textView2.getText().length() > 12)
                    {
                        toastMessage("Character limit reached!");
                        lock = 0;
                    }


                    if (counter >= 1){
                        counter = counter + 1;

                    }
                    if (counter == 8){
                        toastMessage("Decimal limit reached");
                        lock = 0;
                    }




                }

            }
        });


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {
                    result2 = Double.parseDouble(textView2.getText() + "");

                    entry2 = textView2.getText().toString();
                    DecimalFormat numberFormat = new DecimalFormat("#.000000");

                    dot = 1;
                    lock = 1;
                    counter = 0;
                    lock2 = 1;

                    if (add == 1) {


                        textView2.setText(numberFormat.format(result1 + result2).toString().replaceAll("()\\.0+$|(\\..+?)0+$", "$2") + "");

                        if (result1 + result2 == 0)
                        {
                            textView2.setText("0");
                        }



                        String newEntry = textView2.getText().toString();
                        if (textView2.length() != 0) {
                            AddData(entry1 + " + " + entry2 + " = " + newEntry);
                        }





                        entry1 = newEntry;


                        add = 0;


                    }
                    if (sub == 1) {


                        textView2.setText(numberFormat.format(result1 - result2).toString().replaceAll("()\\.0+$|(\\..+?)0+$", "$2") + "");


                        if (result1 == result2){
                            textView2.setText("0");
                        }


                        //textView2.setText(result1 - result2 + "");
                        sub = 0;

                        String newEntry = textView2.getText().toString();
                        if (textView2.length() != 0) {
                            AddData(entry1 + " - " + entry2 + " = " + newEntry);
                        }
                        entry1 = newEntry;

                    }

                    if (mult == 1) {

                        textView2.setText(numberFormat.format(result1 * result2).toString().replaceAll("()\\.0+$|(\\..+?)0+$", "$2") + "");

                        if (result1 * result2 == 0) {
                            textView2.setText("0");
                        }


                        mult = 0;

                        String newEntry = textView2.getText().toString();
                        if (textView2.length() != 0) {
                            AddData(entry1 + " x " + entry2 + " = " + newEntry);
                        }
                        entry1 = newEntry;

                    }
                    if (div == 1) {



                        textView2.setText(numberFormat.format(result1 / result2).toString().replaceAll("()\\.0+$|(\\..+?)0+$", "$2") + "");


                        if (result1 / result2 == 0) {
                            textView2.setText("0");

                        }


                        if (result2 == 0 || (result1 == 0 && result2 == 0 ) )
                        {
                            toastMessage("Undefined! Cannot divide by zero!");
                            textView2.setText("0");

                        }

                        else{
                            String newEntry = textView2.getText().toString();
                            if (textView2.length() != 0) {
                                AddData(entry1 + " / " + entry2 + " = " + newEntry);
                            }
                            entry1 = newEntry;
                        }
                        div = 0;











                    }

                } catch (Exception e){

                        toastMessage("Error!");
                        add = 0;
                        mult = 0;
                        sub = 0;
                        div = 0;
                        dot = 0;


                }

            }
        });


        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    if (lock == 1) {

                        if (textView2.getText().toString().contains(".")) {
                            toastMessage("Error! Decimal present!");
                            dot = 0;
                        }

                        if (textView2.getText().length() > 12) {
                            toastMessage("Character limit reached!");
                            lock = 0;
                        }

                        if (dot == 1) {
                            textView2.setText(textView2.getText() + ".");

                            dot = 0;
                            counter = 1;
                        }


                    }




            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (lock2 == 1)
                {
                    entry1 = textView2.getText().toString();
                    dot = 1;
                    lock = 1;
                    counter = 0;

                    result1 = Double.parseDouble(textView2.getText() + "");
                    div = 1;
                    textView2.setText(null);
                    lock2 = 0;
                }




            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if (lock2 == 1) {
                    dot = 1;
                    lock = 1;
                    counter = 0;


                    entry1 = textView2.getText().toString();
                    result1 = Double.parseDouble(textView2.getText() + "");
                    mult = 1;
                    textView2.setText(null);

                    lock2 = 0;

                }

            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lock2 == 1)
                {
                    dot = 1;
                    lock = 1;
                    counter = 0;



                    entry1 = textView2.getText().toString();


                    result1 = Double.parseDouble(textView2.getText() + "");
                    sub = 1;
                    textView2.setText(null);

                    lock2 = 0;
                }

            }
        });

        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lock2 == 1){
                    dot = 1;
                    lock = 1;
                    counter = 0;
                    entry1 = textView2.getText().toString();
                    result1 = Double.parseDouble(textView2.getText() + "");
                    add = 1;
                    // String r = Double.toString(result1);
                    textView2.setText(null);

                    lock2 = 0;
                }


            }
        });

    }

    @SuppressLint("ResourceAsColor")
    public void RetroTheme(){

        textView.setText("Retro Calculator");

        //title
        textView.setTextColor((ContextCompat.getColor(this, R.color.retroTitle)));

        //text
        textView2.setTextColor((ContextCompat.getColor(this, R.color.retroText)));

        //background
        backdrop.setBackgroundColor(ContextCompat.getColor(this, R.color.retroBack));



        // numbers
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button6.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button7.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button8.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button9.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button10.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));
        button11.setBackgroundColor(ContextCompat.getColor(this, R.color.retroNumbers));

        //calcs
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button12.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button13.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button14.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button15.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button16.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));
        button17.setBackgroundColor(ContextCompat.getColor(this, R.color.retroCalc));

        //history
       // mListData.retrocolor();



    }

    public void BlingTheme()
    {
        //
        textView.setText("Bling Calculator");

        //title
        textView.setTextColor((ContextCompat.getColor(this, R.color.blingTitle)));

        //text
        textView2.setTextColor((ContextCompat.getColor(this, R.color.blingText)));

        //background
        backdrop.setBackgroundColor(ContextCompat.getColor(this, R.color.blingBack));



        // numbers
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button6.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button7.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button8.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button9.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button10.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));
        button11.setBackgroundColor(ContextCompat.getColor(this, R.color.blingNumbers));

        //calcs
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button12.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button13.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button14.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button15.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button16.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));
        button17.setBackgroundColor(ContextCompat.getColor(this, R.color.blingCalc));

        //history
        // mListData.blingcolor();


    }

    public void DarkTheme(){

        textView.setText("");

        //title
        textView.setTextColor((ContextCompat.getColor(this, R.color.darkTitle)));

        //text
        textView2.setTextColor((ContextCompat.getColor(this, R.color.darkText)));

        //background
        backdrop.setBackgroundColor(ContextCompat.getColor(this, R.color.darkBack));



        // numbers
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button6.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button7.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button8.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button9.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button10.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));
        button11.setBackgroundColor(ContextCompat.getColor(this, R.color.darkNumbers));

        //calcs
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button12.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button13.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button14.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button15.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button16.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));
        button17.setBackgroundColor(ContextCompat.getColor(this, R.color.darkCalc));



        //history
        // mListData.darkcolor();


    }




    public void DeleteData(){

        mDatabaseHelper.deleteData();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.nav_history:

                toastMessage("History");
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_clear:
                toastMessage("History cleared!");
                DeleteData();
                break;

            case R.id.nav_retro:
                toastMessage("Retro theme");
                RetroTheme();
                break;

            case R.id.nav_bling:
                toastMessage("Bling theme");
                BlingTheme();
                break;

            case R.id.nav_dark:
                toastMessage("Dark theme");
                DarkTheme();
                break;


        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("Added to History");
        } else{
            toastMessage("History Error");
        }
    }



    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}



