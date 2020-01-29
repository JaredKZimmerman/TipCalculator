package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText bill;
    private EditText tip;
    private EditText totalBill;
    private EditText party;
    private RadioButton divide;
    private RadioButton single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = findViewById(R.id.bill);
        tip = findViewById(R.id.tip);
        totalBill = findViewById(R.id.totalBill);
        party = findViewById(R.id.party);
        divide = findViewById(R.id.divide);
        single = findViewById(R.id.single);
    }

    public void calculate (View v){
        String inputbill = bill.getText().toString();
        if (inputbill.length()>0) {
            double billvalue = Double.parseDouble(inputbill);
            String inputtip = tip.getText().toString();
            if (inputtip.length() > 0) {
                double tipvalue = Double.parseDouble(inputtip);
                if(divide.isChecked()){
                    String inputparty = party.getText().toString();
                    if (party.length() > 0) {
                        double partynum = Double.parseDouble(inputparty);
                        double tbvalue = (billvalue + (billvalue * (tipvalue / 100))) / partynum;
                        totalBill.setText(String.format("%.2f", tbvalue));
                    }else{
                        Toast.makeText(this, "Please enter # of party members", Toast.LENGTH_SHORT).show();
                    }
                }else if(single.isChecked()) {
                    double tbvalue = billvalue + (billvalue * (tipvalue / 100));
                    totalBill.setText(String.format("%.2f", tbvalue));
                }else {
                    Toast.makeText(this, "Please choose a radio button", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No tip value entered", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No bill entered", Toast.LENGTH_SHORT).show();
        }
    }
}
