package com.hmatewu.ewulife;

public class newsadapter {
    String NFID,Category;
    String Title;
    String Description;
    String Mobile;
    String item_id;
    String Upload_User_ID;

    public newsadapter() {
    }

    public newsadapter(String NFID, String category, String title, String description, String mobile, String item_id, String upload_User_ID) {
        this.NFID = NFID;
        Category = category;
        Title = title;
        Description = description;
        Mobile = mobile;
        this.item_id = item_id;
        Upload_User_ID = upload_User_ID;
    }

    public String getUpload_User_ID() {
        return Upload_User_ID;
    }

    public void setUpload_User_ID(String upload_User_ID) {
        Upload_User_ID = upload_User_ID;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getNFID() {
        return NFID;
    }

    public void setNFID(String NFID) {
        this.NFID = NFID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
