package com.example.lunchbox

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random


class Lunchrandom : AppCompatActivity() {
    private lateinit var foodNameTextView: TextView
    private lateinit var diceImageView: ImageView
    private lateinit var rollButton: ImageButton
    private val diceImages = arrayOf(
        R.drawable.beefnoodlesshop,
        R.drawable.breakfastshop,
        R.drawable.hambuergershop,
        R.drawable.toastshop,
    )
    private val foodNames = arrayOf(
        "蕭家牛肉麵",
        "呷尚寶",
        "弘爺漢堡",
        "吐司覺得熱",
        "東石便當"
    )
    private var isRolling = false
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunchrandom)

        diceImageView = findViewById(R.id.diceImageView)
        rollButton = findViewById(R.id.rollButton)
        foodNameTextView = findViewById(R.id.foodname)
        rollButton.setOnClickListener {
            if (!isRolling) {
                rollDice()
            }
        }
    }

    private fun rollDice() {
        isRolling = true

        val fadeInAnimator = ObjectAnimator.ofFloat(diceImageView, "alpha", 0f, 1f)
        fadeInAnimator.duration = 500
        fadeInAnimator.interpolator = AccelerateDecelerateInterpolator()

        val fadeOutAnimator = ObjectAnimator.ofFloat(diceImageView, "alpha", 1f, 0f)
        fadeOutAnimator.duration = 500
        fadeOutAnimator.interpolator = AccelerateDecelerateInterpolator()

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(fadeInAnimator, fadeOutAnimator)
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                currentImageIndex++
                if (currentImageIndex < diceImages.size) {
                    diceImageView.setImageResource(diceImages[currentImageIndex])
                    Handler().postDelayed({
                        rollDice()
                    }, 500)
                } else {
                    val randomIndex = (0 until diceImages.size).random()
                    diceImageView.setImageResource(diceImages[randomIndex])
                    isRolling = false
                    currentImageIndex = 0
                    fadeInAnimator.start()
                    showFoodName(randomIndex)
                }
            }
        })

        diceImageView.setImageResource(diceImages[currentImageIndex])
        animatorSet.start()
    }

    fun go_mainPage(v: View) {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }

    fun showFoodName(index: Int) {
        val foodName = foodNames[index]
        foodNameTextView.text = foodName
    }
}
