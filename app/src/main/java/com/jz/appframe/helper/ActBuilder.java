package com.jz.appframe.helper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.jz.appframe.ui.base.ActFactory;


/**
 * @author jackzhous
 * @package com.jack.helper
 * @filename ActBuilder
 * date on 2019/2/20 11:13 AM
 * @describe TODO
 * @email jackzhouyu@foxmail.com
 **/
public class ActBuilder {

    private Activity context;

    private Intent intent;

    private Bundle bundle;

    private Class target;



    public ActBuilder() {
        bundle = new Bundle();
    }

    public ActBuilder setSrc(Activity context) {
        this.context = context;
        return this;
    }


    public ActBuilder setTarget(int action){
        Args.positive(action, "actBuilder action");
        target = ActFactory.INSTANCE.newActClass(action);
        return this;
    }


    public ActBuilder setStringValue(String key, String value){
        bundle.putString(key, value);
        return this;
    }

    public ActBuilder setIntValue(String key, int value){
        bundle.putInt(key, value);
        return this;
    }

    public ActBuilder setFloatValue(String key, Float value){
        bundle.putFloat(key, value);
        return this;
    }

    public ActBuilder setBooleanValue(String key, boolean value){
        bundle.putBoolean(key, value);
        return this;
    }

    public ActBuilder setParcelableValue(String key, Parcelable value){
        bundle.putParcelable(key, value);
        return this;
    }

    public ActBuilder setBundleValue(Bundle value){
        bundle.putAll(bundle);
        return this;
    }




    private void build(){
        if(intent == null){
            intent = new Intent();
        }
        intent.setComponent(new ComponentName(context, target));
        if(bundle != null){
            intent.putExtras(bundle);
        }

    }

    public void toAct(boolean closedSrc){
        build();
        context.startActivity(intent);
        if(closedSrc){
            context.finish();
        }
    }

    public void toActForResult(int requestCode, boolean closedSrc){
        build();
        context.startActivityForResult(intent, requestCode);
        if(closedSrc){
            context.finish();
        }
    }
}
