package com.nvma.tabang.view;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.nvma.tabang.R;

public class NewProgressDialog extends AlertDialog {
    private Context context;

    public NewProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressdialog);
        ImageView image = (ImageView) NewProgressDialog.this
                .findViewById(R.id.pd_imageview);
        Animation anim = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(1000);
        anim.setInterpolator(new LinearInterpolator());
        image.startAnimation(anim);
    }

    private void setScreenBrightness() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0;
    }

}
