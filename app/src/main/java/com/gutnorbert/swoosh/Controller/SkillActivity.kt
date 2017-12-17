package com.gutnorbert.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.gutnorbert.swoosh.Utilities.EXTRA_LEAGUE
import com.gutnorbert.swoosh.R
import com.gutnorbert.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)

        beginnerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            skill = "beginner"

        }

        ballerSkillBtn.setOnClickListener {
            beginnerSkillBtn.isChecked = false
            skill = "baller"
        }

        skillFinishBtn.setOnClickListener {
            if (skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_LEAGUE,league)
                finishActivity.putExtra(EXTRA_SKILL,skill)
                startActivity(finishActivity)
            }
            else {
                Toast.makeText(this,"Please select a skill level",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
