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


public class obsoleteTMTPracticeS extends Activity {

    public static String savepath;
    static String id;
    LinearLayout linear;
    ArrayList<Point> arPoint, cfPoint;
    private MyView vm;
    int idx = 0;
    Date start, end;
    long time_a;
    int ch1, ch2, ch3, ch4, ch5, ch6;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        savepath = intent.getStringExtra("savepath");
        id = intent.getStringExtra("id");
        time_a = intent.getLongExtra("tmtA", 0);
        Log.i("test", "a 확인: " + time_a);
        vm = new MyView(this);

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
                    start = new Date();
                    arPoint.add(new Point(event.getX(), event.getY(), false));
                    return true;
                }
                if(event.getAction()==MotionEvent.ACTION_MOVE)
                {

                    if(idx == 0){
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch1 = 1;
                        }else if(event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch2 = 1;
                        }else if(event.getX() >= 1340 && event.getY() >= 600 && event.getX() <= 1440 && event.getY() <= 700){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch3 = 1;
                        }
                    }else if(idx == 1){
                        if(event.getX() >= 1700 && event.getY() >= 200 && event.getX() <= 1800 && event.getY() <= 300){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch4 = 1;
                        }else if(event.getX() >= 780 && event.getY() >= 540 && event.getX() <= 880 && event.getY() <= 640){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch5 = 1;
                        }else  if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch5 =1;
                        }
                    }else if(idx == 2){
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch1 = 1;
                        }else if(event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch2 = 1;
                        }else if(event.getX() >= 1340 && event.getY() >= 600 && event.getX() <= 1440 && event.getY() <= 700){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch3 = 1;
                        }
                    }else if(idx == 3){
                        if(event.getX() >= 1700 && event.getY() >= 200 && event.getX() <= 1800 && event.getY() <= 300){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch4 = 1;
                        }else if(event.getX() >= 780 && event.getY() >= 540 && event.getX() <= 880 && event.getY() <= 640){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch5 = 1;
                        }else  if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch6 = 1;
                        }
                    }else if(idx == 4){
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch1 = 1;
                        }else if(event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch2 = 1;
                        }else if(event.getX() >= 1340 && event.getY() >= 600 && event.getX() <= 1440 && event.getY() <= 700){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch3 = 1;
                        }
                    }else if(idx == 5){
                        if(event.getX() >= 1700 && event.getY() >= 200 && event.getX() <= 1800 && event.getY() <= 300){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch4 = 1;
                        }else if(event.getX() >= 780 && event.getY() >= 540 && event.getX() <= 880 && event.getY() <= 640){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch5 = 1;
                        }else  if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch6 = 1;
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

                                Intent intent = new Intent(obsoleteTMTPracticeS.this, TMTTestS.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                intent.putExtra("tmtA", time_a );
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
        Paint mPaint, cPaint, Pnt, textPaint, Pnt1, Pnt3;
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

            Pnt1 = new Paint();
            Pnt1.setTextSize(95);
            Pnt1.setStyle(Paint.Style.STROKE);
            Pnt1.setStrokeWidth(3);
            Pnt1.setAntiAlias(true);
            Pnt1.setColor(Color.DKGRAY);

            textPaint = new Paint();
            textPaint.setTextSize(28);
            textPaint.setColor(Color.DKGRAY);

            Pnt3 = new Paint();
            Pnt3.setTextSize(40);
            Pnt3.setStyle(Paint.Style.STROKE);
            Pnt3.setStrokeWidth(6);
            Pnt3.setAntiAlias(true);
            Pnt3.setColor(Color.BLACK);

        }

        public void onDraw(Canvas canvas){
            this.canvas = canvas;
            canvas.drawColor(Color.TRANSPARENT);

            drawNumberCircle(canvas, 670, 400, 770, 500, "▲");
            drawNumberCircle(canvas, 1700, 200, 1800, 300, "◼︎");
            drawNumberCircle(canvas, 1340, 600, 1440, 700, "▲");
            drawNumberCircle(canvas, 780, 540, 880, 640, "◼︎");
            drawNumberCircle(canvas, 890, 240, 990, 340, "▲");
            drawNumberCircle(canvas, 1280, 450, 1380, 550, "◼︎");


            if(ch1 == 1){
                drawCorrectCircle(670, 400);
            }
            if(ch1 == 2){
                drawCorrectCircle(1340, 600);
            }
            if(ch1 == 3){
                drawCorrectCircle(890, 240);
            }
            if(ch1 == 4){
                drawCorrectCircle(1700, 200);
            }
            if(ch1 == 5){
                drawCorrectCircle(780, 540);
            }
            if(ch1 == 6){
                drawCorrectCircle(1280, 450);
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
            if(str.equals("▲")){
                canvas.drawText(str, (a + c) / 2 - 25, (b + d) / 2 + 35, Pnt1);
            }else if(str.equals("◼︎")){
                canvas.drawText(str, (a + c) / 2 - 28, (b + d) / 2 + 17, Pnt);
            }

        }

        private void drawCorrectCircle(int a, int b){

            RectF basicRec = new RectF(a, b, a+100, b+100);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
        }

        private void drawText(Canvas canvas){

            canvas.drawText("시작", 700, 530, textPaint);
            canvas.drawText("끝", 1320, 580, textPaint);

            canvas.drawText("세모(▲), 네모(◼)︎ 두가지 모양이 있습니다.", 300, 200, textPaint);
            canvas.drawText("두가지 모양을 번갈아가면서 ", 300, 250, textPaint);
            canvas.drawText("가능한 빠르게 순서대로 선을 그어 이어주세요.", 300, 300, textPaint);

        }


    }
}
