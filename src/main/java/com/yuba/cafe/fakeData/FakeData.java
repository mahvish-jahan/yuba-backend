package com.yuba.cafe.fakeData;

import com.yuba.cafe.model.Category;
import com.yuba.cafe.model.Filter;
import com.yuba.cafe.model.cart.CartLine;
import com.yuba.cafe.model.Snack;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FakeData {

    public static List<Filter> filters() {
        return List.of(
                new Filter(1L, "Organic", false),
                new Filter(2L, "Gluten-free", false),
                new Filter(3L, "Dairy-free", false),
                new Filter(4L, "Sweet", false),
                new Filter(5L, "Savory", false)
        );
    }

    public static List<Category> categories() {
        return List.of(
                new Category(
                        1L,
                        "Chips & crackers",
                        "https://source.unsplash.com/UsSdMZ78Q3E"
                ),
                new Category(
                        2L,
                        "Fruit snacks",
                        "https://source.unsplash.com/SfP1PtM9Qa8"
                ),
                new Category(
                        3L,
                        "Desserts",
                        "https://source.unsplash.com/_jk8KIyN_uA"
                ),
                new Category(
                        4L,
                        "Nuts",
                        "https://source.unsplash.com/UsSdMZ78Q3E"
                ),
                new Category(
                        5L,
                        "Organic",
                        "https://source.unsplash.com/7meCnGCJ5Ms"
                ),
                new Category(
                        6L,
                        "Gluten Free",
                        "https://source.unsplash.com/m741tj4Cz7M"
                ),
                new Category(
                        7L,
                        "Paleo",
                        "https://source.unsplash.com/dt5-8tThZKg"
                ),
                new Category(
                        8L,
                        "Vegan",
                        "https://source.unsplash.com/ReXxkS1m1H0"
                ),
                new Category(
                        9L,
                        "Vegitarian",
                        "https://source.unsplash.com/IGfIGP5ONV0"
                ),
                new Category(
                        10L,
                        "Whole30",
                        "https://source.unsplash.com/9MzCd76xLGk"
                )
        );
    }

    public static List<Snack> snacks() {
        return List.of(
                new Snack(
                        1L,
                        "Ice Lemon Tea",
                        "https://source.unsplash.com/kbch-i63YTg",
                        40L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "A refreshing and invigorating beverage, ice lemon tea combines the briskness of tea with the tanginess of lemon. The tea is brewed to perfection and then chilled, with a squeeze of fresh lemon added for a citrusy twist. Served over ice, it's a cool and revitalizing drink that offers a delightful balance of flavors.",
                        "Tea leaves, water, lemon, sugar, ice cubes"
                ),
                new Snack(
                        2L,
                        "Rabdi Lassi",
                        "https://source.unsplash.com/Xl8vnC9U4EE",
                        39L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "A traditional Indian drink, rabdi lassi is a creamy and indulgent treat. Made by blending thick yogurt with sweetened condensed milk, it has a rich and velvety texture. Infused with aromatic cardamom and garnished with crushed nuts and saffron, this lassi is a beloved beverage that offers a perfect blend of sweetness and tang.",
                        "Yogurt, sweetened condensed milk, cardamom, nuts (such as almonds or pistachios), saffron"
                ),
                new Snack(
                        3L,
                        "Cold Coffee",
                        "https://source.unsplash.com/44d0W8JhoPc",
                        65L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "A beloved chilled beverage, cold coffee is a delightful alternative to hot coffee. It combines freshly brewed coffee with milk, sugar, and ice, creating a smooth and invigorating drink. Often topped with a dollop of whipped cream and a sprinkle of cocoa, cold coffee is a refreshing pick-me-up for coffee enthusiasts.",
                        "Coffee powder, milk, sugar, ice cubes, whipped cream (optional)"
                ),
                new Snack(
                        4L,
                        "Chocolate With Brownie",
                        "https://source.unsplash.com/_sl-WmfIW-o",
                        69L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "A decadent dessert, chocolate with brownie is a heavenly combination that satisfies any chocolate lover's cravings. A warm, fudgy brownie is topped with a generous drizzle of rich chocolate sauce, creating a harmonious blend of flavors and textures. This dessert is often served with a scoop of creamy vanilla ice cream, enhancing its indulgence.",
                        "Brownie, chocolate sauce or syrup, vanilla ice cream (optional)"
                ),
                new Snack(
                        5L,
                        "Milk Shake",
                        "https://source.unsplash.com/4FujjkcI40g",
                        55L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "Creamy and delightful, a milkshake is a classic beverage that combines milk with various flavors and toppings. It begins with a base of milk, ice cream, and flavorings such as chocolate, vanilla, or strawberry. Blended to perfection, milkshakes offer a velvety texture and are often garnished with whipped cream, sprinkles, or a cherry on top, making them a beloved treat for all ages.",
                        "Milk, ice cream (flavor of your choice), sugar, whipped cream (optional), toppings (such as chocolate syrup, sprinkles, or fruits)"

                ),
                new Snack(
                        6L,
                        "Mountain Dew",
                        "https://source.unsplash.com/xncPCVuhXy8",
                        10L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "Mountain Dew is a citrus-flavored carbonated soft drink known for its energizing and refreshing qualities. With a vibrant yellow color and a bold, zesty taste, it provides a burst of invigoration with each sip. Mountain Dew is a popular choice among those seeking a fizzy and tangy beverage to quench their thirst.",
                        "Carbonated water, high fructose corn syrup, concentrated orange juice, citric acid, natural flavors, caffeine"
                ),
                new Snack(
                        7L,
                        "Coca Cola",
                        "https://source.unsplash.com/5E8_AxMO5xw",
                        20L,
                        "",
                        Set.of("Cold Delights"),
                        50L,
                        "A globally recognized and beloved carbonated soft drink, Coca-Cola is known for its distinctive taste and effervescence. With its iconic red label and refreshing fizz, Coca-Cola offers a perfect balance of sweetness and acidity. It has become a classic choice for many, often enjoyed on its own or as a refreshing complement to various meals.",
                        "Carbonated water, high fructose corn syrup, caramel color, phosphoric acid, natural flavors, caffeine"
                ),
                new Snack(
                        8L,
                        "Berger",
                        "https://source.unsplash.com/xW1D-TOCOTY",
                        39L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "A veg burger is a delicious and satisfying sandwich made with a vegetarian patty placed between two soft burger buns. The patty is typically made from ingredients such as vegetables, legumes, or grains, offering a savory and flavorful bite. Accompanied by toppings like lettuce, tomato, onion, and condiments, veg burgers are a popular choice for those seeking a meat-free alternative.",
                        "Burger buns, vegetable patty, lettuce, tomato, onion, cheese (optional), condiments (such as ketchup, mustard, or mayonnaise)"
                ),
                new Snack(
                        9L,
                        "Veg Noodles",
                        "https://source.unsplash.com/8LdmqR8yE-k",
                        59L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "Veg noodles are a savory and versatile dish made by stir-frying noodles with an assortment of vegetables. The noodles, typically made from wheat or rice, are cooked to perfection and then tossed with a medley of colorful veggies like carrots, bell peppers, cabbage, and beans. Seasoned with aromatic sauces and spices, veg noodles offer a delightful combination of textures and flavors.",
                        "Noodles, mixed vegetables (such as carrots, bell peppers, cabbage, and beans), soy sauce, garlic, ginger, vegetable oil, salt, pepper"
                ),
                new Snack(
                        10L,
                        "Momos",
                        "https://source.unsplash.com/Vj-J5xNjnxA",
                        29L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "Momos are a popular street food originating from Tibet and Nepal, but now enjoyed worldwide. These dumplings are made by stuffing a thin dough with a mixture of seasoned vegetables or meat, then steaming or frying them to perfection. Served with a tangy dipping sauce, momos offer a burst of flavors in each bite and",
                        "Dumpling wrappers, ground meat or vegetables, onion, garlic, ginger, soy sauce, chili sauce, oil, salt, pepper"
                ),
                new Snack(
                        11L,
                        "Grilled Sandwich",
                        "https://source.unsplash.com/ZB8NK8cB4EE",
                        45L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "A grilled sandwich is a classic comfort food made by layering various fillings between two slices of bread and toasting it to golden perfection. The sandwich can be customized with ingredients like cheese, vegetables, meats, or spreads, offering endless possibilities. The result is a warm, crispy, and satisfying treat that is perfect for a quick and delicious meal.",
                        "Bread slices, cheese, vegetables (such as tomatoes, onions, bell peppers), butter or margarine, condiments (such as mayonnaise or mustard)"
                ),
                new Snack(
                        12L,
                        "Hot Dog",
                        "https://source.unsplash.com/4PWmqIUlGFQ",
                        49L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "A hot dog is an iconic street food that consists of a juicy sausage nestled in a soft bun. It is often topped with condiments such as mustard, ketchup, relish, onions, or sauerkraut, providing a burst of flavors with every bite. Hot dogs are a popular choice for casual gatherings, sporting events, or as a quick snack on the go.",
                        "Hot dog buns, sausages, mustard, ketchup, onions, relish, sauerkraut (optional)"
                ),
                new Snack(
                        13L,
                        "French Fries",
                        "https://source.unsplash.com/d5PbKQJ0Lu8",
                        49L,
                        "",
                        Set.of("Snacks"),
                        50L,
                        "Crispy, golden, and utterly irresistible, French fries are a beloved side dish that needs no introduction. Made from sliced potatoes that are deep-fried until perfectly crispy on the outside and tender on the inside, they are seasoned with salt and served piping hot. Whether enjoyed on their own or as a companion to burgers or sandwiches, French fries are a universally loved comfort food.",
                        "Potatoes, vegetable oil, salt"
                ),
                new Snack(
                        14L,
                        "Tea",
                        "https://source.unsplash.com/0h1P3pH599k",
                        10L,
                        "",
                        Set.of("Beverages"),
                        50L,
                        "Tea is a comforting and widely consumed hot beverage made by steeping tea leaves in hot water. With a variety of flavors and types available, including black, green, herbal, or flavored teas, it offers a soothing and aromatic experience. Whether enjoyed with a splash of milk, a squeeze of lemon, or a drizzle of honey, tea is a versatile drink that can be customized to one's taste preferences.",
                        "Tea leaves or tea bags, water, milk (optional), sugar (optional), lemon (optional)"
                ),
                new Snack(
                        15L,
                        "Coffee",
                        "https://source.unsplash.com/VCXk_bO97VQ",
                        15L,
                        "",
                        Set.of("Beverages"),
                        50L,
                        "Coffee is a beloved caffeinated beverage made from roasted coffee beans. It is prepared by brewing the ground beans with hot water, resulting in a flavorful and aromatic drink. Coffee comes in various forms, such as espresso, cappuccino, latte, or drip coffee, offering a range of taste profiles and strengths. Known for its energizing properties, coffee is a popular choice for starting the day or enjoying a cozy break.",
                        "Coffee beans or coffee powder, water, milk (optional), sugar (optional)"
                ),
                new Snack(
                        16L,
                        "Water",
                        "https://source.unsplash.com/edBR3b2JAuA",
                        20L,
                        "",
                        Set.of("Beverages"),
                        50L,
                        "Water is the essential and refreshing drink that quenches thirst and hydrates the body. Clear and tasteless, it is a vital component of a healthy lifestyle. Whether served chilled, at room temperature, or infused with fruits or herbs for added flavor, water is a simple yet vital beverage that keeps us refreshed and revitalized.",
                        "H2O"
                ),
                new Snack(
                        17L,
                        "Pasta",
                        "https://source.unsplash.com/t8hTmte4O_g",
                        69L,
                        "",
                        Set.of("Maggie And Pasta"),
                        50L,
                        "Pasta is a versatile Italian staple made from unleavened dough. It comes in various shapes and sizes, such as spaghetti, penne, or fusilli, and can be paired with a multitude of sauces, from rich tomato-based options to creamy alfredo or pesto. Whether enjoyed with meat, vegetables, or cheese, pasta offers a comforting and hearty meal that satisfies both children and adults.",
                        "Pasta, water, salt, pasta sauce (such as marinara, Alfredo, or pesto), vegetables (optional), meat or seafood (optional)"
                ),
                new Snack(
                        18L,
                        "Maggie",
                        "https://source.unsplash.com/-akn2m7cAOk",
                        39L,
                        "",
                        Set.of("Maggie And Pasta"),
                        50L,
                        "Maggie refers to a brand of instant noodles that are popular in India and other countries. These noodles are quick and easy to prepare, making them a convenient snack or meal option. Maggie noodles are typically boiled and then mixed with a flavoring powder or sauce to create a savory and flavorful dish enjoyed by people of all ages.",
                        "Instant noodles, water, flavoring powder or sauce"
                ),
                new Snack(
                        19L,
                        "Egg Maggie",
                        "https://source.unsplash.com/WB3btWnwjaY",
                        59L,
                        "",
                        Set.of("Maggie And Pasta"),
                        50L,
                        "Egg Maggie is a variation of the popular instant noodle dish where an egg is added to the preparation. While cooking the noodles, an egg is cracked into the boiling water and mixed, resulting in a scrambled or poached egg within the noodles. This variation adds protein and an extra layer of flavor to the dish, making it a satisfying and filling meal option.",
                        "Instant noodles, water, flavoring powder or sauce, egg"
                )
        );
    }

    public static SnackCollection tastyTreats() {
        return new SnackCollection(
                1L,
                "Android's picks",
                snacks().subList(0, 13),
                CollectionType.Highlight
        );
    }

    public static SnackCollection popular() {

        return new SnackCollection(
                2L,
                "Popular on Jetsnack",
                snacks().subList(14, 19),
                CollectionType.Highlight
        );
    }

    public static SnackCollection wfhFavs() {
        return new SnackCollection(
                3L,
                "Android's picks",
                snacks().subList(0, 13),
                CollectionType.Highlight
        );
    }

    public static SnackCollection newlyAdded() {
        return new SnackCollection(
                4L,
                "Popular on Jetsnack",
                snacks().subList(14, 19),
                CollectionType.Highlight
        );
    }

    public static SnackCollection exclusive() {
        return new SnackCollection(
                5L,
                "Android's picks",
                snacks().subList(0, 13),
                CollectionType.Highlight
        );
    }

    public static SnackCollection also() {
        return new SnackCollection(
                6L,
                "Android's picks",
                snacks().subList(0, 13),
                CollectionType.Highlight
        );
    }

    public static SnackCollection inspiredByCart() {
        return new SnackCollection(
                7L,
                "Inspired By Cart",
                snacks().subList(0, 13),
                CollectionType.Highlight
        );
    }

    public static List<SnackCollection> snackCollections() {
        return List.of(
                tastyTreats(),
                popular(),
                wfhFavs(),
                newlyAdded(),
                exclusive()
        );
    }

    public static List<SnackCollection> related() {
        return List.of(
                also(),
                popular()
        );
    }

//    public static List<CartLine> cart() {
//        return List.of(
//                new CartLine(1L, snacks().get(4), 2),
//                new CartLine(2L, snacks().get(6), 3),
//                new CartLine(3L, snacks().get(8), 1)
//        );
//    }
}