package model;

import javax.persistence.*;

@Entity
@Table
public class Blog {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;
    private Long likeNumber;

    public Blog() {
    }

    public Blog(Long id, String title, String content,Long likeNumber) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likeNumber = likeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }
}
