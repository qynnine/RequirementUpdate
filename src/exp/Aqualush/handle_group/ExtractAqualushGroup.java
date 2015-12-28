package exp.Aqualush.handle_group;

import core.type.Granularity;
import exp.Aqualush.AqualushSetting;
import io.CorpusExtractor;
import io.GroupExtractor;

/**
 * Created by niejia on 15/11/29.
 */
public class ExtractAqualushGroup {
    public static void main(String[] args) {

        CorpusExtractor corpus3 = new CorpusExtractor("Aqualush", "change3");
        CorpusExtractor corpus4 = new CorpusExtractor("Aqualush", "change4");
        CorpusExtractor corpus5 = new CorpusExtractor("Aqualush", "change5");
        CorpusExtractor corpus6 = new CorpusExtractor("Aqualush", "change6");
        CorpusExtractor corpus7 = new CorpusExtractor("Aqualush", "change7");
        CorpusExtractor corpus0 = new CorpusExtractor("Aqualush", "change0");
        CorpusExtractor corpus99 = new CorpusExtractor("Aqualush", "change99");

        group("change3", "change4", AqualushSetting.Change3_JAR, AqualushSetting.Change4_JAR,
                AqualushSetting.MethodChanges4, Granularity.METHOD,
                corpus3, corpus4, AqualushSetting.GroupByMethodPath);

        group("change4", "change5", AqualushSetting.Change4_JAR, AqualushSetting.Change5_JAR,
                AqualushSetting.MethodChanges5, Granularity.METHOD,
                corpus4, corpus5, AqualushSetting.GroupByMethodPath);

        group("change6", "change7", AqualushSetting.Change6_JAR, AqualushSetting.Change7_JAR,
                AqualushSetting.MethodChanges7, Granularity.METHOD,
                corpus6, corpus7, AqualushSetting.GroupByMethodPath);

        group("change0", "change99", AqualushSetting.Change0_JAR, AqualushSetting.Change99_JAR,
                AqualushSetting.MethodChanges99, Granularity.METHOD,
                corpus0, corpus99, AqualushSetting.GroupByMethodPath);
    }

    public static void group(String oldVersion, String newVersion, String oldJar, String newJar,
                             String methodChanges, Granularity granularity, CorpusExtractor oldCorpus, CorpusExtractor newCorpus, String groupByMethodPath) {
        System.out.println("------------------------");
        System.out.println("Change " + oldVersion + " to " + newVersion + ":");
        GroupExtractor ge = new GroupExtractor(oldVersion, newVersion, oldJar, newJar, methodChanges, granularity, oldCorpus, newCorpus, groupByMethodPath);
        ge.process();
    }
}
