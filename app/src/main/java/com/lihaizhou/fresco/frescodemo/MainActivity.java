package com.lihaizhou.fresco.frescodemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
public class MainActivity extends Activity {
    private SimpleDraweeView simpleDraweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        //创建SimpleDraweeView对象
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.main_sdv);
        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse("http://avatar.csdn.net/5/D/9/1_vatty748895431.jpg");
        //开始下载
        simpleDraweeView.setImageURI(imageUri);
        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                //重试之后要加载的图片URI地址
                .setUri(imageUri)
                //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                //设置旧的Controller
                .setOldController(simpleDraweeView.getController())
                //构建
                .build();
        //设置DraweeController
        simpleDraweeView.setController(controller);
    }
}
