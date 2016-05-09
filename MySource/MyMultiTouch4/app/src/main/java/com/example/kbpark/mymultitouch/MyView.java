package com.example.kbpark.mymultitouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KBPark on 2016. 5. 3..
 */
public class MyView extends View{


    // 현재좌표
    float curX;
    float curY;

    // 뗐을때 저장된 좌표
    float saveX;
    float saveY;

    // 차이값
    float offsetX;
    float offsetY;

    // draw()할 시작좌표
    float startX;
    float startY;

    // bitmap x,y
    float bitmapX;
    float bitmapY;


    Paint paint; // (붓)
    Bitmap bitmap; // 이미지를 담을 객체에요. 화면에다 애를 그려줄겁니다. (종이)
    Bitmap mBitmap; //memoryBitmap (메모리에 있는 종이)
    Canvas mCanvas; //memoryCanvas (메모리에 있는 종이판) : 그림을 그리려면 판을 대고 그려야지 그냥은 붕떠서 어떻게 그려!



    public MyView(Context context) {
        super(context);

        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context)
    {
        paint = new Paint();

        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res,R.mipmap.highway);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {

        if(w > 0 && h > 0){
            newImage(w, h); // 아무것도 없는 빈곳에, 그림을 그릴 모든 세팅을 다 해줄겁니다 여기서.
            redraw(); // 그리고 마지막으로 채워진 이미지를 그려주는 작업을 해줄겁니다. 실제로 여기서 그리고, 우리가 볼 화면에 다시 그려달라고 요청할겁니다.
        }
    }

    private void newImage(int w, int h)
    {
        // 안드로이드에서는 메모리에 이미지를 로딩하면 Bipmap객체가 되거든요,
        mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888); //ARGB_8888 : 제일 일반적인 이미지 컬러설정 입니다. (도화지에 그려줄 그림)

        mCanvas = new Canvas(); // Canvas는 뭔가 그려줄수 있는 거에요. (이젤, 종이 놓는 판 같은 느낌?)
        mCanvas.setBitmap(mBitmap); // 이렇게하면 canvas에 뭔가를 그려줄수 있습니다. (판 위에 종이 올려놓는 느낌)
    }

    private void redraw()
    {
        mCanvas.drawColor(Color.WHITE); //Canvas전체를 하얗게 칠해준 후,
        mCanvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);

        invalidate(); // "화면을 다시 그려달라!" - invalidate()가 호출되면 onDraw()가 호출되고, 따라서 현재 메모리에 있는 이미지를 다시 뿌려주게 되겠죠?
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 얘는 다 그려둔 이미지를 우리 화면에 뿌려주는 메소드입니다.

        if(mBitmap != null) // 여기서 받아온 canvas는 위에꺼랑 다른 canvas입니다. 직접 화면에 그릴 canvas에요! View쪽에서 넘겨주는 canvas입니다. 혼동하지 마시길!
        {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //MotionEvent객체가 좌표값까지 알수 있게 해줍니다.
        int action = event.getAction();

        // 초기값
        if(action == MotionEvent.ACTION_DOWN) {

            startX = event.getX(0);// offset을 구하기 위해선
            startY = event.getY(0);// '고정된 값'하나와

        }else if(action == MotionEvent.ACTION_MOVE){

            curX = event.getX();// '변하는 값' 하나가 필요하겠죠?
            curY = event.getY();

            offsetX = curX - startX;
            offsetY = curY - startY;


            bitmapX = saveX + offsetX; // saveX, saveY는 offset값들을 계속 누적시키는 변수에요
            bitmapY = saveY + offsetY; // saveX, saveY는 고정이고, offset값은 움직이는 동안 계속 변하겠죠.

            redraw();

        }else if(action == MotionEvent.ACTION_UP){
            saveX = bitmapX; // 누적
            saveY = bitmapY;


        }


        return true;
    }
}
