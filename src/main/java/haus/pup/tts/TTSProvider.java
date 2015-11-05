package haus.pup.tts;

import haus.pup.model.Voice;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.util.List;

@XmlRootElement
public interface TTSProvider {

  public List<Voice> getVoices();
  public FileInputStream getPhraseFile(String voice, String phrase);

}
