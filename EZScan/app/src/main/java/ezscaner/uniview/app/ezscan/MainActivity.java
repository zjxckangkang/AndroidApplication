package ezscaner.uniview.app.ezscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity
public class MainActivity extends Activity {
    private final static int SCANNIN_GREQUEST_CODE = 1;


    @ViewById
    Button btQuery;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Click(R.id.btQuery)
    void query(){
        Intent intent=new Intent(this,InfoListActivity_.class);
        this.startActivity(intent);
    }




}
