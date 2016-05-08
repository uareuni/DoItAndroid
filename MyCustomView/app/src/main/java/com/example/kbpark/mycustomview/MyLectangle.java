package com.example.kbpark.mycustomview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KBPark on 2016. 5. 4..
 */
public class MyLectangle extends View {

    Paint paint;
    Bitmap mBitmap;
    Canvas mCanvas;

    public MyLectangle(Context context) {
        super(context);

        init(context);
    }

    public MyLectangle(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context)
    {
        paint = new Paint();
        paint.setAntiAlias(true);// 픽셀 깨지지 않게 해주는, 부드럽게 해주는 속성이에요
    }

    @Override

    // 왜 하필 onSizeChanged()를 찾는거죠?
    // view의 크기 정보를 가져와야만, 똑같은 크기의 bitmap객체를 만들어줄수 있잖아요.
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        if(w > 0 && h > 0) // 0,0인 경우? 예를들면, 버튼 2개가 가로정렬인데 하나가 match_parent이면 나머지는 안보여서 0,0이 올수도 있습니다. 등등
        {
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas.setBitmap(mBitmap);

            draw1();
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void draw1(){

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        mCanvas.drawRect(100,100,200,200,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(10.0f);
        mCanvas.drawRect(100,100,200,200,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        DashPathEffect effect = new DashPathEffect(new float[]{5,5}, 1);
        paint.setPathEffect(effect);
        mCanvas.drawLine(100,300,500,500, paint);


        // Drawable(그리기 객체)
        ShapeDrawable drawable1 = new ShapeDrawable(); // 얘는 container역할 비스무리한거라고 보시면 될거같아요.

        RectShape shape1 = new RectShape(); // 사각형의 좌표값이 설정된 shape1
        shape1.resize(200,200);
        drawable1.setShape(shape1); // container에 사각형 set.
        drawable1.setBounds(300, 100, 500, 300);// drawable은 setBounds()로 위치를 아예 지정해버릴 수 있어요.
        drawable1.draw(mCanvas); // draw()에 canvas객체를 넘겨주면 이 안에서 알아서 그려줍니다.

        // 그라데이션 효과를 넣는 코드입니다.
        LinearGradient gradient1 = new LinearGradient(0, 0, 0, 300, Color.RED, Color.YELLOW, Shader.TileMode.CLAMP);
        paint.setShader(gradient1);

        shape1.resize(300,300);
        drawable1.setBounds(400, 300, 700, 600);// drawable은 setBounds()로 위치를 아예 지정해버릴 수 있어요.
        drawable1.draw(mCanvas);

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
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            //invalidate();
        }
        return true;
    }
}
