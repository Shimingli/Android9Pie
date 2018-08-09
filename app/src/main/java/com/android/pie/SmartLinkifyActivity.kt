package com.android.pie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.textclassifier.TextClassifier


class SmartLinkifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_linkify)

       // TextClassifier.

      //  在 Android 9 中，我们对识别文本的机器学习模型进行了扩展，使其可以借助 TextClassifier API 识别出类似日期或航班号这样的信息。此外， Smart Linkify 允许开发者通过 Linkify API 使用文本识别模块完成多项操作，比如对用户可采取的操作提出建议。Smart Linkify 让系统在文本识别精确度与速度上都有明显的提升。
        //TextClassifier  后续更新下Demo  研究中
       /// >> TextClassifier API
       // https://developer.android.google.cn/reference/android/view/textclassifier/package-summary

      //  >> Linkify API
      //  https://developer.android.google.cn/reference/android/text/util/Linkify

    }
}
