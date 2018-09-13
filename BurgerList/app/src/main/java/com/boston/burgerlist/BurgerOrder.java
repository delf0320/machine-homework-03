package com.boston.burgerlist;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BurgerOrder extends AppCompatActivity{

    public final static String EXTRA_MESSAGE_BURGER_TYPE= "com.boston.BurgerOrder.BurgerType";
    public final static String EXTRA_MESSAGE_BURGER_ADDONS= "com.boston.BurgerOrder.ADDONS";
    public final static String EXTRA_MESSAGE_NAME= "com.boston.BurgerOrder.Name";
    public final static String EXTRA_MESSAGE_NUMBER= "com.boston.BurgerOrder.Number";
    public final static String EXTRA_MESSAGE_ADDRESS= "com.boston.BurgerOrder.Address";
    Intent intent;
    public String bac;
    public String pin;
    public String let;
    public String pic;
    public String ches;
    public String mus;
//    public final static String EXTRA_MESSAGE_Bacon= "com.boston.BurgerOrder.Bacon";
//    public final static String EXTRA_MESSAGE_Pineapple= "com.boston.BurgerOrder.Pineapple";
//    public final static String EXTRA_MESSAGE_Lettuce= "com.boston.BurgerOrder.Lettuce";
//    public final static String EXTRA_MESSAGE_Pickles= "com.boston.BurgerOrder.Pickles";
//    public final static String EXTRA_MESSAGE_Cheese= "com.boston.BurgerOrder.Cheese";
//    public final static String EXTRA_MESSAGE_Mustard= "com.boston.BurgerOrder.Mustard";
//    private CheckBox bacon = null;
//    private CheckBox pineapple = null;
//    private CheckBox lettuce = null;
//    private CheckBox pickles = null;
//    private CheckBox cheese = null;
//    private CheckBox mustard = null;
//    private boolean baconCheckBoxValue = false;
//    private boolean pineappleCheckBoxValue = false;
//    private boolean lettuceCheckBoxValue = false;
//    private boolean cheeseCheckBoxValue = false;
//    private boolean mustardCheckBoxValue = false;
//    private boolean picklesCheckBoxValue = false;

    public RadioGroup burgerType;
    public int radioId;
    public RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_order);
        getSupportActionBar().setTitle("Burger Queen!");



        burgerType = findViewById(R.id.rG);


        burgerType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_chicken:
                        Toast.makeText(BurgerOrder.this, "Chicken!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.radio_beef:
                        Toast.makeText(BurgerOrder.this, "Beef!", Toast.LENGTH_SHORT).show();
                        break;
                }


            }

        });



        radioId = burgerType.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        android.support.v7.widget.AppCompatImageButton cart = findViewById(R.id.cart);
        cart.setOnClickListener(clickListener);

    }
    public void onCheckedBox(View view)
    {
        CheckBox bacon = findViewById(R.id.Bacon);
        CheckBox pineapple = findViewById(R.id.Pineapple);
        CheckBox lettuce = findViewById(R.id.Lettuce);
        CheckBox pickels = findViewById(R.id.Pickles);
        CheckBox cheese = findViewById(R.id.Cheese);
        CheckBox mustard = findViewById(R.id.Mustard);
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId())
        {
            case R.id.Bacon:if (checked){
                Toast.makeText(BurgerOrder.this, "Bacon", Toast.LENGTH_LONG).show();
                bac=bacon.getText().toString();
            }else{if(bacon == null){bacon.getResources().getText(R.string.empty);
                bac=bacon.getText().toString();}
                }break;
            case R.id.Pineapple:if(checked){
                Toast.makeText(BurgerOrder.this, "Pineapple", Toast.LENGTH_LONG).show();
                pin=pineapple.getText().toString();

            }else {pineapple.getResources().getText(R.string.empty);
                pic=pineapple.getText().toString();}break;
            case R.id.Lettuce:if (checked) {
                Toast.makeText(BurgerOrder.this, "Lettuce", Toast.LENGTH_LONG).show();
                let=lettuce.getText().toString();

            }else{lettuce.getResources().getText(R.string.empty);
                let=lettuce.getText().toString();}break;
            case R.id.Pickles:if (checked){
                Toast.makeText(BurgerOrder.this, "Pickles", Toast.LENGTH_LONG).show();
                pic=pickels.getText().toString();

            }else{pickels.getResources().getText(R.string.empty);
                pic=pineapple.getText().toString();}break;
            case R.id.Cheese:if (checked){
                Toast.makeText(BurgerOrder.this, "Cheese", Toast.LENGTH_LONG).show();
                ches=cheese.getText().toString();
            }else {cheese.setText("");
                ches=cheese.getText().toString();

            }break;
            case R.id.Mustard:if (checked){
                Toast.makeText(BurgerOrder.this, "Mustard", Toast.LENGTH_LONG).show();
                mus=mustard.getText().toString();
            }else {mustard.setText("");
                mus=mustard.getText().toString();}break;
        }
    }
    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            intent = new Intent(BurgerOrder.this, com.boston.burgerlist.BurgerOrdered.class);

            radioId = burgerType.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);

            String  newRadioButton = radioButton.getText().toString();


            EditText name = findViewById(R.id.name);
            EditText number = findViewById(R.id.number);
            EditText address = findViewById(R.id.address);



            String sname = name.getText().toString();
            String snumber = number.getText().toString();
            String saddress = address.getText().toString();


            String nextLine = "\n";

            intent.putExtra(EXTRA_MESSAGE_BURGER_TYPE,newRadioButton);
            intent.putExtra(EXTRA_MESSAGE_NAME,sname);
            intent.putExtra(EXTRA_MESSAGE_NUMBER,snumber);
            intent.putExtra(EXTRA_MESSAGE_ADDRESS,saddress);
            intent.putExtra(EXTRA_MESSAGE_BURGER_ADDONS,nextLine+bac+nextLine+pin+nextLine+let+nextLine+pic+nextLine+ches+nextLine+mus);
            startActivity(intent);

        }
    };





}
