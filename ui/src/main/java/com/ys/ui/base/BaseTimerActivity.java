package com.ys.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.ys.ui.R;
import com.ys.ui.activity.HomeActivity;
import com.ys.ui.utils.PropertyUtils;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

public abstract class BaseTimerActivity extends BaseActivity {

    @Bind(R.id.tv_timer)
    TextView tvTimer;

    Timer timer;
    TimerTask timerTask;
    protected  int minute;
    protected int second;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onStop() {
        stopTimer();

        super.onStop();
    }


    @Override
    protected void onResume() {
//        minute = 0;
//        second = 0;
        initTimer();
        super.onResume();
    }


    private void stopTimer() {
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
        stopTimer();
    }


    protected String getPrice(Long price) {

        if (price == null) {
            return "0";
        }
        return new BigDecimal(price).divide(new BigDecimal(100)).setScale(2).toString();
    }

    private void initTimer() {
        if (minute ==0 && second ==0) {
            int timeout = PropertyUtils.getInstance().getTransTimeout();
            minute = timeout / 60;
            second = timeout % 60;
        }


        tvTimer.setText(getTime());

        timerTask = new TimerTask() {

            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            String times = getTime();
            if (TextUtils.isEmpty(times)) {

                stopTimer();
                finish();
                startActivity(new Intent(App.getContext(), HomeActivity.class));
                return;
            }

            if (tvTimer != null) {
                tvTimer.setText(times);
            } else {
                stopTimer();
                finish();
                startActivity(new Intent(App.getContext(), HomeActivity.class));
            }
        }
    };

    String getTime() {
//        Log.d("BaseTimerminiute:second", minute + ":" + second);
        if (minute == 0) {
            if (second == 0) {
                return "";
            } else {
                second--;
                if (second >= 10) {
                    return "0" + minute + ":" + second;
                } else {
                    return "0" + minute + ":0" + second;
                }
            }
        } else {
            if (second == 0) {

                second = 59;
                minute--;
                if (minute >= 10) {
                    return minute + ":" + second;
                } else {
                    return "0" + minute + ":" + second;
                }
            } else {
                second--;
                if (second >= 10) {
                    if (minute >= 10) {
                        return minute + ":" + second;
                    } else {
                        return "0" + minute + ":" + second;
                    }
                } else {
                    if (minute >= 10) {
                        return minute + ":0" + second;
                    } else {
                        return "0" + minute + ":0" + second;
                    }
                }
            }
        }

    }

    protected abstract int getLayoutId();

    protected abstract void create(Bundle savedInstanceState);

    protected Context getCtx() {
        return App.getContext();
    }

    protected String getMcNo() {
        return App.mcNo;
    }

}
