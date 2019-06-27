package com.waterflower.coldplay.waterflower.basic.utils.smart_show.snackbar;

import android.support.design.widget.Snackbar;
import android.widget.TextView;

/**
 * Created by 喜欢、陪你看风景 on 2017/11/15.
 */

public interface ProcessViewCallback {
    void processSnackbarView(Snackbar.SnackbarLayout layout, TextView msgView, TextView actionView);
}
