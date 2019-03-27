package com.chinaso.loginlibrary;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * @auther Su Yuewen
 * @time 2019/3/26 10:40.
 */

public class LoginView extends RelativeLayout {
    private Context mContext;
    private EditText accountEt;
    private EditText passwordEt;
    private Button loginBtn;

    public LoginView(Context context) {
        super(context);
        mContext = context;
        initView();

    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_login, this);
        accountEt = view.findViewById(R.id.account_et);
        passwordEt = view.findViewById(R.id.password_et);
        loginBtn = view.findViewById(R.id.login_btn);
        accountEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 0) {
                    loginBtn.setEnabled(true);
                    loginBtn.setBackgroundColor(mContext.getResources().getColor(R.color.theme_color));
                } else {
                    loginBtn.setEnabled(false);
                    loginBtn.setBackgroundColor(mContext.getResources().getColor(R.color.color_d9d9d9));
                }
            }
        });
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public void setOnLoginClickListener(final LoginInterface loginClickListener) {
        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClickListener.loginBtnClick();
            }
        });
    }

    public interface LoginInterface {
        void loginBtnClick();
    }

}
