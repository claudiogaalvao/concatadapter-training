package com.claudiogalvaodev.concatadaptertraining

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val description: String,
    val price: String,
    @DrawableRes
    val image: Int
)

val products = listOf(
    Product("Funko Freddie Mercury", "Funko do Freddie Mercury inspirada no filme Bohemian Rhapsody", "R$ 129,90", R.drawable.funko1),
    Product("Funko A Freira", "Funko de A Freira inspirada no filme A Freira", "R$ 129,90", R.drawable.funko2),
    Product("Funko Eleven", "Funko da Eleven inspirada na série Stanger Things", "R$ 129,90", R.drawable.funko3),
    Product("Funko Harry Potter", "Funko de Harry Potter inspirada na saga de filmes Harry Potter", "R$ 129,90", R.drawable.funko4),
    Product("Funko Chaves", "Funko de Chaves inspirada na série da televisão Mexicana Chaves", "R$ 129,90", R.drawable.funko5),
    Product("Funko Doutor Estranho", "Funko do Doutor Estranho inspirada na série What If...", "R$ 129,90", R.drawable.funko6),
    Product("Funko Feiticeira Escarlate", "Funko da Feiticeira Escarlate inspirada na série WandaVision", "R$ 129,90", R.drawable.funko7),
    Product("Funko Homem Aranha", "Funko do Homem Aranha inspirada nos filme do Homem Aranha", "R$ 129,90", R.drawable.funko8),
)