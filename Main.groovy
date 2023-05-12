class Main {
    static main(String[] args){
        Scraper myScraper = new Scraper();
        Stories myStories = myScraper.scrape();
        def input;
        def counter;
        ArrayList<String> stories = new ArrayList<>();
        String prompt = 
"""Please provide a topic to filter article headlines: 
Entering no input will print all articles (q to quit)""";
        while(true){
            println(prompt);
            input = System.in.newReader().readLine();
            if(input.toLowerCase().equals("q")){
                break;
            } else {
                stories = myStories.search(input);
            }
            if(stories.size() > 0){
                counter = 1;
                stories.each{ story ->
                    println(counter + ".)" + story);
                    counter++;
                }
            } else {
                println("Error: no articles found for this topic, please try again.");
            }
        }
    }
}