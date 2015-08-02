package fbilab.snu.hyes.snufbi_test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hyes on 2015. 7. 10..
 */
public class obsoleteTMTTestA extends Activity {

        public static String savepath;
        public static StringBuilder tmt_sb;
        static String id;
        ArrayList<Point> arPoint, cfPoint;
        private MyView vm;
        int idx = 0;
        Date start, end;
        long time_a;
        private TimerTask mTask;
        private Timer mTimer;
        boolean ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;


    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Intent intent = getIntent();
            savepath = intent.getStringExtra("savepath");
            id = intent.getStringExtra("id");

            vm = new MyView(this);

            Window win = getWindow();

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

                        start = new Date();

                        //5분 제한
                        mTask = new TimerTask() {
                            @Override
                            public void run() {
                                time_a = 300000;
                                capture();
                                saveResult();

                                Intent intent = new Intent(obsoleteTMTTestA.this, TestSelection.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                startActivity(intent);

                                Log.i("test", "time a : " + time_a + "times up");

                            }
                        };

                        mTimer = new Timer();

                        mTimer.schedule(mTask, 300000);

                        arPoint.add(new Point(event.getX(), event.getY(), false));
                        return true;
                    }

                    if(event.getAction()==MotionEvent.ACTION_MOVE)
                    {

                        if(idx == 0 ){
                            if(event.getX() >= 350 && event.getY() >=250 && event.getX() <= 450 && event.getY() <= 350){
//                                Log.i("test", "in rect1: " + event.getX() + ", " + event.getY());
                                idx += 1;
                                ch1 = !ch1;

                            }
                        }else if(idx ==1){
                            if(event.getX() >= 100 && event.getY() >=90 && event.getX() <= 200 && event.getY() <= 190){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch2 = !ch2;
                            }
                        }else if(idx == 2){
                            if(event.getX() >= 670 && event.getY() >= 300 && event.getX() <= 770 && event.getY() <= 400){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch3 = !ch3;
                            }
                        }else if(idx == 3){
                            if(event.getX() >= 800 && event.getY() >= 40 && event.getX() <= 900 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch4 = !ch4;
                            }
                        }else if(idx == 4){
                            if(event.getX() >= 1400 && event.getY() >= 300 && event.getX() <= 1500 && event.getY() <= 400){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch5 = !ch5;
                            }
                        }else if(idx == 5){
                            if(event.getX() >= 1350 && event.getY() >= 80 && event.getX() <= 1450 && event.getY() <= 180){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch6 = !ch6;
                            }
                        }else if(idx == 6){
                            if(event.getX() >= 1750 && event.getY() >= 50 && event.getX() <= 1850 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch7 = !ch7;
                            }
                        }else if(idx == 7){
                            if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch8 = !ch8;
                            }
                        }else if(idx == 8){
                            if(event.getX() >= 1800 && event.getY() >= 500 && event.getX() <= 1900 && event.getY() <= 600){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch9 = !ch9;
                            }
                        }else if(idx == 9){
                            if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch10 = !ch10;
                            }
                        }else if(idx == 10){
                            if(event.getX() >= 1670 && event.getY() >= 730 && event.getX() <= 1770 && event.getY() <= 830){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch11 = !ch11;
                            }
                        }else if(idx == 11){
                            if(event.getX() >= 1340 && event.getY() >= 600 && event.getX() <= 1440 && event.getY() <= 700){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch12 = !ch12;
                            }
                        }else if(idx == 12){
                            if(event.getX() >= 890 && event.getY() >= 440 && event.getX() <= 990 && event.getY() <= 540){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch13 = !ch13;
                            }
                        }else if(idx == 13){
                            if(event.getX() >= 1180 && event.getY() >= 350 && event.getX() <= 1280 && event.getY() <= 450){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }
                        }else if(idx == 14){
                            if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }
                        }else if(idx == 15){
                            if(event.getX() >= 780 && event.getY() >= 540 && event.getX() <= 880 && event.getY() <= 640){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }
                        }else if(idx == 16){
                            if(event.getX() >= 200 && event.getY() >= 400 && event.getX() <= 300 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 = !ch17;
                            }
                        }else if(idx == 17){
                            if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 = !ch18;
                            }
                        }else if(idx == 18){
                            if(event.getX() >= 450 && event.getY() >= 600 && event.getX() <= 550 && event.getY() <= 700){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 = !ch19;
                            }
                        }else if(idx == 19){
                            if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 = !ch20;
                            }
                        }else if(idx == 20){
                            if(event.getX() >= 540 && event.getY() >= 740 && event.getX() <= 640 && event.getY() <= 840){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }
                        }else if(idx == 21){
                            if(event.getX() >= 1000 && event.getY() >= 720 && event.getX() <= 1100 && event.getY() <= 820){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }
                        }else if(idx == 22){
                            if(event.getX() >= 680 && event.getY() >= 880 && event.getX() <= 780 && event.getY() <= 980){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;
                            }
                        }else if(idx == 23){
                            if(event.getX() >= 1610 && event.getY() >= 900 && event.getX() <= 1710 && event.getY() <= 1000){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }
                        }else if(idx == 24){
                            if(event.getX() >= 1240 && event.getY() >= 810 && event.getX() <= 1340 && event.getY() <= 910){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;

                            }
                        }


                        arPoint.add(new Point(event.getX(), event.getY(), true));

                        vm.invalidate();
                        return true;
                    }

                    if(event.getAction()==MotionEvent.ACTION_UP){

                        if(idx == 25){

                            mTimer.cancel();
                            mTimer.purge();
                           // mTimer.cancel();
                            end = new Date();
                            time_a = end.getTime() - start.getTime();

                            idx++;
                            capture();

                            saveResult();
                            final Handler handler = new Handler();

                            final Runnable r = new Runnable() {
                                public void run() {

                                    Intent intent = new Intent(obsoleteTMTTestA.this, TMTPracticeS.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("savepath", savepath);
                                    intent.putExtra("tmtA", time_a );
                                    startActivity(intent);
                                }
                            };

                            handler.postDelayed(r, 1000);

                        }

                    }


                    return false;
                }
            });


        }

    private void saveResult() {

            MakeFile mf = new MakeFile();
            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_tmt.txt");

            tmt_sb = new StringBuilder("id");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(id);
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append("TMT_A");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(time_a);
            tmt_sb.append(System.getProperty("line.separator"));

            mf.writeFile(file, tmt_sb.toString().getBytes());


        }


    public void capture() {

            vm.setDrawingCacheEnabled(true);
            Bitmap b = vm.getDrawingCache();
            try {
                b.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream(savepath + "/" + id + "_TMT_A.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    @Override
    protected void onDestroy() {
        Log.i("test", "a onDstory()");
        mTimer.cancel();
        mTimer.purge();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(obsoleteTMTTestA.this, TMTPracticeA.class);
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
                canvas.drawColor(Color.WHITE);

                drawNumberCircle(canvas, 350, 250, 450, 350, "1");
                drawNumberCircle(canvas, 100, 90, 200, 190, "2");
                drawNumberCircle(canvas, 670, 300, 770, 400, "3");
                drawNumberCircle(canvas, 800, 40, 900, 140, "4");
                drawNumberCircle(canvas, 1400, 300, 1500, 400, "5");
                drawNumberCircle(canvas, 1350, 80, 1450, 180, "6");
                drawNumberCircle(canvas, 1750, 50, 1850, 150, "7");
                drawNumberCircle(canvas, 1600, 200, 1700, 300, "8");
                drawNumberCircle(canvas, 1800, 500, 1900, 600, "9");
                drawNumberCircle(canvas, 1280, 450, 1380, 550, "10");
                drawNumberCircle(canvas, 1670, 730, 1770, 830, "11");
                drawNumberCircle(canvas, 1340, 600, 1440, 700, "12");
                drawNumberCircle(canvas, 890, 440, 990, 540, "13");
                drawNumberCircle(canvas, 1180, 350, 1280, 450, "14");
                drawNumberCircle(canvas, 900, 160, 1000, 260, "15");
                drawNumberCircle(canvas, 780, 540, 880, 640, "16");
                drawNumberCircle(canvas, 200, 400, 300, 500, "17");
                drawNumberCircle(canvas, 40, 640, 140, 740, "18");
                drawNumberCircle(canvas, 450, 600, 550, 700, "19");
                drawNumberCircle(canvas, 100, 910, 200, 1010, "20");
                drawNumberCircle(canvas, 540, 740, 640, 840, "21");
                drawNumberCircle(canvas, 1000, 720, 1100, 820, "22");
                drawNumberCircle(canvas, 680, 880, 780, 980, "23");
                drawNumberCircle(canvas, 1610, 900, 1710, 1000, "24");
                drawNumberCircle(canvas, 1240, 810, 1340, 910, "25");


                if(ch1){
                    drawCorrectCircle(350, 250);
                }
                if(ch2){
                    drawCorrectCircle(100, 90);
                }
                if(ch3){
                    drawCorrectCircle(670, 300);
                }
                if(ch4){
                    drawCorrectCircle(800, 40);
                }
                if(ch5){
                    drawCorrectCircle(1400, 300);
                }
                if(ch6){
                    drawCorrectCircle(1350, 80);
                }
                if(ch7){
                    drawCorrectCircle(1750, 50);
                }
                if(ch8){
                    drawCorrectCircle(1600, 200);
                }
                if(ch9){
                    drawCorrectCircle(1800, 500);
                }
                if(ch10){
                    drawCorrectCircle(1280, 450);
                }
                if(ch11){
                    drawCorrectCircle(1670, 730);
                }
                if(ch12){
                    drawCorrectCircle(1340, 600);
                }

                if(ch13){
                    drawCorrectCircle(890, 440);
                }
                if(ch14){
                    drawCorrectCircle(1180, 350);
                }
                if(ch15){
                    drawCorrectCircle(900, 160);
                }
                if(ch16){
                    drawCorrectCircle(780, 540);
                }
                if(ch17){
                    drawCorrectCircle(200, 400);
                }
                if(ch18){
                    drawCorrectCircle(40, 640);
                }

                if(ch19){
                    drawCorrectCircle(450, 600);
                }
                if(ch20){
                    drawCorrectCircle(100, 910);
                }
                if(ch21){
                    drawCorrectCircle(540, 740);
                }
                if(ch22){
                    drawCorrectCircle(1000, 720);
                }
                if(ch23){
                    drawCorrectCircle(680, 880);
                }
                if(ch24){
                    drawCorrectCircle(1610, 900);
                }
                if(ch25){
                    drawCorrectCircle(1240, 810);
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

                canvas.drawText("시작", 370, 380, textPaint);
                canvas.drawText("끝", 1280, 940, textPaint);

            }


        }
        public static File makeDirectory(String dir_path){
            File dir = new File(dir_path);
            if (!dir.exists())
            {
                dir.mkdirs();
                Log.i("test", "!dir.exists");
            }else{
                Log.i("test" , "dir.exists" );
            }

            return dir;
        }
    }

