package com.example.user.ServiceSide.trackingModule;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class traking {

    private static final int POLL_INTERVAL = 1000;

    public void init() throws Exception {
        //FileAlterationObserver observer = new FileAlterationObserver("C:/Users/MinsuJo/Desktop/TestWatch"); 윈도우
        FileAlterationObserver observer = new FileAlterationObserver("/home/minsujo/Dropbox");//리눅스
        FileAlterationMonitor monitor = new FileAlterationMonitor(POLL_INTERVAL);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("FileCreated : " + file.getName());
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("FileChanged : " + file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("FileDeleted : " + file.getName());
            }
        };

        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();

    }
}
