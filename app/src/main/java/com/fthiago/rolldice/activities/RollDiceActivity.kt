package com.fthiago.rolldice.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fthiago.rolldice.R
import com.fthiago.rolldice.application.RollDiceApplication
import com.fthiago.rolldice.dagger.DaggerFundamentalsComponent
import com.fthiago.rolldice.databinding.ActivityRollDiceBinding
import com.fthiago.rolldice.model.Info
import javax.inject.Inject

class RollDiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRollDiceBinding
    private lateinit var viewModel: RollDiceViewModel

    @Inject
    lateinit var info: Info

    @Inject
    lateinit var app: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_roll_dice)

        (application as RollDiceApplication).getComponentFromDagger().inject(this)

        setViewModel()
        bindViewModel()
        observeImageToDraw()
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
        binding.testUrl = "https://imgix.ranker.com/user_node_img/50023/1000440445/original/happy-poodle-photo-u2?w=650&q=50&fm=pjpg&fit=crop&crop=faces"
        binding.buttonText = "Roll Dice"
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this).get(RollDiceViewModel::class.java)
    }

    private fun observeImageToDraw() {
        viewModel.getImageToDraw().observe(this, Observer {
            binding.diceImage.setImageResource(it)
            binding.buttonText = "Roll Dice $it $app"
        })
    }

}
