package haus.pup.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Provider {

  public Provider(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  private String id;

}
