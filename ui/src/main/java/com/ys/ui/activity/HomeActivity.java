package com.ys.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ys.data.bean.AdvBean;
import com.ys.data.dao.AdvBeanDao;
import com.ys.ui.R;
import com.ys.ui.base.App;
import com.ys.ui.base.BaseActivity;
import com.ys.ui.utils.Utils;
import com.ys.ui.view.CirclePageView;

import java.util.List;

import butterknife.Bind;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.btn_buy)
    ImageButton btnBuy;
    @Bind(R.id.btn_get_drug)
    ImageButton btnGetDrug;
    @Bind(R.id.btn_smart)
    ImageButton btnSmart;
    @Bind(R.id.btn_shop)
    ImageButton btnShop;
    @Bind(R.id.btn_about)
    ImageButton btnAbout;
    @Bind(R.id.btn_member)
    ImageButton btnMember;
    @Bind(R.id.btn_statement)
    ImageButton btnStatement;
    @Bind(R.id.btn_help)
    ImageButton btnHelp;


    @Bind(R.id.ll_pages)
    LinearLayout mPagesLayout;
    private CirclePageView mPageView;

    @Bind(R.id.ad)
    ImageView ad;

    @Bind(R.id.ib_pre_page)
    ImageButton imPrePage;

    @Bind(R.id.ib_next_page)
    ImageButton imNextPage;

    Handler mhandler = new Handler();

    public int adIndex;

    //int[] ads = {R.mipmap.ad1,R.mipmap.adv_1, R.mipmap.adv_2};
    List<AdvBean> adsList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void create(Bundle savedInstanceState) {
        btnGetDrug.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnStatement.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnShop.setOnClickListener(this);
        btnSmart.setOnClickListener(this);
        btnMember.setOnClickListener(this);

        imPrePage.setOnClickListener(this);
        imNextPage.setOnClickListener(this);

        ad.setOnClickListener(this);
        // 如果终端号不存在， 则跳转到设置终端信息界面

    }

    @Override
    protected void onResume() {
        super.onResume();
        adsList = App.getDaoSession(App.getContext()).getAdvBeanDao().queryBuilder().where(AdvBeanDao.Properties.Ai_type.eq("1")).list();

        mPagesLayout.removeAllViews();
        mPageView = new CirclePageView(this);

        mPageView.init(adsList.size());
        mPagesLayout.addView(mPageView);
        mPageView.setSelectedPage(adIndex);

        adsStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mhandler != null) {
            mhandler.removeCallbacksAndMessages(null);
        }
    }

    private void adsStart() {

       // Log.d("advstart", "advstart:index=" + adIndex);
        if (adsList == null || adsList.isEmpty()) {
            Glide.with(HomeActivity.this)
                    .load(R.mipmap.ad1)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ad);
        } else {
            Glide.with(HomeActivity.this)
                    .load(adsList.get(adIndex).getFileUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ad);

            mhandler.postDelayed(loopRunnable, 10000);
        }
    }


    @Override
    public void onClick(View view) {
        if (Utils.isFastClick()) {
            return;
        }
        switch (view.getId()) {

            default:
                break;

        }
    }

    Runnable loopRunnable = new Runnable() {
        @Override
        public void run() {
            Glide.with(HomeActivity.this)
                    .load(adsList.get(adIndex).getFileUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ad);

            adIndex++;
            if (adIndex >= adsList.size()) {
                adIndex = 0;
            }
            mPageView.setSelectedPage(adIndex);

            adsStart();
        }
    };
}
