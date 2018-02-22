package se.resonantri.stargazerutil.api.cap;

public interface IKnowledgeHandler {
    boolean hasKnowledge(String knowledge);

    void addString(String knowledge);

    void removeString(String knowledge);
}
