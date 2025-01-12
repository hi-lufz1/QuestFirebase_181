package com.example.firebasepam.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebasepam.MahasiswaApplication

object PenyediaViewModel {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    val Factory = viewModelFactory {
        initializer { HomeViewModel(MahasiswaApp().container.mahasiswaRepository) }
        initializer { InsertViewModel(MahasiswaApp().container.mahasiswaRepository) }
    }

    fun CreationExtras.MahasiswaApp(): MahasiswaApplication =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplication)
}
