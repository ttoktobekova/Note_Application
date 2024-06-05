package com.example.noteapp.UI.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.UI.fragment.onBoard.OnBoardPagingFragment
import com.example.noteapp.UI.fragment.onBoard.OnBoardPagingFragment.Companion.ARGS_ON_BOARD_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARGS_ON_BOARD_POSITION, position)
        }
    }
}