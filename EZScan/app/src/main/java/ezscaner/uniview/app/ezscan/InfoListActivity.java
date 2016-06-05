package ezscaner.uniview.app.ezscan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import java.util.ArrayList;
import java.util.List;

@EActivity
public class InfoListActivity extends Activity {

    @ViewById
    ListView lvInfo;


    @ViewById
    View llBack;

    private InfoListAdapter mInfoListAdapter;
    private List<DeviceBelongBean>  mDeviceBelongBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
    }

    @AfterViews
    void initView(){
        mDeviceBelongBeans=new ArrayList<>();
        mInfoListAdapter=new InfoListAdapter(mDeviceBelongBeans,this);
        lvInfo.setAdapter(mInfoListAdapter);
        updateData();
    }

    private void updateData(){
        for (int i=0;i<100;i++){
            DeviceBelongBean deviceBelongBean=new DeviceBelongBean("1"+i,"2","3");
            mDeviceBelongBeans.add(deviceBelongBean);
        }

        mInfoListAdapter.notifyDataSetChanged();
    }


    @Click(R.id.llBack)
    void back(){
        finish();
    }
}
