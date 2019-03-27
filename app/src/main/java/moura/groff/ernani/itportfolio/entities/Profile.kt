package moura.groff.ernani.itportfolio.entities

data class Profile(
        var name: String,
        var role: String
) {
    constructor() : this("", "")
}