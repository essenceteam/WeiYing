package com.example.liufan.weiyingapplication.widget;

import android.content.Context;

import java.io.File;

/**
 * Created by liufan on 2018/5/21.
 */

interface IBlockCanaryContext {
    int getConfigBlockThreshold();

    boolean isNeedDisplay();

    String getQualifier();

    String getUid();

    String getNetworkType();

    Context getContext();

    String getLogPath();

    boolean zipLogFile(File[] src, File dest);

    void uploadLogFile(File zippedFile);

    String getStackFoldPrefix();

    int getConfigDumpIntervalMillis();
}
