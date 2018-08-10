package com.android.pie

import android.app.Notification
import android.app.Person
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

       // 电量优化
        btn_electricity_manager.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,ElectricityManagementActivity::class.java))
        })

//        文本识别与 Smart Linkify
//        在 Android 9 中，我们对识别文本的机器学习模型进行了扩展，使其可以借助 TextClassifier API 识别出类似日期或航班号这样的信息。此外， Smart Linkify 允许开发者通过 Linkify API 使用文本识别模块完成多项操作，比如对用户可采取的操作提出建议。Smart Linkify 让系统在文本识别精确度与速度上都有明显的提升。

        btn_smart_linkify.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,SmartLinkifyActivity::class.java))
        })



        btn_slices_and_app_actions.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,SlicesAndAppActionsActivity::class.java))
        })



        // 神经网络 API 1.1   todo 咋个使用的  Android 9.0 对神经网络 API 进行了扩展与改进，进一步优化 Android 对机器学习硬件加速的支持。神经网络 API 1.1 共增加了对 9 个新算子的支持，它们分别是 Pad、BatchToSpaceND、SpaceToBatchND、Transpose、Strided Slice、Mean、Div、Sub 和 Squeeze。TensorFlow Lite 就是一个已经用上此 API 的典型机器学习框架。
//        >> 神经网络 API 1.1
//        https://developer.android.google.cn/ndk/guides/neuralnetworks/index.html
//
//        >> TensorFlow Lite
//        https://www.tensorflow.org/mobile/tflite/

        // 人机交互

//        全新系统导航
//        经过一年多的努力， Android 9 迎来了全新的系统导航，让多任务切换及关联应用探索变得更加简单。您只需要向上滑动屏幕就可以全屏预览最近使用过的应用，轻触预览页后便可以切换至所选应用。


//        凹口屏支持  想起来 苹果大佬 还是牛逼，刘海是为了屈服某种硬件的缺陷，然后谷歌就开始支持了
//        Android 9 中加入了凹口屏支持，让您的应用可以充分利用最新全面屏，展现应用的独特魅力。该功能可以在大部分应用中无缝工作，系统会通过调整状态栏高度将应用内容与屏幕缺口区域分开。如果您的应用含有沉浸式内容，您可调用 display cutout APIs 确认缺口形状与位置，然后请求围绕缺口进行全屏布局。另外，我们还加入了开发者选项来模拟任意设备上的凹口形状，从而极大简化了应用支持凹口屏幕所需的构建以及测试流程。


//        >> 凹口屏支持
//        https://developer.android.google.cn/guide/topics/display-cutout/
//
//        >> display cutout APIs
//        https://developer.android.google.cn/reference/android/view/DisplayCutout.html




//        通知与智能回复
//        Android 9 进一步改善了通知的实用性与可操作性。消息类应用可以调用新的 MessagingStyle API 来显示对话，附加照片和表情，或者提供智能回复建议。再过不久，您就可以使用 ML Kit 在应用中生成智能回复。
//        >> MessagingStyle
//        https://developer.android.google.cn/preview/features%23notifications
//
//        >> ML Kit
//        https://developers.google.com/ml-kit/
//     // Create new Person.  完蛋了，这下在安卓中Person类有了，不仅仅是一个了
//        val sender = Person()
//                .setName(name)
//                .setUri(uri)
//                .setIcon(null)
//                .build()
//      // Create image message.
//        val message = Notification.MessagingStyle.Message("Picture", time, sender)
//                .setData("image/", imageUri)
//        val style = Notification.MessagingStyle(getUser())
//                .addMessage("Check this out!", 0, sender)
//                .addMessage(message)

//        文本放大镜
//        Android 9 中添加文字放大镜工具 (Magnifier widget)，以提升文本选择方面的用户体验。由于该放大器提供了可以在文本上方拖拽的文本放大面板，所以有助于用户精准地定位光标或文本选择手柄。该功能可以灵活运用在所有附加在窗口的视图上，个性化小部件和定制文本呈现均是不错的应用场景。而且，该放大器工具还可以提供任何视图或界面的放大版本，而不仅仅是文本。

//        >> 文字放大镜工具 (Magnifier widget)
//        https://developer.android.google.cn/reference/android/widget/Magnifier




        //用户安全与隐私
        btn_user_security_and_privacy.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,UserSecurityAndPrivacyActivity::class.java))
        })



         // 感官新体验: 摄像和影音的全面升级

        btn_new_sensory_experience.setOnClickListener(View.OnClickListener {
            startActivity(Intent(MainActivity@this,NewSensoryExperienceActivity::class.java))
        })




    }
}
