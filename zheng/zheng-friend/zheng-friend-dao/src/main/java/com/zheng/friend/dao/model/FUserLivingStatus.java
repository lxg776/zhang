package com.zheng.friend.dao.model;

import java.io.Serializable;

public class FUserLivingStatus implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 抽烟状况(0:不抽,1:偶尔抽,2:经常抽)
     *
     * @mbg.generated
     */
    private Byte smokingStatus;

    /**
     * 饮酒状况(0:不喝,1:偶尔喝,2:经常喝)
     *
     * @mbg.generated
     */
    private Byte drinkingStatus;

    /**
     * 饮酒状况(0:不下厨,1:厨艺有待提高,3:上得了厅堂，4.饭店大厨级别)
     *
     * @mbg.generated
     */
    private Byte cooking;

    /**
     * 与父母同住情况
     *
     * @mbg.generated
     */
    private String liveWithParents;

    /**
     * 喜欢怎么样的约会
     *
     * @mbg.generated
     */
    private String favoriteDate;

    /**
     * 喜欢的音乐
     *
     * @mbg.generated
     */
    private String favoriteMusic;

    /**
     * 喜欢的电影
     *
     * @mbg.generated
     */
    private String favoriteFilm;

    /**
     * 喜欢的运动
     *
     * @mbg.generated
     */
    private String favoriteSports;

    /**
     * 喜欢的运动
     *
     * @mbg.generated
     */
    private String favoritePet;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(Byte smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public Byte getDrinkingStatus() {
        return drinkingStatus;
    }

    public void setDrinkingStatus(Byte drinkingStatus) {
        this.drinkingStatus = drinkingStatus;
    }

    public Byte getCooking() {
        return cooking;
    }

    public void setCooking(Byte cooking) {
        this.cooking = cooking;
    }

    public String getLiveWithParents() {
        return liveWithParents;
    }

    public void setLiveWithParents(String liveWithParents) {
        this.liveWithParents = liveWithParents;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public void setFavoriteDate(String favoriteDate) {
        this.favoriteDate = favoriteDate;
    }

    public String getFavoriteMusic() {
        return favoriteMusic;
    }

    public void setFavoriteMusic(String favoriteMusic) {
        this.favoriteMusic = favoriteMusic;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public String getFavoriteSports() {
        return favoriteSports;
    }

    public void setFavoriteSports(String favoriteSports) {
        this.favoriteSports = favoriteSports;
    }

    public String getFavoritePet() {
        return favoritePet;
    }

    public void setFavoritePet(String favoritePet) {
        this.favoritePet = favoritePet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", smokingStatus=").append(smokingStatus);
        sb.append(", drinkingStatus=").append(drinkingStatus);
        sb.append(", cooking=").append(cooking);
        sb.append(", liveWithParents=").append(liveWithParents);
        sb.append(", favoriteDate=").append(favoriteDate);
        sb.append(", favoriteMusic=").append(favoriteMusic);
        sb.append(", favoriteFilm=").append(favoriteFilm);
        sb.append(", favoriteSports=").append(favoriteSports);
        sb.append(", favoritePet=").append(favoritePet);
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
        FUserLivingStatus other = (FUserLivingStatus) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSmokingStatus() == null ? other.getSmokingStatus() == null : this.getSmokingStatus().equals(other.getSmokingStatus()))
            && (this.getDrinkingStatus() == null ? other.getDrinkingStatus() == null : this.getDrinkingStatus().equals(other.getDrinkingStatus()))
            && (this.getCooking() == null ? other.getCooking() == null : this.getCooking().equals(other.getCooking()))
            && (this.getLiveWithParents() == null ? other.getLiveWithParents() == null : this.getLiveWithParents().equals(other.getLiveWithParents()))
            && (this.getFavoriteDate() == null ? other.getFavoriteDate() == null : this.getFavoriteDate().equals(other.getFavoriteDate()))
            && (this.getFavoriteMusic() == null ? other.getFavoriteMusic() == null : this.getFavoriteMusic().equals(other.getFavoriteMusic()))
            && (this.getFavoriteFilm() == null ? other.getFavoriteFilm() == null : this.getFavoriteFilm().equals(other.getFavoriteFilm()))
            && (this.getFavoriteSports() == null ? other.getFavoriteSports() == null : this.getFavoriteSports().equals(other.getFavoriteSports()))
            && (this.getFavoritePet() == null ? other.getFavoritePet() == null : this.getFavoritePet().equals(other.getFavoritePet()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSmokingStatus() == null) ? 0 : getSmokingStatus().hashCode());
        result = prime * result + ((getDrinkingStatus() == null) ? 0 : getDrinkingStatus().hashCode());
        result = prime * result + ((getCooking() == null) ? 0 : getCooking().hashCode());
        result = prime * result + ((getLiveWithParents() == null) ? 0 : getLiveWithParents().hashCode());
        result = prime * result + ((getFavoriteDate() == null) ? 0 : getFavoriteDate().hashCode());
        result = prime * result + ((getFavoriteMusic() == null) ? 0 : getFavoriteMusic().hashCode());
        result = prime * result + ((getFavoriteFilm() == null) ? 0 : getFavoriteFilm().hashCode());
        result = prime * result + ((getFavoriteSports() == null) ? 0 : getFavoriteSports().hashCode());
        result = prime * result + ((getFavoritePet() == null) ? 0 : getFavoritePet().hashCode());
        return result;
    }
}