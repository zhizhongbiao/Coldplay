package com.waterflower.coldplay.waterflower.basic.utils.smart_show.toast;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by 朱志强 on 2017/11/13.
 */

public interface CustomToastSetting {

    CustomToastSetting view(View view);
    CustomToastSetting view(@LayoutRes int layout);
    CustomToastSetting processCustomView(ProcessViewCallback callback);
}
