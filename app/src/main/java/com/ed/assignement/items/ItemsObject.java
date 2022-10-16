package com.ed.assignement.items;

/**
 * the model for the item object
 */
public class ItemsObject {
    private String Id;
    private String ParentId;
    private String Slug;
    private String Name;
    private String IconUrl;
    private String UpdatedAt;

    public ItemsObject() {
        super();
    }

    public String getId() {
        return Id;
    }

    public void setId(final String Id) {
        this.Id = Id;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(final String ParentId) {
        this.ParentId = ParentId;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(final String Slug) {
        this.Slug = Slug;
    }

    public String getName() {
        return Name;
    }

    public void setName(final String Name) {
        this.Name = Name;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(final String IconUrl) {
        this.IconUrl = IconUrl;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(final String UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }

}
