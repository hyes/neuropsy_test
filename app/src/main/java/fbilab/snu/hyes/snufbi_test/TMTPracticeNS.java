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


public class TMTPracticeNS extends Activity {

    public static String savepath;
    static String id;
    LinearLayout linear;
    ArrayList<Point> arPoint, cfPoint;
    private MyView vm;
    int idx = 0;
    Date start, end;
    long time_a, time_s;
    boolean ch1, ch2, ch3, ch4, ch5, ch6;
    private Stimulus s1, s2, s3, s4, s5, s6;
    private static final ArrayList<Stimulus> triangleList = new ArrayList<Stimulus>();
    private static final ArrayList<Stimulus> squareList = new ArrayList<Stimulus>();

    {
        s1 = new Stimulus(300, 420, "1");
        s2 = new Stimulus(170, 500, "▲");
        s3 = new Stimulus(150, 630, "2");
        s4 = new Stimulus(540, 530, "◼︎");
        s5 = new Stimulus(610, 671, "3");
        s6 = new Stimulus(700, 420, "▲");

        triangleList.add(s2);
        squareList.add(s4);
        triangleList.add(s6);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        savepath = intent.getStringExtra("savepath");
        id = intent.getStringExtra("id");
//        time_a = intent.getLongExtra("tmtA", 0);
//        Log.i("test", "a: "+time_a);
//        time_s = intent.getLongExtra("tmtS", 0);
//        Log.i("test", "s: "+time_s);
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

                    if(idx == 0 ){
                        if(event.getX() >= s1.getX() && event.getY() >= s1.getY() && event.getX() <= s1.getX() + 70 && event.getY() <= s1.getY() + 70){
                            idx += 1;
                            ch1 = true;
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
                            ch3 = true;
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
                            ch5 = true;
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
                                startActivity(intent);
                            }
                        };

                        handler.postDelayed(r, 2000);

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
                }
                if((idx % 4) == 3) {
                    type = "sqaure";
                }

//                if ((idx % 2) == 0 && (idx % 4) != 0) {
//                    type = "triangle";
//                } else if ((idx % 4) == 0) {
//                    type = "sqaure";
//                }

//                0(tntwk) 1삼각 2숫자 3네모 4숫자 5삼각 6숫자 7네모 8숫자 9넵모넵모
              switch (type) {
                    case "triangle":

                        if (temp.equals(s2)) {
                            ch2 = true;
                        } else if (temp.equals(s6)) {
                            ch6 = true;
                        }
                        break;

                    case "sqaure":
                        if (temp.equals(s4)) {
                            ch4 = true;
                        }
                        break;


                    default:
                        break;
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TMTPracticeNS.this, TestSelection.class);
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

            drawNumberCircle(canvas, s1);
            drawShapeCircle(canvas, s2);
            drawNumberCircle(canvas, s3);
            drawShapeCircle(canvas, s4);
            drawNumberCircle(canvas, s5);
            drawShapeCircle(canvas, s6);



            if (ch1 == true) {
                drawCorrectCircle(s1);
            }
            if (ch2 == true){
                drawCorrectCircle(s2);
            }
            if (ch3 == true){
                drawCorrectCircle(s3);
            }
            if (ch4 == true){
                drawCorrectCircle(s4);
            }
            if (ch5 == true){
                drawCorrectCircle(s5);
            }
            if (ch6 == true){
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
            canvas.drawText("숫자와 세모(▲), 네모(◼)︎ 두가지 모양이 있습니다.", 200, 200, textPaint);
            canvas.drawText("숫자와 두가지 모양을 번갈아가면서 ", 200, 250, textPaint);
            canvas.drawText("(1 - 세모 - 2 - 네모 - 3 ...) ", 200, 300, textPaint);
            canvas.drawText("위와 같은 순서로 가능한 빨리 선을 그어주세요.", 200, 350, textPaint);
            canvas.drawText("시작", s1.getX() + 13, s1.getY() + 100, textPaint);
            canvas.drawText("끝", s6.getX() + 20, s6.getY() + 100, textPaint);
        }
    }
}
