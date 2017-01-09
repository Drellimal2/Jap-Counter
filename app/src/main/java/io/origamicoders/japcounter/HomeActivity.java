package io.origamicoders.japcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button counters = (Button) findViewById(R.id.home_counter_button);
        Button hundred = (Button) findViewById(R.id.home_hundred_button);
        Button quiz = (Button) findViewById(R.id.home_quiz_button);

        final Intent counterIntent = new Intent(this, CountersActivity.class);
        final Intent numberIntent = new Intent(this, HundredActivity.class);
        Utils.getDatabase();
        counters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(counterIntent);

            }
        });
        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(numberIntent);

            }
        });


    }

}
