package com.waterflower.coldplay.waterflower.basic.utils.smart_show.snackbar;

import android.support.design.widget.Snackbar;

/**
 * Created by 朱志强 on 2017/11/12.
 */

public interface SnackbarCallback {

    void onSnackbarShown(Snackbar sb);

    void onSnackbarDismissed(Snackbar sb, int event);

}
