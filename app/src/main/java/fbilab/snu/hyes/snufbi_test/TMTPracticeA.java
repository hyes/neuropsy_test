package fbilab.snu.hyes.snufbi_test;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;


public class TMTPracticeA extends Activity {

    public static String savepath;
    static String id;
    LinearLayout linear;
    ArrayList<Point> arPoint, cfPoint;
    private MyView vm;
    int idx = 0;
    Date start, end;
    long time_a;
    boolean ch1, ch2, ch3, ch4, ch5, ch6;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        savepath = intent.getStringExtra("savepath");
        id = intent.getStringExtra("id");

        vm = new MyView(this);

        Window win = getWindow();
        //  win.setContentView(R.layout.main);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
//        vm.setAlpha((float) 0.5);
        win.addContentView(vm, params);

//        LayoutInflater inflater1 = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LinearLayout linear = (LinearLayout)inflater1.inflate(R.layout.main, null);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//        win.addContentView(linear, layoutParams);

        arPoint=new ArrayList<Point>();
        cfPoint=new ArrayList<Point>();



        vm.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {


                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    arPoint.add(new Point(event.getX(), event.getY(), false));
                    return true;
                }

                if(event.getAction()==MotionEvent.ACTION_MOVE)
                {

                    if(idx == 0){
                        if(event.getX() >= 200 && event.getY() >= 400 && event.getX() <= 300 && event.getY() <= 500){
                            ch1 = true;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 1){
                        if (event.getX() >= 450 && event.getY() >= 600 && event.getX() <= 550 && event.getY() <= 700) {
                            ch2 = !ch2;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx++;
                            Log.i("test", "if1: " + idx + "");
                        }
                    } else if (idx == 2) {
                        if (event.getX() >= 800 && event.getY() >= 40 && event.getX() <= 900 && event.getY() <= 140) {
                            ch3 = !ch3;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            Log.i("test", "if2: " + idx+"");
                        }
                    } else if (idx == 3) {
                        if (event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500) {
                            ch4 = !ch4;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    } else if (idx == 4) {
                        if (event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340) {
                            ch5 = !ch5;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    } else if (idx == 5) {
                        if (event.getX() >= 1000 && event.getY() >= 550 && event.getX() <= 1100 && event.getY() <= 650) {
                            ch6 = !ch6;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();

                        }
                    }


                    arPoint.add(new Point(event.getX(), event.getY(), true));

                    vm.invalidate();
                    return true;
                }

                if(event.getAction()==MotionEvent.ACTION_UP){

                    if (idx == 5) {

                        Toast.makeText(getApplicationContext(), "검사로 이동합니다", Toast.LENGTH_SHORT).show();

                        final Handler handler = new Handler();

                        final Runnable r = new Runnable() {
                            public void run() {

                                Intent intent = new Intent(TMTPracticeA.this, TMTTestA.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);

                                startActivity(intent);
                            }
                        };

                        handler.postDelayed(r, 2000);

                    }

                }


                return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TMTPracticeA.this, TestSelection.class);
        intent.putExtra("id", id);
        intent.putExtra("savepath", savepath);
        startActivity(intent);
    }

    public class Point{

        float x;
        float y;
        boolean Draw;

        Point(float ax, float ay, boolean ad){
            x=ax;
            y=ay;
            Draw=ad;
        }
    }

    protected class MyView extends View{
        Paint mPaint, cPaint, Pnt, textPaint, Pnt3;
        Canvas canvas;

        public MyView(Context context){
            super(context);


            mPaint=new Paint();
            mPaint.setColor(Color.LTGRAY);
            mPaint.setStrokeWidth(3);
            mPaint.setAntiAlias(true);

            cPaint=new Paint();
            cPaint.setColor(Color.DKGRAY);
            cPaint.setStrokeWidth(4);
            cPaint.setAntiAlias(true);

            Pnt = new Paint();
            Pnt.setTextSize(40);
            Pnt.setStyle(Paint.Style.STROKE);
            Pnt.setStrokeWidth(3);
            Pnt.setAntiAlias(true);
            Pnt.setColor(Color.DKGRAY);

            Pnt3 = new Paint();
            Pnt3.setTextSize(40);
            Pnt3.setStyle(Paint.Style.STROKE);
            Pnt3.setStrokeWidth(6);
            Pnt3.setAntiAlias(true);
            Pnt3.setColor(Color.BLACK);


            textPaint = new Paint();
            textPaint.setTextSize(28);
            textPaint.setColor(Color.DKGRAY);

        }

        public void onDraw(Canvas canvas){
            this.canvas = canvas;
            canvas.drawColor(Color.WHITE);


            drawNumberCircle(canvas, 200, 400, 300, 500, "1");
            drawNumberCircle(canvas, 450, 600, 550, 700, "2");
            drawNumberCircle(canvas, 800, 40, 900, 140, "3");
            drawNumberCircle(canvas, 670, 400, 770, 500, "4");
            drawNumberCircle(canvas, 890, 240, 990, 340, "5");
            drawNumberCircle(canvas, 1000, 550, 1100, 650, "6");

            if(ch1){
                drawCorrectCircle(200, 400);
            }
            if(ch2){
                drawCorrectCircle(450, 600);
            }
            if(ch3){
                drawCorrectCircle(800, 40);
            }
            if(ch4){
                drawCorrectCircle(670, 400);
            }
            if(ch5){
                drawCorrectCircle(890, 240);
            }
            if(ch6){
                drawCorrectCircle(1000, 550);
            }

            drawText(canvas);


            for(int i=0; i<cfPoint.size(); i++){
                if(cfPoint.get(i).Draw){
                    canvas.drawLine(cfPoint.get(i-1).x, cfPoint.get(i-1).y,
                            cfPoint.get(i).x, cfPoint.get(i).y, cPaint);
                }
            }
            for(int i=1; i<arPoint.size(); i++){
                if(arPoint.get(i).Draw){
                    canvas.drawLine(arPoint.get(i-1).x, arPoint.get(i-1).y,
                            arPoint.get(i).x, arPoint.get(i).y, mPaint);
                }
            }

        }

        private void drawNumberCircle(Canvas canvas, int a, int b, int c, int d, String str){

            RectF basicRec = new RectF(a, b, c, d);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt);
            if(str.length() == 1) {
                canvas.drawText(str, (a + c) / 2 - 10, (b + d) / 2 + 15, Pnt);
            }else{
                canvas.drawText(str, (a + c) / 2 - 20, (b + d) / 2 + 15, Pnt);
            }
        }

        private void drawCorrectCircle(int a, int b){

            RectF basicRec = new RectF(a, b, a+100, b+100);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
        }

        private void drawText(Canvas canvas){

            canvas.drawText("시작", 230, 530, textPaint);
            canvas.drawText("끝", 1040, 680, textPaint);

            canvas.drawText("1부터 25까지 숫자가 있습니다.", 200, 200, textPaint);
            canvas.drawText("가능한 빠르게 순서대로 선을 그어 이어주세요.", 200, 250, textPaint);

        }


    }
}
