package relation;

import org.apache.commons.collections15.Factory;
import relation.graph.CodeEdge;
import relation.graph.CodeVertex;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by niejia on 15/3/1.
 */
public abstract class RelationGraph {

    protected final Factory<Integer> edgeFactory;
    protected final RelationInfo relationInfo;

    protected Map<Integer, CodeVertex> idCodeVertexMap;
    protected Map<String, CodeVertex> nameCodeVertexMap;

    protected RelationGraph(RelationInfo relationInfo) {
        this.relationInfo = relationInfo;

        edgeFactory = new Factory<Integer>() {
            int i = 1;

            @Override
            public Integer create() {
                return i++;
            }
        };
    }

    public abstract int getVertexesNum();

    public abstract Map<Integer, CodeVertex> getVertexes();
    public abstract List<CodeVertex> getNeighbours(String vertexName);
    public abstract int getNeighboursNum(String vertexName);

    public abstract Collection<CodeEdge> getEdges(String vertexName);

    public abstract List<CodeEdge> getCallEdges();

    public Integer getVertexIdByName(String vertexName) {
        return relationInfo.getVertexIdByName(vertexName);
    }

    public String getVertexNameById(Integer id) {
        return relationInfo.getVertexNameById(id);
    }

    public CodeVertex getCodeVertexByName(String vertexName) {
        return nameCodeVertexMap.get(vertexName);
    }

    public RelationInfo getRelationInfo() {
        return relationInfo;
    }


}
