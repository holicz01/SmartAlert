package com.anonymus.smartalert.dashboard.fragment;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by holicz01 on 7/2/2017 AD.
 */

public class NoticeDialog {


    public static void showMsg(Context context, String title, String content, MaterialDialog.SingleButtonCallback callback) {
        MaterialDialog dialog = new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText("OK")
                .onPositive(callback)
                .canceledOnTouchOutside(false)
                .show();
    }

}
