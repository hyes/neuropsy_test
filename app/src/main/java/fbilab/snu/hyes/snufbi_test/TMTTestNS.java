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
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

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
public class TMTTestNS extends Activity {

        public static StringBuilder tmt_sb;
        public static String savepath;
        static String id;
        ArrayList<Point> arPoint, cfPoint;
        private MyView vm;
        int idx = 0;
        Date start, end;
        public static long time_a, time_s, time_ns;
        private TimerTask mTask;
        private Timer mTimer;
        boolean ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Intent intent = getIntent();
            savepath = intent.getStringExtra("savepath");
            id = intent.getStringExtra("id");
            time_a = intent.getLongExtra("tmtA", 0);
            time_s = intent.getLongExtra("tmtS", 0);

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
//                        Log.i("test", start.getTime() + "");
                        //5분 제한
                        mTask = new TimerTask() {
                            @Override
                            public void run() {
                                time_ns = 300000;
                                capture();
                                saveResult();

                                final Handler handler = new Handler(Looper.getMainLooper());
                                final Runnable r = new Runnable() {
                                    public void run() {

                                        Intent intent = new Intent(TMTTestNS.this, TestSelection.class);
                                        intent.putExtra("id", id);
                                        intent.putExtra("savepath", savepath);
                                        startActivity(intent);
                                    }
                                };

                                handler.postDelayed(r, 1000);

//                                Log.i("test", "time ns : " + time_ns + "times up");

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
                            if(event.getX() >= 600 && event.getY() >=400 && event.getX() <= 700 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch1 = !ch1;
                            }
                        }else if(idx ==1){//triangle
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 2){
                            if(event.getX() >= 540 && event.getY() >=700 && event.getX() <= 640 && event.getY() <= 800){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch2 = !ch2;
                            }
                        }else if(idx == 3){//square
                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 4){
                            if(event.getX() >= 340 && event.getY() >=600 && event.getX() <= 440 && event.getY() <= 700){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch3 = !ch3;

                            }
                        }else if(idx == 5){
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 6){
                            if(event.getX() >= 150 && event.getY() >=340 && event.getX() <= 250 && event.getY() <= 440){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch4 = !ch4;
                            }
                        }else if(idx == 7){
                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 8){
                            if(event.getX() >= 1100 && event.getY() >=100 && event.getX() <= 1200 && event.getY() <= 200){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch5 =!ch5;
                            }
                        }else if(idx == 9){
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 10){
                            if(event.getX() >= 770 && event.getY() >=260 && event.getX() <= 870 && event.getY() <= 360){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch6 =!ch6;
                            }
                        }else if(idx == 11){
                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 12){
                            if(event.getX() >= 580 && event.getY() >=850 && event.getX() <= 680 && event.getY() <= 950){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch7 =!ch7;
                            }
                        }else if(idx == 13){
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 14){
                            if(event.getX() >= 1200 && event.getY() >=840 && event.getX() <= 1300 && event.getY() <= 940){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch8 = !ch8;
                            }
                        }else if(idx == 15){
                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 16){
                            if(event.getX() >= 1350 && event.getY() >=350 && event.getX() <= 1450 && event.getY() <= 450){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch9 = !ch9;
                            }
                        }else if(idx == 17){
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 18){
                            if(event.getX() >= 1400 && event.getY() >=140 && event.getX() <= 1500 && event.getY() <= 240){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch10 = !ch10;
                            }
                        }else if(idx == 19){

                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 20){
                            if(event.getX() >= 1540 && event.getY() >=490 && event.getX() <= 1640 && event.getY() <= 590){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch11 = !ch11;
                            }
                        }else if(idx == 21){
                            if(event.getX() >=350 && event.getY() >=400 && event.getX() <= 450 && event.getY() <= 500){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = !ch14;
                            }else if(event.getX() >= 40 && event.getY() >= 640 && event.getX() <= 140 && event.getY() <= 740){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = !ch15;
                            }else if(event.getX() >= 1050 && event.getY() >= 400 && event.getX() <= 1150 && event.getY() <= 500){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = !ch16;
                            }else if(event.getX() >= 950 && event.getY() >= 680 && event.getX() <= 1050 && event.getY() <= 780){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 =!ch17;
                            }else if(event.getX() >= 1450 && event.getY() >= 840 && event.getX() <= 1550 && event.getY() <= 940){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 =!ch18;
                            }else if(event.getX() >= 900 && event.getY() >= 160 && event.getX() <= 1000 && event.getY() <= 260){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 =!ch19;
                            }
                        }else if(idx == 22){
                            if(event.getX() >= 1700 && event.getY() >=680 && event.getX() <= 1800 && event.getY() <= 780){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch12 = !ch12;
                            }
                        }else if(idx == 23){
                            if(event.getX() >= 740 && event.getY() >=640 && event.getX() <= 840 && event.getY() <= 740){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 =!ch20;
                            }else if(event.getX() >= 600 && event.getY() >= 40 && event.getX() <= 700 && event.getY() <= 140){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = !ch21;
                            }else if(event.getX() >= 1500 && event.getY() >= 50 && event.getX() <= 1600 && event.getY() <= 150){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = !ch22;
                            }else if(event.getX() >= 1170 && event.getY() >= 630 && event.getX() <= 1270 && event.getY() <= 730){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = !ch23;

                            }else if(event.getX() >= 100 && event.getY() >= 910 && event.getX() <= 200 && event.getY() <= 1010){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = !ch24;
                            }else if(event.getX() >= 1600 && event.getY() >= 200 && event.getX() <= 1700 && event.getY() <= 300){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = !ch25;
                            }
                        }else if(idx == 24){
                            if(event.getX() >= 1800 && event.getY() >=530 && event.getX() <= 1900 && event.getY() <= 630){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch13 = !ch13;
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
                          //  mTimer.cancel();
                            end = new Date();
                            time_ns = end.getTime() - start.getTime();
                            Log.i("test", "time ns : " + time_ns);
                            idx++;
                            capture();
                            saveResult();

                            Toast.makeText(getApplicationContext(), "검사 메뉴로 이동합니다", Toast.LENGTH_SHORT).show();
                            final Handler handler = new Handler();
                            final Runnable r = new Runnable() {
                                public void run() {

                                    Intent intent = new Intent(TMTTestNS.this, TestSelection.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("savepath", savepath);
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
            tmt_sb.append("TMT_S");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(time_s);
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append("TMT_NS");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(time_ns);
            tmt_sb.append(System.getProperty("line.separator"));


            mf.writeFile(file, tmt_sb.toString().getBytes());


      }

    public void capture() {


            vm.setDrawingCacheEnabled(true);
            Bitmap b = vm.getDrawingCache();
            try {
                b.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream(savepath + "/" + id + "_TMT_NS.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onDestroy() {
            Log.i("test", "onDstory()");
            mTimer.cancel();
            mTimer.purge();
            super.onDestroy();
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(TMTTestNS.this, TMTPracticeNS.class);
            intent.putExtra("id", id);
            intent.putExtra("savepath", savepath);
            intent.putExtra("tmtA", time_a);
            Log.i("test", "NSa: "+time_a);
            intent.putExtra("tmtS", time_s);
            Log.i("test", "NSs: "+time_s);
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
            Paint mPaint, cPaint, Pnt, Pnt1, textPaint, Pnt2, Pnt3;
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

            }

            public void onDraw(Canvas canvas){
                this.canvas = canvas;
                canvas.drawColor(Color.WHITE);
//                canvas.drawColor(Color.TRANSPARENT);
                drawNumberCircle(canvas, 600, 400, 700, 500, "1︎");
                drawNumberCircle(canvas, 540, 700, 640, 800, "2");
                drawNumberCircle(canvas, 340, 600, 440, 700, "3");
                drawNumberCircle(canvas, 150, 340, 250, 440, "4");
                drawNumberCircle(canvas, 1100, 100, 1200, 200, "5︎");
                drawNumberCircle(canvas, 770, 260, 870, 360, "6");
                drawNumberCircle(canvas, 580, 850, 680, 950, "7");
                drawNumberCircle(canvas, 1200, 840, 1300, 940, "8");
                drawNumberCircle(canvas, 1350, 350, 1450, 450, "9");
                drawNumberCircle(canvas, 1400, 140, 1500, 240, "10");
                drawNumberCircle(canvas, 1540, 490, 1640, 590, "11︎");
                drawNumberCircle(canvas, 1700, 680, 1800, 780, "12");
                drawNumberCircle(canvas, 1800, 530, 1900, 630, "13");

                drawShapeCircle(canvas, 740, 640, 840, 740, "◼︎");
                drawShapeCircle(canvas, 600, 40, 700, 140, "◼︎");
                drawShapeCircle(canvas, 1500, 50, 1600, 150, "◼︎");
                drawShapeCircle(canvas, 1170, 630, 1270, 730, "◼︎");
                drawShapeCircle(canvas, 100, 910, 200, 1010, "◼︎");
                drawShapeCircle(canvas, 1600, 200, 1700, 300, "◼︎");

                drawShapeCircle(canvas, 350, 400, 450, 500, "▲");
                drawShapeCircle(canvas, 40, 640, 140, 740, "▲");
                drawShapeCircle(canvas, 1050, 400, 1150, 500, "▲");
                drawShapeCircle(canvas, 950, 680, 1050, 780, "▲");
                drawShapeCircle(canvas, 1450, 840, 1550, 940, "▲");
                drawShapeCircle(canvas, 900, 160, 1000, 260, "▲");

                if(ch1){
                    drawCorrectCircle(600, 400);
                }
                if(ch2){
                    drawCorrectCircle(540, 700);
                }
                if(ch3){
                    drawCorrectCircle(340, 600);
                }
                if(ch4){
                    drawCorrectCircle(150, 340);
                }
                if(ch5){
                    drawCorrectCircle(1100, 100);
                }
                if(ch6){
                    drawCorrectCircle(770, 260);
                }
                if(ch7){
                    drawCorrectCircle(580, 850);
                }
                if(ch8){
                    drawCorrectCircle(1200, 840);
                }
                if(ch9){
                    drawCorrectCircle(1350, 350);
                }
                if(ch10){
                    drawCorrectCircle(1400, 140);
                }
                if(ch11){
                    drawCorrectCircle(1540, 490);
                }
                if(ch12){
                    drawCorrectCircle(1700, 680);
                }
                if(ch13){
                    drawCorrectCircle(1800, 530);
                }
                if(ch14){
                    drawCorrectCircle(350, 400);
                }
                if(ch15){
                    drawCorrectCircle(40, 640);
                }
                if(ch16){
                    drawCorrectCircle(1050, 400);
                }
                if(ch17){
                    drawCorrectCircle(950, 680);
                }
                if(ch18){
                    drawCorrectCircle(1450, 840);
                }
                if(ch19){
                    drawCorrectCircle(900, 160);
                }
                if(ch20){
                    drawCorrectCircle(740, 640);
                }
                if(ch21){
                    drawCorrectCircle(600, 40);
                }
                if(ch22){
                    drawCorrectCircle(1500, 50);
                }
                if(ch23){
                    drawCorrectCircle(1170, 630);
                }
                if(ch24){
                    drawCorrectCircle(100, 910);
                }
                if(ch25){
                    drawCorrectCircle(1600, 200);
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

            private void drawCorrectCircle(int a, int b){

                RectF basicRec = new RectF(a, b, a+100, b+100);
                canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
            }

            private void drawText(Canvas canvas){

                canvas.drawText("시작", 620, 530, textPaint);
                canvas.drawText("끝", 1830, 660, textPaint);

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
