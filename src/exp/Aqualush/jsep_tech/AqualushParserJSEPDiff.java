package exp.Aqualush.jsep_tech;

import exp.Aqualush.AqualushSetting;
import io.CorpusExtractor;
import parser.JSEPDiffParser_Version2;

/**
 * Created by niejia on 15/12/3.
 */
public class AqualushParserJSEPDiff {
    public static void main(String[] args) {
        double callMethodGraphThreshold = -1;
        double callClassGraphThreshold = -1;

        CorpusExtractor corpus3 = new CorpusExtractor("Aqualush", "change3");
        CorpusExtractor corpus4 = new CorpusExtractor("Aqualush", "change4");
        CorpusExtractor corpus5 = new CorpusExtractor("Aqualush", "change5");
        CorpusExtractor corpus6 = new CorpusExtractor("Aqualush", "change6");
        CorpusExtractor corpus7 = new CorpusExtractor("Aqualush", "change7");

        JSEPDiffParser_Version2 parser4 = new JSEPDiffParser_Version2("data/Aqualush/JSEP_Diff/Aqualush_change4.txt", corpus4, corpus3,
                "data/Aqualush/grouped_by_jsep_my_version", "Aqualush", "change4");

        parser4.callClassGraphThreshold = callClassGraphThreshold;
        parser4.callMethodGraphThreshold = callMethodGraphThreshold;
        parser4.process(AqualushSetting.Change4_JAR, AqualushSetting.Change3_JAR);

        JSEPDiffParser_Version2 parser5 = new JSEPDiffParser_Version2("data/Aqualush/JSEP_Diff/Aqualush_change5.txt", corpus5, corpus4,
                "data/Aqualush/grouped_by_jsep_my_version", "Aqualush", "change5");
        parser5.callClassGraphThreshold = callClassGraphThreshold;
        parser5.callMethodGraphThreshold = callMethodGraphThreshold;
        parser5.process(AqualushSetting.Change5_JAR, AqualushSetting.Change4_JAR);

        JSEPDiffParser_Version2 parser7 = new JSEPDiffParser_Version2("data/Aqualush/JSEP_Diff/Aqualush_change7.txt", corpus7, corpus6,
                "data/Aqualush/grouped_by_jsep_my_version", "Aqualush", "change7");
        parser7.callClassGraphThreshold = callClassGraphThreshold;
        parser7.callMethodGraphThreshold = callMethodGraphThreshold;
        parser7.process(AqualushSetting.Change7_JAR, AqualushSetting.Change6_JAR);
    }
}
