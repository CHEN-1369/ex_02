package com.example.ex_2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//根据保存的实例状态初始化activuty
        EdgeToEdge.enable(this);//边到边显示（沉浸显示），使内容视图可以铺满屏幕（内容延申到系统栏下面）
        setContentView(R.layout.activity_linear);//从R（资源类）加载布局文件
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linear), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });//动态处理系统栏避让——通过监听 WindowInsets，给根视图设置合适的 padding，防止内容被状态栏和导航栏遮挡。（处理edgetoedge产生的系统栏覆盖问题）
    }
}