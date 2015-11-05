package haus.pup.repository;

import haus.pup.model.Provider;
import haus.pup.model.Voice;

import java.util.List;
import java.util.Map;

public interface ProviderRepository {
  public List<Voice> getVoices(String provider);
  public List<Voice> getVoicesByLang(String provider, String lang);
  public List<Provider> getProviders();

}
