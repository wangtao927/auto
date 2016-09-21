package com.ys.data.dao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;

import com.tencent.bugly.crashreport.CrashReport;
import com.ys.data.bean.SaleListBean;
import com.ys.ui.base.App;
import com.ys.ui.base.CrashHandler;
import com.ys.ui.common.constants.SlOutStatusEnum;
import com.ys.ui.common.constants.SlPayStatusEnum;
import com.ys.ui.common.constants.SlSendStatusEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table salelist.
*/
public class SaleListBeanDao extends AbstractDao<SaleListBean, Long> {

    public static final String TABLENAME = "salelist";

    /**
     * Properties of entity SaleListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Sl_id = new Property(0, Long.class, "sl_id", true, "SL_ID");
        public final static Property Sl_no = new Property(1, String.class, "sl_no", false, "SL_NO");
        public final static Property Sl_batch_no = new Property(2, String.class, "sl_batch_no", false, "SL_BATCH_NO");
        public final static Property Sl_time = new Property(3, String.class, "sl_time", false, "SL_TIME");
        public final static Property Mc_no = new Property(4, String.class, "mc_no", false, "MC_NO");
        public final static Property Sl_gd_no = new Property(5, String.class, "sl_gd_no", false, "SL_GD_NO");
        public final static Property Sl_gd_name = new Property(6, String.class, "sl_gd_name", false, "SL_GD_NAME");
        public final static Property Sl_pre_price = new Property(7, Long.class, "sl_pre_price", false, "SL_PRE_PRICE");
        public final static Property Sl_disc_price = new Property(8, Long.class, "sl_disc_price", false, "SL_DISC_PRICE");
        public final static Property Sl_vip_price = new Property(9, Long.class, "sl_vip_price", false, "SL_VIP_PRICE");
        public final static Property Sl_amt = new Property(10, Long.class, "sl_amt", false, "SL_AMT");
        public final static Property Sl_score = new Property(11, Long.class, "sl_score", false, "SL_SCORE");
        public final static Property Sl_cash_in = new Property(12, Long.class, "sl_cash_in", false, "SL_CASH_IN");
        public final static Property Sl_cash_out = new Property(13, Long.class, "sl_cash_out", false, "SL_CASH_OUT");
        public final static Property Sl_coin_in = new Property(14, String.class, "sl_coin_in", false, "SL_COIN_IN");
        public final static Property Sl_coin_out = new Property(15, String.class, "sl_coin_out", false, "SL_COIN_OUT");
        public final static Property Sl_chann = new Property(16, String.class, "sl_chann", false, "SL_CHANN");
        public final static Property Sl_num = new Property(17, Long.class, "sl_num", false, "SL_NUM");
        public final static Property Sl_type = new Property(18, String.class, "sl_type", false, "SL_TYPE");
        public final static Property Sl_isvip = new Property(19, String.class, "sl_isvip", false, "SL_ISVIP");
        public final static Property Sl_err_msg = new Property(20, String.class, "sl_err_msg", false, "SL_ERR_MSG");
        public final static Property Sl_acc_no = new Property(21, String.class, "sl_acc_no", false, "SL_ACC_NO");
        public final static Property Sl_bf_amt = new Property(22, Long.class, "sl_bf_amt", false, "SL_BF_AMT");
        public final static Property Sl_af_amt = new Property(23, Long.class, "sl_af_amt", false, "SL_AF_AMT");
        public final static Property Sl_send_status = new Property(24, Long.class, "sl_send_status", false, "SL_SEND_STATUS");
        public final static Property Sl_pay_status = new Property(25, String.class, "sl_pay_status", false, "SL_PAY_STATUS");
        public final static Property Sl_out_status = new Property(26, String.class, "sl_out_status", false, "SL_OUT_STATUS");
    };


    public SaleListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SaleListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'salelist' (" + //
                "'SL_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: sl_id
                "'SL_NO' TEXT," + // 1: sl_no
                "'SL_BATCH_NO' TEXT," + // 2: sl_batch_no
                "'SL_TIME' TEXT," + // 3: sl_time
                "'MC_NO' TEXT," + // 4: mc_no
                "'SL_GD_NO' TEXT," + // 5: sl_gd_no
                "'SL_GD_NAME' TEXT," + // 6: sl_gd_name
                "'SL_PRE_PRICE' INTEGER," + // 7: sl_pre_price
                "'SL_DISC_PRICE' INTEGER," + // 8: sl_disc_price
                "'SL_VIP_PRICE' INTEGER," + // 9: sl_vip_price
                "'SL_AMT' INTEGER," + // 10: sl_amt
                "'SL_SCORE' INTEGER," + // 11: sl_score
                "'SL_CASH_IN' INTEGER," + // 12: sl_cash_in
                "'SL_CASH_OUT' INTEGER," + // 13: sl_cash_out
                "'SL_COIN_IN' TEXT," + // 14: sl_coin_in
                "'SL_COIN_OUT' TEXT," + // 15: sl_coin_out
                "'SL_CHANN' TEXT," + // 16: sl_chann
                "'SL_NUM' INTEGER," + // 17: sl_num
                "'SL_TYPE' TEXT," + // 18: sl_type
                "'SL_ISVIP' TEXT," + // 19: sl_isvip
                "'SL_ERR_MSG' TEXT," + // 20: sl_err_msg
                "'SL_ACC_NO' TEXT," + // 21: sl_acc_no
                "'SL_BF_AMT' INTEGER," + // 22: sl_bf_amt
                "'SL_AF_AMT' INTEGER," + // 23: sl_af_amt
                "'SL_SEND_STATUS' INTEGER," + // 24: sl_send_status
                "'SL_PAY_STATUS' TEXT," + // 25: sl_pay_status
                "'SL_OUT_STATUS' TEXT);"); // 26: sl_out_status
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'salelist'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SaleListBean entity) {
        stmt.clearBindings();
 
        Long sl_id = entity.getSl_id();
        if (sl_id != null) {
            stmt.bindLong(1, sl_id);
        }
 
        String sl_no = entity.getSl_no();
        if (sl_no != null) {
            stmt.bindString(2, sl_no);
        }
 
        String sl_batch_no = entity.getSl_batch_no();
        if (sl_batch_no != null) {
            stmt.bindString(3, sl_batch_no);
        }
 
        String sl_time = entity.getSl_time();
        if (sl_time != null) {
            stmt.bindString(4, sl_time);
        }
 
        String mc_no = entity.getMc_no();
        if (mc_no != null) {
            stmt.bindString(5, mc_no);
        }
 
        String sl_gd_no = entity.getSl_gd_no();
        if (sl_gd_no != null) {
            stmt.bindString(6, sl_gd_no);
        }
 
        String sl_gd_name = entity.getSl_gd_name();
        if (sl_gd_name != null) {
            stmt.bindString(7, sl_gd_name);
        }
 
        Long sl_pre_price = entity.getSl_pre_price();
        if (sl_pre_price != null) {
            stmt.bindLong(8, sl_pre_price);
        }
 
        Long sl_disc_price = entity.getSl_disc_price();
        if (sl_disc_price != null) {
            stmt.bindLong(9, sl_disc_price);
        }
 
        Long sl_vip_price = entity.getSl_vip_price();
        if (sl_vip_price != null) {
            stmt.bindLong(10, sl_vip_price);
        }
 
        Long sl_amt = entity.getSl_amt();
        if (sl_amt != null) {
            stmt.bindLong(11, sl_amt);
        }
 
        Long sl_score = entity.getSl_score();
        if (sl_score != null) {
            stmt.bindLong(12, sl_score);
        }
 
        Long sl_cash_in = entity.getSl_cash_in();
        if (sl_cash_in != null) {
            stmt.bindLong(13, sl_cash_in);
        }
 
        Long sl_cash_out = entity.getSl_cash_out();
        if (sl_cash_out != null) {
            stmt.bindLong(14, sl_cash_out);
        }
 
        String sl_coin_in = entity.getSl_coin_in();
        if (sl_coin_in != null) {
            stmt.bindString(15, sl_coin_in);
        }
 
        String sl_coin_out = entity.getSl_coin_out();
        if (sl_coin_out != null) {
            stmt.bindString(16, sl_coin_out);
        }
 
        String sl_chann = entity.getSl_chann();
        if (sl_chann != null) {
            stmt.bindString(17, sl_chann);
        }
 
        Long sl_num = entity.getSl_num();
        if (sl_num != null) {
            stmt.bindLong(18, sl_num);
        }
 
        String sl_type = entity.getSl_type();
        if (sl_type != null) {
            stmt.bindString(19, sl_type);
        }
 
        String sl_isvip = entity.getSl_isvip();
        if (sl_isvip != null) {
            stmt.bindString(20, sl_isvip);
        }
 
        String sl_err_msg = entity.getSl_err_msg();
        if (sl_err_msg != null) {
            stmt.bindString(21, sl_err_msg);
        }
 
        String sl_acc_no = entity.getSl_acc_no();
        if (sl_acc_no != null) {
            stmt.bindString(22, sl_acc_no);
        }
 
        Long sl_bf_amt = entity.getSl_bf_amt();
        if (sl_bf_amt != null) {
            stmt.bindLong(23, sl_bf_amt);
        }
 
        Long sl_af_amt = entity.getSl_af_amt();
        if (sl_af_amt != null) {
            stmt.bindLong(24, sl_af_amt);
        }
 
        Long sl_send_status = entity.getSl_send_status();
        if (sl_send_status != null) {
            stmt.bindLong(25, sl_send_status);
        }
 
        String sl_pay_status = entity.getSl_pay_status();
        if (sl_pay_status != null) {
            stmt.bindString(26, sl_pay_status);
        }
 
        String sl_out_status = entity.getSl_out_status();
        if (sl_out_status != null) {
            stmt.bindString(27, sl_out_status);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SaleListBean readEntity(Cursor cursor, int offset) {
        SaleListBean entity = new SaleListBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // sl_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // sl_no
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sl_batch_no
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sl_time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mc_no
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // sl_gd_no
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // sl_gd_name
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // sl_pre_price
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8), // sl_disc_price
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // sl_vip_price
            cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10), // sl_amt
            cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11), // sl_score
            cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12), // sl_cash_in
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // sl_cash_out
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // sl_coin_in
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // sl_coin_out
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // sl_chann
            cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17), // sl_num
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // sl_type
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // sl_isvip
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // sl_err_msg
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // sl_acc_no
            cursor.isNull(offset + 22) ? null : cursor.getLong(offset + 22), // sl_bf_amt
            cursor.isNull(offset + 23) ? null : cursor.getLong(offset + 23), // sl_af_amt
            cursor.isNull(offset + 24) ? null : cursor.getLong(offset + 24), // sl_send_status
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // sl_pay_status
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26) // sl_out_status
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SaleListBean entity, int offset) {
        entity.setSl_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSl_no(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSl_batch_no(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSl_time(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMc_no(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSl_gd_no(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSl_gd_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSl_pre_price(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setSl_disc_price(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        entity.setSl_vip_price(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setSl_amt(cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10));
        entity.setSl_score(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
        entity.setSl_cash_in(cursor.isNull(offset + 12) ? null : cursor.getLong(offset + 12));
        entity.setSl_cash_out(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setSl_coin_in(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setSl_coin_out(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setSl_chann(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setSl_num(cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17));
        entity.setSl_type(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setSl_isvip(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setSl_err_msg(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setSl_acc_no(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setSl_bf_amt(cursor.isNull(offset + 22) ? null : cursor.getLong(offset + 22));
        entity.setSl_af_amt(cursor.isNull(offset + 23) ? null : cursor.getLong(offset + 23));
        entity.setSl_send_status(cursor.isNull(offset + 24) ? null : cursor.getLong(offset + 24));
        entity.setSl_pay_status(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setSl_out_status(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SaleListBean entity, long rowId) {
        entity.setSl_id(rowId);
        return rowId;
    }


    public void updatePayStatus(String slNo, String slPayStatus) {
        List<SaleListBean> saleListBeanList = null;
        try {
            saleListBeanList = App.getDaoSession(App.getContext()).
                    getSaleListBeanDao().queryBuilder().where(Properties.Sl_no.eq(slNo)).list();
            if (saleListBeanList != null && !saleListBeanList.isEmpty()) {
                SaleListBean saleListBean = saleListBeanList.get(0);
                saleListBean.setSl_pay_status(slPayStatus);
                String sql = "UPDATE salelist SET  SL_PAY_STATUS = ? where SL_NO =? and sl_time=?";

                SQLiteStatement stmt = db.compileStatement(sql);
                if (db.isDbLockedByCurrentThread()) {
                    synchronized (stmt) {
                        stmt.bindString(1, slPayStatus);
                        stmt.bindString(2, slNo);
                        stmt.bindString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        stmt.execute();
                        attachEntity(saleListBean.getSl_id(), saleListBean, true);
                    }
                } else {
                    // Do TX to acquire a connection before locking the stmt to avoid deadlocks
                    db.beginTransaction();
                    try {
                        synchronized (stmt) {
                            stmt.bindString(1, slPayStatus);
                            stmt.bindString(2, slNo);
                            stmt.bindString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                            stmt.execute();
                            attachEntity(saleListBean.getSl_id(), saleListBean, true);

                        }
                        db.setTransactionSuccessful();
                    } finally {
                        db.endTransaction();
                    }
                }
            }
        } catch (SQLException e) {

            Log.e("updatePayStatus", "param: slNo="+ slNo + "slPayStatus=" +slPayStatus+  "salieList:" + saleListBeanList);
            CrashReport.postCatchedException(e);

        }


    }

    public void updatePayStatusAndOutStatus(String slNo, SlPayStatusEnum slPayStatus, SlOutStatusEnum slOutStatus ) {
        SaleListBean saleListBean = App.getDaoSession(App.getContext()).
                getSaleListBeanDao().queryBuilder().where(Properties.Sl_no.eq(slNo)).unique();
        saleListBean.setSl_pay_status(String.valueOf(slPayStatus.getIndex()));
        saleListBean.setSl_out_status(String.valueOf(slOutStatus.getIndex()));
        String sql = "UPDATE salelist SET  SL_PAY_STATUS = ?, SL_OUT_STATUS=? where SL_NO =?";

        SQLiteStatement stmt = db.compileStatement(sql);
        if (db.isDbLockedByCurrentThread()) {
            synchronized (stmt) {
                stmt.bindString(1, String.valueOf(slPayStatus.getIndex()));
                stmt.bindString(2, String.valueOf(slOutStatus.getIndex()));
                stmt.bindString(3, slNo);

                stmt.execute();
                attachEntity(saleListBean.getSl_id(), saleListBean, true);

            }
        } else {
            // Do TX to acquire a connection before locking the stmt to avoid deadlocks
            db.beginTransaction();
            try {
                synchronized (stmt) {
                    stmt.bindString(1, String.valueOf(slPayStatus.getIndex()));
                    stmt.bindString(2, String.valueOf(slOutStatus.getIndex()));
                    stmt.bindString(3, slNo);
                    stmt.execute();
                    attachEntity(saleListBean.getSl_id(), saleListBean, true);

                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }


    }

    public void updateOutStatus(String slNo, SlOutStatusEnum slOutStatus) {

        SaleListBean saleListBean = App.getDaoSession(App.getContext()).
                getSaleListBeanDao().queryBuilder().where(Properties.Sl_no.eq(slNo)).unique();
        saleListBean.setSl_out_status(String.valueOf(slOutStatus.getIndex()));
        String sql = "UPDATE salelist SET SL_OUT_STATUS=? where SL_NO =?";

        SQLiteStatement stmt = db.compileStatement(sql);
        if (db.isDbLockedByCurrentThread()) {
            synchronized (stmt) {
                stmt.bindString(1, String.valueOf(slOutStatus.getIndex()));
                stmt.bindString(2, slNo);

                stmt.execute();
                attachEntity(saleListBean.getSl_id(), saleListBean, true);

            }
        } else {
             db.beginTransaction();
            try {
                synchronized (stmt) {
                    stmt.bindString(1, String.valueOf(slOutStatus.getIndex()));
                    stmt.bindString(2, slNo);
                    stmt.execute();
                    attachEntity(saleListBean.getSl_id(), saleListBean, true);

                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }

    }

    public void updateOutStatusFail(String slNo, SlOutStatusEnum slOutStatus, SlOutStatusEnum oldStatus) {

        SaleListBean saleListBean = App.getDaoSession(App.getContext()).
                getSaleListBeanDao().queryBuilder().where(Properties.Sl_no.eq(slNo)).unique();
        if (String.valueOf(oldStatus.getIndex()).equals(saleListBean.getSl_out_status())) {
            updateOutStatus(slNo, slOutStatus);
        }


    }

    public void deleteSaleListBySendStatus() {
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.DAY_OF_MONTH, -5);// 5天之前的时间
        Date beforeD = beforeTime.getTime();

        String slTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeD);

        String sql = "delete from salelist where SL_SEND_STATUS=? and sl_time < ? ";
        SQLiteStatement stmt = db.compileStatement(sql);
        if (db.isDbLockedByCurrentThread()) {
            synchronized (stmt) {
                stmt.bindString(1, String.valueOf(SlSendStatusEnum.FINISH.getIndex()));
                stmt.bindString(2, slTime);
                stmt.execute();
            }
        } else {
            db.beginTransaction();
            try {
                synchronized (stmt) {
                    stmt.bindString(1, String.valueOf(SlSendStatusEnum.FINISH.getIndex()));
                    stmt.bindString(2, slTime);

                    stmt.execute();
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }

    }

    public void updateSendStatusBatch(List<SaleListBean> saleListBeans,  SlSendStatusEnum slSendStatus) {
          for (SaleListBean saleListBean : saleListBeans) {
              saleListBean.setSl_send_status(Long.valueOf(slSendStatus.getIndex()));
          }

        updateInTx(saleListBeans);
    }

    public void updateSendStatus(String slNo, SlSendStatusEnum slSendStatus) {
        SaleListBean saleListBean = App.getDaoSession(App.getContext()).
                getSaleListBeanDao().queryBuilder().where(Properties.Sl_no.eq(slNo)).unique();
        saleListBean.setSl_send_status(Long.valueOf(slSendStatus.getIndex()));

        String sql = "UPDATE salelist SET SL_SEND_STATUS=? where SL_NO =?";
        SQLiteStatement stmt = db.compileStatement(sql);
        if (db.isDbLockedByCurrentThread()) {
            synchronized (stmt) {
                stmt.bindString(1, String.valueOf(slSendStatus.getIndex()));
                stmt.bindString(2, slNo);

                stmt.execute();
                attachEntity(saleListBean.getSl_id(), saleListBean, true);

            }
        } else {
            db.beginTransaction();
            try {
                synchronized (stmt) {
                    stmt.bindString(1, String.valueOf(slSendStatus.getIndex()));
                    stmt.bindString(2, slNo);
                    stmt.execute();
                    attachEntity(saleListBean.getSl_id(), saleListBean, true);

                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }


    }

    /** @inheritdoc */
    @Override
    public Long getKey(SaleListBean entity) {
        if(entity != null) {
            return entity.getSl_id();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
