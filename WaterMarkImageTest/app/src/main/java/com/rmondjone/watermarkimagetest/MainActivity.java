package com.rmondjone.watermarkimagetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.rmondjone.watermarkimage.TextLocation;
import com.rmondjone.watermarkimage.WaterMarkImage;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private ImageView mImageView;
    private Bitmap mBitmap;
    private RadioGroup mRadioGroup;
    private EditText mEditText_Text;
    private EditText mEditText_Angle;

    private TextLocation mTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.markbutton);
        mImageView = (ImageView) findViewById(R.id.background);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.back);
        mEditText_Text=(EditText)findViewById(R.id.markText);
        mEditText_Angle=(EditText)findViewById(R.id.markTextAngle);
        mTextLocation=TextLocation.CENTER;
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.center:
                        mTextLocation = TextLocation.CENTER;
                        break;
                    case R.id.top_left:
                        mTextLocation = TextLocation.TOP_LEFT;
                        break;
                    case R.id.top_right:
                        mTextLocation = TextLocation.TOP_RIGHT;
                        break;
                    case R.id.bottom_left:
                        mTextLocation = TextLocation.BOTTOM_LEFT;
                        break;
                    case R.id.bottom_right:
                        mTextLocation = TextLocation.BOTTOM_RIGHT;
                        break;
                    default:
                        break;
                }
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WaterMarkImage waterMarkImage = new WaterMarkImage(mBitmap);
                Bitmap resBit = waterMarkImage
                        //设置水印遮罩图片
//                        .setWaterMarkBitmap(BitmapFactory.decodeResource(getResources()
//                                ,R.drawable.watermarkimage))
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
            }
        });
    }
}
