package factory;

import entity.*;

import java.util.ArrayList;

public class DictionaryFactory {

    public static Word createWord(String keyword) {
        return new Word(keyword);
    }

    public static Pronunciation createPronunciation(String ipa) {
        return new Pronunciation(ipa);
    }

    public static NounDefinition createNounDefinition(
            String meaning,
            String sentence,
            String sentenceMeaning,
            String pluralForm) {

        return new NounDefinition(
                meaning,
                sentence,
                sentenceMeaning,
                pluralForm
        );
    }

    public static VerbDefinition createVerbDefinition(
            String meaning,
            String sentence,
            String sentenceMeaning,
            String verbForm,
            String tense) {

        return new VerbDefinition(
                meaning,
                sentence,
                sentenceMeaning,
                verbForm,
                tense
        );
    }

    public static AdjectiveDefinition createAdjectiveDefinition(
            String meaning,
            String sentence,
            String sentenceMeaning,
            String comparisonForm) {

        return new AdjectiveDefinition(
                meaning,
                sentence,
                sentenceMeaning,
                comparisonForm
        );
    }

    public static SynonymousDefinition createSynonymousDefinition() {
        return new SynonymousDefinition(new ArrayList<>());
    }

}