package com.satya.mealbox.constant

//cuisine model
data class Cuisine(var name: String,var imageUrl: String)
//makes You Happy model
data class MakesYouHappy(var name: String,var imageUrl: String)

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
class DifferentFoodItem {
    companion object {
        val differentFood = arrayOf(
            MakesYouHappy("Healthy","https://cdn.loveandlemons.com/wp-content/uploads/2021/04/green-salad-500x375.jpg"),
            MakesYouHappy("Biryani","https://res.cloudinary.com/swiggy/image/upload/f_auto,q_auto,fl_lossy/nxmlubuz0b1qixa29gov"),
            MakesYouHappy("Chicken","https://recipes.timesofindia.com/thumb/53007558.cms?width=1200&height=900"),
            MakesYouHappy("Paratha","https://imgk.timesnownews.com/story/paratha_0.gif"),
            MakesYouHappy("Rolls","https://www.licious.in/blog/wp-content/uploads/2021/11/Vegetable-Rolls.jpg"),
            MakesYouHappy("Burger","https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YnVyZ2VyfGVufDB8fDB8fA%3D%3D&w=1000&q=80"),
            MakesYouHappy("Pizza","https://thumbs.dreamstime.com/b/pizza-pepperoni-cheese-salami-vegetables-58914487.jpg"),
            MakesYouHappy("Noodles","https://thewoksoflife.com/wp-content/uploads/2020/04/homemade-chinese-egg-noodles-19-e1609271249794.jpg"),
            MakesYouHappy("Momos","https://www.tiffinboxfood.com/wp-content/uploads/2020/03/chicken-momo-1.jpg"),
            MakesYouHappy("Soup","https://www.whiskaffair.com/wp-content/uploads/2016/08/Clear-Chicken-Soup-2-3.jpg"),
            MakesYouHappy("Fries","https://www.awesomecuisine.com/wp-content/uploads/2009/05/french-fries.jpg"),
            MakesYouHappy("Chaat","https://www.cookwithmanali.com/wp-content/uploads/2022/03/Papdi-Chaat-500x500.jpg")
        )
    }
}
