package client

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object Client {


  fun sendRequest(): String? {
    val client = HttpClient.newBuilder().build()
    val response = client.send(createLOLRequest(), HttpResponse.BodyHandlers.ofString())
    return response.body()
  }

  private fun createLOLRequest() = HttpRequest.newBuilder().uri(URI.create("https://ddragon.leagueoflegends.com/cdn/11.23.1/data/en_US/champion.json")).build()


}