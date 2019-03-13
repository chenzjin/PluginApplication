package com.ctrip.thirdpartyapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ctrip.standard.AlipayInterface;

import org.jetbrains.annotations.Nullable;

/**
 * @author Zhenhua on 2018/3/3.
 * @email zhshan@ctrip.com ^.^
 */

public class BaseActivity extends Activity implements AlipayInterface {

    protected Activity that;

    /**
     * super.setContentView(layoutResID);
     * <p>
     * 最终是调用了系统给我们注入的上下文
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (that == null) {
            super.setContentView(layoutResID);
        } else {
            that.setContentView(layoutResID);
        }

    }

    @Override
    public View findViewById(@IdRes int id) {
        if (that == null) {
            return super.findViewById(id);
        } else {
            return that.findViewById(id);
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if (that == null) {
            return super.getClassLoader();
        } else {
            return that.getClassLoader();
        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if (that == null) {
            return super.getLayoutInflater();
        } else {
            return that.getLayoutInflater();
        }
    }

    @Override
    public Window getWindow() {
        if (that == null) {
            return super.getWindow();
        } else {
            return that.getWindow();
        }
    }

    @Override
    public WindowManager getWindowManager() {
        if (that == null) {
            return super.getWindowManager();
        } else {
            return that.getWindowManager();
        }
    }

    @Override
    public void startActivity(Intent intent) {
        if (that == null) {
            super.startActivity(intent);
        } else {
            Intent newIntent = new Intent();
            newIntent.putExtra("className", intent.getComponent().getClassName());
            that.startActivity(newIntent);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
//        super.onStart();
    }

    @Override
    public void onResume() {
//        super.onResume();
    }

    @Override
    public void onPause() {
//        super.onPause();
    }

    @Override
    public void onStop() {
//        super.onStop();
    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void attach(Activity appCompatActivity) {
        this.that = appCompatActivity;
    }

}
