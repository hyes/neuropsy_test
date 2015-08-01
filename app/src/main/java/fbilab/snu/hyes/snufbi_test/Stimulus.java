package fbilab.snu.hyes.snufbi_test;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hyes on 2015. 8. 1..
 */
public class Stimulus {
    private int x, y;
    private String str;
    private ArrayList<Stimulus> stimulusList = new ArrayList<>();

    public Stimulus(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
        check(this);
    }

    private void check(Stimulus stimulus) {
        for(int i = 0 ; i < stimulusList.size(); i++){
            if(this.x == stimulusList.get(i).getX() && this.y == stimulusList.get(i).getY()){
               Log.i("test", "construction fail");
            }else{
                stimulusList.add(stimulus);
            }
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
