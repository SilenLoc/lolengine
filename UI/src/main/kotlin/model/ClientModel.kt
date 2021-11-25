package client

import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import kotlin.concurrent.thread


class ClientModel {
  var observableString: StringProperty = SimpleStringProperty()

  fun getNewestInfo(){
      observableString.set(Client.sendRequest())
  }


}