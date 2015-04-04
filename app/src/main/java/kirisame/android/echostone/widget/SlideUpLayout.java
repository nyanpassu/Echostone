package kirisame.android.echostone.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by 雾雨 on 2015/3/27.
 */
public class SlideUpLayout extends ViewGroup {

    public SlideUpLayout(Context context) {
        super(context);
    }

    public SlideUpLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideUpLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlideUpLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
