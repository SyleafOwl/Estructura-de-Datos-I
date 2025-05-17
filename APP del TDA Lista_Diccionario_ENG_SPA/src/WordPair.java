public class WordPair {
    private String english;
    private String spanish;

    public WordPair(String english, String spanish) {
        this.english = english.toLowerCase();
        this.spanish = spanish.toLowerCase();
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    @Override
    public String toString() {
        return "WordPair [english=" + english + ", spanish=" + spanish + "]";
    }
   
}