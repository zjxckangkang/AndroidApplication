package ezscaner.uniview.app.ezscan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kangkang on 16/6/4.
 */
public class InfoListAdapter extends BaseAdapter{
    private List<DeviceBelongBean> mDeviceBelongBeans;
    private Context mContext;


    public InfoListAdapter(List<DeviceBelongBean> deviceBelongBeans, Context context) {
        mDeviceBelongBeans = deviceBelongBeans;
        mContext = context;
    }

    @Override
    public int getCount() {
        if (mDeviceBelongBeans==null){
            return 0;
        }
        return mDeviceBelongBeans.size();
    }

    @Override
    public DeviceBelongBean getItem(int position) {
        return mDeviceBelongBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView==null){
            convertView=View.inflate(mContext,R.layout.item_info_list,null);
            holder=new Holder();
            holder.tvAddress= (TextView) convertView.findViewById(R.id.tvAddress);
            holder.tvOwner= (TextView) convertView.findViewById(R.id.tvOwner);
            holder.tvSN= (TextView) convertView.findViewById(R.id.tvSN);
            convertView.setTag(holder);


        }else {
            holder= (Holder) convertView.getTag();
        }
        holder.tvAddress.setText(getItem(position).getLocation());
        holder.tvOwner.setText(getItem(position).getOwner());
        holder.tvSN.setText(getItem(position).getSn());
        return convertView;
    }

    private class Holder{
        private TextView tvSN;
        private TextView tvAddress;
        private TextView tvOwner;
    }
}
