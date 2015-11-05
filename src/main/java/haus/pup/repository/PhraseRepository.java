package haus.pup.repository;

import haus.pup.model.Phrase;

import java.util.List;

public interface PhraseRepository {
  List<Phrase> findAllPhrases();

  Phrase findPhrase(String phraseId);

  Phrase findPhraseText(String phraseId);
}
