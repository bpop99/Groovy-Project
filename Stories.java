import java.util.ArrayList;
import java.util.HashMap;

public class Stories {
    
    //I would like to use Article as the value datatype but its not working so far 
    //since groovy imports aren't working for me.
    private HashMap<String, String> dict;

    /**
     * Constructor that initializes map
     */
    public Stories(){
        this.dict = new HashMap<>();
    }

    /**
     *
     * @param headline name of the story
     * @param content context of the story
     */
    public void addStory(String headline, String content){
        this.dict.put(headline, content);
    }

    /**
     * Searches through the content of each title of an article to search whether it contains the desired phrase
     *      and returns the title
     * @param phrase desired content to be searched
     * @return either error message that no content with such data was found or sub header of article found
     */
    public ArrayList<String> search(String phrase){
        ArrayList<String> stories = new ArrayList<>();
        // Check to see if content of each contains
        for (HashMap.Entry<String,String> entry : dict.entrySet()) {
            String content = (entry.getKey()).toLowerCase();
            if (content.contains(phrase.toLowerCase())) {
                stories.add(entry.getValue().toString());
            }
        }
        return stories;
    }


}
