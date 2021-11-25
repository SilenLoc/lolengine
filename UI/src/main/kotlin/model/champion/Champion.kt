package model.champion

data class Champion(
    val id: String = "",
    val name: String = "",
    val blurb: String = "",
    val infos: List<Pair<String,Int>>
)

