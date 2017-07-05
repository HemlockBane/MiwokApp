package com.example.android.miwokapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.start;
import static android.os.Build.VERSION_CODES.N;
import static com.example.android.miwokapp.R.id.numbers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/** Find the numbers view*/

        TextView numbers = (TextView) findViewById(R.id.numbers);

        /** Set an onClickListener on the numbers view*/

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a Toast message to display upon click
                Toast.makeText(v.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
                // Create a new intent to open the numbers activity

                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //Start  the numbers activity

                startActivity(numbersIntent);

            }
        });

        TextView family = (TextView) findViewById(R.id.family);

        /** Set an OnClickListener for the family activity*/

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Open the family activity", Toast.LENGTH_SHORT).show();

                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                /** Start the numbers activity*/

                startActivity(familyIntent);


            }
        });

        TextView colors = (TextView) findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Open the colors activity", Toast.LENGTH_SHORT).show();

                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                startActivity(colorsIntent);
            }
        });


        TextView phrases = (TextView) findViewById(R.id.phrases);

      phrases.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Toast.makeText(v.getContext(), "Open the phrases activity", Toast.LENGTH_SHORT).show();

              Intent colorsIntent = new Intent(MainActivity.this, PhrasesActivity.class);

              startActivity(colorsIntent);

          }
      });






    }

}
