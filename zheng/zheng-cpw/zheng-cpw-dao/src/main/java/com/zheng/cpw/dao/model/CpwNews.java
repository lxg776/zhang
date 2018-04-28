package com.zheng.cpw.dao.model;

import java.io.Serializable;

public class CpwNews implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createTime;

    private String cover;

    /**
     * 链接
     *
     * @mbg.generated
     */
    private String link;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private String beginTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private String endTime;

    /**
     * timeState
     *
     * @mbg.generated
     */
    private String timeState;

    /**
     * 作者
     *
     * @mbg.generated
     */
    private String author;

    /**
     * 标签
     *
     * @mbg.generated
     */
    private String source;

    /**
     * 身高
     *
     * @mbg.generated
     */
    private String origin;

    /**
     * bootContent
     *
     * @mbg.generated
     */
    private String bootContent;

    /**
     * bootType
     *
     * @mbg.generated
     */
    private String bootType;

    /**
     * 浏览次数
     *
     * @mbg.generated
     */
    private String readCount;

    /**
     * 栏目
     *
     * @mbg.generated
     */
    private String newsColumn;

    /**
     * 职业
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimeState() {
        return timeState;
    }

    public void setTimeState(String timeState) {
        this.timeState = timeState;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBootContent() {
        return bootContent;
    }

    public void setBootContent(String bootContent) {
        this.bootContent = bootContent;
    }

    public String getBootType() {
        return bootType;
    }

    public void setBootType(String bootType) {
        this.bootType = bootType;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getNewsColumn() {
        return newsColumn;
    }

    public void setNewsColumn(String newsColumn) {
        this.newsColumn = newsColumn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", cover=").append(cover);
        sb.append(", link=").append(link);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", timeState=").append(timeState);
        sb.append(", author=").append(author);
        sb.append(", source=").append(source);
        sb.append(", origin=").append(origin);
        sb.append(", bootContent=").append(bootContent);
        sb.append(", bootType=").append(bootType);
        sb.append(", readCount=").append(readCount);
        sb.append(", newsColumn=").append(newsColumn);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CpwNews other = (CpwNews) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getTimeState() == null ? other.getTimeState() == null : this.getTimeState().equals(other.getTimeState()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getOrigin() == null ? other.getOrigin() == null : this.getOrigin().equals(other.getOrigin()))
            && (this.getBootContent() == null ? other.getBootContent() == null : this.getBootContent().equals(other.getBootContent()))
            && (this.getBootType() == null ? other.getBootType() == null : this.getBootType().equals(other.getBootType()))
            && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
            && (this.getNewsColumn() == null ? other.getNewsColumn() == null : this.getNewsColumn().equals(other.getNewsColumn()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getTimeState() == null) ? 0 : getTimeState().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = prime * result + ((getBootContent() == null) ? 0 : getBootContent().hashCode());
        result = prime * result + ((getBootType() == null) ? 0 : getBootType().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getNewsColumn() == null) ? 0 : getNewsColumn().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}