package com.quwaysim.travelmantics;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {
    //initialising the widgets as global
    EditText destination;
    EditText price;
    EditText description;
    //setting up Firebase Database variables
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //setting up firebase && reading/writing to the realtime database
        FirebaseUtility.openFirebaseReference("traveldeals", this);
        mFirebaseDatabase = FirebaseUtility.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtility.mDatabaseReference;
        //referencing the widgets
        destination = (EditText) findViewById(R.id.destination_editText);
        price = (EditText) findViewById(R.id.price_editText);
        description = (EditText) findViewById(R.id.description_editText);

    }

    //creating the menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    //what happens when save is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_menu:
                saveDeal();
                Toast.makeText(AdminActivity.this, "Deal Saved", Toast.LENGTH_LONG).show();
                reset();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //
    public void saveDeal() {
        String ndestination = destination.getText().toString();
        String nprice = price.getText().toString();
        String ndescription = description.getText().toString();
        TravelDeal deal = new TravelDeal(ndestination, nprice, ndescription, "");
        mDatabaseReference.push().setValue(deal);
    }

    //This method resets the editText fields
    public void reset() {
        destination.setText("");
        price.setText("");
        description.setText("");
        destination.requestFocus();
    }
}
