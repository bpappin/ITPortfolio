package moura.groff.ernani.itportfolio.entities

/*
Entity used for data of App Portfolio and Game Portfolio View
 */
data class Portfolio(
        var description: String,
        var name: String,
        var photoUrl: String,
        var videoUrl: String
) {
    constructor() : this("", "", "", "")
}