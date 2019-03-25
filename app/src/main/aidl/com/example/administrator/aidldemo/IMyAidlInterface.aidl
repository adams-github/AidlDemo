// IMyAidlInterface.aidl
package com.example.administrator.aidldemo;

import com.example.administrator.aidldemo.ProcessBean;

// Declare any non-default types here with import statements

interface IMyAidlInterface {

    int getPid();

    ProcessBean getClientProcess(in ProcessBean clientProcess);

}
