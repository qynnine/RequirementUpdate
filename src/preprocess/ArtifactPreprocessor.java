package preprocess;

import util.AppConfigure;

/**
 * Created by niejia on 15/2/22.
 */
public class ArtifactPreprocessor {

//    private static final String stopwordsPath = "data/stopwords/stop-words_english_1_en.txt";
//    private static final String stopwordsPath = "data/stopwords/retro_stopwords.txt";

    public static String handlePureTextFile(String str) {
        str = CleanUp.chararctorClean(str);
        str = CleanUp.lengthFilter(str, 3);
        str = CleanUp.tolowerCase(str);
        str = Snowball.stemming(str);
        str = Stopwords.remover(str, AppConfigure.Stopwords);
        return str;
    }

    public static String handleJavaFile(String str) {
        str = CleanUp.chararctorClean(str);
        str = CamelCase.split(str);
        str = SentenceSplitter.process(str);
        str = CleanUp.lengthFilter(str, 3);
        str = CleanUp.tolowerCase(str);
        str = Snowball.stemming(str);
        str = Stopwords.remover(str, AppConfigure.Stopwords);
        return str;
    }

    public static String handleMethodBody(String str) {
//        str = CleanUp.chararctorClean(str);
//        str = CamelCase.split(str);
//        str = CleanUp.tolowerCase(str);
        str = Stopwords.remover(str, AppConfigure.JavaKeywords);
        return str;
    }
}