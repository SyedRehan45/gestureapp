// MainActivity.java
package com.example.gestureapp;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView gestureText;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureText = findViewById(R.id.gestureText);
        gestureDetector = new GestureDetector(this, new GestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            gestureText.setText("Single Tap detected");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            gestureText.setText("Long Press detected");
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (e1.getY() < e2.getY()) {
                gestureText.setText("Scroll Down detected");
            } else {
                gestureText.setText("Scroll Up detected");
            }
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() < e2.getX()) {
                gestureText.setText("Swipe Right detected");
            } else {
                gestureText.setText("Swipe Left detected");
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            gestureText.setText("Double Tap detected");
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            gestureText.setText("Single Tap Up detected");
            return true;
        }

        // Implement pinch gestures
        // Note: Pinch gestures require additional implementation, which is complex and usually involves handling multi-touch events manually.
    }
}
