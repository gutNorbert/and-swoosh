package com.gutnorbert.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gutnorbert.swoosh.Utilities.EXTRA_LEAGUE
import com.gutnorbert.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false;
            coedLeagueBtn.isChecked = false;
            selectedLeague = "mens"
        }

        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false;
            coedLeagueBtn.isChecked = false;
            selectedLeague = "womens"
        }

        coedLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false;
            mensLeagueBtn.isChecked = false;
            selectedLeague = "coed"
        }
    }



    fun leagueNextClicked(view: View){
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        }
        else{
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
}