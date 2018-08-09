package com.android.pie

import android.app.usage.UsageStatsManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


@Suppress("DEPRECATION")
/*
Android P 的电量管理表示类
 */
class ElectricityManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electricity_management)
        // Android P 在现在的平台的功能上加入多想新的特性来提升设备电量的管理能力，确保系统对应用进行最合适的资源的分配

        // 1、应用待机分组
        //   Android P 新增加应用待机分组的功能，让系统根据用户的使用情况而限制应用调用CPU或网络等设备的资源
        //应用待机分组是 Android P 新添加的一项电量管理功能，它能根据应用的使用频率或者最近一次使用时间，对其资源请求进行优先级排序。应用待机分组一共有五个分组，系统会根据每个应用的使用情况，将其划分至五个优先分组中的一个，而每个分组对设备资源的调度各有不同的限制。



        val usageStatsManager =this.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        // 在设备上不是这个 28 设备的话 就会报错
    //    var appStandbyBucket = usageStatsManager.appStandbyBucket
     //   val appStandbyBucket = usageStatsManager.appStandbyBucket
        println("appStandbyBucket=$usageStatsManager")
        //  优先分组   在默认的情况下，系统会更具应用的近期的使用的情况进行等级划分，应用活跃度越高，所处的分组优先级就越高，也更加容易获取设备的资源；第二种是系统安装了通过利用机器学习预加载的应用，从而预测各个应用的使用概率，然后将他们编配值相应的群组，在我朝手机设备厂商应该不会是这种。
      //  *注意：设备厂商可以自行规定非活跃应用的群组划分规则(我朝特色，厂商白名单)。请开发者不要试图篡改应用所处的群组，而是专注于改善应用行为，确保应用被划分至目标群组后，依旧能够顺利运行（小公司，好好提升技术，）

//        活跃 (Active): 应用正在被使用 （每个应用都可以）
//            1、启动了一个Activity
//            2、正在运行的前台服务
//            3、另外一个应用已关联该应用  　Slice 的概念则是 Google Assistant 的延伸，让使用者能快速使用到 app 里的某个特定功能 Google 想要透过 Action 和 Slice 这两个功能让使用者减少操作动作，让应用程式和操作行为更紧密结合，把以前需要操作四五下才能完成的事减少到操作两三下或是操作一下就能自动完成。
//            4、 用户点击了推送

//        工作 (Working set): 应用使用频率很高
            //   1、若应用的运行频率很高，但目前并未处于“活跃”状态，它就会被划分至工作群组，例如用户常用的社交媒体应用。此外，该群组还包括了那些被间接使用的应用。微信 QQ 支付宝 ，工作分组内的应用任务（Job）运行和闹铃受到系统的部分限制

//        常用 (Frequent): 应用经常但不是每天被使用
//        常用应用指用户经常使用但不是每天使用的应用，比如用户在健身房使用的打卡应用可能就属于这一群组。跑步的APP ：系统对常用分组采用的限制更强，应用运行任务(job)和触发闹铃的能力都会受到影响，而且接受的高优先性FCM消息也有数量上限


//        极少 (Rare): 应用偶尔被使用
              // 若应用的使用频率很低，它就会被划分至该分组，(比如说你去某个地方，订酒店之类的APP，)该群组下的应用在任务 (job)、闹铃和高优先性FCM消息的资源调用上都会受到严格的限制。此外，网络访问能力也会受到影响

//        应用偶尔被使用 (App is not frequently used)
      //  安装后一次都未被使用过的应用将被划分至 “从不” 这一特殊群组，并受到十分严格的系统限制  我们自己的手机上有这种的App 很多
        // todo  我们写APP 应该怎么应对这几种分组
        // 每个模式下，都能打开APP，确保App不能炸掉
        // 要确保有启动的 Launcher Activity，如果没有的话，有可能你的应用不会切换到活跃分组
        //推送的消息要具有可操作性，这个的意思就是说，点了通知栏要跳到应用去
        //若应用在接受高优先级的 FCM 消息之后未能发送推送，用户将无法与应用产生互动并将其优先级提升至 “活跃” 等级。
        //如果用户多次忽略某个App的推送，系统会去询问用户是否不再接受此推送 。所以不要乱去推送，为了保持活跃群组



        //后台的限制 （微信经常这样）当系统检测到应用消耗过多的资源时，系统会发通知询问用户是否需要限制该应用的后台的活动
            //1、第一中期情况是，频繁使用唤醒锁 (wake locks)：屏幕关闭后，局部唤醒锁 (Partial wake lock) 连续开启 1 小时；
           //  2、过多的后台服务：当应用目标 API 等级低于 26，且运行过多后台服务。

        // Android P 进一步提升了省电模式的性能。需要由设备的厂商来决定采用的具体的限制
        // 作为开发者 我们自己，我们需要在省电模式下测试应用。去设置里面开启省电模式，


        //使用 Android Debug Bridge 命令 https://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652046811&idx=1&sn=f0340e6fabb07a3ee40db45bdd58e7b0&chksm=808ca59eb7fb2c883c6ae99be7c84460f48886cd79bb0de886a5bac84afa2d8050a58339cc89&scene=21#wechat_redirect


        // 2、后台限制
        // Android P 新增后台限制功能，如果应用出现 · Android Vitals· 里面所描述的行为，系统将提醒用户限制该应用的访问设备的资源

        //  Android Vitals:是谷歌提高Android设备稳定性和性能的一项举措。当选择的用户运行你的应用程序时，他们的Android设备记录各种度量，包括关于应用程序稳定性、应用程序启动时间、电池使用时间、渲染时间和权限拒绝的数据。谷歌播放控制台聚集这些数据并将其显示在Android虚拟仪表板中。仪表板突出了崩溃率、ANR率、过度唤醒和卡尾锁：这是开发人员应该关注的核心。所有其他的vitals，当适用于你的APP或游戏类型时，都应该被监控，以确保它们不会产生负面影响。如果产生了，应用的商店被发现的可能性低，说到底的意思就是，垃圾应用，我不帮你推荐


      // 3、省电模式的优化  Android P 优化了现在的省电助手的功能，在启动该功能后，系统将对所有的后台运行实施加以限制

     // 4、低耗能模式， 当用户一段时间没有使用设备时候，设备将进入 低耗电模式，所有的应用都将要受到影响。Android P 并没有针对低电耗模式做出改变
      // 低耗电模式:   低电耗模式通过在设备长时间处于闲置状态时推迟应用的后台 CPU 和网络 Activity 来减少电池消耗。应用待机模式可推迟用户近期未与之交互的应用的后台网络 Activity. 如果用户设备未插接电源、处于静止状态一段时间且屏幕关闭，设备会进入低电耗模式。 在低电耗模式下，系统会尝试通过限制应用对网络和 CPU 密集型服务的访问来节省电量。 这还可以阻止应用访问网络并推迟其作业、同步和标准闹铃.一旦用户通过移动设备、打开屏幕或连接到充电器唤醒设备，系统就会立即退出低电耗模式，并且所有应用都将返回到正常 Activity。
       // 有个例子。手机设备8.0上，打开视频APP下载视屏，关闭屏幕，一会视屏App就会关闭，在以前的版本不会出现，这就是低电耗模式




    }
}
