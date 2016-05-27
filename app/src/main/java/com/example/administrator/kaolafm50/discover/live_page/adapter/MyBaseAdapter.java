package com.example.administrator.kaolafm50.discover.live_page.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.live_page.bean.HostInDataInlive;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by Administrator on 16-5-27.
 */
public class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private List<HostInDataInlive> listDate;

    public MyBaseAdapter(Context context, List<HostInDataInlive> listDate) {
        this.context = context;
        this.listDate=listDate;
    }

    @Override
    public int getCount() {
        return listDate==null?0:listDate.size();
    }

    @Override
    public Object getItem(int position) {
        return listDate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dis_live_select_today_item, parent, false);
            holder = new ViewHolder();
            holder.tv_time = (TextView) convertView.findViewById(R.id.select_today_tv_time);
            holder.tv_title = (TextView) convertView.findViewById(R.id.select_today_tv_title);
            holder.iv_anchor = (ImageView) convertView.findViewById(R.id.select_today_iv_anchor);
            holder.tv_anchor = (TextView) convertView.findViewById(R.id.select_today_tv_anchor);
//            holder.iv_gender = (TextView) convertView.findViewById(R.id.select_today_iv_gender);
//            holder.iv_weibo = (ImageView) convertView.findViewById(R.id.select_today_iv_weibo);
//            holder.iv_head_icon = (ImageView) convertView.findViewById(R.id.select_today_tv_head_icon);
            convertView.setTag(holder);
        } else {
            holder= (ViewHolder) convertView.getTag();
        }
        long startTime = listDate.get(position).getStartTime();

        //将long型的时间格式化
        Date date = new Date(startTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        String format = simpleDateFormat.format(date);

        holder.tv_time.setText(format);
        holder.tv_title.setText(listDate.get(position).getLiveName());
        ImageLoader.getInstance().displayImage(listDate.get(position).getLivePic(),holder.iv_anchor,
                ImageUtil.getCircleImageOption());
        holder.tv_anchor.setText(listDate.get(position).getComperes());
//        holder.iv_gender
//        holder.iv_weibo
//        holder.iv_head_icon
        return convertView;
    }

    public class ViewHolder {
    public TextView tv_time;
    public TextView tv_title;
    public ImageView iv_anchor;
    public TextView tv_anchor;
//    public TextView tv_gender;
//    public ImageView iv_weibo;
//    public ImageView iv_head_icon;

    }

}
