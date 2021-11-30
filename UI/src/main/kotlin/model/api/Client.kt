package model.api


import model.json.ChampionsJson
import model.json.SpecificChampionJson
import model.service.ChampionLoader
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object Client {

  val client: HttpClient = HttpClient.newBuilder().build()

  fun sendLolRequest(): Pair<ChampionsJson, List<SpecificChampionJson>> {
    val response = client.send(createLOLRequest(), HttpResponse.BodyHandlers.ofString())
    println("trying to fetch common champion file")
    val champions = ChampionLoader.loadChampions(response.body())

    val specificResponses = sendChampionsRequest(champions.data.values.map { it.id })

    val specificChampions = ChampionLoader.loadSpecChampions(specificResponses)



    return Pair(champions, specificChampions)
  }

  private fun sendChampionsRequest(ids: List<String>): List<String> = ids.map {
        println("trying to fetch $it")
        val response = client.send(createSpecificChampionRequest(it), HttpResponse.BodyHandlers.ofString())
        val body = response.body()
        body
      }




  private fun createLOLRequest() = HttpRequest.newBuilder().uri(URI.create("https://ddragon.leagueoflegends.com/cdn/11.23.1/data/en_US/champion.json")).build()

  private fun createSpecificChampionRequest(championId:String) =
    HttpRequest
      .newBuilder()
      .uri(
        URI
          .create(
            "https://ddragon.leagueoflegends.com/cdn/11.23.1/data/en_US/champion/$championId.json"
          )).build()

}