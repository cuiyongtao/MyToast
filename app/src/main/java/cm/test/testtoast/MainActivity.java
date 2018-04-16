package cm.test.testtoast;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView btnShow;
    private ToastUtil toastUtils;
    private PopUtil popUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (TextView) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                toastUtils = new ToastUtil(MainActivity.this);
//                toastUtils.showToastTop("我是Toast测试");
                popUtil = new PopUtil(MainActivity.this, "我是POP测试");
                new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        popUtil.showAtLocation(MainActivity.this.findViewById(R.id.pop),
 Gravity.TOP, 0, 0);
                    }
                    @Override
                    public void onFinish() {
                        popUtil.dismiss();
                    }
                }.start();
            }
        });
    }
}
