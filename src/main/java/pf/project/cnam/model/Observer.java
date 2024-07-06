package pf.project.cnam.model;

public interface Observer {
    void update(String eventType, Object data);
}