package com.tsunghsuanparty.utils.ui.basic_framework_demo

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.Interpolator
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tsunghsuanparty.utils.databinding.AnimFragmentBinding
import com.tsunghsuanparty.utils.utils.LogMessage


class AnimFragment : Fragment() {

    companion object {
        private val TAG = AnimFragment::class.java.simpleName
    }

    private lateinit var mBinding: AnimFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        LogMessage.D(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogMessage.D(TAG, "onCreateView()")
        mBinding = AnimFragmentBinding.inflate(inflater, container, false)
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
        val adapter = ArrayAdapter.createFromResource(
            context!!, com.tsunghsuanparty.utils.R.array.anim_options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mBinding.animSpinner.adapter = adapter
        mBinding.animSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    when (position) {
                        1 -> translate()
                        2 -> rotate()
                        3 -> fade()
                        4 -> scale()
                        5 -> combineAnims()
                        6 -> valueAnim()
                    }
                }
            }
        }
    }

    private fun translate() {
        val ty1 = ObjectAnimator.ofFloat(mBinding.ball, View.TRANSLATION_Y, 0f, 200f)
        ty1.duration = 1000
        ty1.interpolator = BounceInterpolator()
        ty1.start()
    }

    private fun rotate() {
        val rotate = ObjectAnimator.ofFloat(mBinding.ball, View.ROTATION, -360f, 0f)
        rotate.duration = 1000
        rotate.interpolator = AccelerateInterpolator()
        rotate.start()
    }

    private fun fade() {
        val fade = ObjectAnimator.ofFloat(mBinding.ball, View.ALPHA, 0.2f, 1.0f)
        fade.duration = 1000
        fade.start()
    }

    private fun scale() {
        val anims = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(mBinding.ball, View.SCALE_X, 0.2f, 2.0f)
        val sY = ObjectAnimator.ofFloat(mBinding.ball, View.SCALE_Y, 0.2f, 2.0f)
        anims.duration = 5000
        anims.playTogether(sX, sY)
        anims.interpolator = HesitateInterpolator()
        anims.start()
    }

    private fun combineAnims() {
        val anims1 = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(mBinding.ball, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(mBinding.ball, View.SCALE_Y, 0.2f, 1.0f)
        val fade = ObjectAnimator.ofFloat(mBinding.ball, View.ALPHA, 0.2f, 1.0f)
        anims1.playTogether(sX, sY, fade)
        anims1.duration = 1000

        val anims2 = AnimatorSet()
        val tx1 = ObjectAnimator.ofFloat(mBinding.ball, View.TRANSLATION_Y, 0f, 200f)
        tx1.duration = 1000
        tx1.interpolator = BounceInterpolator()
        val rotate = ObjectAnimator.ofFloat(mBinding.ball, View.ROTATION, -360f, 0f)
        rotate.duration = 1000
        rotate.interpolator = AccelerateInterpolator()
        anims2.playTogether(tx1, rotate)

        val finalAnim = AnimatorSet()
        finalAnim.play(anims1).before(anims2)
        finalAnim.play(anims2)

        finalAnim.addListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(context!!, "Animation Finished", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(context!!, "Animation Started", Toast.LENGTH_SHORT).show()
            }
        })

        finalAnim.start()
    }

    private fun valueAnim() {
        val tx = ValueAnimator.ofFloat(400f, -200f)
        tx.duration = 1000
        tx.addUpdateListener { animation ->
            mBinding.ball.translationX = (animation.animatedValue as Float)
        }
        tx.start()
    }

    inner class HesitateInterpolator : Interpolator {
        override fun getInterpolation(t: Float): Float {
            val x = 2.0f * t - 1.0f
            return 0.5f * (x * x * x + 1.0f)
        }
    }
}
