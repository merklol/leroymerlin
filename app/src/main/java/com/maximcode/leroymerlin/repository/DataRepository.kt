package com.maximcode.leroymerlin.repository

import android.content.Context
import androidx.core.content.ContextCompat
import com.maximcode.leroymerlin.R
import com.maximcode.leroymerlin.dto.CatalogueItemSecondVariant
import com.maximcode.leroymerlin.dto.CatalogueItemVariant
import com.maximcode.leroymerlin.dto.DefaultCatalogueItem
import com.maximcode.leroymerlin.dto.ProductItem

class DataRepository(private val context: Context) {

    fun productList() = listOf(
        ProductItem(
            "930,60 ₽/кор.",
            "Ламинат Artens\n«Тангай» 33 класс",
            ContextCompat.getDrawable(context, R.drawable.laminate1)),
        ProductItem(
            "899,21 ₽/кор.",
            "Ламинат Artens\n«Ленасиа» 33 класс",
            ContextCompat.getDrawable(context, R.drawable.laminate2)),
        ProductItem(
            "413 ₽/шт.",
            "Штукатурка гипсовая Knauf Ротбанд",
            ContextCompat.getDrawable(context, R.drawable.plaster1)),
        ProductItem(
            "335 ₽/шт.",
            "Штукатурка гипсовая Волма Слой",
            ContextCompat.getDrawable(context, R.drawable.plaster2)),
        ProductItem(
            "318 ₽/шт.",
            "Штукатурка гипсовая Unis Теплон",
            ContextCompat.getDrawable(context, R.drawable.plaster3)),
        ProductItem(
            "722 ₽/шт.",
            "Грунтовка глубокого проникновения",
            ContextCompat.getDrawable(context, R.drawable.primer)),
        ProductItem(
            "242 ₽/шт.",
            "Мешки для мусора 220л цвет черный",
            ContextCompat.getDrawable(context, R.drawable.trashbags)),
        ProductItem(
            "21 ₽/шт.",
            "Круг отрезной по металлу А54",
            ContextCompat.getDrawable(context, R.drawable.cutoffwheel)),
        ProductItem(
            "125 ₽/шт.",
            "Краска для садовых деревьев 4.0 кг",
            ContextCompat.getDrawable(context, R.drawable.paint)),
        ProductItem(
            "673 ₽/шт.",
            "Шпаклевка полимерная финишная Weber Vetonit LR Plus, 22 кг",
            ContextCompat.getDrawable(context, R.drawable.plaster4)),
        ProductItem(
            "2 491 ₽/шт.",
            "Тачка садовая одноколесная 200 кг/90 л",
            ContextCompat.getDrawable(context, R.drawable.wheelbarrow))
    )

    fun bestPriceList() = listOf(
        ProductItem(
            "1737 ₽/шт.",
            "Обои флизеленовые Erismann",
            ContextCompat.getDrawable(context, R.drawable.wallpaper1)),
        ProductItem(
            "410 ₽/шт.",
            "Обои виниловые Home Color Jardin",
            ContextCompat.getDrawable(context, R.drawable.wallpaper2)),
        ProductItem(
            "126 ₽/шт.",
            "Гель для чистки унитаза Prosept",
            ContextCompat.getDrawable(context, R.drawable.gel)),
        ProductItem(
            "168 ₽/шт.",
            "Средство для удаления известкового налета Prosept",
            ContextCompat.getDrawable(context, R.drawable.remover)),
        ProductItem(
            "328 ₽/шт.",
            "Патрон быстрозажимной Спец 3/8-24 UNF",
            ContextCompat.getDrawable(context, R.drawable.cartridge)),
        ProductItem(
            "3 652 ₽/шт.",
            "Стеллаж Кабуки 60x201x28 см ЛДСП",
            ContextCompat.getDrawable(context, R.drawable.rack)),
        ProductItem(
            "686 ₽/шт.",
            "Лак для мебели V33 ангора 0.5л",
            ContextCompat.getDrawable(context, R.drawable.lacquer)),
        ProductItem(
            "104 ₽/шт.",
            "Контейнер для сыпучих продуктов MIO, 2.1 л",
            ContextCompat.getDrawable(context, R.drawable.container)),
        ProductItem(
            "104 ₽/шт.",
            "Лоток для столовых приборов двойной MIO",
            ContextCompat.getDrawable(context, R.drawable.tray)),
        ProductItem(
            "48 ₽/шт.",
            "Набор крючков для полотенец 1.5x5 см, 5 шт.",
            ContextCompat.getDrawable(context, R.drawable.clotheshook)),
        ProductItem(
            "658 ₽/шт.",
            "Кашпо Idea Дюна ø34 h63 см v42",
            ContextCompat.getDrawable(context, R.drawable.pot)),
        ProductItem(
            "122 ₽/шт.",
            "Салфетка, 35х35 см, микрофибра, 4шт.",
            ContextCompat.getDrawable(context, R.drawable.towels))
    )

    fun catalogue() = listOf(
        CatalogueItemVariant(
            "Каталог",
            ContextCompat.getDrawable(context, R.drawable.list_icon)),
        DefaultCatalogueItem(
            "Сад",
            ContextCompat.getDrawable(context, R.drawable.plant)),
        DefaultCatalogueItem(
            "Освещение",
            ContextCompat.getDrawable(context, R.drawable.table_lamp)),
        DefaultCatalogueItem(
            "Инструменты",
            ContextCompat.getDrawable(context, R.drawable.drill)),
        DefaultCatalogueItem(
            "Строймате-\nриалы",
            ContextCompat.getDrawable(context, R.drawable.brick)),
        DefaultCatalogueItem(
            "Декор",
            ContextCompat.getDrawable(context, R.drawable.wallpaper_roll)),
        CatalogueItemSecondVariant("Смотреть все")
    )
}