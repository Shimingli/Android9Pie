package com.android.pie

import android.graphics.*
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.File



/*
感官新体验: 摄像和影音的全面升级
 */
class NewSensoryExperienceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_sensory_experience)

        //多摄像头的API的改进 从 Android 9 开始，您可以在支持多摄像头 API 的设备上通过两个或更多实体摄像头同时访问视频流；在配有双前置或双后置摄像头的设备上，实现单摄像头无法实现的创新功能：如无缝变焦、散景和立体视觉。该 API 还允许您调用可以在两台或更多台摄像头之间自动切换的逻辑或混合摄像头视频流。

       // 使用动态处理增强音频  todo 降噪技术
        //开发者可以调用 Dynamics Processing API 对音频进行动态处理，通过分离出特定频率的声音，降低过大的音量，或者增强过小的音量，来改善应用的音频质量。比如说，即便说话者声音小，离麦克风远，而且外界环境十分嘈杂，您的应用依然可以有效捕捉并他/她的声音，并进行相应优化。该 API 提供了多声场、多频段的动态处理效果，包括一个预均衡器、一个多频段压缩器，一个后均衡器以及一个串联的音量限制器。

      //用于位图和 drawable 的 ImageDecoder
        //ImageDecoder API 让开发者可以通过一种更为简单的方式将图像解码为位图或 drawable。ImageDecoder 允许您从字节缓冲区、文件或 URI 创建位图或 drawable。它相比 BitmapFactory 有以下几个优势：支持精确缩放，支持单步解码至硬件存储器，支持解码后处理，以及动画图像解码。
        imageDecoderDemo()
      // TODO 2018.8.10    java.lang.NoClassDefFoundError: Failed resolution of: Landroid/graphics/ImageDecoder;   哎哎 多么的希望有个 9.0的手机啊


    }
    //对于图片和位图图像解码器
    private fun imageDecoderDemo() {
        //一个的可以将PNG, JPEG, WEBP, GIF, or HEIF 格式的图片的转换成Drawable 或者Bitmap 对象的类。ImageDecoder

        val file =File("filename")
        val source = ImageDecoder.createSource(file)
        val drawable = ImageDecoder.decodeDrawable(source)

         //还可以传递OnHeaderDecodedListener，这里ImageInfo存放的是原始的图片的宽和高。可以修改用来修改图片宽高的时候修改SampleSize
        val listener = object : ImageDecoder.OnHeaderDecodedListener {
            override fun onHeaderDecoded(decoder: ImageDecoder, info: ImageDecoder.ImageInfo, source: ImageDecoder.Source) {
                decoder.setTargetSampleSize(2)
            }
        }
        val drawable1 = ImageDecoder.decodeDrawable(source, listener)

         //如果要解码的图片是gif，会被解码成AnimatedImageDrawable
        val drawable2 = ImageDecoder.decodeDrawable(source)
        if (drawable is AnimatedImageDrawable) {
            drawable.start()
        }

       //解码出来的bitmap是不可变，但是仍然可以使用PostProcessor来添加一些自定义的效果
        val drawable3 = ImageDecoder.decodeDrawable(source) { decoder, info, src ->
            decoder.setPostProcessor { canvas ->
                // This will create rounded corners.
                //创建圆角照片
                val path = Path()
                path.setFillType(Path.FillType.INVERSE_EVEN_ODD)
                val width = canvas.width
                val height = canvas.height
                 // 最低的API的要求是 21 所以我的工程里面的 API为 21
                path.addRoundRect(0.toFloat(), 0.toFloat(), width.toFloat(), height.toFloat(), 20.toFloat(), 20.toFloat(), Path.Direction.CW)
                val paint = Paint()
                paint.setAntiAlias(true)
                paint.setColor(Color.TRANSPARENT)
                paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC))
                canvas.drawPath(path, paint)
                PixelFormat.TRANSLUCENT
            }
        }
      // 如果解码的照片是不完整的或者包含错误，解码的时候会抛出DecodeException，一些情况下，可能已经解码出一部分的照片，这个时候传递OnPartialImageListener ，并返回true，就只显示解码出来的部分，剩余部分使用空白代替
        val drawable5 = ImageDecoder.decodeDrawable(source) { decoder, info, src ->
            decoder.setOnPartialImageListener { e: ImageDecoder.DecodeException ->
                 true
            }
        }
    }
}
