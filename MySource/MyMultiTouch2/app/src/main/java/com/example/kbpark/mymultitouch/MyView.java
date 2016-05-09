package com.example.kbpark.mymultitouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KBPark on 2016. 5. 3..
 */
public class MyView extends View{

    public static final String TAG = "MyView";

    float curX1;
    float curY1;

    float curX2;
    float curY2;

    Paint paint;
    Bitmap bitmap; // 이미지를 담을 객체에요. 화면에다 애를 그려줄겁니다.

    Bitmap mBitmap;
    Canvas mCanvas;


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

    // 여러분이 View를 layout에 넣으면, 여러분들이 보기전에 이미 각각의 view는 화면의 크기가 정해져요.
    // 그렇게 화면의 크기가 정해지면 onSizeChanged()가 호출됩니다.
    // 그래서 여러분이 각각 view의 사이즈가 정해졌을때 뭔가 하라고 하려고 이걸 오버라이딩 한겁니다.
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // 화면의 크기가 정해졌을때 이미지를 display 해볼겁니다.
        // 우리는 화면에다 뭔가를 그릴때, '더블 버퍼링'이라고 해서
        // 메모리에 이미지를 하나 만든다음에 그걸 가져다가 여기에 보여주는 과정을 거치게 됩니다.

        // 예를들면 여기 init()이란게 호출되서 context라는게 넘어왔잖아요?
        // context.getResources()라는걸 사용하면 얘는 /res에 접근할수 있게 해줍니다.

        // 왜 더블 버퍼링을 쓰죠?
        // 그래야 속도가 빠르거든요. 가상의 버퍼를 만들어서 거기다가 그릴거 다 그려놓고, 그다음에 불러와야 속도가 빠릅니다.

        if(w > 0 && h > 0){
            newImage(w, h); // 얘는 아무것도 없는 그냥 빈 이미지에요. 내가 가져올 highway이미지랑 다릅니다. 빈 container역할을 하는거에요.
            redraw(); // 그리고 마지막으로 채워진 이미지를 그려주는 작업을 해줄겁니다.
        }
    }

    private void newImage(int w, int h)
    {
        // 안드로이드에서는 메모리에 이미지를 로딩하면 Bipmap객체가 되거든요,
        mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888); //ARGB_8888 : 제일 일반적인 이미지 컬러입니다.
        mCanvas = new Canvas(); // Canvas는 뭔가 그려줄수 있는 거에요.
        mCanvas.setBitmap(mBitmap); // 이렇게하면 canvas에 뭔가를 그려줄수 있습니다.
    }

    private void redraw()
    {
        mCanvas.drawColor(Color.WHITE); //Canvas전체를 하얗게 칠해준 후,
        mCanvas.drawBitmap(bitmap,0,0,paint); //아까 위에서 정의한 bitmap객체를 (0,0)의 위치에 그려줄겁니다.
        // 안드로이드는 뭔가를 그릴때(draw) Paint객체를 사용합니다.
        // 이렇게 Paint객체를 만들면 그 안에 Color값을 지정해놓을 수 있어요. (지금은 지정하진 않았어요)

        // -> 이런식으로 drawBitmap을 하면 현재 메모리에 그림이 하나 만들어져있는거에요.
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mBitmap != null) // 이 canvas는 또 다른 canvas입니다. 직접 화면에 그릴 canvas에요! View쪽에서 넘겨주는 canvas입니다. 혼동하지 마시길!
        {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //MotionEvent객체가 좌표값까지 알수 있게 해줍니다.
        int action = event.getAction();

        int pointerCount = event.getPointerCount(); // 몇개의 손가락으로 터치했는지 알아올수 있습니다. return되는 값으로!

        curX1 = event.getX(0);
        curY1 = event.getY(0);

        if(pointerCount > 1) // 손가락이 한개 이상일때
        {
            curX2 = event.getX(1);
            curY2 = event.getY(1);
        }

        if(action == MotionEvent.ACTION_DOWN) {
            Log.d(TAG,"action_dowm:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }else if(action == MotionEvent.ACTION_MOVE){
            Log.d(TAG,"action_move:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }else if(action == MotionEvent.ACTION_UP){
            Log.d(TAG,"action_up:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }

        return true;
    }
}
