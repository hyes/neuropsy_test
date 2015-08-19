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
        int ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;
        private Stimulus s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25;

        private static final ArrayList<Stimulus> triangleList = new ArrayList<Stimulus>();
        private static final ArrayList<Stimulus> squareList = new ArrayList<Stimulus>();

        {
            s1 = new Stimulus(100, 90, "1");
            s2 = new Stimulus(520, 510, "▲");
            s3 = new Stimulus(250, 200, "2");
            s4 = new Stimulus(890, 370, "◼︎");
            s5 = new Stimulus(170, 340, "3︎");
            s6 = new Stimulus(1000, 580, "▲");
            s7 = new Stimulus(340, 470, "4");
            s8 = new Stimulus(260, 640, "◼︎");
            s9 = new Stimulus(615, 340, "5");
            s10 = new Stimulus(940, 220, "▲");
            s11 = new Stimulus(685, 240, "6");
            s12 = new Stimulus(780, 320, "◼︎");
            s13 = new Stimulus(1000, 95, "7");
            s14 = new Stimulus(300, 70, "▲");
            s15 = new Stimulus(750, 120, "8");
            s16 = new Stimulus(330, 305, "◼︎");
            s17 = new Stimulus(700, 491, "9");
            s18 = new Stimulus(480, 200, "▲");
            s19 = new Stimulus(1080, 448, "10");
            s20 = new Stimulus(600, 40, "◼︎");
            s21 = new Stimulus(1100, 140, "11");
            s22 = new Stimulus(60, 520, "▲");
            s23 = new Stimulus(1080, 669, "12");
            s24 = new Stimulus(710, 630, "◼︎");
            s25 = new Stimulus(470, 590, "13");


            triangleList.add(s2);
            squareList.add(s4);
            triangleList.add(s6);
            squareList.add(s8);
            triangleList.add(s10);
            squareList.add(s12);
            triangleList.add(s14);
            squareList.add(s16);
            triangleList.add(s18);
            squareList.add(s20);
            triangleList.add(s22);
            squareList.add(s24);

        }


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Intent intent = getIntent();
            savepath = intent.getStringExtra("savepath");
            id = intent.getStringExtra("id");
