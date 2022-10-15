package com.example.hammersystemtest.data


import com.example.hammersystemtest.R
import com.example.hammersystemtest.model.Banner
import com.example.hammersystemtest.model.Menu
import com.example.hammersystemtest.model.ProductCategory

class Datasource(){
    fun loadBanners(): List<Banner> {
        return listOf<Banner>(
            Banner( R.drawable.image1),
            Banner( R.drawable.image2),
            Banner( R.drawable.image3),
            Banner( R.drawable.image4),
            Banner( R.drawable.image5),
            Banner( R.drawable.image6),

        )
    }
    fun loadMenu(): List<Menu>{
        return listOf<Menu>(
            Menu(R.string.titleDish1,R.string.descriptionDish1,R.string.Price1,R.drawable.image1),
            Menu(R.string.titleDish2,R.string.descriptionDish2,R.string.Price2,R.drawable.image2),
            Menu(R.string.titleDish3,R.string.descriptionDish3,R.string.Price3,R.drawable.image3),
            Menu(R.string.titleDish4,R.string.descriptionDish4,R.string.Price4,R.drawable.image4),
            Menu(R.string.titleDish5,R.string.descriptionDish5,R.string.Price5,R.drawable.image5),
            Menu(R.string.titleDish6,R.string.descriptionDish6,R.string.Price6,R.drawable.image6)
        )
    }
    fun loadListProductCategory(): List<ProductCategory>{
        return listOf<ProductCategory>(
            ProductCategory(R.string.pizza),
            ProductCategory(R.string.combo),
            ProductCategory(R.string.desserts),
            ProductCategory(R.string.beverages)
        )
    }
}


