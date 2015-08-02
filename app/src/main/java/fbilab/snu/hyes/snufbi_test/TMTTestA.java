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
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hyes on 2015. 7. 10..
 */
public class TMTTestA extends Activity {

        public static String savepath;
        public static StringBuilder tmt_sb;
        static String id;
        ArrayList<Point> arPoint, cfPoint;
        HashMap<Integer,Stimulus> sMap;
        private MyView vm;
        int idx = 0;
        Date start, end;
        long time_a;
        private TimerTask mTask;
        private Timer mTimer;
        boolean ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25;
        private Stimulus s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25;

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

            arPoint=new ArrayList<Point>();
            cfPoint=new ArrayList<Point>();
            sMap = new HashMap<Integer, Stimulus>();



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

                                Intent intent = new Intent(TMTTestA.this, TestSelection.class);
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
                        }else if(idx == 5){
                            if(event.getX() >= s6.getX() && event.getY() >= s6.getY() && event.getX() <= s6.getX() + 70 && event.getY() <= s6.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch6 = true;
                            }
                        }else if(idx == 6){
                            if(event.getX() >= s7.getX() && event.getY() >= s7.getY() && event.getX() <= s7.getX() + 70 && event.getY() <= s7.getY()+70){
                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch7 = true;
                            }
                        }else if(idx == 7){
                            if(event.getX() >= s8.getX() && event.getY() >= s8.getY() && event.getX() <= s8.getX() + 70 && event.getY() <= s8.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch8 = true;
                            }
                        }else if(idx == 8){
                            if(event.getX() >= s9.getX() && event.getY() >= s9.getY() && event.getX() <= s9.getX() + 70 && event.getY() <= s9.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch9 = true;
                            }
                        }else if(idx == 9){
                            if(event.getX() >= s10.getX() && event.getY() >= s10.getY() && event.getX() <= s10.getX() + 70 && event.getY() <= s10.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch10 = true;
                            }
                        }else if(idx == 10){
                            if(event.getX() >= s11.getX() && event.getY() >= s11.getY() && event.getX() <= s11.getX() + 70 && event.getY() <= s11.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch11 = true;
                            }
                        }else if(idx == 11){
                            if(event.getX() >= s12.getX() && event.getY() >= s12.getY() && event.getX() <= s12.getX() + 70 && event.getY() <= s12.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch12 = true;
                            }
                        }else if(idx == 12){
                            if(event.getX() >= s13.getX() && event.getY() >= s13.getY() && event.getX() <= s13.getX() + 70 && event.getY() <= s13.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch13 = true;
                            }
                        }else if(idx == 13){
                            if(event.getX() >= s14.getX() && event.getY() >= s14.getY() && event.getX() <= s14.getX() + 70 && event.getY() <= s14.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch14 = true;
                            }
                        }else if(idx == 14){
                            if(event.getX() >= s15.getX() && event.getY() >= s15.getY() && event.getX() <= s15.getX() + 70 && event.getY() <= s15.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch15 = true;
                            }
                        }else if(idx == 15){
                            if(event.getX() >= s16.getX() && event.getY() >= s16.getY() && event.getX() <= s16.getX() + 70 && event.getY() <= s16.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch16 = true;
                            }
                        }else if(idx == 16){
                            if(event.getX() >= s17.getX() && event.getY() >= s17.getY() && event.getX() <= s17.getX() + 70 && event.getY() <= s17.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch17 = true;
                            }
                        }else if(idx == 17){
                            if(event.getX() >= s18.getX() && event.getY() >= s18.getY() && event.getX() <= s18.getX() + 70 && event.getY() <= s18.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch18 = true;
                            }
                        }else if(idx == 18){
                            if(event.getX() >= s19.getX() && event.getY() >= s19.getY() && event.getX() <= s19.getX() + 70 && event.getY() <= s19.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch19 = true;
                            }
                        }else if(idx == 19){
                            if(event.getX() >= s20.getX() && event.getY() >= s20.getY() && event.getX() <= s20.getX() + 70 && event.getY() <= s20.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch20 = true;
                            }
                        }else if(idx == 20){
                            if(event.getX() >= s21.getX() && event.getY() >= s21.getY() && event.getX() <= s21.getX() + 70 && event.getY() <= s21.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch21 = true;
                            }
                        }else if(idx == 21){
                            if(event.getX() >= s22.getX() && event.getY() >= s22.getY() && event.getX() <= s22.getX() + 70 && event.getY() <= s22.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch22 = true;
                            }
                        }else if(idx == 22){
                            if(event.getX() >= s23.getX() && event.getY() >= s23.getY() && event.getX() <= s23.getX() + 70 && event.getY() <= s23.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch23 = true;
                            }
                        }else if(idx == 23){
                            if(event.getX() >= s24.getX() && event.getY() >= s24.getY() && event.getX() <= s24.getX() + 70 && event.getY() <= s24.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch24 = true;
                            }
                        }else if(idx == 24){
                            if(event.getX() >= s25.getX() && event.getY() >= s25.getY() && event.getX() <= s25.getX() + 70 && event.getY() <= s25.getY()+70){

                                cfPoint.addAll(arPoint);
                                arPoint.clear();
                                idx += 1;
                                ch25 = true;

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

                            end = new Date();
                            time_a = end.getTime() - start.getTime();

                            capture();
                            saveResult();
                            Toast.makeText(getApplicationContext(), "검사 메뉴로 이동합니다", Toast.LENGTH_SHORT).show();
                            final Handler handler = new Handler();

                            final Runnable r = new Runnable() {
                                public void run() {

                                    Intent intent = new Intent(TMTTestA.this, TestSelection.class);
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
            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_tmt_a.txt");

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
        Intent intent = new Intent(TMTTestA.this, TMTPracticeA.class);
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

//                Random random = new Random();
//
//                for(int i=1; i < 6; i++) {
//
//                    int x = random.nextInt(1240);
//                    int y = random.nextInt(760);
//                    Log.i("test","i"+i+": "+ x+ ","+ y);
//
//                    switch(i){
//                        case 1: s1 = new Stimulus(x, y, ""+i); break;
//                        case 2: s2 = new Stimulus(x, y, ""+i); break;
//                        case 3: s3 = new Stimulus(x, y, ""+i); break;
//                        case 4: s4 = new Stimulus(x, y, ""+i); break;
//                        case 5: s5 = new Stimulus(x, y, ""+i); break;
//                        case 6: s6 = new Stimulus(x, y, ""+i); break;
//                        default : break;
//
//                    }
//                }
                s1 = new Stimulus(47, 275, "1");
                s2 = new Stimulus(239, 242, "2");
                s3 = new Stimulus(350, 320, "3");
                s4 = new Stimulus(280, 540, "4");
                s5 = new Stimulus(58, 420, "5");
                s6 = new Stimulus(130, 600, "6");
                s7 = new Stimulus(498, 625, "7");
                s8 = new Stimulus(500, 419, "8");
                s9 = new Stimulus(301, 110, "9");
                s10 = new Stimulus(472, 238, "10");
                s11 = new Stimulus(520, 70, "11");
                s12 = new Stimulus(656, 312, "12");
                s13 = new Stimulus(691, 32, "13");
                s14 = new Stimulus(830, 107, "14");
                s15 = new Stimulus(1140, 24, "15");
                s16 = new Stimulus(1000, 131, "16");
                s17 = new Stimulus(1180, 454, "17");
                s18 = new Stimulus(1037, 454, "18");
                s19 = new Stimulus(970, 645, "19");
                s20 = new Stimulus(828, 500, "20");
                s21 = new Stimulus(601, 620, "21");
                s22 = new Stimulus(850, 371, "22");
                s23 = new Stimulus(1080, 302, "23");
                s24 = new Stimulus(806, 278, "24");
                s25 = new Stimulus(620, 480, "25");

//                sMap.put(s1.getX(), s1);
//                sMap.put(s2.getX(), s2);
//                sMap.put(s3.getX(), s3);
//                sMap.put(s4.getX(), s4);
//                sMap.put(s5.getX(), s5);




                drawNumberCircle(canvas, s1);
                drawNumberCircle(canvas, s2);
                drawNumberCircle(canvas, s3);
                drawNumberCircle(canvas, s4);
                drawNumberCircle(canvas, s5);
                drawNumberCircle(canvas, s6);
                drawNumberCircle(canvas, s7);
                drawNumberCircle(canvas, s8);
                drawNumberCircle(canvas, s9);
                drawNumberCircle(canvas, s10);
                drawNumberCircle(canvas, s11);
                drawNumberCircle(canvas, s12);
                drawNumberCircle(canvas, s13);
                drawNumberCircle(canvas, s14);
                drawNumberCircle(canvas, s15);
                drawNumberCircle(canvas, s16);
                drawNumberCircle(canvas, s17);
                drawNumberCircle(canvas, s18);
                drawNumberCircle(canvas, s19);
                drawNumberCircle(canvas, s20);
                drawNumberCircle(canvas, s21);
                drawNumberCircle(canvas, s22);
                drawNumberCircle(canvas, s23);
                drawNumberCircle(canvas, s24);
                drawNumberCircle(canvas, s25);


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
                if(ch7){
                    drawCorrectCircle(s7);
                }
                if(ch8){
                    drawCorrectCircle(s8);
                }
                if(ch9){
                    drawCorrectCircle(s9);
                }
                if(ch10){
                    drawCorrectCircle(s10);
                }
                if(ch11){
                    drawCorrectCircle(s11);
                }
                if(ch12){
                    drawCorrectCircle(s12);
                }

                if(ch13){
                    drawCorrectCircle(s13);
                }
                if(ch14){
                    drawCorrectCircle(s14);
                }
                if(ch15){
                    drawCorrectCircle(s15);
                }
                if(ch16){
                    drawCorrectCircle(s16);
                }
                if(ch17){
                    drawCorrectCircle(s17);
                }
                if(ch18){
                    drawCorrectCircle(s18);
                }
                if(ch19){
                    drawCorrectCircle(s19);
                }
                if(ch20){
                    drawCorrectCircle(s20);
                }
                if(ch21){
                    drawCorrectCircle(s21);
                }
                if(ch22){
                    drawCorrectCircle(s22);
                }
                if(ch23){
                    drawCorrectCircle(s23);
                }
                if(ch24){
                    drawCorrectCircle(s24);
                }
                if(ch25){
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

                canvas.drawText("시작", s1.getX()+13, s1.getY()+100, textPaint);
                canvas.drawText("끝", s25.getX()+20, s25.getY()+100, textPaint);

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

