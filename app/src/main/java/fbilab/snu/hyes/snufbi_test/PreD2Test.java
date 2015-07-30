package fbilab.snu.hyes.snufbi_test;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class PreD2Test extends ActionBarActivity {

    public static String savepath;
    static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d2_main);

          Intent intent = getIntent();
          savepath = intent.getStringExtra("savepath");
          Log.i("test", "savepath from intent: "+savepath);
          id = intent.getStringExtra("id");
//        String name = intent.getStringExtra("name");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FlankerPractice1())
                    .commit();

//            if (savedInstanceState == null) {
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.container, new PreFlankerTest())
//                        .commit();
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FlankerPractice1 extends Fragment {
        ImageView imageView;
        public FlankerPractice1() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.d2_fragment, container, false);
//            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
//            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
//            imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);
//
//            left_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
//                    imageView.setImageDrawable(drawable);
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerPractice2()).commit();
//                }
//            });
//
//            right_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
//                    imageView.setImageDrawable(drawable);
//
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlankerPractice2()).commit();
//
//                }
//            });
            return rootView;
        }
    }

    public static class FlankerPractice2 extends Fragment {
        ImageView imageView;
        public FlankerPractice2() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_practice2, container, false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);
            imageView = (ImageView)rootView.findViewById(R.id.flanker_iv);

            left_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.wrong, null);
                    imageView.setImageDrawable(drawable);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreFlankerTest()).commit();
                }
            });

            right_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.right, null);
                    imageView.setImageDrawable(drawable);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreFlankerTest()).commit();

                }
            });
            return rootView;
        }
    }

    public static class FlankerTestComplete extends Fragment {

        public FlankerTestComplete() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_complete, container, false);


            Button left_btn = (Button) getActivity().findViewById(R.id.left_btn);
            Button right_btn = (Button) getActivity().findViewById(R.id.right_btn);

            PreFlankerTest pre = new PreFlankerTest();
            StringBuilder sb = pre.getFlanker_sb();

            MakeFile mf = new MakeFile();

            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_flanker.txt");
            mf.writeFile(file, sb.toString().getBytes());


            left_btn.setOnClickListener(null);
            right_btn.setOnClickListener(null);

            final Handler handler = new Handler();

            final Runnable r = new Runnable() {
                public void run() {

                    Intent intent = new Intent(getActivity().getApplicationContext(), TestSelection.class);
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

}
