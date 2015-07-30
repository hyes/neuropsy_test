package fbilab.snu.hyes.snufbi_test;

import android.content.Intent;
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
import android.widget.ImageView;

import java.util.Date;

/**
 * Created by hyes on 2015. 6. 22..
 */
public class PreFlankerTest extends Fragment{

    Button right_btn, left_btn;
    public static StringBuilder flanker_sb;
    public String id, name;

    public static StringBuilder getFlanker_sb() {
        return flanker_sb;
    }

    public PreFlankerTest() {

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
        View rootView = inflater.inflate(R.layout.fragment_flanker, container, false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
      //  Toast.makeText(getActivity().getApplicationContext(), "id: "+ id + "name: "+ name, Toast.LENGTH_SHORT).show();
        flanker_sb = new StringBuilder("id");
        flanker_sb.append(System.getProperty("line.separator"));
        flanker_sb.append(id);
        flanker_sb.append(System.getProperty("line.separator"));
        flanker_sb.append("tester");
        flanker_sb.append(System.getProperty("line.separator"));
        flanker_sb.append(name);
        flanker_sb.append(System.getProperty("line.separator"));

        left_btn = (Button) getActivity().findViewById(R.id.left_btn);
        right_btn = (Button) getActivity().findViewById(R.id.right_btn);

        left_btn.setEnabled(false);
        right_btn.setEnabled(false);


        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {

              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest1()).commit();

            }
        };

        handler.postDelayed(r, 3000);




        return rootView;
    }


    public static class FlankerTest1 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest1() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_test1, container, false);
            Date test1 = new Date();
            Log.i("test", "onCreateView: " + test1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            left_btn.setEnabled(true);
            right_btn.setEnabled(true);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);
            start_d = new Date();
            Log.i("test", "after thread maybe...: " + start_d);
            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("test", "left" + v.getX() + ", " + v.getY());


                    end_d = new Date();
                    Log.i("test", "end...: " + end_d);
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    long diff = end_d.getTime() - start_d.getTime();
                    flanker_sb.append("test1").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("test", "rightt" + v.getX() + ", " + v.getY());
                    end_d = new Date();
                    long diff = end_d.getTime() - start_d.getTime();
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    flanker_sb.append("test1").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest2()).commit();
                }
            });

            return rootView;
        }
    }




    public static class FlankerTest2 extends Fragment {
        Date d3;
        Date d4;
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
            d3= new Date();
            View rootView = inflater.inflate(R.layout.fragment_test2, container, false);

            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);


            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d4= new Date();
                    long diff = (d4.getTime() - d3.getTime());
                    flanker_sb.append("test2").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest3()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    d4= new Date();
                    long diff = (d4.getTime() - d3.getTime());
                    Log.i("test", "test2 right~ : "+diff);
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    flanker_sb.append("test2").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Log.i("test", flanker_sb.toString());
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest3()).commit();

                }
            });

            return rootView;
        }
    }

    public static class FlankerTest3 extends Fragment {

        Date start_d;
        Date end_d;

        public FlankerTest3() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test3, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test3").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest4()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test3").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest4()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest4 extends Fragment {

        Date start_d;
        Date end_d;

        public FlankerTest4() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            View rootView = inflater.inflate(R.layout.fragment_test4, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test4").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest5()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test4").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest5()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest5 extends Fragment {

        Date start_d;
        Date end_d;
        public FlankerTest5() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test5, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test5").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest6()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test5").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest6()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest6 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest6() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test6, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test6").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest7()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test6").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest7()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest7 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest7() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test7, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test7").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest8()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test7").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest8()).commit();

                }
            });
            return rootView;
        }
    }
    public static class FlankerTest8 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest8() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test8, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test8").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest9()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test8").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest9()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest9 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest9() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test9, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test9").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest10()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test9").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest10()).commit();

                }
            });
            return rootView;
        }
    }
    public static class FlankerTest10 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest10() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test10, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test10").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest11()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test10").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest11()).commit();

                }
            });
            return rootView;
        }
    }
    public static class FlankerTest11 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest11() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test11, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test11").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest12()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test11").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest12()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest12 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest12() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test12, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test12").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest13()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test12").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest13()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest13 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest13() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test13, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test13").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest14()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test13").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest14()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest14 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest14() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test14, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test14").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest15()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test14").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest15()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest15 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest15() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test15, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test15").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest16()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test15").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest16()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest16 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest16() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test16, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test16").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest17()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test16").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest17()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest17 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest17() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test17, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test17").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest18()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test17").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest18()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest18 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest18() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test18, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test18").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest19()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test18").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest19()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest19 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest19() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            View rootView = inflater.inflate(R.layout.fragment_test19, container, false);
            start_d = new Date();
            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            final ImageView imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test19").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest20()).commit();

                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    end_d = new Date();
                    long diff = (end_d.getTime() - start_d.getTime());
                    flanker_sb.append("test19").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerTest20()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTest20 extends Fragment {
        Date start_d;
        Date end_d;

        public FlankerTest20() {
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
                    flanker_sb.append("test20").append(System.getProperty("line.separator")).append(1).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

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
                    flanker_sb.append("test20").append(System.getProperty("line.separator")).append(0).append(System.getProperty("line.separator")).append(diff).append(System.getProperty("line.separator"));

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainActivity.FlankerTestComplete()).commit();

                }
            });
            return rootView;
        }
    }

}

