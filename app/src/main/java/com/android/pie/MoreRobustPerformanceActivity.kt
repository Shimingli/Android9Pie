package com.android.pie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MoreRobustPerformanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_robust_performance)

        // ART 性能提升
        // Android 9 借助 ART 运行时显著提高了应用的性能表现与运行效率。我们扩展了 ART 对执行特征的使用，以优化应用并减少已编译应用代码的内存占用量。ART 现可使用特征文件信息在设备上重写 DEX 文件，帮助多个常见应用的内存占用减少高达 11％。我们期望借此减少系统 DEX 内存使用量并加快应用启动时间。

       // Kotlin 优化
           //     Kotlin 是 Android 开发的一等编程语言，如果您还未尝试，还在等什么呢？我们在 Kotlin 性能方面进行了长期资源投入，同时持续加大对 Kotlin 的支持，如优化 Kotlin 代码性能。在 Android 9 中，您会看到这项工作已初见成效 —— 我们已经改进了一些编译器优化，尤其是那些针对循环的编译器优化，以实现更好的性能。我们还将继续与 JetBrains 合作，优化 Kotlin 生成的代码。只需保持更新 Android Studio 上的 Kotlin 插件，您就能获得所有最新的 Kotlin 性能更新。


        //现代化的 Android
        // 在 Android 9 中，我们继续投入大量资源，进一步打造更为现代的 Android 平台与运行应用，进而推动我们在安全性、性能和稳定性这三方面长远目标的实现。

    }
}
