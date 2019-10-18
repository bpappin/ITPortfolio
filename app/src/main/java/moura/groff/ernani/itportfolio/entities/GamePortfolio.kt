package moura.groff.ernani.itportfolio.entities

data class GamePortfolio (
        var description: String,
        var name: String,
        var photoUrl: String,
        var videoUrl: String
) {
    constructor(): this("","","","")
}