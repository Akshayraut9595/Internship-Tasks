public class APIResponseParser {
    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "</title>";
        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        endRule = "</original_publication_year>";
        startRule = "<original_publication_year type=\"integer\">";
        int publication_year = Integer.parseInt(parse(response, startRule, endRule));
        book.setPublicationYear(publication_year);

        endRule = "</average_rating>";
        startRule = "<average_rating>";
        double average_rating = Double.parseDouble(parse(response, startRule, endRule));
        book.setAverageRating(average_rating);

        endRule = "</ratings_count>";
        startRule = "<ratings_count type=\"integer\">";
        int rating_count = Integer.parseInt(parse(response, startRule, endRule));
        book.setRatingsCount(rating_count);

        endRule = "</image_url>";
        startRule = "<image_url>";
        String image_url = parse(response, startRule, endRule);
        book.setImageUrl(image_url);

        endRule = "</name>";
        startRule = "<name>";
        String author = parse(response, startRule, endRule);
        book.setAuthor(author);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startingIndex = response.indexOf(startRule);
        int endingIndex = response.indexOf(endRule);
        String data = response.substring(startingIndex+startRule.length(), endingIndex);
        if(data.contains(",")){
            data = data.replace(",", "");
        }
        return data;
    }
//    write overloaded parse method with the 3 parameters response,startRule, endRule
     public static void main(String[] args) {
        String response = "<work>"+
                "<id type=\"integer\">2361393</id>"+
                "<books_count type=\"integer\">813</books_count>"+
                "<ratings_count type=\"integer\">1,16,315</ratings_count>"+
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>"+
                "<original_publication_year type=\"integer\">1854</original_publication_year>"+
                "<original_publication_month type=\"integer\" nil=\"true\"/>"+
                "<original_publication_day type=\"integer\" nil=\"true\"/>"+
                "<average_rating>3.79</average_rating>"+
                "<best_book type=\"Book\">"+
                    "<id type=\"integer\">16902</id>"+
                    "<title>Walden</title>"+
                    "<author>"+
                        "<id type=\"integer\">10264</id>"+
                        "<name>Henry David Thoreau</name>"+
                    "</author>"+
                    "<image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>"+
                    "<small_image_url>http://images.gr-assets.com/books/1465675526s/16902.jpg</small_image_url>"+
                "</best_book>"+
            "</work>";
        Book book = APIResponseParser.parse(response);
        System.out.println("Title: "+book.getTitle());
        System.out.println("Author: "+book.getAuthor());
        System.out.println("AverageRating: "+book.getAverageRating());
        System.out.println("RatingsCount: "+book.getRatingsCount());
        System.out.println("PublicationYear: "+book.getPublicationYear());
        System.out.println("ImageUrl: "+book.getImageUrl());
    }
}
