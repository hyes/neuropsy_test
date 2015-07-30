package fbilab.snu.hyes.snufbi_test;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Date;

/**
 * Created by hyes on 2015. 6. 22..
 */
public class RavenTest extends Fragment{

    Button right_btn, left_btn;
    public static StringBuilder raven_sb;
    public String id, name;

    public static StringBuilder getRaven_sb() {
        return raven_sb;
    }

    public RavenTest() {
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.i("test", "onStart1");
//        d1 = new Date();
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.raven_main, container, false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
      //  Toast.makeText(getActivity().getApplicationContext(), "id: "+ id + "name: "+ name, Toast.LENGTH_SHORT).show();
        raven_sb = new StringBuilder("id");
        raven_sb.append(System.getProperty("line.separator"));
        raven_sb.append(id);
        raven_sb.append(System.getProperty("line.separator"));
        raven_sb.append("tester");
        raven_sb.append(System.getProperty("line.separator"));
        raven_sb.append(name);
        raven_sb.append(System.getProperty("line.separator"));

//        left_btn = (Button) getActivity().findViewById(R.id.left_btn);
//        right_btn = (Button) getActivity().findViewById(R.id.right_btn);

        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {

              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new RavenTest1()).commit();

            }
        };

        handler.postDelayed(r, 100);


        return rootView;
    }


    public static class RavenTest1 extends Fragment {
        Date start_d;
        Date end_d;
        static int response;

        public RavenTest1() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.raven_test1, container, false);
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
                 //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                  //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
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
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
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
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
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
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
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
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
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
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
                }
            });
//
//            right_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    end_d = new Date();
//                    long diff = end_d.getTime() - start_d.getTime();
//                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
//                    imageView.setImageDrawable(drawable);
//                    raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
//                }
//            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "response: " + response+"");
                    //   raven_sb_odd.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
                }
            });
            return rootView;
        }
    }





    public static class FlankerTest2 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest2() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test20, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    raven_sb.append("test20").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainActivity.FlankerTestComplete()).commit();


                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    raven_sb.append("test20").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainActivity.FlankerTestComplete()).commit();

                }
            });
            return rootView;
        }
    }

}

