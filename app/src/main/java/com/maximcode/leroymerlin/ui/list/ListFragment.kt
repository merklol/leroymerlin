package com.maximcode.leroymerlin.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maximcode.leroymerlin.R
import com.maximcode.leroymerlin.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private val binding by viewBinding(FragmentListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = "Мой Список"
    }
}