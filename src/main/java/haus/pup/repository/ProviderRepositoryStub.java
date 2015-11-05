package haus.pup.repository;

import haus.pup.model.Provider;
import haus.pup.model.Voice;
import haus.pup.tts.TTSProvider;
import haus.pup.tts.impl.IvonaProvider;

import java.util.*;

public class ProviderRepositoryStub implements ProviderRepository {
  Map<String, TTSProvider> providers = new HashMap<String, TTSProvider>();

  public ProviderRepositoryStub() {
    TTSProvider ivona = new IvonaProvider();
    providers.put("ivona",ivona);
  }

  public List<Voice> getVoices(String provider) {
    return providers.get(provider).getVoices();
  }

  public List<Provider> getProviders() {
    List<Provider> providers = new ArrayList<Provider>();

    Provider ivona = new Provider();

    ivona.setId("ivona");

    providers.add(new Provider("ivona"));


    return providers;
  }

}
