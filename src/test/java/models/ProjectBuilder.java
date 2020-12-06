package models;

public class ProjectBuilder {

    private String name;
    private String announcement;
    private boolean isShowAnnouncementFlag;
    private int typeOfProject;
    private boolean isCompleted;

    private ProjectBuilder() {
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public Project build() {
        return new Project(name, announcement, isShowAnnouncementFlag, typeOfProject, isCompleted);
    }

    public ProjectBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder announcement(String announcement) {
        this.announcement = announcement;
        return this;
    }

    public ProjectBuilder showAnnouncementFlag(boolean showAnnouncementFlag) {
        this.isShowAnnouncementFlag = showAnnouncementFlag;
        return this;
    }

    public ProjectBuilder typeOfProject(int typeOfProject) {
        this.typeOfProject = typeOfProject;
        return this;
    }

    public ProjectBuilder completed(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

}