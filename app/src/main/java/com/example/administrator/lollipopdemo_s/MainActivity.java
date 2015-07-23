package com.example.administrator.lollipopdemo_s;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnTouchListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViewById(R.id.card).setOnTouchListener(this);
        findViewById(R.id.card).setOnClickListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        CardView cardView = (CardView) v;
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                cardView.setCardElevation(getResources().getDimension(R.dimen.card_max_elevation));
                break;
            case MotionEvent.ACTION_UP:
                cardView.setCardElevation(getResources().getDimension(R.dimen.card_elevation));
                break;
        }
        //return true;
        return !v.isClickable();

    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this,"CardView is clicked",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,RecyclerActivity.class));
    }
}
