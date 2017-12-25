package com.example.auser.demodragdrop;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        constraintLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        imageView.setOnTouchListener(listener);
    }

    View.OnTouchListener listener = new View.OnTouchListener() {

        private float x,y;
        private int mx,my;


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                case MotionEvent.ACTION_MOVE:
                    mx = (int)(event.getRawX()-x);
                    my = (int)(event.getRawY()-getContentViewTop()-y);
                    v.layout(mx,my,mx+v.getWidth(),my+v.getHeight());
                    break;
            }
            return true;
        }
    };

    public int getContentViewTop() {
        View contentView = getWindow().findViewById(android.R.id.content);
        int[] coordinates = new int[2];
        contentView.getLocationOnScreen(coordinates);
        return coordinates[1];
    }
}
