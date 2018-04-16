package cm.test.testtoast;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author:Victory
 * @time: 2018/4/16
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain; toast工具
 */

public class ToastUtil extends Toast {

    private Context mContext;
    private Toast mToast = null;

    public ToastUtil(Context context) {
        super(context);
        this.mContext = context;
    }

    public void showToastTop(String text) {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        View toastView = LayoutInflater.from(mContext).inflate(R.layout.layout_toast, null);
        if (mToast == null) {
            mToast = new Toast(mContext);
        }
        LinearLayout relativeLayout = (LinearLayout) toastView.findViewById(R.id.test);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wm
                .getDefaultDisplay().getWidth(), dip2px(mContext, 60));
        relativeLayout.setLayoutParams(layoutParams);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.TOP, 0, 0);
        mToast.setView(toastView);
        mToast.show();

//        TextView textView = (TextView) toastView.findViewById(R.id.txtToastMessage);
//        textView.setText(text);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
