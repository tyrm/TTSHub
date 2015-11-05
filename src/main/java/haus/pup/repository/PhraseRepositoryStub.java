package haus.pup.repository;

import haus.pup.model.Phrase;
import haus.pup.model.PhraseFile;

import java.util.ArrayList;
import java.util.List;

public class PhraseRepositoryStub implements PhraseRepository {

  public List<Phrase> findAllPhrases() {

    List<Phrase> phrases = new ArrayList<Phrase>();
    List<PhraseFile> phrase1files = new ArrayList<PhraseFile>();

    Phrase phrase1 = new Phrase();
    PhraseFile p1file1 = new PhraseFile();
    phrase1.setText("Good Morning.");

    p1file1.setProvider("Ivona");
    p1file1.setVoice("Emma");

    phrase1files.add(p1file1);

    phrase1.setPhraseFiles(phrase1files);

    phrases.add(phrase1);


    return phrases;

  }

  public Phrase findPhrase(String phraseId) {
    Phrase phrase1 = new Phrase();

    return phrase1;
  }

  public Phrase findPhraseText(String phraseId) {
    return null;
  }
}
