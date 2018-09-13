package com.boston.burgerlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.boston.burgerlist.BurgerOrder.EXTRA_MESSAGE_BURGER_ADDONS;
import static com.boston.burgerlist.BurgerOrder.EXTRA_MESSAGE_BURGER_TYPE;
import static com.boston.burgerlist.BurgerOrder.EXTRA_MESSAGE_NAME;
import static com.boston.burgerlist.BurgerOrder.EXTRA_MESSAGE_NUMBER;
import static com.boston.burgerlist.BurgerOrder.EXTRA_MESSAGE_ADDRESS;

public class BurgerOrdered extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_ordered);

        Intent intent = getIntent();
        String sBurgerType = intent.getStringExtra(EXTRA_MESSAGE_BURGER_TYPE);
        String sAddOns = intent.getStringExtra(EXTRA_MESSAGE_BURGER_ADDONS);
        String SnameOrdered = intent.getStringExtra(EXTRA_MESSAGE_NAME);
        String SNumberOrdered = intent.getStringExtra(EXTRA_MESSAGE_NUMBER);
        String SAddressOrdered = intent.getStringExtra(EXTRA_MESSAGE_ADDRESS);

        TextView textViewBurgerType = findViewById(R.id.textviewBurgerType);
        TextView textViewAddOns = findViewById(R.id.tAddOns);
        TextView textViewName = findViewById(R.id.textviewNameBurgerOrdered);
        TextView textViewNumber = findViewById(R.id.textviewNumberBurgerOrdered);
        TextView textViewAddress = findViewById(R.id.textviewAddressBurgerOrdered);

        textViewBurgerType.setText("Burger Type: " + sBurgerType.toString() + "\n");
        textViewAddOns.setText("AddOns: " + sAddOns.toString() + "\n");
        textViewName.setText("Name: " + SnameOrdered.toString() + "\n");
        textViewNumber.setText("Number: " + SNumberOrdered.toString() + "\n");
        textViewAddress.setText("Address: " + SAddressOrdered.toString());
    }


    public void submit(View view){

        Toast.makeText(BurgerOrdered.this, "Record Submitted", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(BurgerOrdered.this, com.boston.burgerlist.BurgerOrder.class);
        startActivity(intent);}
}
