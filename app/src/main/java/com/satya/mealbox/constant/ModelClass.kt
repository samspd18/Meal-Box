package com.satya.mealbox.constant

data class Cuisine(var name: String,var imageUrl: String)

class DifferentCuisine {
    companion object {
        val cuisines = arrayOf(
            Cuisine("Indian\nCuisine","https://openthemagazine.com/wp-content/uploads/2020/12/Indiancuisine.jpg"),
            Cuisine("American\nCuisine","https://www.rd.com/wp-content/uploads/2020/11/RD-americas-favorite-foods-FT-Getty-Images-7-JValentine.jpg?fit=700,1024"),
            Cuisine("Spanish\nCuisine","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7hyjfU60e5vcJZKnAbbEnMdz0N-96JOgYYQ&usqp=CAU"),
            Cuisine("Italian\nCuisine","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2UZyjKQizwU_ots5dzXhodOeRcDyHuVj-cg&usqp=CAU"),
            Cuisine("British\nCuisine","https://ihmnotessite.com/wp-content/uploads/2020/04/bc-1024x641.jpg"),
            Cuisine("Mexican\nCuisine","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/traditional-mexican-foods-1621872883.jpg?crop=0.405xw:1.00xh;0.519xw,0&resize=640:*"),
            Cuisine("Japanese\nCuisine","https://cdn.tasteatlas.com//images/toplistarticles/8cc45833c34a4bc99d85375ecfde18f6.jpg?w=375&h=280"),
            Cuisine("French\nCuisine","https://www.chenabgourmet.com/wp-content/uploads/2021/07/4-Taureaux-Spread.jpeg"),
//            Cuisine("European\nCuisine","https://thumbs.dreamstime.com/z/assortment-dishes-european-cuisine-background-food-top-view-176376648.jpg")
        )
    }
}
