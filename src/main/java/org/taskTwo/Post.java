package org.taskTwo;

import java.util.Objects;

public class Post {
    private String text;
    private Integer likesCount;

    public Post(Integer likesCount){
        this.likesCount = likesCount;
    }

    public Post(String text, Integer likesCount) {
        this.text = text;
        this.likesCount = likesCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(text, post.text) && Objects.equals(likesCount, post.likesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, likesCount);
    }
}
