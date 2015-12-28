package exp.Aqualush.commit_preprocess;

import io.CommitReader;

/**
 * Created by niejia on 15/12/2.
 */
public class AqualushCommitProcess {
    public static void main(String[] args) {
        CommitReader.process("data/Aqualush/commit", "data/Aqualush/cleaned_commit");
    }
}
