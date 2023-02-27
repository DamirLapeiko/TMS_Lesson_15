package by.teachmeskills.lapeiko.homework15.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private final String[] badWords;

    public TextBlackListFilter(String[] badWords) {
        this.badWords = badWords;
    }

    public boolean isContainBadWords(String comment) {
        for (String badWords : badWords) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(comment);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public int CounterForBadWords(String words) {
        int count = 0;
        for (String badWords : badWords) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWords) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(words);
            if (matcher.find()) {
                count++;
            }
        }
        return count;
    }

    public String modificatedBadWords(String words) {
        if (isContainBadWords(words)) {
            for (String badWord : badWords) {
                    words = words.replaceAll(badWord,"####");
            }
        }
        return words;
    }
}
