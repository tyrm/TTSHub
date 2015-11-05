package haus.pup.tts.impl;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.ListVoicesResult;
import com.ivona.services.tts.model.Voice;
import haus.pup.tts.TTSProvider;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement
public class IvonaProvider implements TTSProvider{
  final static IvonaSpeechCloudClient speechCloud = new IvonaSpeechCloudClient(
          new ClasspathPropertiesFileCredentialsProvider("IvonaCredentials.properties"));

  private String id = "ivona";

  public String getId() {
    return id;
  }

  public void setId(String id) {
    //this.id = id;
  }


  public IvonaProvider() {
    speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
  }



  public List<haus.pup.model.Voice> getVoices() {
    List<haus.pup.model.Voice> response = new ArrayList<haus.pup.model.Voice>();

    ListVoicesRequest allVoicesRequest = new ListVoicesRequest();
    ListVoicesResult allVoicesResult = speechCloud.listVoices(allVoicesRequest);
    List<Voice> voices = allVoicesResult.getVoices();

    Iterator<Voice> voiceIterator = voices.iterator();
    while (voiceIterator.hasNext()){
      Voice oldVoice = voiceIterator.next();
      haus.pup.model.Voice newVoice = new haus.pup.model.Voice();

      newVoice.setName(oldVoice.getName());
      newVoice.setGender(oldVoice.getGender());
      newVoice.setLang(oldVoice.getLanguage());

      response.add(newVoice);
    }

    return response;
  }

  public FileInputStream getPhraseFile(String voice, String phrase) {
    return null;
  }
}
