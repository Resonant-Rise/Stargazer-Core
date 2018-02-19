package se.resonantri.stargazerutil.api.cap;

import java.util.List;

public class DefaultKnowledgeHandler implements IKnowledgeHandler {

    public List<String> knowledgeList;

    @Override
    public boolean hasKnowledge(String knowledge) {
        return knowledgeList.contains(knowledge);
    }

    @Override
    public void addString(String knowledge) {
        knowledgeList.add(knowledge);
    }

    @Override
    public void removeString(String knowledge) {
        knowledgeList.remove(knowledge);
    }

    public void getLength(){
        knowledgeList.size();
    }
}
