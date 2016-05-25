package com.example.administrator.kaolafm50.discover.radio_page.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.radio_page.bean.ChannelInRadio;

import java.util.List;

/**
 * Created by Administrator on 16-5-24.
 */
public class RadioRCAdapter extends RecyclerView.Adapter<RadioRCAdapter.MyViewHolder>{

    private List<ChannelInRadio> list;
    private Context context;
    private View view;
    private int position1;
    private OnMyRecycleViewClickListener onMyRecycleViewClickListener=null;

    public RadioRCAdapter(List<ChannelInRadio> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.adapter_radio_rv, parent, false);
        //给每个view注册点击事件
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels-60;
        view.setLayoutParams(new LinearLayout.LayoutParams(widthPixels/4,widthPixels/4*3/4));
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        position1=position;
        if (position<15) {
            holder.adapter_radio_tv_name.setText(list.get(position).getName());
        } else if (position==15) {
            holder.adapter_radio_iv_pic.setImageResource(R.drawable.category_up);
        }
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private final ImageView adapter_radio_iv_pic;
        private final TextView adapter_radio_tv_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            adapter_radio_iv_pic = (ImageView) itemView.findViewById(R.id.adapter_radio_iv_pic);
            adapter_radio_tv_name = (TextView) itemView.findViewById(R.id.adapter_radio_tv_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onMyRecycleViewClickListener==null) {
                return;
            }
            onMyRecycleViewClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public interface OnMyRecycleViewClickListener{
        void onItemClick(View v,int position);
    }
    public void setOnMyRecycleViewClickListener(OnMyRecycleViewClickListener m){
        this.onMyRecycleViewClickListener=m;
    }
}
