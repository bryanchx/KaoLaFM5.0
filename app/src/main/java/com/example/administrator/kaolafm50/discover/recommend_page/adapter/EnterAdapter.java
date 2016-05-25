package com.example.administrator.kaolafm50.discover.recommend_page.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.discover.recommend_page.bean.Special;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 16-5-19.
 */
public class EnterAdapter extends RecyclerView.Adapter<EnterAdapter.EnterViewHolder>{

    private List<Special> list;
    private Context context;
    private LayoutInflater inflater;
    private DisplayImageOptions options=new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build();

    public EnterAdapter(Context context,List<Special> list) {
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public EnterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.adapter_recommend_enter,null);
        return new EnterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EnterViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(list.get(position).getPic(),holder.imageView,options);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class EnterViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public EnterViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.recommend_enter_iv);
            textView= (TextView) itemView.findViewById(R.id.recommend_enter_tv);
        }
    }
}
