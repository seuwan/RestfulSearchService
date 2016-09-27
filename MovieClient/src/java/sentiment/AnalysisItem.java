
package sentiment;


public class AnalysisItem {
    
    private String text = null;
    private String mood = null;
    private String prob = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob = prob;
    }

    public AnalysisItem() {
    }

    public AnalysisItem(String text,String mood,String prob) {       
        this.text = text;
        this.mood = mood;
        this.prob = prob;
    }
    
    
}
