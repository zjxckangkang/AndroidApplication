package ezscaner.uniview.app.ezscan;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ezscaner.uniview.app.ezscan.log.KLog;

/**
 * Created by kangkang on 16/6/3.
 */

public class EditTextWithDelete extends RelativeLayout implements View.OnClickListener ,TextWatcher,View.OnFocusChangeListener{
    private EditText et;
    private ImageView iv;
    private boolean hasFocus;

    public EditTextWithDelete(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.et_with_delete, this, true);


        et= (EditText) this.findViewById(R.id.et);
        iv= (ImageView) this.findViewById(R.id.iv);
        et.addTextChangedListener(this);
        iv.setOnClickListener(this);
        et.setOnFocusChangeListener(this);


    }
    private void setClearIconVisible(boolean visible){
        if (visible){

            iv.setVisibility(VISIBLE);

        }else {

            iv.setVisibility(INVISIBLE);

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv:

                et.setText("");
                setClearIconVisible(false);
                break;
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {

        if(hasFocus){
            setClearIconVisible(s.length() > 0);
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (v.getId()==R.id.et){

            this.hasFocus = hasFocus;
            if (hasFocus) {

                setClearIconVisible(et.getText().length() > 0);
            } else {

                setClearIconVisible(false);
            }
        }

    }

    public Editable getText() {
        return et.getText();
    }

    public void setText(CharSequence text) {
        et.setText(text);
    }


}
