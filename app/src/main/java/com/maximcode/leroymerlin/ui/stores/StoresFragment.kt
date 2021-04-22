package com.maximcode.leroymerlin.ui.stores

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maximcode.leroymerlin.R
import com.maximcode.leroymerlin.databinding.FragmentStoresBinding

class StoresFragment : Fragment(R.layout.fragment_stores) {
    private val binding by viewBinding(FragmentStoresBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = "Магазины"
    }
}