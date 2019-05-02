package com.tsunghsuanparty.utils.ui.basic_framework_demo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.jakewharton.rxbinding.widget.RxTextView
import com.tsunghsuanparty.commonlib.util.LiveDataBus
import com.tsunghsuanparty.utils.databinding.DemoFragmentBinding
import com.tsunghsuanparty.utils.utils.LogMessage
import java.util.concurrent.TimeUnit


class DemoFragment : Fragment() {

    companion object {
        private val TAG = DemoFragment::class.java.simpleName

//        @JvmStatic
//        @BindingAdapter("convertWeekRankView")
//        fun convertWeekRankView(view: RecyclerView, curHotStatus: Int) {
//            if (curHotStatus == YoutubeConnector.DAILY_HOT_VIDEO) {
//                view.visibility = View.VISIBLE
//            } else {
//                view.visibility = View.GONE
//            }
//        }
    }

    private lateinit var mBinding: DemoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        LogMessage.D(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogMessage.D(TAG, "onCreateView()")
        mBinding = DemoFragmentBinding.inflate(inflater, container, false)
        initUI()

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        LogMessage.D(TAG, "onActivityCreated()")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        LogMessage.D(TAG, "onResume()")
        super.onResume()
    }

    override fun onPause() {
        LogMessage.D(TAG, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        LogMessage.D(TAG, "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        LogMessage.D(TAG, "onDestroy()")
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        LogMessage.D(TAG, "onActivityResult()")
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun initUI() {
        LiveDataBus.get().with("key_test", String::class.java)
            .observe(this, Observer {
                mBinding.demoText.text = it
            })

        RxTextView.textChanges(mBinding.demoEdit)
            .subscribe { charSequence ->
                LiveDataBus.get().with("key_test").value = charSequence.toString()
            }
    }
}
