package com.dispatching.feima.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.dispatching.feima.R;
import com.dispatching.feima.database.OrderNotice;
import com.dispatching.feima.utils.TimeUtil;

import java.util.List;


public class NoticeAdapter extends BaseQuickAdapter<OrderNotice, BaseViewHolder> {
    private Context mContext;
    public NoticeAdapter(List<OrderNotice> notices, Context context) {
        super( R.layout.adapter_notice, notices);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderNotice item) {
        switch (item.getOrderChannel()) {
            case "bdwm":
                helper.setImageDrawable(R.id.order_channel,ContextCompat.getDrawable(mContext,R.mipmap.channl_baidu));
                break;
            case "eleme":
                helper.setImageDrawable(R.id.order_channel,ContextCompat.getDrawable(mContext,R.mipmap.channl_elme));
                break;
            case "fmwd":
                helper.setImageDrawable(R.id.order_channel,ContextCompat.getDrawable(mContext,R.mipmap.channl_laoxiangji));
                break;
            case "mtwm":
                helper.setImageDrawable(R.id.order_channel,ContextCompat.getDrawable(mContext,R.mipmap.channl_meituan));
                break;
            default:
                helper.setVisible(R.id.order_channel, false);
                break;
        }

        helper.setText(R.id.adapter_time, TimeUtil.getTimeNow(item.getOrderTime()));
        if(item.getOrderFlag() == 0 ){
            helper.setVisible(R.id.order_new_message,true);
        }else {
            helper.setVisible(R.id.order_new_message,false);
        }

    }

}
