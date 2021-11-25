package model.api

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty


class ClientModel {
  var observableString: StringProperty = SimpleStringProperty()

  fun getNewestInfo(){
      observableString.set(Client.sendRequest())
  }


}