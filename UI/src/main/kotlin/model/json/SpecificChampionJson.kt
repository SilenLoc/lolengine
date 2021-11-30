package model.json


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpecificChampionJson(
    @SerialName("data")
    val `data`: Map<String, Champion>,
    @SerialName("format")
    val format: String, // standAloneComplex
    @SerialName("type")
    val type: String, // champion
    @SerialName("version")
    val version: String // 11.23.1
) {
        @Serializable
        data class Champion(
            @SerialName("allytips")
            val allytips: List<String> = emptyList(),
            @SerialName("blurb")
            val blurb: String, // Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...
            @SerialName("enemytips")
            val enemytips: List<String> = emptyList(),
            @SerialName("id")
            val id: String, // Aatrox
            @SerialName("image")
            val image: Image,
            @SerialName("info")
            val info: Info,
            @SerialName("key")
            val key: String, // 266
            @SerialName("lore")
            val lore: String, // Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find freedom once more, corrupting and transforming those foolish enough to try and wield the magical weapon that contained his essence. Now, with stolen flesh, he walks Runeterra in a brutal approximation of his previous form, seeking an apocalyptic and long overdue vengeance.
            @SerialName("name")
            val name: String, // Aatrox
            @SerialName("partype")
            val partype: String, // Blood Well
            @SerialName("passive")
            val passive: Passive,
            @SerialName("recommended")
            val recommended: List<String> = emptyList(),
            @SerialName("skins")
            val skins: List<Skin>,
            @SerialName("spells")
            val spells: List<Spell>,
            @SerialName("stats")
            val stats: Stats,
            @SerialName("tags")
            val tags: List<String> = emptyList(),
            @SerialName("title")
            val title: String // the Darkin Blade
        ) {
            @Serializable
            data class Image(
                @SerialName("full")
                val full: String, // Aatrox.png
                @SerialName("group")
                val group: String, // champion
                @SerialName("h")
                val h: Double, // 48
                @SerialName("sprite")
                val sprite: String, // champion0.png
                @SerialName("w")
                val w: Double, // 48
                @SerialName("x")
                val x: Double, // 0
                @SerialName("y")
                val y: Double // 0
            )

            @Serializable
            data class Info(
                @SerialName("attack")
                val attack: Double, // 8
                @SerialName("defense")
                val defense: Double, // 4
                @SerialName("difficulty")
                val difficulty: Double, // 4
                @SerialName("magic")
                val magic: Double // 3
            )

            @Serializable
            data class Passive(
                @SerialName("description")
                val description: String, // Periodically, Aatrox's next basic attack deals bonus <physicalDamage>physical damage</physicalDamage> and heals him, based on the target's max health. 
                @SerialName("image")
                val image: Image,
                @SerialName("name")
                val name: String // Deathbringer Stance
            ) {
                @Serializable
                data class Image(
                    @SerialName("full")
                    val full: String, // Aatrox_Passive.png
                    @SerialName("group")
                    val group: String, // passive
                    @SerialName("h")
                    val h: Double, // 48
                    @SerialName("sprite")
                    val sprite: String, // passive0.png
                    @SerialName("w")
                    val w: Double, // 48
                    @SerialName("x")
                    val x: Double, // 0
                    @SerialName("y")
                    val y: Double // 0
                )
            }

            @Serializable
            data class Skin(
                @SerialName("chromas")
                val chromas: Boolean, // false
                @SerialName("id")
                val id: String, // 266000
                @SerialName("name")
                val name: String, // default
                @SerialName("num")
                val num: Double // 0
            )

            @Serializable
            data class Spell(
                @SerialName("cooldown")
                val cooldown: List<Double>,
                @SerialName("cooldownBurn")
                val cooldownBurn: String, // 14/12/10/8/6
                @SerialName("cost")
                val cost: List<Double>,
                @SerialName("costBurn")
                val costBurn: String, // 0
                @SerialName("costType")
                val costType: String, // No Cost
                @SerialName("datavalues")
                val datavalues: Datavalues,
                @SerialName("description")
                val description: String, // Aatrox slams his greatsword down, dealing physical damage. He can swing three times, each with a different area of effect.
                @SerialName("effect")
                val effect: List<List<Double>?> = emptyList(),
                @SerialName("effectBurn")
                val effectBurn: List<String?>? = emptyList(),
                @SerialName("id")
                val id: String, // AatroxQ
                @SerialName("image")
                val image: Image,
                @SerialName("leveltip")
                val leveltip: Leveltip,
                @SerialName("maxammo")
                val maxammo: String, // -1
                @SerialName("maxrank")
                val maxrank: Double, // 5
                @SerialName("name")
                val name: String, // The Darkin Blade
                @SerialName("range")
                val range: List<Double>,
                @SerialName("rangeBurn")
                val rangeBurn: String, // 25000
                @SerialName("resource")
                val resource: String, // No Cost
                @SerialName("tooltip")
                val tooltip: String, // Aatrox slams his greatsword, dealing <physicalDamage>{{ qdamage }} physical damage</physicalDamage>. If they are hit on the edge, they are briefly <status>Knocked Up</status> and they take <physicalDamage>{{ qedgedamage }}</physicalDamage> instead. This Ability can be <recast>Recast</recast> twice, each one changing shape and dealing 25% more damage than the previous one.
                @SerialName("vars")
                val vars: List<String>
            ) {
                @Serializable
                class Datavalues

                @Serializable
                data class Image(
                    @SerialName("full")
                    val full: String, // AatroxQ.png
                    @SerialName("group")
                    val group: String, // spell
                    @SerialName("h")
                    val h: Double, // 48
                    @SerialName("sprite")
                    val sprite: String, // spell0.png
                    @SerialName("w")
                    val w: Double, // 48
                    @SerialName("x")
                    val x: Double, // 288
                    @SerialName("y")
                    val y: Double // 48
                )

                @Serializable
                data class Leveltip(
                    @SerialName("effect")
                    val effect: List<String>,
                    @SerialName("label")
                    val label: List<String>
                )
            }

            @Serializable
            data class Stats(
                @SerialName("armor")
                val armor: Double, // 38
                @SerialName("armorperlevel")
                val armorperlevel: Double, // 3.25
                @SerialName("attackdamage")
                val attackdamage: Double, // 60
                @SerialName("attackdamageperlevel")
                val attackdamageperlevel: Double, // 5
                @SerialName("attackrange")
                val attackrange: Double, // 175
                @SerialName("attackspeed")
                val attackspeed: Double, // 0.651
                @SerialName("attackspeedperlevel")
                val attackspeedperlevel: Double, // 2.5
                @SerialName("crit")
                val crit: Double, // 0
                @SerialName("critperlevel")
                val critperlevel: Double, // 0
                @SerialName("hp")
                val hp: Double, // 580
                @SerialName("hpperlevel")
                val hpperlevel: Double, // 90
                @SerialName("hpregen")
                val hpregen: Double, // 3
                @SerialName("hpregenperlevel")
                val hpregenperlevel: Double, // 1
                @SerialName("movespeed")
                val movespeed: Double, // 345
                @SerialName("mp")
                val mp: Double, // 0
                @SerialName("mpperlevel")
                val mpperlevel: Double, // 0
                @SerialName("mpregen")
                val mpregen: Double, // 0
                @SerialName("mpregenperlevel")
                val mpregenperlevel: Double, // 0
                @SerialName("spellblock")
                val spellblock: Double, // 32
                @SerialName("spellblockperlevel")
                val spellblockperlevel: Double // 1.25
            )
        }

}