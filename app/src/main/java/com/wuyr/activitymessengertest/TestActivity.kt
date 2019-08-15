package com.wuyr.activitymessengertest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wuyr.activitymessenger.ActivityMessenger
import com.wuyr.activitymessenger.get
import kotlinx.android.synthetic.main.act_test_view.*

/**
 * @author wuyr
 * @github https://github.com/wuyr/ActivityMessenger
 * @since 2019-08-14 下午1:54
 */
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_test_view)

        //获取参数
        editText.setText(intent.get<String>("Content"))
    }

    fun ok(view: View) {
        val result = editText.text.toString()

        //退出并设置参数
        ActivityMessenger.finish(this, "Result" to result)
    }
}