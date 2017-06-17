# WaterMarkImage
图片水印工具，可以直接直接添加水印遮罩图片，也可直接添加水印文字并自定义水印文字位置和旋转角度<br>
## 效果展示

![image](https://github.com/RmondJone/WaterMarkImage/blob/master/GIF.gif)

## 更新日志
* 2017年06月17日16:48:04----------WaterMarkImage V1.0.0

## 工程集成说明
* 第一步
```java
//在工程gradle文件里
allprojects {
    repositories {
        .......
        maven { url 'https://jitpack.io' }
        ......
    }
}
```

```java
//如果不在工程gradle文件里加入，也可以加入模块gradle文件中
repositories {
    maven {
        url  "https://jitpack.io"
    }
}
```

* 第二步
```java
  dependencies {
		compile 'com.github.RmondJone:WaterMarkImage:1.0.0'
	}
```

## API使用说明

```java

           WaterMarkImage waterMarkImage = new WaterMarkImage(mBitmap);
           Bitmap resBit = waterMarkImage
                   //设置水印遮罩图片
                   .setWaterMarkBitmap(BitmapFactory.decodeResource(getResources()
                           ,R.drawable.watermarkimage))
                   //设置水印文字
                   .setWaterMarkString(mEditText_Text.getText().toString())
                   //设置水印文字位置
                   .setWaterMarkTextLocation(mTextLocation)
                   //设置水印文字选择角度
                   .setWaterMarkTextRotationAngle(Integer.parseInt
                           (mEditText_Angle.getText().toString()))
                   //设置水印文字颜色
                   .setWaterMarkTextColor(Color.RED)
                   //设置水印文字大小
                   .setWaterMarkTextSize(getResources()
                           .getDimension(R.dimen.water_mark_text_size))
                   //设置水印文字字体
                   .setWaterMarkTextTypeface(Typeface.create("宋体",
                           Typeface.BOLD))
                   //此方法必须调用，得到水印图片
                   .getBitmap();
           mImageView.setImageBitmap(resBit);

```
## 目前支持可自定义属性

```java
   /**
    * 要加水印的图片
    */
   private Bitmap mInitBitmap;
   /**
    * 水印遮罩图片
    */
   private Bitmap mWaterMarkBitmap;
   /**
    * 水印文字
    */
   private String mWaterMarkString;
   /**
    * 水印文字位置
    */
   private TextLocation mWaterMarkTextLocation;

   /**
    * 水印文字旋转角度
    */
   private int mWaterMarkTextRotationAngle;

   /**
    * 水印文字颜色
    */
   private int mWaterMarkTextColor;

   /**
    * 水印文字大小
    */
   private float mWaterMarkTextSize;
   /**
    * 水印文字类型
    */
   private Typeface mWaterMarkTextTypeface;

```

## 问题反馈
* 联系方式：QQ(2318560278）
* 技术交流群：QQ(264587303)
* Demo作者：郭翰林
