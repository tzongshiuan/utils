package com.tsunghsuanparty.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tsunghsuanparty.utils.utils.LogMessage
import com.tsunghsuanparty.utils.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    companion object {
        private val TAG = MainFragment::class.java.simpleName
    }

    private lateinit var mBinding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        LogMessage.D(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        LogMessage.D(TAG, "onCreateView()")

        mBinding = FragmentMainBinding.inflate(inflater, container, false)

        initUI()

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogMessage.D(TAG, "onActivityCreated()")
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

        mBinding.fragmentDemoBtn.setOnClickListener {
            Navigation.findNavController(mBinding.root).navigate(R.id.action_mainFragment_to_demoFragment)
        }

        mBinding.fragmentAnimBtn.setOnClickListener {
            Navigation.findNavController(mBinding.root).navigate(R.id.action_mainFragment_to_animFragment)
        }

        mBinding.fragmentBoomMenuBtn.setOnClickListener {
            Navigation.findNavController(mBinding.root).navigate(R.id.action_mainFragment_to_boomMenuFragment)
        }
    }
}
