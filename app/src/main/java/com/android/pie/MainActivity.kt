package com.android.pie

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.util.Linkify
import android.view.View
import android.view.textclassifier.TextClassifier
import kotlinx.android.synthetic.main.activity_main.*

/*
以机器学习为核心，打造更为智能的手机

Android 9 赋予手机强大的学习能力：系统能够根据用户在使用过程中展露的习惯与偏好，进行自我学习与适应 —— 从强劲续航到人性化应用推荐，Android 9 都能想您所想，保障持久流畅的用户体验。
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        文本识别与 Smart Linkify

//        在 Android 9 中，我们对识别文本的机器学习模型进行了扩展，使其可以借助 TextClassifier API 识别出类似日期或航班号这样的信息。此外， Smart Linkify 允许开发者通过 Linkify API 使用文本识别模块完成多项操作，比如对用户可采取的操作提出建议。Smart Linkify 让系统在文本识别精确度与速度上都有明显的提升。

        btn_smart_linkify.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,SmartLinkifyActivity::class.java))
        })


    }
}
