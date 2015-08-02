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
public class TMTTestS extends Activity {

        public static StringBuilder tmt_sb;
        public static String savepath;
        static String id;
        ArrayList<Point> arPoint, cfPoint;
        private MyView vm;
        int idx = 0;
        Date start, end;
        static long time_a, time_s;
        private TimerTask mTask;
        private Timer mTimer;
        int ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;
        private Stimulus s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25;

        private static final ArrayList<Stimulus> triangleList = new ArrayList<Stimulus>();
        private static final ArrayList<Stimulus> squareList = new ArrayList<Stimulus>();

        {
            s1 = new Stimulus(100, 90, "▲");
            s2 = new Stimulus(890, 460, "◼︎");
            s3 = new Stimulus(1000, 480, "▲");
            s4 = new Stimulus(690, 540, "◼︎");
            s5 = new Stimulus(940, 200, "▲");
            s6 = new Stimulus(780, 320, "◼︎");
            s7 = new Stimulus(470, 410, "▲");
            s8 = new Stimulus(250, 340, "◼︎");
            s9 = new Stimulus(350, 200, "▲");
            s10 = new Stimulus(1060, 40, "◼︎");
            s11 = new Stimulus(1200, 140, "▲");
            s12 = new Stimulus(535, 50, "◼︎");
            s13 = new Stimulus(402, 340, "▲");
            s14 = new Stimulus(1080, 660, "◼︎");
            s15 = new Stimulus(810, 640, "▲");
            s16 = new Stimulus(540, 590, "◼︎");
            s17 = new Stimulus(160, 220, "▲");
            s18 = new Stimulus(120, 420, "◼︎");
            s19 = new Stimulus(890, 320, "▲");
            s20 = new Stimulus(1050, 350, "◼︎");
            s21 = new Stimulus(50, 650, "▲");
            s22 = new Stimulus(600, 300, "◼︎");
            s23 = new Stimulus(700, 190, "▲");
            s24 = new Stimulus(320, 580, "◼︎");
            s25 = new Stimulus(1150, 540, "▲");

            triangleList.add(s1);
            squareList.add(s2);
            triangleList.add(s3);
            squareList.add(s4);
            triangleList.add(s5);
            squareList.add(s6);
            triangleList.add(s7);
            squareList.add(s8);
            triangleList.add(s9);
            squareList.add(s10);
            triangleList.add(s11);
            squareList.add(s12);
            triangleList.add(s13);
            squareList.add(s14);
            triangleList.add(s15);
            squareList.add(s16);
            triangleList.add(s17);
            squareList.add(s18);
            triangleList.add(s19);
            squareList.add(s20);
            triangleList.add(s21);
            squareList.add(s22);
            triangleList.add(s23);
            squareList.add(s24);
            triangleList.add(s25);
        }


    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


            Intent intent = getIntent();
            savepath = intent.getStringExtra("savepath");
            id = intent.getStringExtra("id");
            time_a = intent.getLongExtra("tmtA", 0);

            vm = new MyView(this);

            Window win = getWindow();

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            win.addContentView(vm, params);

            arPoint = new ArrayList<Point>();
            cfPoint = new ArrayList<Point>();


