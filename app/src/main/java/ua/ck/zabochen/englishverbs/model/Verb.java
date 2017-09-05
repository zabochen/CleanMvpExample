package ua.ck.zabochen.englishverbs.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Verb extends RealmObject {

    @PrimaryKey
    private String verb;
    private String verbTranscription;

    private String verbPastSimple;
    private String verbPastSimpleTranscription;

    private String verbPastParticiple;
    private String verbPastParticipleTranscription;

    private String verbTranslation;

    public Verb() {
    }

    public Verb(String verb, String verbTranscription,
                String verbPastSimple, String verbPastSimpleTranscription,
                String verbPastParticiple, String verbPastParticipleTranscription,
                String verbTranslation) {
        this.verb = verb;
        this.verbTranscription = verbTranscription;
        this.verbPastSimple = verbPastSimple;
        this.verbPastSimpleTranscription = verbPastSimpleTranscription;
        this.verbPastParticiple = verbPastParticiple;
        this.verbPastParticipleTranscription = verbPastParticipleTranscription;
        this.verbTranslation = verbTranslation;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getVerbTranscription() {
        return verbTranscription;
    }

    public void setVerbTranscription(String verbTranscription) {
        this.verbTranscription = verbTranscription;
    }

    public String getVerbPastSimple() {
        return verbPastSimple;
    }

    public void setVerbPastSimple(String verbPastSimple) {
        this.verbPastSimple = verbPastSimple;
    }

    public String getVerbPastSimpleTranscription() {
        return verbPastSimpleTranscription;
    }

    public void setVerbPastSimpleTranscription(String verbPastSimpleTranscription) {
        this.verbPastSimpleTranscription = verbPastSimpleTranscription;
    }

    public String getVerbPastParticiple() {
        return verbPastParticiple;
    }

    public void setVerbPastParticiple(String verbPastParticiple) {
        this.verbPastParticiple = verbPastParticiple;
    }

    public String getVerbPastParticipleTranscription() {
        return verbPastParticipleTranscription;
    }

    public void setVerbPastParticipleTranscription(String verbPastParticipleTranscription) {
        this.verbPastParticipleTranscription = verbPastParticipleTranscription;
    }

    public String getVerbTranslation() {
        return verbTranslation;
    }

    public void setVerbTranslation(String verbTranslation) {
        this.verbTranslation = verbTranslation;
    }
}
