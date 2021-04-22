package com.maximcode.leroymerlin.ui.home

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.maximcode.leroymerlin.repository.DataRepository
import com.maximcode.leroymerlin.R
import com.maximcode.leroymerlin.adapter.ListAdapter
import com.maximcode.leroymerlin.databinding.*
import com.maximcode.leroymerlin.dto.ListItem
import com.maximcode.leroymerlin.utils.MarginDecoration

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBtn.setOnClickListener(clickListener)
        binding.collapsedSearchBtn.setOnClickListener(clickListener)
        binding.barCodeBtn.setOnClickListener {
            Snackbar.make(requireView(), "Сканировать QR code", Snackbar.LENGTH_SHORT).show()
        }

        val context = requireContext()
        val repository = DataRepository(context)
        setupCatalogue(context, repository)
        setupProductList(context, repository)
        setupBestPriceList(context, repository)
    }

    private val clickListener = View.OnClickListener {
        findNavController().navigate(R.id.action_navigation_home_to_navigation_search)
    }

    private fun setupCatalogue(context: Context, dataRepository: DataRepository) {
        binding.catalogueView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        binding.catalogueView.addItemDecoration(MarginDecoration(context, 8))
        binding.catalogueView.adapter = listAdapter(requireView(), dataRepository.catalogue())
    }

    private fun setupProductList(context: Context, dataRepository: DataRepository) {
        binding.productList.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        binding.productList.addItemDecoration(MarginDecoration(context, 8))
        binding.productList.adapter = listAdapter(requireView(), dataRepository.productList())
    }

    private fun setupBestPriceList(context: Context, dataRepository: DataRepository) {
        binding.bestPriceList.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false)
        binding.bestPriceList.addItemDecoration(MarginDecoration(context, 8))
        binding.bestPriceList.adapter = listAdapter(requireView(), dataRepository.bestPriceList())
    }

    private fun listAdapter(view: View, data: List<ListItem>): ListAdapter {
        val adapter = ListAdapter()
        adapter.setItems(data)
        adapter.setOnListItemClickListener {
            Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
        }

        return adapter
    }
}