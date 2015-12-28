package io;

import util._;

import java.util.HashSet;

/**
 * Created by niejia on 15/11/8.
 */
public class ChangedArtifactsParser {

    public HashSet<String> addedArtifactList;
    public HashSet<String> removedArtifactList;
    public HashSet<String> changedArtifactList;

    public HashSet<String> wholeChangedArtifactList;

    public void parse(String path) {
        String input = _.readFile(path);
        String lines[] = input.split("\n");

        addedArtifactList = new HashSet<>();
        removedArtifactList = new HashSet<>();
        changedArtifactList = new HashSet<>();
        wholeChangedArtifactList = new HashSet<>();

        for (String line : lines) {
            if (line.startsWith("Added")) {
                addedArtifactList.add(line.split(" ")[1]);
            } else if (line.startsWith("Removed")) {
                removedArtifactList.add(line.split(" ")[1]);
            } else if (line.startsWith("Changed")) {
                changedArtifactList.add(line.split(" ")[1]);
            }
        }

        wholeChangedArtifactList.addAll(addedArtifactList);
        wholeChangedArtifactList.addAll(removedArtifactList);
        wholeChangedArtifactList.addAll(changedArtifactList);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Added elements: " + addedArtifactList.size());
        for (String e : addedArtifactList) {
            sb.append(e);
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("Removed elements: " + removedArtifactList.size());
        for (String e : removedArtifactList) {
            sb.append(e);
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("changed elements: " + changedArtifactList.size());
        for (String e : changedArtifactList) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }
}
