package haus.pup.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@XmlRootElement
public class PhraseFile {

  private String id;
  private String provider;
  private String voice;

  public String getId() {
    return id;
  }
  public void setId(String id) {
    //this.id = id;
  }
  public String getProvider() {
    return provider;
  }
  public void setProvider(String provider) {
    this.provider = provider;
  }
  public String getVoice() {
    return voice;
  }
  public void setVoice(String voice) {
    this.voice = voice;
  }

  String getMD5(String s) {
    // Safely Create MD5 Message Digest
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    md.update(s.getBytes());
    byte[] digest = md.digest();
    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
      sb.append(String.format("%02x", b & 0xff));
    }

    return sb.toString();
  }
}
