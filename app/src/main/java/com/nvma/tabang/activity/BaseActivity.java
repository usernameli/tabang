package com.nvma.tabang.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.nvma.tabang.view.NewProgressDialog;
public abstract class BaseActivity extends Activity {
    private Dialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
        initView();
        initParams();
        setAction();
    }

    /**
     * 给Activity设置Layout
     */
    public abstract void setView();

    /**
     * 调用findViewById初始化View
     */
    public abstract void initView();

    /**
     * 给View设置显示状态
     */
    public abstract void initParams();

    /**
     * 添加监听器
     */
    public abstract void setAction();

    public void jumpFromTo(Context fromContext, Class<?> toClass) {
        Intent intent = new Intent();
        intent.setClass(fromContext, toClass);
        startActivity(intent);
    }

    public void jumpFromTo(Context fromCotext, Class<?> toClass, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(fromCotext, toClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void jumpFromToForResult(Context formContext, Class<?> toClass, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(formContext, toClass);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 版本太低，这个方法调用不了
     */
    /*public void jumpFromToForResult(Context fromContext,Class<?> toClass,int requestCode, Bundle bundle){
        Intent intent = new Intent();
        intent.setClass(fromContext,toClass);
        intent.putExtras(bundle);
        startActivityForResult(intent,requestCode,bundle);
    }*/

    /**
     * 使用Toast显示提示信息
     */
    public void showMessage(String message, boolean isLong) {
        if (isLong) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 显示等待对话框
     */
    public void showProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.show();
        } else {
            progressDialog = new NewProgressDialog(this);
            progressDialog.show();
            progressDialog.setCancelable(true);
        }
    }

    /**
     * 关闭等待对话框
     */
    public void cancleProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
