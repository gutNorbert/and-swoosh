package com.gutnorbert.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gutnorbert.swoosh.Model.Player
import com.gutnorbert.swoosh.R
import com.gutnorbert.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        mensLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false;
            coedLeagueBtn.isChecked = false;
            player.league = "mens"
        }

        womensLeagueBtn.setOnClickListener {
            mensLeagueBtn.isChecked = false;
            coedLeagueBtn.isChecked = false;
            player.league = "womens"
        }

        coedLeagueBtn.setOnClickListener {
            womensLeagueBtn.isChecked = false;
            mensLeagueBtn.isChecked = false;
            player.league = "coed"
        }
    }



    fun leagueNextClicked(view: View){
        if ( player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER,  player)
            startActivity(skillActivity)
        }
        else{
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
}
