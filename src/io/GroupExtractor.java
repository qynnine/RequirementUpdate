package io;

import core.type.Granularity;
import group.ChangeRegionFetcher;
import group.GroupedByMethodRegion;
import relation.CallRelationGraph;
import relation.RelationInfo;

/**
 * Created by niejia on 15/11/29.
 */
public class GroupExtractor {

    private String oldVersionName;
    private String newVersionName;
    private String oldVersionJar;
    private String newVersionJar;
    private String changesPath;
    private Granularity granularity;
    private CorpusExtractor oldCorpus;
    private CorpusExtractor newCorpus;
    private String exportGroupPath;



    public GroupExtractor(String oldVersionName, String newVersionName, String oldVersionJar, String newVersionJar, String changesPath, Granularity granularity, CorpusExtractor oldCorpus, CorpusExtractor newCorpus, String exportGroupPath) {
        this.oldVersionName = oldVersionName;
        this.newVersionName = newVersionName;
        this.oldVersionJar = oldVersionJar;
        this.newVersionJar = newVersionJar;
        this.changesPath = changesPath;
        this.granularity = granularity;
        this.oldCorpus = oldCorpus;
        this.newCorpus= newCorpus;
        this.exportGroupPath = exportGroupPath;
    }

    public void process() {
        RelationInfo relationInfo = new RelationInfo(oldVersionJar, newVersionJar,
                changesPath, granularity,false);

        RelationInfo completedRelationInfo = new RelationInfo(oldVersionJar, newVersionJar,
                changesPath, granularity, true);
        completedRelationInfo.setPruning(0.5);

        CallRelationGraph changedCallGraph = new CallRelationGraph(relationInfo);
        CallRelationGraph completedCallGraph = new CallRelationGraph(completedRelationInfo);

        RelationInfo oldRelationInfo = new RelationInfo(oldVersionJar,granularity,false);
        RelationInfo newRelationInfo = new RelationInfo(newVersionJar,granularity,false);

        CallRelationGraph oldCallGraph = new CallRelationGraph(oldRelationInfo);
        CallRelationGraph newCallGraph = new CallRelationGraph(newRelationInfo);

        ChangeRegionFetcher fetcher = new ChangeRegionFetcher(changesPath, changedCallGraph,completedCallGraph);
//        fetcher.showChangeRegion();
//        fetcher.showChangeRegionWithoutModifiedPart();


        GroupedByMethodRegion methodRegion = new GroupedByMethodRegion(newCorpus, oldCorpus, exportGroupPath, fetcher, newVersionName, oldVersionName, newCallGraph, oldCallGraph, changedCallGraph, completedCallGraph);
        methodRegion.export();

        methodRegion.showChangeRegion();
    }
}
