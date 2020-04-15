package proj.xmlws.UserModule.dto;

public class CommentRateDTO {

    private String contentOfComment;
    private boolean approvedComment;
    private int rate;

    public CommentRateDTO() {

    }

    public String getContentOfComment() {
        return contentOfComment;
    }

    public void setContentOfComment(String contentOfComment) {
        this.contentOfComment = contentOfComment;
    }

    public boolean isApprovedComment() {
        return approvedComment;
    }

    public void setApprovedComment(boolean approvedComment) {
        this.approvedComment = approvedComment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
