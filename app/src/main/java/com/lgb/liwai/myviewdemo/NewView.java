package com.lgb.liwai.myviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgb.liwai.myviewdemo.R;


/**
 * Created by liwai on 2015/10/19.
 */
public class NewView extends LinearLayout {
    private TextView textView;
    private String labelText;
    private int labelFontSize;
    private String labelPosition;


    public NewView(Context context, AttributeSet attrs) {

        super(context, attrs);
        //读取属性的资源ID
        int resourceId = attrs.getAttributeResourceValue(null, "labelTextt", 0);
        //未获得资源ID，继续读取属性值
        if (resourceId == 0) {
            labelText = attrs.getAttributeValue(null, "labelTextt");
            //从资源文件中获得labelText的属性的值

        } else
            labelText = getResources().getString(resourceId);
        if (labelText == null) {
            throw new RuntimeException("请设置text属性");
        }
        resourceId = attrs.getAttributeResourceValue(null, "labelFontSize", 0);

        if (resourceId == 0) {
            labelFontSize = attrs.getAttributeIntValue(null, "labelFontSize", 14);
        } else
            labelFontSize = getResources().getInteger(resourceId);
        //获得labelPosition属性的资源ID
        resourceId = attrs.getAttributeResourceValue(null, "labelPosition", 0);
        //获取labelPosition属性的值
        if (resourceId == 0)
            labelPosition = attrs.getAttributeValue(null, "labelPosition");
        else
            labelPosition = getResources().getString(resourceId);
        if (labelPosition == null)
            labelPosition = "left";
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        //获得LAYOUT_INFLATER_SERVICE服务
        li = (LayoutInflater) context.getSystemService(infService);
        LinearLayout linearLayout = null;
        //根据labelPosition属性的值装载不同的布局文件


        if ("left".equals(labelPosition))
            linearLayout = (LinearLayout) li.inflate(R.layout.layoutfirst, this);
        else if ("top".equals(labelPosition))
            linearLayout = (LinearLayout) li.inflate(R.layout.layout2, this);
        else
            throw new RuntimeException("labelPosition属性的值只能是left或top.");

        //  下面的代码从相应的布局文件中获得了TextView对象，并根据LabelTextView的属性值设置TextView的属性
        textView = (TextView) findViewById(R.id.textview);
        //textView.setTextSize((float)labelFontSize);
        textView.setTextSize(labelFontSize);
        textView.setText(labelText);


    }



}
