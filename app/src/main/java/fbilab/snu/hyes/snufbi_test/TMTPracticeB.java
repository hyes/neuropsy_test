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


public class TMTPracticeB extends Activity {

    public static String savepath;
    static String id;
    LinearLayout linear;
    ArrayList<Point> arPoint, cfPoint;
    private MyView vm;
    int idx = 0;
    Date start, end;
    long time_a;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        savepath = intent.getStringExtra("savepath");
        id = intent.getStringExtra("id");
        time_a = intent.getLongExtra("tmtA", 0);

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
                        if(event.getX() >= 670 && event.getY() >= 400 && event.getX() <= 770 && event.getY() <= 500){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 1){
                        if(event.getX() >= 1700 && event.getY() >= 200 && event.getX() <= 1800 && event.getY() <= 300){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 2){
                        if(event.getX() >= 1340 && event.getY() >= 600 && event.getX() <= 1440 && event.getY() <= 700){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 3){
                        if(event.getX() >= 780 && event.getY() >= 540 && event.getX() <= 880 && event.getY() <= 640){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 4){
                        if(event.getX() >= 890 && event.getY() >= 240 && event.getX() <= 990 && event.getY() <= 340){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();
                            idx += 1;
                        }
                    }else if(idx == 5){
                        if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550){

                            cfPoint.addAll(arPoint);
                            arPoint.clear();


                        }
                    }

                    arPoint.add(new Point(event.getX(), event.getY(), true));

                    vm.invalidate();
                    return true;
                }

                if(event.getAction()==MotionEvent.ACTION_UP){

                    if(event.getX() >= 1280 && event.getY() >= 450 && event.getX() <= 1380 && event.getY() <= 550 && idx == 5){

                        Toast.makeText(getApplicationContext(), "검사로 이동합니다", Toast.LENGTH_SHORT).show();
                        final Handler handler = new Handler();

                        final Runnable r = new Runnable() {
                            public void run() {

                                Intent intent = new Intent(getApplicationContext(), TMTTestB.class);
                                intent.putExtra("id", id);
                                intent.putExtra("savepath", savepath);
                                intent.putExtra("tmtA", time_a);
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
        Paint mPaint, cPaint, Pnt, textPaint, Pnt1;


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

            Pnt1 = new Paint();
            Pnt1.setTextSize(50);
            Pnt1.setStyle(Paint.Style.STROKE);
            Pnt1.setStrokeWidth(3);
            Pnt1.setAntiAlias(true);
            Pnt1.setColor(Color.DKGRAY);

            textPaint = new Paint();
            textPaint.setTextSize(28);
            textPaint.setColor(Color.DKGRAY);

        }

        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.WHITE);

            drawNumberCircle(canvas, 670, 400, 770, 500, "1");
            drawNumberCircle(canvas, 1700, 200, 1800, 300, "A︎");
            drawNumberCircle(canvas, 1340, 600, 1440, 700, "2");
            drawNumberCircle(canvas, 780, 540, 880, 640, "B");
            drawNumberCircle(canvas, 890, 240, 990, 340, "3");
            drawNumberCircle(canvas, 1280, 450, 1380, 550, "c︎");

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

        private void drawText(Canvas canvas){


            canvas.drawText("숫자는 1~13까지,", 150, 540, textPaint);
            canvas.drawText("알파벳은 A~L까지 있습니다.", 150, 590, textPaint);
            canvas.drawText("숫자와 알파벳을 1-A-2-B-3 ...과 같이 교대로", 150, 640, textPaint);
            canvas.drawText("선을 그어 이어주세요", 150, 690, textPaint);
            canvas.drawText("시작", 700, 530, textPaint);
            canvas.drawText("끝", 1300, 580, textPaint);

        }


    }
}
