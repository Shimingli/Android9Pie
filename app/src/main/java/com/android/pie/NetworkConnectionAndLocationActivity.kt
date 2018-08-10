package com.android.pie

import android.app.job.JobScheduler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NetworkConnectionAndLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_connection_and_location)



        //使用 Wi-Fi RTT ，进行室内定位
        //Android 9 为 IEEE 802.11mc Wi-Fi 协议添加了平台支持 (也称为 Wi-Fi 往返时间，RTT)，这可以让您在应用中使用室内定位功能。在提供硬件支持的 Android 9 设备上，在启动位置服务并勾选 “允许获取地理位置信息” 选项后，应用就可以使用 RTT API 测量与附近 Wi-Fi 接入点 (AP) 的距离。设备不需要连接到 AP 便可以使用 RTT，而且为了保护隐私，只有手机能够确定距离，而 AP 不可以。
        //通过测量从设备到三个或更多 AP 的距离，您可以计算设备位置至 1 到 2 米的精度。这种精确度允许您创建更多新的体验：室内导航、基于位置的细粒度服务，例如，模糊语音控制 ( "打开这里的灯" ) ；以及基于位置的资讯服务 ( "这个产品有优惠活动吗？" )。




        //JobScheduler 中的数据费用敏感度  在 Android 9 中，JobScheduler 可以更好地帮助用户处理与网络相关的任务，并与运营商单独提供的网络状态信号相协调
         //JobScheduler 是 Android 的一项核心服务，它可以帮助您针对低耗电模式、应用待机模式以及后台限制，妥善进行各种任务的调度。在 Android 9 中，JobScheduler 可以更好地帮助用户处理与网络相关的任务，并与运营商单独提供的网络状态信号相协调。任务现在可以声明预估数据量、信号预取以及指定详细的网络要求 —— 运营商可以报告网络状况是拥塞还是不计量，然后 JobScheduler 会根据网络状态管理作业。例如，当网络拥塞时，JobScheduler 可能推迟大型网络请求；而在网络可以不计量使用时，则可以运行多种预加载作业 (例如，预读标题) 来改进用户体验。


       // 用于 NFC 支付和安全交易的 Open Mobile API
         //       Android 9 将 GlobalPlatform Open Mobile API 的实现添加至平台中。在支持的设备上，应用可以使用 OMAPI API 访问安全元素 (SE) ，以启用智能卡支付等安全服务。硬件抽象层 (HAL) 提供了必要的 API，用于枚举多种可用的 Secure Elements (如 eSE, UICC 等)。


    }
}
