package haus.pup.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Phrase {

  private String id;
  private String text;
  public List<PhraseFile> phraseFiles = new ArrayList<PhraseFile>();


  public String getId() {
    return id;
  }
  public void setId(String id) {
    //this.id = id;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
    this.id = getMD5(text);
  }
  public List<PhraseFile> getPhraseFiles() {
    return phraseFiles;
  }
  public void setPhraseFiles(List<PhraseFile> phraseFiles) {
    this.phraseFiles = phraseFiles;
  }
  public void addPhraseFiles(String provider, String voice) {
    PhraseFile phraseFile = new PhraseFile();

    phraseFile.setProvider(provider);
    phraseFile.setVoice(voice);
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
