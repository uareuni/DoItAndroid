package com.example.kbpark.mypaintboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KBPark on 2016. 5. 5..
 */
public class PaintBoard extends View {

    Context mContext;
    Paint paint;
    Bitmap mBitmap;
    Canvas mCanvas;

    float curX;
    float curY;

    float oldX;
    float oldY;

    public PaintBoard(Context context) {
        super(context);

        init(context);
    }

    public PaintBoard(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        mContext = context;
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mBitmap != null)
        {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if(w > 0 && h > 0)
        {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas();
            mCanvas.setBitmap(mBitmap);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();

        curX = event.getX();
        curY = event.getY();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                mCanvas.drawLine(oldX, oldY, curX, curY, paint);


                break;
            case MotionEvent.ACTION_UP:
                break;

        }

        //저장해줍니다.
        oldX = curX;
        oldY = curY;

        invalidate();// onDraw()를 호출해줍니다. 새로 그려줍니다.

        return true;
    }
}
