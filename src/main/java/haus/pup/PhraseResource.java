package haus.pup;

import haus.pup.model.Phrase;
import haus.pup.repository.PhraseRepository;
import haus.pup.repository.PhraseRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import java.util.List;

@Path("phrases")
public class PhraseResource {

  private PhraseRepository phraseRepository = new PhraseRepositoryStub();

  @POST
  @Path("activity")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Phrase createPhrase(Phrase p) {
    return p;
  }

  @POST
  @Path("activity")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Phrase createPhraseParams(MultivaluedHashMap<String, String> formParams) {

    return null;
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public List<Phrase> getAllPhrases() {
    return phraseRepository.findAllPhrases();
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  @Path("{phraseId}")
  public Phrase getPhrase(@PathParam ("phraseId") String phraseId) {
    return phraseRepository.findPhrase(phraseId);
  }
}