//            time_a = intent.getLongExtra("tmtA", 0);
//            time_s = intent.getLongExtra("tmtS", 0);

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

                                Intent intent = new Intent(TMTTestNS.this, TestSelection.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                startActivity(intent);

                                Log.i("test", "time ns : " + time_ns + "times up");

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
                            if(event.getX() >= s1.getX() && event.getY() >= s1.getY() && event.getX() <= s1.getX() + 70 && event.getY() <= s1.getY() + 70){
                                idx += 1;
                                ch1 = 1;
                                changeLineType();
                            }
                        }else if(idx ==1){//triangle
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 1) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 2){
                            if(event.getX() >= s3.getX() && event.getY() >= s3.getY() && event.getX() <= s3.getX() + 70 && event.getY() <= s3.getY() + 70){
                                idx += 1;
                                ch3 = 1;
                                changeLineType();
                            }
                        }else if(idx == 3){//square
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==3) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 4){
                            if(event.getX() >= s5.getX() && event.getY() >= s5.getY() && event.getX() <= s5.getX() + 70 && event.getY() <= s5.getY() + 70){
                                idx += 1;
                                ch5 = 1;
                                changeLineType();
                            }
                        }else if(idx == 5){
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 5) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 6){
                            if(event.getX() >= s7.getX() && event.getY() >= s7.getY() && event.getX() <= s7.getX() + 70 && event.getY() <= s7.getY() + 70){
                                idx += 1;
                                ch7 = 1;
                                changeLineType();
                            }
                        }else if(idx == 7){
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==7) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 8){
                            if(event.getX() >= s9.getX() && event.getY() >= s9.getY() && event.getX() <= s9.getX() + 70 && event.getY() <= s9.getY() + 70){
                                idx += 1;
                                ch9 = 1;
                                changeLineType();
                            }
                        }else if(idx == 9){
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 9) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 10){
                            if(event.getX() >= s11.getX() && event.getY() >= s11.getY() && event.getX() <= s11.getX() + 70 && event.getY() <= s11.getY() + 70){
                                idx += 1;
                                ch11 = 1;
                                changeLineType();
                            }
                        }else if(idx == 11){
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==11) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 12){
                            if(event.getX() >= s13.getX() && event.getY() >= s13.getY() && event.getX() <= s13.getX() + 70 && event.getY() <= s13.getY() + 70){
                                idx += 1;
                                ch13 = 1;
                                changeLineType();
                            }
                        }else if(idx == 13){
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 13) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 14){
                            if(event.getX() >= s15.getX() && event.getY() >= s15.getY() && event.getX() <= s15.getX() + 70 && event.getY() <= s15.getY() + 70){
                                idx += 1;
                                ch15 = 1;
                                changeLineType();
                            }
                        }else if(idx == 15){
                            for(int i = 0; i<squareList.size(); i++) {
                                if (idx == 15) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 16){
                            if(event.getX() >= s17.getX() && event.getY() >= s17.getY() && event.getX() <= s17.getX() + 70 && event.getY() <= s17.getY() + 70){
                                idx += 1;
                                ch17 = 1;
                                changeLineType();
                            }
                        }else if(idx == 17){
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 17) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 18){
                            if(event.getX() >= s19.getX() && event.getY() >= s19.getY() && event.getX() <= s19.getX() + 70 && event.getY() <= s19.getY() + 70){
                                idx += 1;
                                ch19 = 1;
                                changeLineType();
                            }
                        }else if(idx == 19){
                            for(int i = 0; i<squareList.size(); i++) {
                                if (idx == 19) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 20){
                            if(event.getX() >= s21.getX() && event.getY() >= s21.getY() && event.getX() <= s21.getX() + 70 && event.getY() <= s21.getY() + 70){
                                idx += 1;
                                ch21 = 1;
                                changeLineType();
                            }
                        }else if(idx == 21){
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 21) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 22){
                            if(event.getX() >= s23.getX() && event.getY() >= s23.getY() && event.getX() <= s23.getX() + 70 && event.getY() <= s23.getY() + 70){
                                idx += 1;
                                ch23 = 1;
                                changeLineType();
                            }
                        }else if(idx == 23){
                            for(int i = 0; i<squareList.size(); i++) {
                                if (idx == 23) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }else if(idx == 24){
                            if(event.getX() >= s25.getX() && event.getY() >= s25.getY() && event.getX() <= s25.getX() + 70 && event.getY() <= s25.getY() + 70){
                                idx += 1;
                                ch25 = 1;
                                changeLineType();
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
                private void changeLineType() {
                    cfPoint.addAll(arPoint);
                    arPoint.clear();
                }

                private void checkPosition(int idx, Stimulus temp) {
                    String type = "";
                    if ((idx % 4) == 1){
                        type = "triangle";
                    }else if((idx % 4) == 3){
                        type = "sqaure";
                    }else if((idx % 2) == 0){
                        type = "number";
                    }
                    switch (type) {
                        case "triangle":

                            if (temp.equals(s2)) {
                                ch2 = 1;
                            } else if (temp.equals(s6)) {
                                ch6 = 1;
                            } else if (temp.equals(s10)) {
                                ch10 = 1;
                            } else if (temp.equals(s14)) {
                                ch14 = 1;
                            } else if (temp.equals(s18)) {
                                ch18 = 1;
                            } else if (temp.equals(s22)) {
                                ch22 = 1;
                            }
                            break;

                        case "sqaure":
                            if (temp.equals(s4)) {
                                ch4 = 1;
                            } else if (temp.equals(s8)) {
                                ch8 = 1;
                            } else if (temp.equals(s12)) {
                                ch12 = 1;
                            } else if (temp.equals(s16)) {
                                ch16 = 1;
                            } else if (temp.equals(s20)) {
                                ch20 = 1;
                            } else if (temp.equals(s24)) {
                                ch24 = 1;
                            }
                            break;
                        case "number":
                            if (temp.equals(s1)) {
                                ch1 = 1;
                            } else if (temp.equals(s3)) {
                                ch3 = 1;
                            } else if (temp.equals(s5)) {
                                ch5 = 1;
                            } else if (temp.equals(s7)) {
                                ch7 = 1;
                            } else if (temp.equals(s9)) {
                                ch9 = 1;
                            } else if (temp.equals(s11)) {
                                ch11 = 1;
                            }else if (temp.equals(s13)) {
                                ch13 = 1;
                            } else if (temp.equals(s15)) {
                                ch15 = 1;
                            } else if (temp.equals(s17)) {
                                ch17 = 1;
                            } else if (temp.equals(s19)) {
                                ch19 = 1;
                            } else if (temp.equals(s21)) {
                                ch21 = 1;
                            }else if (temp.equals(s23)) {
                                ch23 = 1;
                            } else if (temp.equals(s25)) {
                                ch25 = 1;
                            }
                            break;

                        default:
                            break;
                    }
                }
            });
        }

      private void saveResult() {

            MakeFile mf = new MakeFile();
            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_tmt_c.txt");

            tmt_sb = new StringBuilder("id");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(id);
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append("TMT_C");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(time_ns);
            mf.writeFile(file, tmt_sb.toString().getBytes());


      }

    public void capture() {


            vm.setDrawingCacheEnabled(true);
            Bitmap b = vm.getDrawingCache();
            try {
                b.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream(savepath + "/" + id + "_TMT_C.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.i("test", "C onStop()");
            if(mTimer !=null) {
                Log.i("test", "C timer stop()");
                mTimer.cancel();
                mTimer.purge();
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i("test", "C onDstory()");
            if(mTimer !=null) {
                mTimer.cancel();
                mTimer.purge();
            }
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(TMTTestNS.this, TMTPracticeNS.class);
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
                drawNumberCircle(canvas, s1);
                drawNumberCircle(canvas, s3);
                drawNumberCircle(canvas, s5);
                drawNumberCircle(canvas, s7);
                drawNumberCircle(canvas, s9);
                drawNumberCircle(canvas, s11);
                drawNumberCircle(canvas, s13);
                drawNumberCircle(canvas, s15);
                drawNumberCircle(canvas, s17);
                drawNumberCircle(canvas, s19);
                drawNumberCircle(canvas, s21);
                drawNumberCircle(canvas, s23);
                drawNumberCircle(canvas, s25);

                drawShapeCircle(canvas, s2);
                drawShapeCircle(canvas, s6);
                drawShapeCircle(canvas, s10);
                drawShapeCircle(canvas, s14);
                drawShapeCircle(canvas, s18);
                drawShapeCircle(canvas, s22);

                drawShapeCircle(canvas, s4);
                drawShapeCircle(canvas, s8);
                drawShapeCircle(canvas, s12);
                drawShapeCircle(canvas, s16);
                drawShapeCircle(canvas, s20);
                drawShapeCircle(canvas, s24);

                if (ch1 == 1) {
                    drawCorrectCircle(s1);
                }
                if (ch2 == 1) {
                    drawCorrectCircle(s2);
                }
                if (ch3 == 1) {
                    drawCorrectCircle(s3);
                }
                if (ch4 == 1) {
                    drawCorrectCircle(s4);
                }
                if (ch5 == 1) {
                    drawCorrectCircle(s5);
                }
                if (ch6 == 1) {
                    drawCorrectCircle(s6);
                }
                if (ch7 == 1) {
                    drawCorrectCircle(s7);
                }
                if (ch8 == 1) {
                    drawCorrectCircle(s8);
                }
                if (ch9 == 1) {
                    drawCorrectCircle(s9);
                }
                if (ch10 == 1) {
                    drawCorrectCircle(s10);
                }
                if (ch11 == 1) {
                    drawCorrectCircle(s11);
                }
                if (ch12 == 1) {
                    drawCorrectCircle(s12);
                }

                if (ch13 == 1) {
                    drawCorrectCircle(s13);
                }
                if (ch14 == 1) {
                    drawCorrectCircle(s14);
                }
                if (ch15 == 1) {
                    drawCorrectCircle(s15);
                }
                if (ch16 == 1) {
                    drawCorrectCircle(s16);
                }
                if (ch17 == 1) {
                    drawCorrectCircle(s17);
                }
                if (ch18 == 1) {
                    drawCorrectCircle(s18);
                }

                if (ch19 == 1) {
                    drawCorrectCircle(s19);
                }
                if (ch20 == 1) {
                    drawCorrectCircle(s20);
                }
                if (ch21 == 1) {
                    drawCorrectCircle(s21);
                }
                if (ch22 == 1) {
                    drawCorrectCircle(s22);
                }
                if (ch23 == 1) {
                    drawCorrectCircle(s23);
                }
                if (ch24 == 1) {
                    drawCorrectCircle(s24);
                }
                if (ch25 == 1) {
                    drawCorrectCircle(s25);
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
                    canvas.drawText(stimulus.getStr(), (x + x+70) / 2 - 10, (y + y+70) / 2 + 15, Pnt2);
                }else{
                    canvas.drawText(stimulus.getStr(), (x + x+70) / 2 - 20, (y + y+70) / 2 + 15, Pnt2);
                }
            }

            private void drawShapeCircle(Canvas canvas, Stimulus stimulus) {
                int x = stimulus.getX();
                int y = stimulus.getY();
                String str = stimulus.getStr();

                RectF basicRec = new RectF(x, y, x + 70, y + 70);
                canvas.drawRoundRect(basicRec, 50, 50, Pnt);
                if (str.equals("▲")) {
                    canvas.drawText(str, (x + x + 70) / 2 - 25, (y + y + 70) / 2 + 35, Pnt1);
                } else if (str.equals("◼︎")) {
                    canvas.drawText(str, (x + x + 70) / 2 - 28, (y + y + 70) / 2 + 17, Pnt);
                }

            }

            private void drawCorrectCircle(Stimulus stimulus) {
                int x = stimulus.getX();
                int y = stimulus.getY();
                RectF basicRec = new RectF(x, y, x + 70, y + 70);
                canvas.drawRoundRect(basicRec, 50, 50, Pnt3);
            }


            private void drawText(Canvas canvas) {
                canvas.drawText("시작", s1.getX() + 13, s1.getY() + 100, textPaint);
                canvas.drawText("끝", s25.getX() + 20, s25.getY() + 100, textPaint);
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

