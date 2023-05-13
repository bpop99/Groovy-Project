class Article {
    String title
    String user
    String url
    String date
    int id
    int score

    Article(String title, String user, String url, String date, int id, int score){
        this.title = title
        this.user = user
        this.url = url
        this.date = date
        this.id = id
        this.score = score
    }

    def String toString(){
        String out
        if (this.date.equals("Null")){
            out = """
Article title: $title
Posted by: $user, has a score of $score points
Link: $url"""
        } else {
            out = """
Article title: $title
Posted by: $user, on $date, has a score of $score points
Link: $url"""
        }
        
        return out
    }
    //Getters and setters below
}