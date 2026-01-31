package com.limbergdv.f1_velocity_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.limbergdv.f1_velocity_app.core.di.AppContainer
import com.limbergdv.f1_velocity_app.core.ui.theme.AppTheme
import com.limbergdv.f1_velocity_app.features.formula1.presentation.navigation.F1Navigation


class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        enableEdgeToEdge()
        setContent {
            AppTheme {F1Navigation(appContainer) }

        }
    }
}
