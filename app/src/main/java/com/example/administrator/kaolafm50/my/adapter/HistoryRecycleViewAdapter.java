package com.example.administrator.kaolafm50.my.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;

import java.util.List;

/**
 * Created by Administrator on 16-5-25.
 */
public class HistoryRecycleViewAdapter extends RecyclerView.Adapter<HistoryRecycleViewAdapter.MyRecycleViewAdapter>{

    private List<String> list;
    private Context context;
    private OnMyItemTouchListener onMyItemTouchListener;

    public HistoryRecycleViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyRecycleViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_recycle_adapter_item, parent, false);
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        view.setLayoutParams(new LinearLayout.LayoutParams(widthPixels,widthPixels/4));
        return new MyRecycleViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(MyRecycleViewAdapter holder, int position) {
        holder.history_iv_icon.setImageResource(R.drawable.ic_launcher);
        holder.history_tv_title.setText("历史记录("+list.get(position)+")");
        holder.history_tv_msg.append("");
        holder.history_tv_listenState.setText((int)(Math.random()*31)+"分钟前");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyRecycleViewAdapter extends RecyclerView.ViewHolder {

        private TextView history_tv_title;
        private TextView history_tv_msg;
        private TextView history_tv_listenState;
        private ImageView history_iv_icon;

        public MyRecycleViewAdapter(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (onMyItemTouchListener==null) {
                        return;
                    }
                    onMyItemTouchListener.getItemId(getAdapterPosition());

                }
            });
            history_iv_icon= (ImageView) itemView.findViewById(R.id.history_iv_icon);
            history_tv_title = (TextView) itemView.findViewById(R.id.history_tv_title);
            history_tv_msg = (TextView) itemView.findViewById(R.id.history_tv_msg);
            history_tv_listenState = (TextView) itemView.findViewById(R.id.history_tv_listenState);

        }
    }

    public interface OnMyItemTouchListener{
        void getItemId(int id);
    }

    public void setOnMyItemTouchListener(OnMyItemTouchListener onMyItemTouchListener){
        this.onMyItemTouchListener=onMyItemTouchListener;
    }
}
