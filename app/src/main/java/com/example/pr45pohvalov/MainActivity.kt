package com.example.pr45pohvalov

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Установка слушателя нажатия для кнопки
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { v: View? ->
            try {
                // Пример кода, который может вызвать исключение
                val number = "Это кнопка".toInt() // Это вызовет NumberFormatException
            } catch (e: NumberFormatException) {
                Log.e(TAG, "Кнопка нажата: " + e.message)
            }
        }

        // Установка слушателя для обработки отступов
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "запуск: Действие начато")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "при возобновлении: Активность возобновлена")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Приложение на паузе")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "на паузе: Действие, основанное на")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "при уничтожении: Активность уничтожена")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
