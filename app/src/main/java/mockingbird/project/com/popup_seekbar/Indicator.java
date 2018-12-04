package mockingbird.project.com.popup_seekbar;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Indicator extends TextView {

    private LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );

    public Indicator(Context context) {
        super(context);
    }

    public Indicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void moveIndicator(SeekBar seekBar, int left) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels < 720)
            left -= 24;
        else if (displayMetrics.widthPixels < 1080)
            left -= 30;
        else
            left -= 45;

        lp.setMargins(left, 0, 0, 0);
        setLayoutParams(lp);
    }
}
