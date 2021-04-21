package com.maximcode.leroymerlin.dto

import android.graphics.drawable.Drawable

sealed class ListItem

data class DefaultCatalogueItem(
    val title: String,
    val imageDrawable: Drawable?): ListItem()

data class CatalogueItemVariant(
    val title: String,
    val imageDrawable: Drawable?): ListItem()

data class CatalogueItemSecondVariant(val title: String): ListItem()

data class ProductItem(
    val price: String,
    val description: String,
    val imageDrawable: Drawable?): ListItem()