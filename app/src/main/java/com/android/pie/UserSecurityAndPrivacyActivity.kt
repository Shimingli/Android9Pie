package com.android.pie

import android.Manifest
import android.hardware.biometrics.BiometricPrompt
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.SensorManager
import android.net.LinkProperties
import android.os.Build
import android.os.CancellationSignal
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.StrongBoxUnavailableException
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.util.Log
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.Mac
import javax.crypto.SecretKey

/*
api的目录 ：https://developer.android.google.cn/reference/android/hardware/biometrics/BiometricPrompt
 */
class UserSecurityAndPrivacyActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_security_and_privacy)
        // 身份识别，会报错
//         identityAuthentication()

        //高可信度用户确认
        androidProtectedConfirmation()


        //KeyStore 加强密钥安全保护
        keyStoreDemo()

        // DNS over TLS 基于TLS的DNS   Android 9 内置对 DNS over TLS 的支持：若网络 DNS 服务器提供支持，设备会自动将 DNS 查询升级为 TLS 查询。用户可以通过更改 “网络和互联网” 设置下的隐私 DNS (Private DNS) 模式来管理 DNS over TLS 行为
        DNSAndTLS()


        // todo  Android P 默认使用了HTTPS




        //基于编译器的安全缓解措施
        //Android 9 将进一步扩展编译器级别的安全缓解措施，借助运行时危险行为监测进一步加强平台安全建设。Android 9 通过控制流程完整性 (CFI) 技术解决了代码重用 (code-reuse) 和任意代码执行两大漏洞，并扩展了 CFI 在媒体框架和其它关键安全组件内的使用范围，如 NFC 与蓝牙。同时，Android 9 还针对 Android 常见内核的 LLVM 编译添加了 CFI 内核支持。

        //此外，Android 9 还将整数溢出检查器 (Integer overflow sanitizer) 的使用范围扩展到其他库，以缓解内存损坏与信息泄露这两个问题。我们调高了检查器在以下两类库中的优先级：1) 存在历史漏洞，2) 需要处理复杂且不受信任的输入，如 libui、libnl 和 libmediaplayerservice 一类的库都在调整范围内。


        //用户隐私
        //Android 9 新加入多项机制，进一步加强了对用户隐私的保护。系统禁止所有处于空闲状态的应用对话筒、摄像头和所有 SensorManager 传感器的访问。当应用的 UID 空闲时，麦克风将会报告 “无音频信号”，传感器将会停止报告事件，应用使用的摄像头也会断开连接，并在应用试图访问时生成错误。在大多数情况下，这些限制不会对现有应用造成新的问题，但建议您从应用中移除此类传感器请求。
      // SensorManager  s
        // 需要读取手机的权限
        // Android 9 还让用户控制是否允许访问平台 build.serial 识别码 (它被 READ_PHONE_STATE 权限保护) 。
     //val vdd=   Build.getSerial()

        //获取硬件序列号，如果可用的话。
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            //注意需要在 高版本的 SDK的手机上运行
            val serial = Build.getSerial()
        }




    }

    /**
     * 大多的网络连接 --DNS查询--》返回IP地址--》客服端就能连接上网页了。互联网的大佬们一直在致力于新的NDS的协议的开发，该协议就是NDS over  TLS协议     TLS：安全传输层协议（TLS）用于在两个通信应用程序之间提供保密性和数据完整性
     * Android P 开发者预览版内置对 DNS over TLS 的支持，在 “网络和互联网” 设置中添加了隐私 DNS (Private DNS) 模式。
     */
    private fun DNSAndTLS() {
         //DNS over TLS 模式自动为所有系统上的应用提供安全 DNS查询。不过，若应用未使用系统 API，而是自行运行 DNS 查询，它们必须确保在系统进行安全连接情况下，不发送不安全的 DNS 查询。应用可以调用新的 API!
//        LinkProperties.isPrivateDnsActive()
//        val lv=LinkProperties

        //将会内置对 DNS over TLS 的支持。今后，我们希望 DNS 安全传输能够覆盖所有操作系统，为广大用户的每一次新连接都提供更好的安全隐私保护。

    }

    //加入了一个新的 KeyStore 类 —— StrongBox，并提供相应的 API 来支持那些提供了防入侵硬件措施的设备，比如独立的 CPU，内存以及安全存储。您可以在 KeyGenParameterSpec 里进行设置，决定是否把密钥交给 StrongBox 安全芯片来保存。
    private fun keyStoreDemo() {

//        StrongBox
////
////        StrongBox

    }

    // 新增了  安卓保护确认 Android Protected Confirmation
    private fun androidProtectedConfirmation() {
        //运行Android 9或更高版本的支持设备使您有能力使用Android保护的确认。使用此工作流时，应用程序向用户显示提示，要求用户批准简短语句。这个声明允许应用程序重新确认用户希望完成一个敏感的交易，例如支付。

        println("运行Android 9或更高版本的支持设备使您有能力使用Android保护的确认。使用此工作流时，应用程序向用户显示提示，要求用户批准简短语句。这个声明允许应用程序重新确认用户希望完成一个敏感的交易，例如支付。")
    }

    private fun identityAuthentication() {
        // 统一身份验证对话框  : 为了保障用户在不同甘银强和应用之间能够获得一致的体验，Android P 引入了统一的身份验证对话框，提醒用户进行操作。应用可以不自行的设计，该API还支持面部识别 虹膜识别技术  是基于眼睛中的虹膜进行身份识别，应用于安防设备（如门禁等），以及有高度保密需求的场所。
//   优点
//        1．便于用户使用；
//        2．可能会是最可靠的生物识别技术；.
//        3．不需物理的接触；
//        4．可靠性高。
//  缺点
//        1．很难将图像获取设备的尺寸小型化；
//        2．设备造价高，无法大范围推广；
//        3．镜头可能产生图像畸变而使可靠性降低；
//        4．两大模块：硬件和软件；
//        5．一个自动虹膜识别系统包含硬件和软件两大模块：虹膜图像获取装置和虹膜识别算法。分别对应于图像获取和模式匹配这两个基本问题。

        // TODO 一定要在 API 28的模拟器上跑 要不然 app 会直接奔溃掉
        val BiometricPrompt = BiometricPrompt.Builder(this)
                .setTitle("指纹验证")
                .setDescription("描述")
                .setNegativeButton("取消", mainExecutor, DialogInterface.OnClickListener { dialogInterface, i -> Log.i(UserSecurityAndPrivacyActivity@ this.localClassName, "Cancel button clicked") })
                .build()
        val mCancellationSignal = CancellationSignal()
        mCancellationSignal.setOnCancelListener {
            CancellationSignal.OnCancelListener {
                fun onCancel() {
                    println("取消了啊")
                }
            }
        }
        val mAuthenticationCallback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                println("发生了 错误了啊")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                println("发生了 成功了啊")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                println("发生了 失败了")
            }
        }
        BiometricPrompt.authenticate(mCancellationSignal, mainExecutor, mAuthenticationCallback)

    }
}
