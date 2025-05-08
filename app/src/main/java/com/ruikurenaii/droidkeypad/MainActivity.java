package com.ruikurenaii.droidkeypad;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TouchView touchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        touchView = new TouchView(this);
        setContentView(touchView);
    }

    private static class TouchView extends View {
        private float touchX = -1, touchY = -1;
        private final Paint paint = new Paint();

        public TouchView(MainActivity context) {
            super(context);
            paint.setColor(Color.MAGENTA);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (touchX >= 0 && touchY >= 0) {
                canvas.drawCircle(touchX, touchY, 100, paint);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                touchX = event.getX();
                touchY = event.getY();
                invalidate();
                // TODO: Send mouse click or keypress here
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                touchX = -1;
                touchY = -1;
                invalidate();
                // TODO: Send mouse release here
            }
            return true;
        }
    }
}
