package com.aldana.ejemplo14

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.setLifecycleOwner(this) //estudiar mas a fondo el LifeCicleOwner
        binding.viewmodelx = scoreViewModel


        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {

            scoreViewModel.scoreTeamA.value = add(scoreViewModel.scoreTeamA.value,1)

    }

    fun addOneTeamB(v: View) {

            scoreViewModel.scoreTeamB.value = add(scoreViewModel.scoreTeamB.value,1)

    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = add(scoreViewModel.scoreTeamA.value,2)

    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = add(scoreViewModel.scoreTeamB.value,2)

    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = add(scoreViewModel.scoreTeamA.value,3)

    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = add(scoreViewModel.scoreTeamB.value,3)

    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA.value ="0"
        scoreViewModel.scoreTeamB.value = "0"


    }

    fun add(a: String?,num:Int):String{
        return (a?.toInt()?.plus(num)).toString()
    }

    // TODO: Limpiando datos

    /*fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }*/

}
