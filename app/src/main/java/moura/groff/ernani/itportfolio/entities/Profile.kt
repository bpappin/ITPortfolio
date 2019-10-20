package moura.groff.ernani.itportfolio.entities

/*
Entity used for data of the Main View
 */
data class Profile(
        var name: String,
        var role: String,
        var photoUrl: String
) {
    constructor() : this("", "", "")
}