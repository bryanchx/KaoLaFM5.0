package com.example.administrator.kaolafm50.discover.type_page;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.kaolafm50.R;
import com.example.administrator.kaolafm50.others.utils.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 16-5-24.
 */
public class TypeAdapter extends
        RecyclerView.Adapter<TypeAdapter.TypeViewHolder>{

    private List<Type> list;
    private Context context;

    public TypeAdapter(Context context, List<Type> list) {
        this.list = list;
        this.context=context;
    }

    @Override
    public TypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_type_rv, parent, false);
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels-60;
        view.setLayoutParams(new LinearLayout.LayoutParams(widthPixels/4,widthPixels/4));
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TypeViewHolder holder, int position) {
        holder.adapter_type_name_tv.setText(list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getIcon(),holder.adapter_type_name_iv,
                ImageUtil.getNormalImageOption());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {
        private ImageView adapter_type_name_iv;
        private TextView adapter_type_name_tv;
        public TypeViewHolder(View itemView) {
            super(itemView);
            adapter_type_name_iv = (ImageView) itemView.findViewById(R.id.adapter_type_name_iv);
            adapter_type_name_tv = (TextView) itemView.findViewById(R.id.adapter_type_name_tv);
        }
    }
}
