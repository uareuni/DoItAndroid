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

    // 현재좌표
    float curX1;
    float curY1;
    float curX2;
    float curY2;

    // 이전좌표
    float oldX1;
    float oldY1;
    float oldX2;
    float oldY2;

    // 차이값
    float diffx1;
    float diffy1;
    float diffx2;
    float diffy2;


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
        //중요! : 판위에 종이를 올려놓으면(set하면) 향후 판(canvas)에 그리는(draw) 모든 작업은 종이(bitmap)에도 자동 반영됩니다!
        // 판에 댄 종이 위에다 그린다 생각하면 되요!
    }

    private void redraw()
    {
        mCanvas.drawColor(Color.WHITE); //Canvas전체를 하얗게 칠해준 후,
        mCanvas.drawBitmap(bitmap,diffx1,diffy1,paint); //아까 위에서 정의한 bitmap객체를 (0,0)의 위치에 그려줄겁니다.
        // bitmap을 그려주는 메소드는 Canvas의 멤버함수 밖에 없어요.

        // 안드로이드는 뭔가를 그릴때(draw) 그 도구로 Paint객체를 사용합니다.
        // 이렇게 Paint객체를 만들면 그 안에 Color값을 지정해놓을 수 있어요. (지금은 지정하진 않았어요)

        // -> 이런식으로 drawBitmap을 하면 현재 메모리에 그림이 하나 만들어져있는거에요.


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

//            diffx1 = curX1 - oldX1; //diff : 차이값
//            diffy1 = curY1 - oldY1; //diff : 차이값

            // 원래 diff는 차이값을 목적으로 만든거지만 일단은 Move동작을 명확하게 보기위해 cur값으로 해볼게요.
            diffx1 = curX1;
            diffy1 = curY1;

            redraw();

        }else if(action == MotionEvent.ACTION_UP){
            Log.d(TAG,"action_up:"+ pointerCount + "/(" + curX1 + "," + curY1 + ") , (" + curX2 + "," + curY2 + ")");
        }

        oldX1 = curX1;
        oldY1 = curY1;

        oldX2 = curX2;
        oldY2 = curY2;



        return true;
    }
}
