package io;

import preprocess.*;

/**
 * Created by niejia on 15/11/29.
 * Extract corpus at method level for each version of code
 */
public class CorpusExtractor {

    public String codePath;
    public String extractedCorpusPath;
    public String extractedMethodBodyPath;
    public String extractedMethodIdentifierPath;
    public String extractedClassIdentifierPath;

    public String extractedMethodCommentPath;
    public String extractedClassCommentPath;
    public String extractedClassFieldPath;
    public String extractedMethodParameterPath;
    public String extractedClassMethodPath;
    public String extractedClassMethodFullNamePath;

    public CorpusExtractor(String projectName, String versionName) {
        this.codePath = "data/" + projectName + "/code/" + versionName;
        this.extractedCorpusPath = "data/" + projectName + "/ExtractedCorpus";
        this.extractedMethodBodyPath = extractedCorpusPath + "/methodBody/" + versionName;
        this.extractedMethodIdentifierPath = extractedCorpusPath + "/MethodIdentifier/" + versionName;
        this.extractedClassIdentifierPath = extractedCorpusPath + "/ClassIdentifier/" + versionName;
        this.extractedMethodCommentPath = extractedCorpusPath + "/MethodComment/" + versionName;
        this.extractedClassCommentPath = extractedCorpusPath + "/ClassComment/" + versionName;
        this.extractedClassFieldPath = extractedCorpusPath + "/ClassField/" + versionName;
        this.extractedMethodParameterPath =  extractedCorpusPath + "/MethodParameter/" + versionName;

        this.extractedClassMethodPath = extractedCorpusPath + "/ClassMethod/" + versionName;
        this.extractedClassMethodFullNamePath = extractedCorpusPath + "/ClassMethodFullName/" + versionName;
    }

    public void process() {
        ExportMethodBody methodBody = new ExportMethodBody(codePath, extractedMethodBodyPath);
        ExportMethodIdentifier methodIdentifier = new ExportMethodIdentifier(codePath, extractedMethodIdentifierPath);
        ExportClassIdentifier classIdentifier = new ExportClassIdentifier(codePath, extractedClassIdentifierPath);

        ExtractMethodComment methodComment = new ExtractMethodComment(codePath, extractedMethodCommentPath);
        ExtractClassComment classComment = new ExtractClassComment(codePath, extractedClassCommentPath);
        ExtractClassField classField = new ExtractClassField(codePath, extractedClassFieldPath);
        ExtractMethodParameter methodParameter = new ExtractMethodParameter(codePath, extractedMethodParameterPath);
        ExtractClassMethod classMethod = new ExtractClassMethod(codePath, extractedClassMethodPath);

        ExtractClassMethodFullName classMethodFullName = new ExtractClassMethodFullName(codePath, extractedClassMethodFullNamePath);
    }
}
