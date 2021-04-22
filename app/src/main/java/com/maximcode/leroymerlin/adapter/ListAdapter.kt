package com.maximcode.leroymerlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.maximcode.leroymerlin.databinding.*
import com.maximcode.leroymerlin.dto.*

private const val DefaultCatalogueItem = 0
private const val CatalogueItemVariant= 1
private const val CatalogueItemSecondVariant= 2
private const val ProductListItem = 3

fun interface OnListItemClickListener {
    fun onListItemClicked(text: String)
}

class ListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<ListItem>()
    private var clickListener: OnListItemClickListener? = null

    fun setOnListItemClickListener(clickListener: OnListItemClickListener) {
        this.clickListener = clickListener
    }

    fun setItems(data: List<ListItem>) {
        items.clear()
        items.addAll(data)
        notifyItemInserted(items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    = when(viewType) {
        DefaultCatalogueItem -> CatalogueViewHolder(
            CatalogueItemViewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener)

        CatalogueItemVariant -> CatalogueViewHolderVariant(
            CatalogueItemViewVariantBinding
                .inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener)

        CatalogueItemSecondVariant -> CatalogueViewHolderSecondVariant(
            CatalogueItemSecondVariantViewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener)

        else -> ProductListItemViewHolder(
            ProductListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CatalogueViewHolder ->
                holder.bind(items[position] as DefaultCatalogueItem)

            is CatalogueViewHolderVariant ->
                holder.bind(items[position] as CatalogueItemVariant)

            is CatalogueViewHolderSecondVariant ->
                holder.bind(items[position] as CatalogueItemSecondVariant)

            is ProductListItemViewHolder ->
                holder.bind(items[position] as ProductItem)
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = when(items[position]) {
        is DefaultCatalogueItem -> DefaultCatalogueItem
        is CatalogueItemVariant -> CatalogueItemVariant
        is CatalogueItemSecondVariant -> CatalogueItemSecondVariant
        else -> ProductListItem
    }
}

class CatalogueViewHolder(
    private val binding: CatalogueItemViewBinding,
    private val clickListener: OnListItemClickListener?
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    fun bind(item: DefaultCatalogueItem) {
        binding.root.setOnClickListener(this)
        binding.title.text = item.title
        binding.imageSlot.setImageDrawable(item.imageDrawable)
    }

    override fun onClick(v: View?) {
        clickListener?.onListItemClicked(binding.title.text.toString())
    }
}

class CatalogueViewHolderVariant(
    private val binding: CatalogueItemViewVariantBinding,
    private val clickListener: OnListItemClickListener?
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    fun bind(item: CatalogueItemVariant) {
        binding.root.setOnClickListener(this)
        binding.title.text = item.title
        binding.imageSlot.setImageDrawable(item.imageDrawable)
    }

    override fun onClick(v: View?) {
        clickListener?.onListItemClicked(binding.title.text.toString())
    }
}

class CatalogueViewHolderSecondVariant(
    private val binding: CatalogueItemSecondVariantViewBinding,
    private val clickListener: OnListItemClickListener?
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    fun bind(item: CatalogueItemSecondVariant) {
        binding.title.text = item.title
        binding.actionBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        clickListener?.onListItemClicked(binding.title.text.toString())
    }
}

class ProductListItemViewHolder(
    private val binding: ProductListItemBinding,
    private val clickListener: OnListItemClickListener?
    ): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    fun bind(item: ProductItem) {
        binding.root.setOnClickListener(this)
        binding.price.text = item.price
        binding.description.text = item.description
        binding.imageSLot.setImageDrawable(item.imageDrawable)
    }

    override fun onClick(v: View?) {
        clickListener?.onListItemClicked(binding.description.text.toString())
    }
}