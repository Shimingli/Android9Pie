package com.android.pie

import android.app.slice.Slice
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
/*
Slices  App Actions  Google 想要透过 Action 和 Slice 这两个功能让使用者减少操作动作，让应用程式和操作行为更紧密结合，把以前需要操作四五下才能完成的事减少到操作两三下或是操作一下就能自动完成。
 */
class SlicesAndAppActionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slices_and_app_actions)

        // App Actions 是一种全新的应用推荐的方式，它能够对应用语义意图和使用场景进行分析，并根据分析结果在适当的时机向用户推荐应用
        // 比如说在用户插入耳机的时候，推荐开启 音乐App 等等  todo  后续公布其使用的方式

        // Slice 的概念则是 Google Assistant 的延伸，让使用者能快速使用到 app 里的某个特定功能，只要开发者导入 Slice 功能，使用者在使用搜寻、Google Play 商店、Google Assitant 或其他内建功能时都会出现 Slice 的操作建议。
        // 在go语言中 有个叫切片 slice ，它的意思是：在初始定义数组时，我们并不知道需要多大的数组，因此我们就需要“动态数组”。在Go里面这种数据结构叫slice


    }
}
