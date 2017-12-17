package com.gutnorbert.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.gutnorbert.swoosh.Model.Player
import com.gutnorbert.swoosh.R
import com.gutnorbert.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)

        beginnerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            player.skill = "beginner"

        }

        ballerSkillBtn.setOnClickListener {
            beginnerSkillBtn.isChecked = false
            player.skill = "baller"
        }

        skillFinishBtn.setOnClickListener {
            if (player.skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_PLAYER,player)
                startActivity(finishActivity)
            }
            else {
                Toast.makeText(this,"Please select a skill level",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }
}
