package by.teachmeskills.lapeiko.homework15.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private final Pattern[] blackListPatterns;

    public TextBlackListFilter(String[] badWords) {
        blackListPatterns = new Pattern[badWords.length];
        for (int i = 0; i < badWords.length; i++) {
            blackListPatterns[i] = Pattern.compile("\\b" + Pattern.quote(badWords[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
    }

    public boolean isContainBadWords(String comment) {
        for (int i = 0; i < blackListPatterns.length; i++) {
            Matcher matcher = blackListPatterns[i].matcher(comment);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public int counterForBadWords(String words) {
        int count = 0;
        for (int i = 0; i < blackListPatterns.length; i++) {
            Matcher matcher = blackListPatterns[i].matcher(words);
            while (matcher.find()) {
                    count++;
                }
            }
        return count;
    }

    public String modificatedBadWords(String words) {
        String s = words;
        for (int i = 0; i < blackListPatterns.length; i++) {
            Matcher matcher = blackListPatterns[i].matcher(s);
            s = matcher.replaceAll("####");
        }
        return s;
    }
}
