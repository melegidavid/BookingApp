package proj.xmlws.UserModule.dto;

import proj.xmlws.UserModule.model.reservation.CommentRate;

import java.util.List;

public class CommentRateListDTO {

    private List<CommentRate> commentRateList;

    public CommentRateListDTO(){

    }

    public List<CommentRate> getCommentRateList() {
        return commentRateList;
    }

    public void setCommentRateList(List<CommentRate> commentRateList) {
        this.commentRateList = commentRateList;
    }
}
