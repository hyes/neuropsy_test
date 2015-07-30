//package fbilab.snu.hyes.snufbi_test;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//import android.widget.Toast;
//
//import java.io.File;
//import java.util.Date;
//
///**
// * Created by hyes on 2015. 7. 10..
// */
//public class TMTComplete extends Activity {
//
//        public static StringBuilder tmt_sb;
//        public static String savepath;
//        static String id;
//        Date start, end;
//        public static long time_a, time_s, time_ns;
//
//
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.tmt_temp);
//
//            Intent intent = getIntent();
//            savepath = intent.getStringExtra("savepath");
//            id = intent.getStringExtra("id");
//            time_a = intent.getLongExtra("tmtA", 0);
//            time_s = intent.getLongExtra("tmtS", 0);
//            time_ns = intent.getLongExtra("tmtNS", 0);
//
//
//            MakeFile mf = new MakeFile();
//            File file = mf.makeFile(makeDirectory(savepath), savepath+"/"+id+"_tmt.txt");
//
//            tmt_sb = new StringBuilder("id");
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append(id);
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append("TMT_A");
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append(time_a);
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append("TMT_S");
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append(time_s);
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append("TMT_NS");
//            tmt_sb.append(System.getProperty("line.separator"));
//            tmt_sb.append(time_ns);
//            tmt_sb.append(System.getProperty("line.separator"));
//
//
//            mf.writeFile(file, tmt_sb.toString().getBytes());
//
//            Toast.makeText(getApplicationContext(), "검사 메뉴로 이동합니다", Toast.LENGTH_SHORT).show();
//            final Handler handler = new Handler();
//            final Runnable r = new Runnable() {
//                public void run() {
//
//                    Intent intent = new Intent(TMTComplete.this, TestSelection.class);
//                    startActivity(intent);
//                }
//            };
//
//            handler.postDelayed(r, 500);
//
//        }
//
//
//
//
//
//    public static File makeDirectory(String dir_path){
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
//}
//
