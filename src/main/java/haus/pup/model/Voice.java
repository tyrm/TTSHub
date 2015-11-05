package haus.pup.model;

import haus.pup.tts.Gender;
import haus.pup.tts.Lang;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Voice {

  private String name;
  private Lang lang;
  private Gender gender;

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setGender(String gender) {
    gender = gender.toUpperCase(); //Convert to uppercase to match ENUM

    this.gender = Gender.valueOf(gender);
  }

  public Lang getLang() {
    return lang;
  }

  public void setLang(Lang lang) {
    this.lang = lang;
  }

  public void setLang(String lang) {
    lang = lang.replace('-','_'); //Convert dashes to underscores to match ENUM
    lang = lang.toUpperCase(); //Convert to uppercase to match ENUM

    this.lang = Lang.valueOf(lang);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
