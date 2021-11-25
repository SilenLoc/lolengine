package lolmodel

import kotlinx.serialization.Serializable

@Serializable
data class Champions(
  val type: String = "",
  val format: String = "",
  val version: String = "",
  val data: Map<String,Champion>
)