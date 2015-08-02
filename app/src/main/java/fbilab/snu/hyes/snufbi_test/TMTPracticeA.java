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
    private Stimulus s1, s2, s3, s4, s5, s6;



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

                    if(idx == 0 ){
                        if(event.getX() >= s1.getX() && event.getY() >= s1.getY() && event.getX() <= s1.getX() + 70 && event.getY() <= s1.getY() + 70){
                            idx += 1;
                            ch1 = true;

                        }
                    }else if(idx ==1){
                        if(event.getX() >= s2.getX() && event.getY() >= s2.getY() && event.getX() <= s2.getX() + 70 && event.getY() <= s2.getY()+70){
                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch2 = true;
                        }
                    }else if(idx == 2){
                        if(event.getX() >= s3.getX() && event.getY() >= s3.getY() && event.getX() <= s3.getX() + 70 && event.getY() <= s3.getY()+70){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch3 = true;
                        }
                    }else if(idx == 3){
                        if(event.getX() >= s4.getX() && event.getY() >= s4.getY() && event.getX() <= s4.getX() + 70 && event.getY() <= s4.getY()+70){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch4 = true;
                        }
                    }else if(idx == 4){
                        if(event.getX() >= s5.getX() && event.getY() >= s5.getY() && event.getX() <= s5.getX() + 70 && event.getY() <= s5.getY()+70){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch5 = true;
                        }
                    }else if(idx == 5) {
                        if (event.getX() >= s6.getX() && event.getY() >= s6.getY() && event.getX() <= s6.getX() + 70 && event.getY() <= s6.getY() + 70) {

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                            ch6 = true;
                        }
                    }

                    arPoint.add(new Point(event.getX(), event.getY(), true));

                    vm.invalidate();
                    return true;
                }

                if(event.getAction()==MotionEvent.ACTION_UP){

                    if (idx == 6) {

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


            s1 = new Stimulus(200, 400, "1");
            s2 = new Stimulus(450, 600, "2");
            s3 = new Stimulus(800, 40, "3");
            s4 = new Stimulus(670, 400, "4");
            s5 = new Stimulus(890, 240, "5");
            s6 = new Stimulus(1000, 550, "6");

            drawNumberCircle(canvas, s1);
            drawNumberCircle(canvas, s2);
            drawNumberCircle(canvas, s3);
            drawNumberCircle(canvas, s4);
            drawNumberCircle(canvas, s5);
            drawNumberCircle(canvas, s6);

            if(ch1){
                drawCorrectCircle(s1);
            }
            if(ch2){
                drawCorrectCircle(s2);
            }
            if(ch3){
                drawCorrectCircle(s3);
            }
            if(ch4){
                drawCorrectCircle(s4);
            }
            if(ch5){
                drawCorrectCircle(s5);
            }
            if(ch6){
                drawCorrectCircle(s6);
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


        private void drawNumberCircle(Canvas canvas, Stimulus stimulus){

            int x = stimulus.getX();
            int y = stimulus.getY();
            String str = stimulus.getStr();
            RectF basicRec = new RectF(x, y, x + 70, y+70);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt);
            if(str.length() == 1) {
                canvas.drawText(stimulus.getStr(), (x + x+70) / 2 - 10, (y + y+70) / 2 + 15, Pnt);
            }else{
                canvas.drawText(stimulus.getStr(), (x + x+70) / 2 - 20, (y + y+70) / 2 + 15, Pnt);
            }
        }

        private void drawCorrectCircle(Stimulus stimulus){
            int x = stimulus.getX();
            int y = stimulus.getY();
            RectF basicRec = new RectF(x, y, x+70, y+70);
            canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
        }


        private void drawText(Canvas canvas){
            canvas.drawText("1부터 25까지 숫자가 있습니다.", 200, 200, textPaint);
            canvas.drawText("가능한 빠르게 순서대로 선을 그어 이어주세요.", 200, 250, textPaint);
            canvas.drawText("시작", s1.getX()+13, s1.getY()+100, textPaint);
            canvas.drawText("끝", s6.getX()+20, s6.getY()+100, textPaint);

        }


    }
}
