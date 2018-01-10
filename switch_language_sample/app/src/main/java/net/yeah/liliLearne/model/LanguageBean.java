package net.yeah.liliLearne.model;


public class LanguageBean {
    private int id;
    private String fullName;
    private String shortName;
    private boolean selected;

    public LanguageBean(int id, String fullName, String shortName, boolean selected) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
