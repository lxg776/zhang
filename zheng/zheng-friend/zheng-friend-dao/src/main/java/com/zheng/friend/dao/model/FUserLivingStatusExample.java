package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FUserLivingStatusExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FUserLivingStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusIsNull() {
            addCriterion("smoking_status is null");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusIsNotNull() {
            addCriterion("smoking_status is not null");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusEqualTo(Byte value) {
            addCriterion("smoking_status =", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusNotEqualTo(Byte value) {
            addCriterion("smoking_status <>", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusGreaterThan(Byte value) {
            addCriterion("smoking_status >", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("smoking_status >=", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusLessThan(Byte value) {
            addCriterion("smoking_status <", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("smoking_status <=", value, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusIn(List<Byte> values) {
            addCriterion("smoking_status in", values, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusNotIn(List<Byte> values) {
            addCriterion("smoking_status not in", values, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusBetween(Byte value1, Byte value2) {
            addCriterion("smoking_status between", value1, value2, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andSmokingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("smoking_status not between", value1, value2, "smokingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusIsNull() {
            addCriterion("drinking_status is null");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusIsNotNull() {
            addCriterion("drinking_status is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusEqualTo(Byte value) {
            addCriterion("drinking_status =", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusNotEqualTo(Byte value) {
            addCriterion("drinking_status <>", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusGreaterThan(Byte value) {
            addCriterion("drinking_status >", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("drinking_status >=", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusLessThan(Byte value) {
            addCriterion("drinking_status <", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("drinking_status <=", value, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusIn(List<Byte> values) {
            addCriterion("drinking_status in", values, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusNotIn(List<Byte> values) {
            addCriterion("drinking_status not in", values, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusBetween(Byte value1, Byte value2) {
            addCriterion("drinking_status between", value1, value2, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("drinking_status not between", value1, value2, "drinkingStatus");
            return (Criteria) this;
        }

        public Criteria andCookingIsNull() {
            addCriterion("cooking is null");
            return (Criteria) this;
        }

        public Criteria andCookingIsNotNull() {
            addCriterion("cooking is not null");
            return (Criteria) this;
        }

        public Criteria andCookingEqualTo(Byte value) {
            addCriterion("cooking =", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingNotEqualTo(Byte value) {
            addCriterion("cooking <>", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingGreaterThan(Byte value) {
            addCriterion("cooking >", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingGreaterThanOrEqualTo(Byte value) {
            addCriterion("cooking >=", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingLessThan(Byte value) {
            addCriterion("cooking <", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingLessThanOrEqualTo(Byte value) {
            addCriterion("cooking <=", value, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingIn(List<Byte> values) {
            addCriterion("cooking in", values, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingNotIn(List<Byte> values) {
            addCriterion("cooking not in", values, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingBetween(Byte value1, Byte value2) {
            addCriterion("cooking between", value1, value2, "cooking");
            return (Criteria) this;
        }

        public Criteria andCookingNotBetween(Byte value1, Byte value2) {
            addCriterion("cooking not between", value1, value2, "cooking");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsIsNull() {
            addCriterion("live_with_parents is null");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsIsNotNull() {
            addCriterion("live_with_parents is not null");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsEqualTo(String value) {
            addCriterion("live_with_parents =", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsNotEqualTo(String value) {
            addCriterion("live_with_parents <>", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsGreaterThan(String value) {
            addCriterion("live_with_parents >", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsGreaterThanOrEqualTo(String value) {
            addCriterion("live_with_parents >=", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsLessThan(String value) {
            addCriterion("live_with_parents <", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsLessThanOrEqualTo(String value) {
            addCriterion("live_with_parents <=", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsLike(String value) {
            addCriterion("live_with_parents like", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsNotLike(String value) {
            addCriterion("live_with_parents not like", value, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsIn(List<String> values) {
            addCriterion("live_with_parents in", values, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsNotIn(List<String> values) {
            addCriterion("live_with_parents not in", values, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsBetween(String value1, String value2) {
            addCriterion("live_with_parents between", value1, value2, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andLiveWithParentsNotBetween(String value1, String value2) {
            addCriterion("live_with_parents not between", value1, value2, "liveWithParents");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateIsNull() {
            addCriterion("favorite_date is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateIsNotNull() {
            addCriterion("favorite_date is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateEqualTo(String value) {
            addCriterion("favorite_date =", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateNotEqualTo(String value) {
            addCriterion("favorite_date <>", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateGreaterThan(String value) {
            addCriterion("favorite_date >", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_date >=", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateLessThan(String value) {
            addCriterion("favorite_date <", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateLessThanOrEqualTo(String value) {
            addCriterion("favorite_date <=", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateLike(String value) {
            addCriterion("favorite_date like", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateNotLike(String value) {
            addCriterion("favorite_date not like", value, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateIn(List<String> values) {
            addCriterion("favorite_date in", values, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateNotIn(List<String> values) {
            addCriterion("favorite_date not in", values, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateBetween(String value1, String value2) {
            addCriterion("favorite_date between", value1, value2, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteDateNotBetween(String value1, String value2) {
            addCriterion("favorite_date not between", value1, value2, "favoriteDate");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicIsNull() {
            addCriterion("favorite_music is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicIsNotNull() {
            addCriterion("favorite_music is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicEqualTo(String value) {
            addCriterion("favorite_music =", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicNotEqualTo(String value) {
            addCriterion("favorite_music <>", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicGreaterThan(String value) {
            addCriterion("favorite_music >", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_music >=", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicLessThan(String value) {
            addCriterion("favorite_music <", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicLessThanOrEqualTo(String value) {
            addCriterion("favorite_music <=", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicLike(String value) {
            addCriterion("favorite_music like", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicNotLike(String value) {
            addCriterion("favorite_music not like", value, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicIn(List<String> values) {
            addCriterion("favorite_music in", values, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicNotIn(List<String> values) {
            addCriterion("favorite_music not in", values, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicBetween(String value1, String value2) {
            addCriterion("favorite_music between", value1, value2, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteMusicNotBetween(String value1, String value2) {
            addCriterion("favorite_music not between", value1, value2, "favoriteMusic");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmIsNull() {
            addCriterion("favorite_film is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmIsNotNull() {
            addCriterion("favorite_film is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmEqualTo(String value) {
            addCriterion("favorite_film =", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmNotEqualTo(String value) {
            addCriterion("favorite_film <>", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmGreaterThan(String value) {
            addCriterion("favorite_film >", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_film >=", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmLessThan(String value) {
            addCriterion("favorite_film <", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmLessThanOrEqualTo(String value) {
            addCriterion("favorite_film <=", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmLike(String value) {
            addCriterion("favorite_film like", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmNotLike(String value) {
            addCriterion("favorite_film not like", value, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmIn(List<String> values) {
            addCriterion("favorite_film in", values, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmNotIn(List<String> values) {
            addCriterion("favorite_film not in", values, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmBetween(String value1, String value2) {
            addCriterion("favorite_film between", value1, value2, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteFilmNotBetween(String value1, String value2) {
            addCriterion("favorite_film not between", value1, value2, "favoriteFilm");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsIsNull() {
            addCriterion("favorite_sports is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsIsNotNull() {
            addCriterion("favorite_sports is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsEqualTo(String value) {
            addCriterion("favorite_sports =", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsNotEqualTo(String value) {
            addCriterion("favorite_sports <>", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsGreaterThan(String value) {
            addCriterion("favorite_sports >", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_sports >=", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsLessThan(String value) {
            addCriterion("favorite_sports <", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsLessThanOrEqualTo(String value) {
            addCriterion("favorite_sports <=", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsLike(String value) {
            addCriterion("favorite_sports like", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsNotLike(String value) {
            addCriterion("favorite_sports not like", value, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsIn(List<String> values) {
            addCriterion("favorite_sports in", values, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsNotIn(List<String> values) {
            addCriterion("favorite_sports not in", values, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsBetween(String value1, String value2) {
            addCriterion("favorite_sports between", value1, value2, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoriteSportsNotBetween(String value1, String value2) {
            addCriterion("favorite_sports not between", value1, value2, "favoriteSports");
            return (Criteria) this;
        }

        public Criteria andFavoritePetIsNull() {
            addCriterion("favorite_pet is null");
            return (Criteria) this;
        }

        public Criteria andFavoritePetIsNotNull() {
            addCriterion("favorite_pet is not null");
            return (Criteria) this;
        }

        public Criteria andFavoritePetEqualTo(String value) {
            addCriterion("favorite_pet =", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetNotEqualTo(String value) {
            addCriterion("favorite_pet <>", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetGreaterThan(String value) {
            addCriterion("favorite_pet >", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetGreaterThanOrEqualTo(String value) {
            addCriterion("favorite_pet >=", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetLessThan(String value) {
            addCriterion("favorite_pet <", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetLessThanOrEqualTo(String value) {
            addCriterion("favorite_pet <=", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetLike(String value) {
            addCriterion("favorite_pet like", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetNotLike(String value) {
            addCriterion("favorite_pet not like", value, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetIn(List<String> values) {
            addCriterion("favorite_pet in", values, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetNotIn(List<String> values) {
            addCriterion("favorite_pet not in", values, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetBetween(String value1, String value2) {
            addCriterion("favorite_pet between", value1, value2, "favoritePet");
            return (Criteria) this;
        }

        public Criteria andFavoritePetNotBetween(String value1, String value2) {
            addCriterion("favorite_pet not between", value1, value2, "favoritePet");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}