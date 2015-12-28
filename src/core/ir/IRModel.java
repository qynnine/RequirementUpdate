package core.ir;

import document.ArtifactsCollection;
import document.SimilarityMatrix;
import document.TermDocumentMatrix;

/**
 * Created by niejia on 15/2/23.
 */
public interface IRModel {
    public SimilarityMatrix Compute(ArtifactsCollection source, ArtifactsCollection target);

    public TermDocumentMatrix getTermDocumentMatrixOfQueries();

    public TermDocumentMatrix getTermDocumentMatrixOfDocuments();
}
