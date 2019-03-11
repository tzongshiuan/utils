package com.tsunghsuanparty.utils.ui.waiting_progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tsunghsuanparty.utils.databinding.WaitingProgressDemoFragmentBinding
import com.tsunghsuanparty.utils.utils.LogMessage

class WaitingProgressDemoFragment : Fragment() {

    companion object {
        private val TAG = WaitingProgressDemoFragment::class.java.simpleName
    }

    private lateinit var mBinding: WaitingProgressDemoFragmentBinding

    private lateinit var viewModel: WaitingProgessDemoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogMessage.D(TAG, "onCreateView()")

        mBinding = WaitingProgressDemoFragmentBinding.inflate(inflater, container, false)

        initUI()

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WaitingProgessDemoViewModel::class.java)
        // TODO: Use the ViewModel
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

    private fun initUI() {
        LogMessage.D(TAG, "initUI()")

//        mBinding.loadingDialogDemoBtn.setOnClickListener {
//            Navigation.findNavController(mBinding.root).navigate(R.id.action_mainFragment_to_loadingDialogDemoFragment)
//        }
    }
}
