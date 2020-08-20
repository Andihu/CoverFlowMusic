package com.hujian.coverflowmusic.bean.album;


/**
 * Auto-generated: 2020-08-20 16:44:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Info {

    private CommentThread commentThread;
    private String latestLikedUsers;
    private boolean liked;
    private String comments;
    private int resourceType;
    private int resourceId;
    private int commentCount;
    private int likedCount;
    private int shareCount;
    private String threadId;

    public void setCommentThread(CommentThread commentThread) {
        this.commentThread = commentThread;
    }

    public CommentThread getCommentThread() {
        return commentThread;
    }

    public void setLatestLikedUsers(String latestLikedUsers) {
        this.latestLikedUsers = latestLikedUsers;
    }

    public String getLatestLikedUsers() {
        return latestLikedUsers;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean getLiked() {
        return liked;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getThreadId() {
        return threadId;
    }

}