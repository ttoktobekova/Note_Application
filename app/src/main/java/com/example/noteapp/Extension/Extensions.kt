package com.example.noteapp.Extension

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

    fun <T : Any> Fragment.setBackStackData(key: String, data: T, doBack: Boolean) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
        if (doBack) {
            findNavController().navigateUp()
        }
    }

    fun <T : Any> Fragment.getBackStakeData(key: String, result: (T) -> (Unit)) {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)?.observe(viewLifecycleOwner) {
                result(it)
            }
    }
