package proj.xmlws.model.reservation;

import javax.persistence.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

@Entity
public class CommentRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean approvedComment;

    private String contentOfComment;

    @Transient
    private XMLGregorianCalendar commentDate;

    @Column(name = "From_date")
    private LocalDateTime commentDateTime;

    private int rate;

    public CommentRate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isApprovedComment() {
        return approvedComment;
    }

    public void setApprovedComment(boolean approvedComment) {
        this.approvedComment = approvedComment;
    }

    public String getContentOfComment() {
        return contentOfComment;
    }

    public void setContentOfComment(String contentOfComment) {
        this.contentOfComment = contentOfComment;
    }

    public LocalDateTime getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(LocalDateTime commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public XMLGregorianCalendar getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(XMLGregorianCalendar commentDate) {
        this.commentDate = commentDate;
    }
}
