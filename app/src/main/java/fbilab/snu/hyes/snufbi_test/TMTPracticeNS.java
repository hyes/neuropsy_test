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


public class TMTPracticeNS extends Activity {

    public static String savepath;
    static String id;
    LinearLayout linear;
    ArrayList<Point> arPoint, cfPoint;
    private MyView vm;
    int idx = 0;
    Date start, end;
    long time_a, time_s;
    boolean ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        savepath = intent.getStringExtra("savepath");
        id = intent.getStringExtra("id");
        time_a = intent.getLongExtra("tmtA", 0);
        Log.i("test", "a: "+time_a);
        time_s = intent.getLongExtra("tmtS", 0);
        Log.i("test", "s: "+time_s);
        vm = new MyView(this);
      //  my = new MyView(getApplicationContext());



        Window win = getWindow();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT);
        win.addContentView(vm, params);


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
                        if(event.getX() >= 1000 && event.getY() >= 400 && event.getX() <= 1100 && event.getY() <= 500){

                            vm.drawCorrectCircle(1000, 400, 1100, 500, "1");
                            ch1 = true;

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 1){
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){
                            vm.drawCorrectCircle(670, 400, 770, 500, "▲");
                            ch2 = true;

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }else if(event.getX() >= 1080 && event.getY() >= 650 && event.getX() <= 1180 && event.getY() <= 750){
                            vm.drawCorrectCircle(1080, 650, 1180, 750, "▲");
                            ch3 = true;

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 2){
                        if(event.getX() >= 840 && event.getY() >= 600 && event.getX() <= 940 && event.getY() <= 700){
                            vm.drawCorrectCircle(840, 600, 940, 700, "2");
                            ch4 = true;

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 3){
                        if(event.getX() >= 1280 && event.getY() >= 540 && event.getX() <= 1380 && event.getY() <= 640){
                            vm.drawCorrectCircle(1280, 540, 1380, 640, "◼︎");
                            ch5 =true;

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 4){
                        if(event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340){
                            vm.drawCorrectCircle(890, 240, 990, 340, "3");
                            ch6 =true;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 5){
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){
                            vm.drawCorrectCircle(670, 400, 770, 500, "▲");
                            ch2 = true;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }else if(event.getX() >= 1080 && event.getY() >= 650 && event.getX() <= 1180 && event.getY() <= 750){
                            vm.drawCorrectCircle(1080, 650, 1180, 750, "▲");
                            ch3 = true;
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }



                    arPoint.add(new Point(event.getX(), event.getY(), true));

                    vm.invalidate();
                    return true;
                }

                if(event.getAction()==MotionEvent.ACTION_UP){

                    if(idx == 6){

                        Toast.makeText(getApplicationContext(), "검사로 이동합니다.", Toast.LENGTH_SHORT).show();

                        final Handler handler = new Handler();

                        final Runnable r = new Runnable() {
                            public void run() {

                                Intent intent = new Intent(TMTPracticeNS.this, TMTTestNS.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                intent.putExtra("tmtA", time_a );
                                intent.putExtra("tmtS", time_s );
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
        Paint mPaint, cPaint, Pnt, textPaint, Pnt1, Pnt2, Pnt3;
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
            Pnt.setTextSize(50);
            Pnt.setStyle(Paint.Style.STROKE);
            Pnt.setStrokeWidth(3);
            Pnt.setAntiAlias(true);
            Pnt.setColor(Color.DKGRAY);

            Pnt2 = new Paint();
            Pnt2.setTextSize(40);
            Pnt2.setStyle(Paint.Style.STROKE);
            Pnt2.setStrokeWidth(3);
            Pnt2.setAntiAlias(true);
            Pnt2.setColor(Color.DKGRAY);

            Pnt3 = new Paint();
            Pnt3.setTextSize(40);
            Pnt3.setStyle(Paint.Style.STROKE);
            Pnt3.setStrokeWidth(6);
            Pnt3.setAntiAlias(true);
            Pnt3.setColor(Color.BLACK);

            Pnt1 = new Paint();
            Pnt1.setTextSize(95);
            Pnt1.setStyle(Paint.Style.STROKE);
            Pnt1.setStrokeWidth(3);
            Pnt1.setAntiAlias(true);
            Pnt1.setColor(Color.DKGRAY);

            textPaint = new Paint();
            textPaint.setTextSize(28);
            textPaint.setColor(Color.DKGRAY);

        }

        public void onDraw(Canvas canvas) {
            this.canvas = canvas;
            canvas.drawColor(Color.TRANSPARENT);

            drawNumberCircle(canvas, 1000, 400, 1100, 500, "1︎");
            drawShapeCircle(canvas, 670, 400, 770, 500, "▲");
            drawNumberCircle(canvas, 840, 600, 940, 700, "2");
            drawShapeCircle(canvas, 1280, 540, 1380, 640, "◼︎");
            drawNumberCircle(canvas, 890, 240, 990, 340, "3");
            drawShapeCircle(canvas, 1080, 650, 1180, 750, "▲");



            if (ch1 == true) {
                drawCorrectCircle(1000, 400, 1100, 500, "1");
            }
            if (ch2 == true){
                drawCorrectCircle(670, 400, 770, 500, "▲");
            }
            if (ch3 == true){
                drawCorrectCircle(1080, 650, 1180, 750, "▲");
            }
            if (ch4 == true){
                drawCorrectCircle(840, 600, 940, 700, "2");
            }
            if (ch5 == true){
                drawCorrectCircle(1280, 540, 1380, 640, "◼︎");

            }
            if (ch6 == true){
                drawCorrectCircle(890, 240, 990, 340, "3");
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

        private void drawShapeCircle(Canvas canvas, int a, int b, int c, int d, String str){

            RectF basicRec = new RectF(a, b, c, d);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt);
            if(str.equals("▲")){
                canvas.drawText(str, (a + c) / 2 - 25, (b + d) / 2 + 35, Pnt1);
            }else if(str.equals("◼︎")){
                canvas.drawText(str, (a + c) / 2 - 28, (b + d) / 2 + 17, Pnt);
            }

        }

        private void drawNumberCircle(Canvas canvas, int a, int b, int c, int d, String str){

            RectF basicRec = new RectF(a, b, c, d);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt2);
            if(str.length() == 1) {
                canvas.drawText(str, (a + c) / 2 - 5, (b + d) / 2 + 15, Pnt2);
            }else{
                canvas.drawText(str, (a + c) / 2 - 20, (b + d) / 2 + 15, Pnt2);
            }
        }


        private void drawCorrectCircle(int a, int b, int c, int d, String str){

            RectF basicRec = new RectF(a, b, c, d);
                canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
        }

        private void drawText(Canvas canvas){

            canvas.drawText("시작", 1030, 530, textPaint);
            canvas.drawText("끝", 1120, 780, textPaint);


            canvas.drawText("숫자와 세모(▲), 네모(◼)︎ 두가지 모양이 있습니다.", 200, 200, textPaint);
            canvas.drawText("숫자와 두가지 모양을 번갈아가면서 ", 200, 250, textPaint);
            canvas.drawText("(1 - 세모 - 2 - 네모 - 3 ...) ", 200, 300, textPaint);
            canvas.drawText("위와 같은 순서로 가능한 빨리 선을 그어주세요.", 200, 350, textPaint);
        }


    }
}
