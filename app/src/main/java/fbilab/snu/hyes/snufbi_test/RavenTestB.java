//package fbilab.snu.hyes.snufbi_test;
//
//import android.content.Intent;
//import android.graphics.PorterDuff;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v4.app.Fragment;
//import android.support.v4.content.res.ResourcesCompat;
//import android.support.v7.app.ActionBarActivity;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//
//import java.io.File;
//import java.util.Date;
//
//
//public class RavenTestB extends ActionBarActivity {
//
//    public static String savepath;
//    static String id;
//
//    public static StringBuilder raven_sb_odd;
//    public String name;
//
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.raven_main);
//
//          Intent intent = getIntent();
//          savepath = intent.getStringExtra("savepath");
//          Log.i("test", "savepath from intent: "+savepath);
//          id = intent.getStringExtra("id");
//
//        //  Toast.makeText(getActivity().getApplicationContext(), "id: "+ id + "name: "+ name, Toast.LENGTH_SHORT).show();
//            raven_sb_odd = new StringBuilder("id");
//            raven_sb_odd.append(System.getProperty("line.separator"));
//            raven_sb_odd.append(id);
//            raven_sb_odd.append(System.getProperty("line.separator"));
//            raven_sb_odd.append("type");
//            raven_sb_odd.append(System.getProperty("line.separator"));
//            raven_sb_odd.append("A");
//            raven_sb_odd.append(System.getProperty("line.separator"));
//
//                if (savedInstanceState == null) {
//                    getSupportFragmentManager().beginTransaction()
//                            .add(R.id.container, new RavenB1())
//                            .commit();
//
//        }
//    }
//
//
//    public static class RavenB1 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b1, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B1").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB2()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB2 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b2, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response + "");
//                    raven_sb_odd.append("B2").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB3()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB3 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b3, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B3").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB4()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB4 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b4, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B4").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB5()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB5 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b5, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B5").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB6()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB6 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b6, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B6").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB7()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB7 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b7, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B7").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB8()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//
//    public static class RavenB8 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b8, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B8").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB9()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB9 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b9, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B9").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB10()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//
//    public static class RavenB10 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b10, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B10").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB11()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//
//    public static class RavenB11 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b11, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B11").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenB12()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//    public static class RavenB12 extends Fragment {
//        static int response;
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.raven_b12, container, false);
//            Date test1 = new Date();
//            Log.i("test", "onCreateView: " + test1);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            final ImageButton btn1 = (ImageButton) rootView.findViewById(R.id.imgbtn_1);
//            final ImageButton btn2 = (ImageButton) rootView.findViewById(R.id.imgbtn_2);
//            final ImageButton btn3 = (ImageButton) rootView.findViewById(R.id.imgbtn_3);
//            final ImageButton btn4 = (ImageButton) rootView.findViewById(R.id.imgbtn_4);
//            final ImageButton btn5 = (ImageButton) rootView.findViewById(R.id.imgbtn_5);
//            final ImageButton btn6 = (ImageButton) rootView.findViewById(R.id.imgbtn_6);
//            final Button next = (Button) rootView.findViewById(R.id.next_btn);
//
//            btn1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 1;
//                    btn1.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 2;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 3;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 4;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 5;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                    btn6.getBackground().clearColorFilter();
//                }
//            });
//            btn6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    response = 6;
//                    btn1.getBackground().clearColorFilter();
//                    btn2.getBackground().clearColorFilter();
//                    btn3.getBackground().clearColorFilter();
//                    btn4.getBackground().clearColorFilter();
//                    btn5.getBackground().clearColorFilter();
//                    btn6.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
//                }
//            });
//
//            next.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Log.i("test", "response: " + response+"");
//                    raven_sb_odd.append("B12").append(System.getProperty("line.separator")).append(response).append(System.getProperty("line.separator"));
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenBComplete()).commit();
//                }
//            });
//            return rootView;
//        }
//    }
//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class RavenBComplete extends Fragment {
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_complete, container, false);
//
//            MakeFile mf = new MakeFile();
//
//            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_raven_B.txt");
//            mf.writeFile(file, raven_sb_odd.toString().getBytes());
//
//
//            final Handler handler = new Handler();
//
//            final Runnable r = new Runnable() {
//                public void run() {
//
//                    Intent intent = new Intent(getActivity().getApplicationContext(), TestSelection.class);
//                    startActivity(intent);
//                }
//            };
//
//            handler.postDelayed(r, 3000);
//
//            return rootView;
//        }
//    }
//
//    public static class FlankerPractice2 extends Fragment {
//        ImageView imageView;
//        public FlankerPractice2() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_practice2, container, false);
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
//            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
//            imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);
//
//            left_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
//                    imageView.setImageDrawable(drawable);
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreFlankerTest()).commit();
//                }
//            });
//
//            right_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
//                    imageView.setImageDrawable(drawable);
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreFlankerTest()).commit();
//
//                }
//            });
//            return rootView;
//        }
//    }
//
//    private static File makeDirectory(String dir_path){
//        File dir = new File(dir_path);
//        if (!dir.exists())
//        {
//            dir.mkdirs();
//            Log.i("test", "!dir.exists");
//        }else{
//            Log.i("test" , "dir.exists" );
//        }
//
//        return dir;
//    }
//
//}
