package com.wuyr.activitymessengertest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wuyr.activitymessenger.get
import com.wuyr.activitymessenger.startActivityForResult
import com.wuyr.activitymessenger.startActivityForResult2
import kotlinx.android.synthetic.main.act_main_view.*

/**
 * @author wuyr
 * @github https://github.com/wuyr/ActivityMessenger
 * @since 2019-08-14 下午1:53
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_view)
    }

    fun start(view: View) {
        val content = editText.text.toString()
        //不接收resultCode
        startActivityForResult<TestActivity>(
            "Content" to content //put参数
        ) {
            if (it == null) {
                //未成功处理
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            } else {
                //处理成功
                val result = it.get<String>("Result")
                editText.setText(result)
            }
        }
//        //接收resultCode
//        startActivityForResult2<TestActivity>(
//            "Content" to content //put参数
//        ) { resultCode, intent ->
//            if (resultCode == RESULT_OK) {
//                //处理成功
//                val result = intent.get<String>("Result")
//                editText.setText(result)
//            } else {
//                //未成功处理
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}