            vm.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {


                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        start = new Date();

                        //5분 제한
                        mTask = new TimerTask() {
                            @Override
                            public void run() {
                                time_s = 300000;
                                capture();

                                Intent intent = new Intent(TMTTestS.this, TestSelection.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                startActivity(intent);

                                Log.i("test", "time s : " + time_s + "times up");

                            }
                        };

                        mTimer = new Timer();

                        mTimer.schedule(mTask, 300000);

                        arPoint.add(new Point(event.getX(), event.getY(), false));
                        return true;
                    }
//
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {

                        if (idx == 0) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 0) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 1) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==1) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 2) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 2) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 3) {
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
                        } else if (idx == 4) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 4) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 5) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==5) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 6) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 6) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 7) {
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
                        } else if (idx == 8) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 8) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 9) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==9) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 10) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 10) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 11) {
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
                        } else if (idx == 12) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 12) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 13) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==13) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 14) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 14) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 15) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==15) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 16) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 16) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 17) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==17) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 18) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 18) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 19) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==19) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 20) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 20) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 21) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==21) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 22) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 22) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 23) {
                            for(int i = 0; i<squareList.size(); i++){
                                if(idx==23) {
                                    Stimulus temp = squareList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        squareList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        } else if (idx == 24) {
                            for (int i = 0; i < triangleList.size(); i++) {
                                if (idx == 24) {
                                    Stimulus temp = triangleList.get(i);
                                    if (event.getX() > temp.getX() && event.getX() < temp.getX() + 70 && event.getY() > temp.getY() && event.getY() < temp.getY() + 70) {
                                        changeLineType();
                                        triangleList.remove(i);
                                        checkPosition(idx, temp);
                                        idx += 1;
                                    }
                                }
                            }
                        }

                        arPoint.add(new Point(event.getX(), event.getY(), true));

                        vm.invalidate();
                        return true;
                    }

                    if (event.getAction() == MotionEvent.ACTION_UP) {

                        if (idx == 25) {

                            mTimer.cancel();
                            mTimer.purge();
                            end = new Date();
                            time_s = end.getTime() - start.getTime();
                            Log.i("test", "diff s: " + time_s);
                            idx++;
                            capture();
                            saveResult();

                            Toast.makeText(getApplicationContext(), "검사 메뉴로 이동합니다", Toast.LENGTH_SHORT).show();

                            final Handler handler = new Handler();
                            final Runnable r = new Runnable() {
                                public void run() {

                                    Intent intent = new Intent(TMTTestS.this, TestSelection.class);
                                    intent.putExtra("id", id);
                                    intent.putExtra("savepath", savepath);
                                    intent.putExtra("tmtA", time_a);
                                    intent.putExtra("tmtS", time_s);
                                    startActivity(intent);
                                }
                            };

                            handler.postDelayed(r, 1000);
//                            final Handler handler = new Handler();
//
//                            final Runnable r = new Runnable() {
//                                public void run() {
//
//                                    Intent intent = new Intent(TMTTestS.this, TMTPracticeNS.class);
//                                    intent.putExtra("id", id);
//                                    intent.putExtra("savepath", savepath);
//                                    intent.putExtra("tmtA", time_a);
//                                    intent.putExtra("tmtS", time_s);
//                                    startActivity(intent);
////                                    getSupportFragmentManager().beginTransaction()
////                                            .replace(R.id.container, new TMTComplete())
////                                            .commit();
//                                }
//                            };
//
//                            handler.postDelayed(r, 1000);

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
                    if((idx % 2) == 0){
                        type = "triangle";
                    }else if((idx % 2) == 1){
                        type = "sqaure";
                    }
                    switch(type){
                        case "triangle" :

                            if(temp.equals(s1)){
                                ch1 = 1;
                            }else if(temp.equals(s3)){
                                ch3 = 1;
                            }else if(temp.equals(s5)){
                                ch5 = 1;
                            }else if(temp.equals(s7)){
                                ch7 = 1;
                            }else if(temp.equals(s9)){
                                ch9 = 1;
                            }else if(temp.equals(s11)){
                                ch11 = 1;
                            }else if(temp.equals(s13)){
                                ch13 = 1;
                            }else if(temp.equals(s15)){
                                ch15 = 1;
                            }else if(temp.equals(s17)){
                                ch17 = 1;
                            }else if(temp.equals(s19)){
                                ch19 = 1;
                            }else if(temp.equals(s21)){
                                ch21 = 1;
                            }else if(temp.equals(s23)){
                                ch23 = 1;
                            }else if(temp.equals(s25)){
                                ch25 = 1;
                            }
                            break;

                        case "sqaure":
                            if(temp.equals(s2)){
                                ch2 = 1;
                            }else if(temp.equals(s4)){
                                ch4 = 1;
                            }else if(temp.equals(s6)){
                                ch6 = 1;
                            }else if(temp.equals(s8)){
                                ch8 = 1;
                            }else if(temp.equals(s10)){
                                ch10 = 1;
                            }else if(temp.equals(s12)){
                                ch12 = 1;
                            }else if(temp.equals(s14)){
                                ch14 = 1;
                            }else if(temp.equals(s16)){
                                ch16 = 1;
                            }else if(temp.equals(s18)){
                                ch18 = 1;
                            }else if(temp.equals(s20)){
                                ch20 = 1;
                            }else if(temp.equals(s22)){
                                ch22 = 1;
                            }else if(temp.equals(s24)){
                                ch24 = 1;
                            }
                            break;

                        default: break;
                    }
                }
            });
        }

    private void saveResult() {

            MakeFile mf = new MakeFile();
            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_tmt_b.txt");

            tmt_sb = new StringBuilder("id");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(id);
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append("TMT_B");
            tmt_sb.append(System.getProperty("line.separator"));
            tmt_sb.append(time_s);
            tmt_sb.append(System.getProperty("line.separator"));


            mf.writeFile(file, tmt_sb.toString().getBytes());




    }

    public void capture() {

        mTimer.cancel();
        vm.setDrawingCacheEnabled(true);
            Bitmap b = vm.getDrawingCache();
            try {
                b.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream(savepath + "/" + id + "_TMT_B.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.i("test", "B onStop()");
            if(mTimer !=null) {
                Log.i("test", "B timer stop()");
                mTimer.cancel();
                mTimer.purge();
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i("test", "B onDstory()");
            if(mTimer !=null) {
                mTimer.cancel();
                mTimer.purge();
            }
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(TMTTestS.this, TMTPracticeS.class);
            intent.putExtra("id", id);
            intent.putExtra("savepath", savepath);
            intent.putExtra("tmtA", time_a);
            startActivity(intent);

            Log.i("test", " tmtA : " + time_a);
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

        protected class MyView extends View {
            Paint mPaint, cPaint, Pnt, Pnt1, textPaint, Pnt3;
            Canvas canvas;

            public MyView(Context context) {
                super(context);


                mPaint = new Paint();
                mPaint.setColor(Color.LTGRAY);
                mPaint.setStrokeWidth(3);
                mPaint.setAntiAlias(true);

                cPaint = new Paint();
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

            public void onDraw(Canvas canvas) {
                this.canvas = canvas;
                canvas.drawColor(Color.WHITE);
//                canvas.drawColor(Color.TRANSPARENT);
                drawShapeCircle(canvas, s1);
                drawShapeCircle(canvas, s2);
                drawShapeCircle(canvas, s3);
                drawShapeCircle(canvas, s4);
                drawShapeCircle(canvas, s5);

                drawShapeCircle(canvas, s6);
                drawShapeCircle(canvas, s7);
                drawShapeCircle(canvas, s8);
                drawShapeCircle(canvas, s9);
                drawShapeCircle(canvas, s10);

                drawShapeCircle(canvas, s11);
                drawShapeCircle(canvas, s12);
                drawShapeCircle(canvas, s13);
                drawShapeCircle(canvas, s14);
                drawShapeCircle(canvas, s15);

                drawShapeCircle(canvas, s16);
                drawShapeCircle(canvas, s17);
                drawShapeCircle(canvas, s18);
                drawShapeCircle(canvas, s19);
                drawShapeCircle(canvas, s20);

                drawShapeCircle(canvas, s21);
                drawShapeCircle(canvas, s22);
                drawShapeCircle(canvas, s23);
                drawShapeCircle(canvas, s24);
                drawShapeCircle(canvas, s25);
                drawText(canvas);

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


                for (int i = 0; i < cfPoint.size(); i++) {
                    if (cfPoint.get(i).Draw) {
                        canvas.drawLine(cfPoint.get(i - 1).x, cfPoint.get(i - 1).y,
                                cfPoint.get(i).x, cfPoint.get(i).y, cPaint);
                    }
                }
                for (int i = 1; i < arPoint.size(); i++) {
                    if (arPoint.get(i).Draw) {
                        canvas.drawLine(arPoint.get(i - 1).x, arPoint.get(i - 1).y,
                                arPoint.get(i).x, arPoint.get(i).y, mPaint);
                    }
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

