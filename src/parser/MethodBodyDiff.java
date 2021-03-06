package parser;

import util._;

import java.io.File;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by niejia on 15/11/8.
 */
public class MethodBodyDiff {

    private final String[] content;
    private final String extendName;

    private HashSet<String> addedFileNames;
    private HashSet<String> removedFileNames;
    private HashSet<String> changedFileNames;

    private String newVersionName;
    private String oldVersionName;

    private String exportPath;

    /**
     * @param diffFilePath is the path of file which is generated by unix diff tool
     * @param newVersionName
     * @param oldVersionName
     * @param extendName
     */
    public MethodBodyDiff(String diffFilePath,String newVersionName, String oldVersionName, String extendName) {
        String input = _.readFile(diffFilePath);
        if (input == null) {
            throw new NoSuchFieldError("Can't find diff file.");
        }

        this.exportPath = (new File(diffFilePath)).getParentFile().getPath();

        this.content = input.split("\n");
        this.extendName = extendName;

        this.newVersionName = newVersionName;
        this.oldVersionName = oldVersionName;

        this.addedFileNames = new HashSet<>();
        this.removedFileNames = new HashSet<>();
        this.changedFileNames = new HashSet<>();

        parser();
        exportChanges();
    }

    private void exportChanges() {
        StringBuffer sb = new StringBuffer();

        for (String f : addedFileNames) {
            sb.append("Added " + f);
            sb.append("\n");
        }
        sb.append("\n");

        sb.append("\n");
        for (String f : removedFileNames) {
            sb.append("Removed "+f);
            sb.append("\n");
        }
        sb.append("\n");

        sb.append("\n");
        for (String f : changedFileNames) {
            sb.append("Changed " + f);
            sb.append("\n");
        }

        _.writeFile(sb.toString(), exportPath + "/method_changes_" + newVersionName + "_" + oldVersionName + ".txt");
    }

    public void parser() {
        for (int i = 0; i < content.length; i++) {
            String line = content[i];
            if (line.startsWith("Only in " + newVersionName)) {
                String fileName = fetchFileName(line);
                addedFileNames.add(fileName.split("." + extendName)[0]);
            } else if (line.startsWith("Only in " + oldVersionName)) {
                String fileName = fetchFileName(line);
                removedFileNames.add(fileName.split("." + extendName)[0]);
            } else if (line.startsWith("diff")) {
                String fileName = fetchFileName(line);
                changedFileNames.add(fileName.split("." + extendName)[0]);
            }
        }
    }

    public String fetchFileName(String str) {
        Pattern p= Pattern.compile("[(\\w|<|>).]*\\."+extendName);
        Matcher m= p.matcher(str);

        if (m.find()) {
            String matched = m.group();
            return matched;
        }

        throw new IllegalArgumentException("Can't fetch fileName in " + str);
    }

    public int addedFilesCount() {
        return addedFileNames.size();
    }

    public int removedFilesCount() {
        return removedFileNames.size();
    }

    public int changedFilesCount() {
        return changedFileNames.size();
    }

    public HashSet<String> getAddedFileNames() {
        return addedFileNames;
    }

    public HashSet<String> getChangedFileNames() {
        return changedFileNames;
    }

    public HashSet<String> getRemovedFileNames() {
        return removedFileNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------- division ----------------");
        sb.append("\n");
        sb.append("Compared versions: " + newVersionName + " and " + oldVersionName);
        sb.append("\n");

        sb.append("Added files" + "(" + addedFilesCount() + "):");
        sb.append("\n");
        for (String f : addedFileNames) {
            sb.append("Added " + f);
            sb.append("\n");
        }
        sb.append("\n");

        sb.append("Removed files" + "(" + removedFilesCount() + "):");
        sb.append("\n");
        for (String f : removedFileNames) {
            sb.append("Removed "+f);
            sb.append("\n");
        }
        sb.append("\n");

        sb.append("Changed files" + "(" + changedFilesCount() + "):");
        sb.append("\n");
        for (String f : changedFileNames) {
            sb.append("Changed " + f);
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String diffFile = "data/iTrust/ExtractedCorpus/MethodBody/diff_change99.txt";
        MethodBodyDiff parser = new MethodBodyDiff(diffFile, "v11", "v10", "java");
        parser.parser();

        System.out.println(parser);
    }
}
