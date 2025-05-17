public class WordPair {
    private String english;
    private String spanish;

    public WordPair(String english, String spanish) {
        this.english = english.toLowerCase();
        this.spanish = spanish.toLowerCase();
    }

    
    // Getters
    public String getEnglish() {
        return english;
    }

    public String getSpanish() {
        return spanish;
    }

    @Override
    public String toString() {
        return english + " - " + spanish;
    }
}