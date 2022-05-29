package com.example.cs4520_inclass;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HeavyWork  implements Runnable {
    static final int COUNT = 900000;

    private int complexity;
    private Handler handler;
    public final static int STATUS_START = 0x001;
    public final static int STATUS_PROGRESS = 0x002;
    public final static  int STATUS_FINAL = 0x003;




    public HeavyWork() {

        this.complexity = 1;
    }

    public HeavyWork(int i, Handler handler) {
        this.complexity = i;
        this.handler = handler;
    }

    static ArrayList<Double> getArrayNumbers(int n){
        ArrayList<Double> returnArray = new ArrayList<>();

        for (int i=0; i<n; i++){
            returnArray.add(getNumber());
        }

        return returnArray;
    }

    static double getNumber(){
        double num = 0;
        Random rand = new Random();
        for(int i=0;i<COUNT; i++){
            num = num + rand.nextDouble();
        }
        return num / ((double) COUNT);
    }

    private double getMin(ArrayList<Double> list){
        return Collections.min(list);
    }

    private double getMax(ArrayList<Double> list){
        return Collections.max(list);
    }

    private double getAvg(ArrayList<Double> list){
        double sum = 0;
        for( double num : list) {
            sum = sum+num;
        }
        return sum / list.size();
    }

    @Override
    public void run() {

        Message startMessage = new Message();
        startMessage.what = STATUS_START;
        handler.sendMessage(startMessage);

        for(int i=0; i<100; i++){
            Message progressMessage = new Message();

            getArrayNumbers(this.complexity);


            Bundle bundle = new Bundle();
            bundle.putInt("progress_key", i);
            progressMessage.what = STATUS_PROGRESS;
            progressMessage.setData(bundle);
            handler.sendMessage(progressMessage);
        }

        //

        Message endMessage = new Message();

        ArrayList<Double> list = new ArrayList<Double>();

        list.add(3.2);
        list.add(1.2);
        list.add(5.2);

        Bundle endBundle = new Bundle();
        endBundle.putDouble("max", this.getMax(list));
        endBundle.putDouble("min", this.getMin(list));
        endBundle.putDouble("avg", this.getAvg(list));
        endMessage.setData(endBundle);
        endMessage.what = STATUS_FINAL;
        handler.sendMessage(endMessage);


    }
}