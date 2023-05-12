@Grab('org.jodd:jodd-lagarto:6.0.6')
import jodd.jerry.Jerry;
@Grab('org.jodd:jodd-http:6.2.1')
import jodd.http.HttpRequest;
class Scraper {
    def title;
    def site;
    def url;
    def scoreParent;
    def idNum;
    def score;
    def user;
    def posted;
    def form = "yyyy-MM-dd'T'hh:mm:ss";
    def titleTag;
    def date;
    Stories myStories = new Stories();
    public Stories scrape(){
        def articleMap = [:];
        //Make request to website and get the table data
        def link = "https://news.ycombinator.com/";
        def response  = HttpRequest.get(link).send();
        def doc = Jerry.of(response.bodyText());
        def data = doc.find('table');

        //Get the row entries with article data
        def titleData = data.find('table tr.athing');
        def subData = doc.find('table td.subtext');

        //Closure
        titleData.each { item -> 
            //Get the title, url and remove site name from the end of title
            titleTag = item.find('span.titleline').find('a');
            if(titleTag != null){
                title = titleTag.text();
                site = titleTag.find('span.sitestr').text();
                title = title.replaceAll(site, "");
                url = titleTag.attr('href');
            }
            idNum = item.attr('id');
            //Get the data from the subtext td entry
            if(subData != null){
                scoreParent = subData.find("#score_$idNum").parent();
                //Get the score and remove words using regex
                score = scoreParent.find('span.score').text();
                score = score.replaceAll("[^0-9]", "");
                user = scoreParent.find('a.hnuser').text();
                posted = scoreParent.find('span.age').attr('title');
            }
            
            //Form of date received
            form = "yyyy-MM-dd'T'hh:mm:ss";
            //Form of date 
            newForm = "MM-dd-yyyy";
            if (posted != null){
                date = Date.parse(form, posted).format(newForm);
            } else {
                date = "Null";
            }

            //Convert id to Integer
            if (!idNum.equals("")){
                idNum = idNum.toInteger();
            } else {
                idNum = 0;
            }

            //Convert score to Integer
            if (!score.equals("")){
                score = score.toInteger();
            } else {
                score = 0;
            }
            //Make article and add to Stories object
            Article art = new Article(title, user, url, date, idNum, score);
            myStories.addStory(title, art.toString());
        }
        return myStories;
    }


}
