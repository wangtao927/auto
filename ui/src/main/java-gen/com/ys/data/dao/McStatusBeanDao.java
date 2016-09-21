package com.ys.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.ys.data.bean.McStatusBean;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table mcstatus.
*/
public class McStatusBeanDao extends AbstractDao<McStatusBean, String> {

    public static final String TABLENAME = "mcstatus";

    /**
     * Properties of entity McStatusBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Mc_no = new Property(0, String.class, "mc_no", true, "MC_NO");
        public final static Property Mr_coin_status = new Property(1, String.class, "mr_coin_status", false, "MR_COIN_STATUS");
        public final static Property Mr_coin_short = new Property(2, String.class, "mr_coin_short", false, "MR_COIN_SHORT");
        public final static Property Mr_bill_status = new Property(3, String.class, "mr_bill_status", false, "MR_BILL_STATUS");
        public final static Property Mr_bill_short = new Property(4, String.class, "mr_bill_short", false, "MR_BILL_SHORT");
        public final static Property Mr_uppos_status = new Property(5, String.class, "mr_uppos_status", false, "MR_UPPOS_STATUS");
        public final static Property Mr_scpos_status = new Property(6, String.class, "mr_scpos_status", false, "MR_SCPOS_STATUS");
        public final static Property Mr_alipay_status = new Property(7, String.class, "mr_alipay_status", false, "MR_ALIPAY_STATUS");
        public final static Property Mr_wxpay_status = new Property(8, String.class, "mr_wxpay_status", false, "MR_WXPAY_STATUS");
        public final static Property Mr_net_status = new Property(9, String.class, "mr_net_status", false, "MR_NET_STATUS");
        public final static Property Mr_temp = new Property(10, String.class, "mr_temp", false, "MR_TEMP");
        public final static Property Mr_door_isfault = new Property(11, String.class, "mr_door_isfault", false, "MR_DOOR_ISFAULT");
        public final static Property Mr_door_status = new Property(12, String.class, "mr_door_status", false, "MR_DOOR_STATUS");
        public final static Property Mr_chann_fault_num = new Property(13, Long.class, "mr_chann_fault_num", false, "MR_CHANN_FAULT_NUM");
        public final static Property Mr_chann_fault_nos = new Property(14, String.class, "mr_chann_fault_nos", false, "MR_CHANN_FAULT_NOS");
        public final static Property Mr_nogd_chnum = new Property(15, Long.class, "mr_nogd_chnum", false, "MR_NOGD_CHNUM");
        public final static Property Mr_nogd_chann = new Property(16, String.class, "mr_nogd_chann", false, "MR_NOGD_CHANN");
        public final static Property Mr_gear_fault_num = new Property(17, Long.class, "mr_gear_fault_num", false, "MR_GEAR_FAULT_NUM");
        public final static Property Mr_gear_fault_nos = new Property(18, String.class, "mr_gear_fault_nos", false, "MR_GEAR_FAULT_NOS");
        public final static Property Mr_data_fault = new Property(19, Long.class, "mr_data_fault", false, "MR_DATA_FAULT");
        public final static Property Mr_door_date = new Property(20, java.util.Date.class, "mr_door_date", false, "MR_DOOR_DATE");
        public final static Property Mr_mc_position = new Property(21, String.class, "mr_mc_position", false, "MR_MC_POSITION");
        public final static Property Mc_isbiller = new Property(22, Long.class, "mc_isbiller", false, "MC_ISBILLER");
        public final static Property Mc_isuppos = new Property(23, Long.class, "mc_isuppos", false, "MC_ISUPPOS");
        public final static Property Mc_iswxpay = new Property(24, Long.class, "mc_iswxpay", false, "MC_ISWXPAY");
        public final static Property Mc_isalipay = new Property(25, Long.class, "mc_isalipay", false, "MC_ISALIPAY");
    };


    public McStatusBeanDao(DaoConfig config) {
        super(config);
    }
    
    public McStatusBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'mcstatus' (" + //
                "'MC_NO' TEXT PRIMARY KEY NOT NULL ," + // 0: mc_no
                "'MR_COIN_STATUS' TEXT," + // 1: mr_coin_status
                "'MR_COIN_SHORT' TEXT," + // 2: mr_coin_short
                "'MR_BILL_STATUS' TEXT," + // 3: mr_bill_status
                "'MR_BILL_SHORT' TEXT," + // 4: mr_bill_short
                "'MR_UPPOS_STATUS' TEXT," + // 5: mr_uppos_status
                "'MR_SCPOS_STATUS' TEXT," + // 6: mr_scpos_status
                "'MR_ALIPAY_STATUS' TEXT," + // 7: mr_alipay_status
                "'MR_WXPAY_STATUS' TEXT," + // 8: mr_wxpay_status
                "'MR_NET_STATUS' TEXT," + // 9: mr_net_status
                "'MR_TEMP' TEXT," + // 10: mr_temp
                "'MR_DOOR_ISFAULT' TEXT," + // 11: mr_door_isfault
                "'MR_DOOR_STATUS' TEXT," + // 12: mr_door_status
                "'MR_CHANN_FAULT_NUM' INTEGER," + // 13: mr_chann_fault_num
                "'MR_CHANN_FAULT_NOS' TEXT," + // 14: mr_chann_fault_nos
                "'MR_NOGD_CHNUM' INTEGER," + // 15: mr_nogd_chnum
                "'MR_NOGD_CHANN' TEXT," + // 16: mr_nogd_chann
                "'MR_GEAR_FAULT_NUM' INTEGER," + // 17: mr_gear_fault_num
                "'MR_GEAR_FAULT_NOS' TEXT," + // 18: mr_gear_fault_nos
                "'MR_DATA_FAULT' INTEGER," + // 19: mr_data_fault
                "'MR_DOOR_DATE' INTEGER," + // 20: mr_door_date
                "'MR_MC_POSITION' TEXT," + // 21: mr_mc_position
                "'MC_ISBILLER' INTEGER," + // 22: mc_isbiller
                "'MC_ISUPPOS' INTEGER," + // 23: mc_isuppos
                "'MC_ISWXPAY' INTEGER," + // 24: mc_iswxpay
                "'MC_ISALIPAY' INTEGER);"); // 25: mc_isalipay
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'mcstatus'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, McStatusBean entity) {
        stmt.clearBindings();
 
        String mc_no = entity.getMc_no();
        if (mc_no != null) {
            stmt.bindString(1, mc_no);
        }
 
        String mr_coin_status = entity.getMr_coin_status();
        if (mr_coin_status != null) {
            stmt.bindString(2, mr_coin_status);
        }
 
        String mr_coin_short = entity.getMr_coin_short();
        if (mr_coin_short != null) {
            stmt.bindString(3, mr_coin_short);
        }
 
        String mr_bill_status = entity.getMr_bill_status();
        if (mr_bill_status != null) {
            stmt.bindString(4, mr_bill_status);
        }
 
        String mr_bill_short = entity.getMr_bill_short();
        if (mr_bill_short != null) {
            stmt.bindString(5, mr_bill_short);
        }
 
        String mr_uppos_status = entity.getMr_uppos_status();
        if (mr_uppos_status != null) {
            stmt.bindString(6, mr_uppos_status);
        }
 
        String mr_scpos_status = entity.getMr_scpos_status();
        if (mr_scpos_status != null) {
            stmt.bindString(7, mr_scpos_status);
        }
 
        String mr_alipay_status = entity.getMr_alipay_status();
        if (mr_alipay_status != null) {
            stmt.bindString(8, mr_alipay_status);
        }
 
        String mr_wxpay_status = entity.getMr_wxpay_status();
        if (mr_wxpay_status != null) {
            stmt.bindString(9, mr_wxpay_status);
        }
 
        String mr_net_status = entity.getMr_net_status();
        if (mr_net_status != null) {
            stmt.bindString(10, mr_net_status);
        }
 
        String mr_temp = entity.getMr_temp();
        if (mr_temp != null) {
            stmt.bindString(11, mr_temp);
        }
 
        String mr_door_isfault = entity.getMr_door_isfault();
        if (mr_door_isfault != null) {
            stmt.bindString(12, mr_door_isfault);
        }
 
        String mr_door_status = entity.getMr_door_status();
        if (mr_door_status != null) {
            stmt.bindString(13, mr_door_status);
        }
 
        Long mr_chann_fault_num = entity.getMr_chann_fault_num();
        if (mr_chann_fault_num != null) {
            stmt.bindLong(14, mr_chann_fault_num);
        }
 
        String mr_chann_fault_nos = entity.getMr_chann_fault_nos();
        if (mr_chann_fault_nos != null) {
            stmt.bindString(15, mr_chann_fault_nos);
        }
 
        Long mr_nogd_chnum = entity.getMr_nogd_chnum();
        if (mr_nogd_chnum != null) {
            stmt.bindLong(16, mr_nogd_chnum);
        }
 
        String mr_nogd_chann = entity.getMr_nogd_chann();
        if (mr_nogd_chann != null) {
            stmt.bindString(17, mr_nogd_chann);
        }
 
        Long mr_gear_fault_num = entity.getMr_gear_fault_num();
        if (mr_gear_fault_num != null) {
            stmt.bindLong(18, mr_gear_fault_num);
        }
 
        String mr_gear_fault_nos = entity.getMr_gear_fault_nos();
        if (mr_gear_fault_nos != null) {
            stmt.bindString(19, mr_gear_fault_nos);
        }
 
        Long mr_data_fault = entity.getMr_data_fault();
        if (mr_data_fault != null) {
            stmt.bindLong(20, mr_data_fault);
        }
 
        java.util.Date mr_door_date = entity.getMr_door_date();
        if (mr_door_date != null) {
            stmt.bindLong(21, mr_door_date.getTime());
        }
 
        String mr_mc_position = entity.getMr_mc_position();
        if (mr_mc_position != null) {
            stmt.bindString(22, mr_mc_position);
        }
 
        Long mc_isbiller = entity.getMc_isbiller();
        if (mc_isbiller != null) {
            stmt.bindLong(23, mc_isbiller);
        }
 
        Long mc_isuppos = entity.getMc_isuppos();
        if (mc_isuppos != null) {
            stmt.bindLong(24, mc_isuppos);
        }
 
        Long mc_iswxpay = entity.getMc_iswxpay();
        if (mc_iswxpay != null) {
            stmt.bindLong(25, mc_iswxpay);
        }
 
        Long mc_isalipay = entity.getMc_isalipay();
        if (mc_isalipay != null) {
            stmt.bindLong(26, mc_isalipay);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public McStatusBean readEntity(Cursor cursor, int offset) {
        McStatusBean entity = new McStatusBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // mc_no
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // mr_coin_status
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mr_coin_short
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mr_bill_status
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mr_bill_short
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // mr_uppos_status
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mr_scpos_status
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // mr_alipay_status
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // mr_wxpay_status
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // mr_net_status
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // mr_temp
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // mr_door_isfault
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // mr_door_status
            cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13), // mr_chann_fault_num
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // mr_chann_fault_nos
            cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15), // mr_nogd_chnum
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // mr_nogd_chann
            cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17), // mr_gear_fault_num
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // mr_gear_fault_nos
            cursor.isNull(offset + 19) ? null : cursor.getLong(offset + 19), // mr_data_fault
            cursor.isNull(offset + 20) ? null : new java.util.Date(cursor.getLong(offset + 20)), // mr_door_date
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // mr_mc_position
            cursor.isNull(offset + 22) ? null : cursor.getLong(offset + 22), // mc_isbiller
            cursor.isNull(offset + 23) ? null : cursor.getLong(offset + 23), // mc_isuppos
            cursor.isNull(offset + 24) ? null : cursor.getLong(offset + 24), // mc_iswxpay
            cursor.isNull(offset + 25) ? null : cursor.getLong(offset + 25) // mc_isalipay
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, McStatusBean entity, int offset) {
        entity.setMc_no(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setMr_coin_status(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMr_coin_short(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMr_bill_status(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMr_bill_short(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMr_uppos_status(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMr_scpos_status(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMr_alipay_status(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMr_wxpay_status(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMr_net_status(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMr_temp(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setMr_door_isfault(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setMr_door_status(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setMr_chann_fault_num(cursor.isNull(offset + 13) ? null : cursor.getLong(offset + 13));
        entity.setMr_chann_fault_nos(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setMr_nogd_chnum(cursor.isNull(offset + 15) ? null : cursor.getLong(offset + 15));
        entity.setMr_nogd_chann(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setMr_gear_fault_num(cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17));
        entity.setMr_gear_fault_nos(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setMr_data_fault(cursor.isNull(offset + 19) ? null : cursor.getLong(offset + 19));
        entity.setMr_door_date(cursor.isNull(offset + 20) ? null : new java.util.Date(cursor.getLong(offset + 20)));
        entity.setMr_mc_position(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setMc_isbiller(cursor.isNull(offset + 22) ? null : cursor.getLong(offset + 22));
        entity.setMc_isuppos(cursor.isNull(offset + 23) ? null : cursor.getLong(offset + 23));
        entity.setMc_iswxpay(cursor.isNull(offset + 24) ? null : cursor.getLong(offset + 24));
        entity.setMc_isalipay(cursor.isNull(offset + 25) ? null : cursor.getLong(offset + 25));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(McStatusBean entity, long rowId) {
        return entity.getMc_no();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(McStatusBean entity) {
        if(entity != null) {
            return entity.getMc_no();
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