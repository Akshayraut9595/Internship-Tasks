package SentimentAnalysis;

import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet,
                                          String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output
        for(int i=0;i<featureSet.length;i++){
            for(String feature:featureSet[i]){
                // getting opinion for each feature in featureSet
                int opinion = getOpinionOnFeature(review.toLowerCase(), feature.toLowerCase(), posOpinionWords, negOpinionWords);
                if(opinion != 0){
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }
        return featureOpinions;
    }

// First invoke checkForWasPhrasePattern and
// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature,
                                           String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if(opinion != 0) return opinion;
        return checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
    }

// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
// You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature,
                                                String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        // checking for positive opinion like { feature + " was " + positiveOpinion}
        for(String positiveOpinion: posOpinionWords){
            if(review.contains(pattern+positiveOpinion)){
                return 1;
            }
        }
        // checking for negative opinion like { feature + " was " + negativeOpinion}
        for(String negativeOpinion: negOpinionWords){
            if(review.contains(pattern+negativeOpinion)){
                return -1;
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
    {
// Extract sentences as feature might appear multiple times. // split() takes a regular expression and "." is a special
// for regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;
        for(String sentence:sentences){
            for(String positiveOpinion:posOpinionWords){
                if(sentence.contains(positiveOpinion+" "+feature)){
                    return 1;
                }
            }
        }
        for(String sentence:sentences){
            for(String negativeOpinion: negOpinionWords){
                if(sentence.contains(negativeOpinion+" "+feature)){
                    return -1;
                }
            }
        }

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
//        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent",
                "amazing", "awesome", "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };
        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}