package com.example.thamilton.colors;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    SeekBar red_seekbar;
    SeekBar green_seekbar;
    SeekBar blue_seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.red_seekbar = (SeekBar) findViewById(R.id.red_seekbar);
        this.green_seekbar = (SeekBar) findViewById(R.id.green_seekbar);
        this.blue_seekbar = (SeekBar) findViewById(R.id.blue_seekbar);

        this.red_seekbar.setOnSeekBarChangeListener(this);
        this.green_seekbar.setOnSeekBarChangeListener(this);
        this.blue_seekbar.setOnSeekBarChangeListener(this);

        this.red_seekbar.setMax(255);
        this.green_seekbar.setMax(255);
        this.blue_seekbar.setMax(255);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView red_seekbar_text = (TextView) findViewById(R.id.red_seekbar_text);
        TextView green_seekbar_text = (TextView) findViewById(R.id.green_seekbar_text);
        TextView blue_seekbar_text = (TextView) findViewById(R.id.blue_seekbar_text);

        int red_text = this.red_seekbar.getProgress();
        int green_text = this.green_seekbar.getProgress();
        int blue_text = this.blue_seekbar.getProgress();

        red_seekbar_text.setText(Integer.toString(red_text));
        green_seekbar_text.setText(Integer.toString(green_text));
        blue_seekbar_text.setText(Integer.toString(blue_text));

        TextView background = (TextView) findViewById(R.id.color_text);
        background.setBackgroundColor(Color.rgb(red_text, green_text, blue_text));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
