package fbilab.snu.hyes.snufbi_test;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class RavenTestOdd extends ActionBarActivity {

    public static String savepath;
    static String id;

    public static StringBuilder raven_sb_odd;
    public String name;

    private TimerTask mTask;
    private static Timer mTimer;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raven_main);

        //raven 15분 제한
        mTask = new TimerTask() {
            @Override
            public void run() {
                Log.i("test", "times up!!!");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new RavenComplete())
                        .commit();
//                Intent intent = new Intent(getApplicationContext()
//                        , TestSelection.class);
//                startActivity(intent);
            }
        };

        mTimer = new Timer();

        mTimer.schedule(mTask, 900000);

          Intent intent = getIntent();
          savepath = intent.getStringExtra("savepath");
          Log.i("test", "savepath from intent: "+savepath);
          id = intent.getStringExtra("id");

        //  Toast.makeText(getActivity().getApplicationContext(), "id: "+ id + "name: "+ name, Toast.LENGTH_SHORT).show();
            raven_sb_odd = new StringBuilder("id");
            raven_sb_odd.append(System.getProperty("line.separator"));
            raven_sb_odd.append(id);
            raven_sb_odd.append(System.getProperty("line.separator"));
            raven_sb_odd.append("type");
            raven_sb_odd.append(System.getProperty("line.separator"));
            raven_sb_odd.append("A");
            raven_sb_odd.append(System.getProperty("line.separator"));

                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, new RavenA1())
                            .commit();

        }
    }

    /**
     * raven A set start
     */


    public static class RavenA1 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a1, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;

                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("A1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA3()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenA3 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a3, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("A3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA5()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenA5 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a5, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("A5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA7()).commit();
                    }
                }
            });
            return rootView;
        }
    }


    public static class RavenA7 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a7, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("A7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA9()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenA9 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a9, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("A9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA11()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenA11 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a11, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("A11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB1()).commit();
                    }
                }
            });
            return rootView;
        }
    }


    /**
     * raven B set start
     */

    public static class RavenB1 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b1, container, false);
            Date test1 = new Date();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;

                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB3()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenB3 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b3, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB5()).commit();
                    }
                }
            });
            return rootView;
        }
    }


    public static class RavenB5 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b5, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB7()).commit();
                    }
                }
            });
            return rootView;
        }
    }


    public static class RavenB7 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b7, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB9()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenB9 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b9, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB11()).commit();
                    }
                }
            });
            return rootView;
        }
    }

    public static class RavenB11 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b11, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        raven_sb_odd.append("B11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC1()).commit();
                    }
                }
            });
            return rootView;
        }
    }


    /**
     * raven C set start
     */


    public static class RavenC1 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c1, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView C: " + this.getActivity().getClass().getSimpleName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC3()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC3 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c3, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC5()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC5 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c5, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC7()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC7 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c7, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC9()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenC9 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c9, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC11()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC11 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c11, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("C11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD1()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    /**
     * raven D set start
     */

    public static class RavenD1 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d1, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD3()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD3 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d3, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD5()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD5 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d5, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD7()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD7 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d7, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD9()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD9 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d9, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD11()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenD11 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d11, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("D11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE1()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    /*
    * raven E set start
    * */

    public static class RavenE1 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e1, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE3()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenE3 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e3, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE5()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenE5 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e5, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mTimer.cancel();
                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE7()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE7 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e7, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE9()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenE9 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e9, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE11()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE11 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e11, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
            final ImageButton btn7 = (ImageButton) rootView.findViewById(R.id.imgbtn_7);
            final ImageButton btn8 = (ImageButton) rootView.findViewById(R.id.imgbtn_8);
            final Button next = (Button) rootView.findViewById(R.id.next_btn);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 1;
                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 2;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 3;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 4;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 5;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 6;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 7;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    btn8.getBackground().clearColorFilter();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    response = 8;
                    btn1.getBackground().clearColorFilter();
                    btn2.getBackground().clearColorFilter();
                    btn3.getBackground().clearColorFilter();
                    btn4.getBackground().clearColorFilter();
                    btn5.getBackground().clearColorFilter();
                    btn6.getBackground().clearColorFilter();
                    btn7.getBackground().clearColorFilter();
                    btn8.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Log.i("test", "response: " + response + "");
                    if(response == 0){
                        Toast.makeText(getActivity().getApplicationContext(), "보기중에 답을 선택해주세요", Toast.LENGTH_SHORT).show();
                    }else{
                        raven_sb_odd.append("E11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenComplete()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenComplete extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_complete, container, false);

            MakeFile mf = new MakeFile();

            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_raven_odd.txt");
            mf.writeFile(file, raven_sb_odd.toString().getBytes());

            mTimer.cancel();
            mTimer.purge();
            Log.i("test", "odd mTimer+ cancle");

            final Handler handler = new Handler();

            final Runnable r = new Runnable() {
                public void run() {

                    Intent intent = new Intent(getActivity().getApplicationContext(), TestSelection.class);
                    intent.putExtra("id", id);
                    intent.putExtra("savepath", savepath);
                    startActivity(intent);
                }
            };

            handler.postDelayed(r, 3000);

            return rootView;
        }
    }


    private static File makeDirectory(String dir_path){
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

    @Override
    public void onBackPressed() {

    }
}
