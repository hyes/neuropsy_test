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


public class RavenTestEven extends ActionBarActivity {

    public static String savepath;
    static String id;

    public static StringBuilder raven_sb_even;
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
            raven_sb_even = new StringBuilder("id");
            raven_sb_even.append(System.getProperty("line.separator"));
            raven_sb_even.append(id);
            raven_sb_even.append(System.getProperty("line.separator"));
            raven_sb_even.append("type");
            raven_sb_even.append(System.getProperty("line.separator"));
            raven_sb_even.append("A");
            raven_sb_even.append(System.getProperty("line.separator"));

                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, new RavenA2())
                            .commit();

        }
    }

    /**
     * raven A set start
     */


    public static class RavenA2 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a2, container, false);
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

                    Log.i("test", "response: " + response + "");
                    raven_sb_even.append("A2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA4()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenA4 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a4, container, false);
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
                    raven_sb_even.append("A4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA6()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenA6 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a6, container, false);
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
                    raven_sb_even.append("A6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA8()).commit();
                }
            });
            return rootView;
        }
    }

    public static class RavenA8 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a8, container, false);
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
                    raven_sb_even.append("A8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA10()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenA10 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a10, container, false);
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
                    raven_sb_even.append("A10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenA12()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenA12 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_a12, container, false);
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
                    raven_sb_even.append("A12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    raven_sb_even.append("type").append(System.getProperty("line.separator")).append("B").append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB2()).commit();
                }
            });
            return rootView;
        }
    }

    /**
     * raven B set start
     */


    public static class RavenB2 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b2, container, false);
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

                    Log.i("test", "response: " + response + "");
                    raven_sb_even.append("B2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB4()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenB4 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b4, container, false);
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
                    raven_sb_even.append("B4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB6()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenB6 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b6, container, false);
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
                    raven_sb_even.append("B6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB8()).commit();
                }
            });
            return rootView;
        }
    }

    public static class RavenB8 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b8, container, false);
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
                    raven_sb_even.append("B8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB10()).commit();
                }
            });
            return rootView;
        }
    }

    public static class RavenB10 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b10, container, false);
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
                    raven_sb_even.append("B10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB12()).commit();
                }
            });
            return rootView;
        }
    }


    public static class RavenB12 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_b12, container, false);
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
                    raven_sb_even.append("B12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                    raven_sb_even.append("type").append(System.getProperty("line.separator")).append("C").append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC2()).commit();
                }
            });
            return rootView;
        }
    }

    /**
     * raven C set start
     */


    public static class RavenC2 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c2, container, false);
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
                        raven_sb_even.append("C2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC4()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenC4 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c4, container, false);

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
                        raven_sb_even.append("C4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC6()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC6 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c6, container, false);

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
                        raven_sb_even.append("C6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC8()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenC8 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c8, container, false);

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
                        raven_sb_even.append("C8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC10()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenC10 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c10, container, false);

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
                        raven_sb_even.append("C10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenC12()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenC12 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_c12, container, false);

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
                        raven_sb_even.append("C12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        raven_sb_even.append("type").append(System.getProperty("line.separator")).append("D").append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD2()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    /**
     * raven D set start
     */

    public static class RavenD2 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d2, container, false);

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
                        raven_sb_even.append("D2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD4()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenD4 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d4, container, false);

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
                        raven_sb_even.append("D4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD6()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD6 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d6, container, false);

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
                        raven_sb_even.append("D6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD8()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD8 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d8, container, false);

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
                        raven_sb_even.append("D8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD10()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD10 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d10, container, false);

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
                        raven_sb_even.append("D10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenD12()).commit();
                    }

                }
            });
            return rootView;
        }
    }


    public static class RavenD12 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_d12, container, false);

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
                        raven_sb_even.append("D12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        raven_sb_even.append("type").append(System.getProperty("line.separator")).append("E").append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE2()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    /*
    * raven E set start
    * */


    public static class RavenE2 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e2, container, false);

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
                        raven_sb_even.append("E2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE4()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE4 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e4, container, false);

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
                        raven_sb_even.append("E4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE6()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE6 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e6, container, false);

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
                        raven_sb_even.append("E6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE8()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE8 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e8, container, false);

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
                        raven_sb_even.append("E8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE10()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE10 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e10, container, false);

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
                        raven_sb_even.append("E10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenE12()).commit();
                    }

                }
            });
            return rootView;
        }
    }

    public static class RavenE12 extends Fragment {
        static int response;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_e12, container, false);

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
                        raven_sb_even.append("E12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
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

            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_raven_even.txt");
            mf.writeFile(file, raven_sb_even.toString().getBytes());

            mTimer.cancel();
            mTimer.purge();
            Log.i("test", "even mTimer+ cancle");

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
