package haus.pup;


import haus.pup.model.Phrase;
import haus.pup.model.Provider;
import haus.pup.model.Voice;
import haus.pup.repository.ProviderRepository;
import haus.pup.repository.ProviderRepositoryStub;
import haus.pup.tts.TTSProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("providers")
public class ProviderResource {

  private ProviderRepository providerRepo = new ProviderRepositoryStub();

  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public List<Provider> getAllProviders() {
    return providerRepo.getProviders();
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  @Path("{providerId}/voices")
  public List<Voice> getVoices(@PathParam("providerId") String providerId) {
    return providerRepo.getVoices(providerId);
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  @Path("{providerId}/voices/{lang}")
  public List<Voice> getVoicesByLang(@PathParam("providerId") String providerId, @PathParam("lang") String lang) {
    return providerRepo.getVoicesByLang(providerId, lang);
  }
}
