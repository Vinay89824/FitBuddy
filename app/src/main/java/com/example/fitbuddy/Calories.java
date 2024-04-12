package com.example.giatorsjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.giatorsjava.R;

public class Calories extends AppCompatActivity  {


    EditText etage, etheight, etweigth, etsbp, etdbp;
    RadioButton rdmale, rdfemale;
    Spinner amrspinner;
    Button btncalculate,btndietplans;
    TextView tvspinn, tvbmi, tvcal, tvBp, tvclass;
    String[] type1 = {"little or no exercise", "exercise 1–3 days/week", "exercise 3–5 days/week",
            "exercise 6–7 days/week", "hard exercise 6–7 days/week"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calories);
        etage = findViewById(R.id.etage);
        etheight = findViewById(R.id.etheight);
        etweigth = findViewById(R.id.etweigth);
        etsbp = findViewById(R.id.etsbp);
        etdbp = findViewById(R.id.etdbp);
        rdmale = findViewById(R.id.rdmale);
        rdfemale = findViewById(R.id.rdfemale);
        amrspinner = findViewById(R.id.amrspinner);
        btncalculate = findViewById(R.id.btncalculate);
        btndietplans=findViewById(R.id.btndietplans);
        tvspinn = findViewById(R.id.tvspinn);
        tvbmi = findViewById(R.id.tvbmi);
        tvcal = findViewById(R.id.tvcal);
        tvBp = findViewById(R.id.tvBp);
        tvclass = findViewById(R.id.tvclass);

        amrspinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, type1));

        amrspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (view.getId() == R.id.amrspinner) {
                    if (type1[i].equals("exercise 1–3 days/week")) {
                        tvspinn.setText("exercise 1–3 days/week");
                    } else if (type1[i].equals("exercise 3–5 days/week")) {
                        tvspinn.setText("exercise 3–5 days/week");
                    } else if (type1[i].equals("exercise 6–7 days/week")) {
                        tvspinn.setText("exercise 6–7 days/week");
                    } else if (type1[i].equals("hard exercise 6–7 days/week")) {
                        tvspinn.setText("hard exercise 6–7 days/week");
                    } else if (type1[i].equals("little or no exercise")) {
                        tvspinn.setText("little or no exercise");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btndietplans.setOnClickListener(l->{
             if(tvclass.getText().toString()=="underweight"){
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","underweight");
                startActivity(ii);

            }else if(tvclass.getText().toString()=="Normal"){
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","Normal");
                startActivity(ii);
            }else if(tvclass.getText().toString()=="overweight"){
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","overweight");
                startActivity(ii);
            }else if (tvclass.getText().toString()=="obesity(Class1)") {
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","obesity(Class1)");
                startActivity(ii);
            } else if (tvclass.getText().toString()=="obesity(Class2)") {
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","obesity(Class2)");
                startActivity(ii);
            } else if (tvclass.getText().toString()=="Extremeobesity") {
                Intent ii= new Intent(Calories.this, Dietplans.class);
                ii.putExtra("name","Extremeobesity");
                startActivity(ii);
            }
        });

        findViewById(R.id.btncalculate).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                float h = Float.parseFloat(etheight.getText().toString());
                int w = Integer.parseInt(etweigth.getText().toString());
                int a = Integer.parseInt(etage.getText().toString());
                float hh = (h * h) / 10000;
                float rr = w / hh;

                if (Integer.parseInt(etsbp.getText().toString()) <= 120 && Integer.parseInt(etdbp.getText().toString()) < 80) {
                    tvBp.setText("your Blood pressure Normal");
                } else if (Integer.parseInt(etsbp.getText().toString()) >= 129 && Integer.parseInt(etsbp.getText().toString()) < 120 && Integer.parseInt(etdbp.getText().toString()) < 80) {
                    tvBp.setText("your Blood pressure Elevated");
                } else if (Integer.parseInt(etsbp.getText().toString()) >= 130 && Integer.parseInt(etdbp.getText().toString()) >= 80) {
                    tvBp.setText("your Blood pressure high");
                } else if ((Integer.parseInt(etsbp.getText().toString()) < 120 && Integer.parseInt(etdbp.getText().toString()) < 80)) {
                    tvBp.setText("your Blood pressure Low");
                }

                if (rr < 18.5) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("underweight");

                } else if (rr > 18.5 && rr < 24.9) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("Normal");
                } else if (rr > 25 && rr < 29.9) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("overweight");
                } else if (rr > 30 && rr < 34.9) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("obesity(Class1)");
                } else if (rr > 35 && rr < 39.9) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("obesity(Class2)");
                } else if (rr > 40.9) {
                    tvbmi.setText("BMI " + rr);
                    tvclass.setText("Extremeobesity");
                }

                if (rdmale.isChecked()) {
                    double bmr = 66.47 + (13.75 * w) + (5.003 * h) - (6.755 * a);
                    if (amrspinner.getSelectedItem().toString().equals("little or no exercise")) {
                        double r1 = bmr * 1.2;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 1–3 days/week")) {
                        double r1 = bmr * 1.375;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 3–5 days/week")) {
                        double r1 = bmr * 1.55;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 6–7 days/week")) {
                        double r1 = bmr * 1.725;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("hard exercise 6–7 days/week")) {
                        double r1 = bmr * 1.9;
                        tvcal.setText("Calories: " + r1);
                    }
                } else if (rdfemale.isChecked()) {
                    double bmr = (655.1 + (9.563 * w) + (1.850 * h) - (4.676 * a));
                    if (amrspinner.getSelectedItem().toString().equals("little or no exercise")) {
                        double r1 = bmr * 1.2;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 1–3 days/week")) {
                        double r1 = bmr * 1.375;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 3–5 days/week")) {
                        double r1 = bmr * 1.55;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("exercise 6–7 days/week")) {
                        double r1 = bmr * 1.725;
                        tvcal.setText("Calories: " + r1);
                    } else if (amrspinner.getSelectedItem().toString().equals("hard exercise 6–7 days/week")) {
                        double r1 = bmr * 1.9;
                        tvcal.setText("Calories: " + r1);
                    }
                }
            }
        });



    }





}