object QuestionsRepository{
    val questions = listOf(
        Question("Putting your phone in rice fixes water damage", false,
            "Rice does not effectively remove moisture."),
        Question("Using keyboard shortcuts improves productivity", true,
            "Shortcuts save time compared to mouse navigation."),
        Question("Charging overnight destroys your battery", false,
            "Modern phones stop charging automatically."),
        Question("Clearing cache can improve app performance", true,
            "Removes temporary files that slow apps."),
        Question("Incognito mode makes you anonymous online", false,
            "It only hides local browsing history.")
    )
}