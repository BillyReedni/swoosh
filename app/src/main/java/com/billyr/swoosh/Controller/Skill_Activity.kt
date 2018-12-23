package com.billyr.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.billyr.swoosh.Utilities.EXTRA_LEAGUE
import com.billyr.swoosh.R
import com.billyr.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill_.*

class Skill_Activity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill_)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClick(view: View){
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }


    fun onSkillFinishedClicked(view: View){
        if (skill !="")
        {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else
        {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT ).show()
        }
    }
}
