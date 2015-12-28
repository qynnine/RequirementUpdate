package parser.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niejia on 15/12/21.
 */
public class ClassGroupArtifact {
    private boolean isClassDocSettled;

    private String classDoc;

    private List<String> methodNames;
    private Map<String, String> methodDocs;
    private Map<String, String> methodCallHierarchy;

    private List<String> filedsCorpus;

    private String classHierarchy;

    private String className;


    public ClassGroupArtifact(String className) {
        this.className = className;

        isClassDocSettled = false;
        methodNames = new ArrayList<>();
        methodDocs = new HashMap<>();
        methodCallHierarchy = new HashMap<>();
        filedsCorpus = new ArrayList<>();

        classDoc = "";

        classHierarchy = "";
    }


    public void addClassHierarchy(String classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    private boolean isClassDocSettled() {
        return isClassDocSettled;
    }

//    public void setClassDocSettled(boolean isClassDocSettled) {
//        this.isClassDocSettled = isClassDocSettled;
//    }

//    public String getClassDoc() {
//        return classDoc;
//    }
//
    public void setClassDoc(String classDoc) {
        if (!isClassDocSettled) {
            this.classDoc = classDoc;
            isClassDocSettled = true;
        }
    }

    public void addClassField(String f) {
        filedsCorpus.add(f);
    }

    public void addMethod(String m) {
        methodNames.add(m);
    }

    public void addMethodDoc(String m, String doc) {
        if (methodDocs.containsKey(m)) {
            String existedDoc = methodDocs.get(m);
            methodDocs.put(m, existedDoc + "\n" + doc);
        } else {
            methodDocs.put(m, doc);
        }
    }

    public void addMethodCallHierarchy(String m, String hierarchy) {
        if (methodCallHierarchy.containsKey(m)) {
            String exisetdHierarchy = methodCallHierarchy.get(m);
            methodCallHierarchy.put(m, exisetdHierarchy + "\n" + hierarchy);
        } else {
            methodCallHierarchy.put(m, hierarchy);
        }
    }
//
//    private String extractMethodIdentifier(String name) {
//        String[] tokens = name.split("\\.");
//        return tokens[tokens.length - 2];
//    }
//
//    private String extractFieldIdentifier(String name) {
//        String[] tokens = name.split("\\.");
//        return tokens[tokens.length - 1];
//    }

    private String extractClassIdentifier(String name) {
        String[] tokens = name.split("\\.");
        return tokens[tokens.length - 2];
    }

    private String extractIdentifier(String name) {
        String[] tokens = name.split("\\.");
        return tokens[tokens.length - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(extractIdentifier(className));
        sb.append("\n");
        sb.append(classDoc);
        sb.append("\n");
        sb.append(classHierarchy);
        sb.append("\n");

        for (String method : methodNames) {
            sb.append(extractClassIdentifier(method) + " " + extractIdentifier(method));
            sb.append("\n");
            sb.append(methodCallHierarchy.get(method));
            sb.append("\n");
            sb.append(methodDocs.get(method));
            sb.append("\n");
        }

        for (String field : filedsCorpus) {
            sb.append(extractIdentifier(field));
            sb.append("\n");
        }

        return sb.toString();
    }

//    public List<String> getMethodsCorpus() {
//        return methodNames;
//    }

//    public void setMethodsCorpus(List<String> methodNames) {
//        this.methodNames = methodNames;
//    }

//    public List<String> getFiledsCorpus() {
//        return filedsCorpus;
//    }

//    public void setFiledsCorpus(List<String> filedsCorpus) {
//        this.filedsCorpus = filedsCorpus;
//    }

//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }
}
