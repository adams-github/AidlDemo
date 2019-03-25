package com.example.administrator.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private IMyAidlInterface remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            remoteService = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                ProcessBean clientProcess = new ProcessBean(Process.myPid(), MainActivity.this.getPackageName());
                ProcessBean serverProcess = remoteService.getClientProcess(clientProcess);
                Log.i(TAG, "RemoeteService pName = " + serverProcess.name);
                Log.i(TAG, "RemoteService pid= " + serverProcess.pid);
                Log.i(TAG, "Client pid= " + Process.myPid());
                Log.i(TAG, "RemoteService pid= " + remoteService.getPid());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

}
