package cm.test.testtoast;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * @author:Victory
 * @time: 2018/4/16
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class PopUtil extends PopupWindow {

    private Context mContext;
    private View mPopWindow;
    private TextView textView;

    public PopUtil(Context context, String text) {
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mPopWindow = inflater.inflate(R.layout.layout_toast, null);
        textView = (TextView) mPopWindow.findViewById(R.id.txtToastMessage);
        setmPopWindow(text);
    }

    public void setmPopWindow(String text) {
        textView.setText(text);
        // 把View添加到PopWindow中
        this.setContentView(mPopWindow);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(dip2px(mContext, 60));
        //  设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(false);
        //   设置背景透明
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
