package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FUserSettingExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FUserSettingExample() {
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

        public Criteria andShowIndexPageIsNull() {
            addCriterion("show_index_page is null");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageIsNotNull() {
            addCriterion("show_index_page is not null");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageEqualTo(Byte value) {
            addCriterion("show_index_page =", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageNotEqualTo(Byte value) {
            addCriterion("show_index_page <>", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageGreaterThan(Byte value) {
            addCriterion("show_index_page >", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_index_page >=", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageLessThan(Byte value) {
            addCriterion("show_index_page <", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageLessThanOrEqualTo(Byte value) {
            addCriterion("show_index_page <=", value, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageIn(List<Byte> values) {
            addCriterion("show_index_page in", values, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageNotIn(List<Byte> values) {
            addCriterion("show_index_page not in", values, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageBetween(Byte value1, Byte value2) {
            addCriterion("show_index_page between", value1, value2, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowIndexPageNotBetween(Byte value1, Byte value2) {
            addCriterion("show_index_page not between", value1, value2, "showIndexPage");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgIsNull() {
            addCriterion("show_base_msg is null");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgIsNotNull() {
            addCriterion("show_base_msg is not null");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgEqualTo(Byte value) {
            addCriterion("show_base_msg =", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgNotEqualTo(Byte value) {
            addCriterion("show_base_msg <>", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgGreaterThan(Byte value) {
            addCriterion("show_base_msg >", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_base_msg >=", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgLessThan(Byte value) {
            addCriterion("show_base_msg <", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgLessThanOrEqualTo(Byte value) {
            addCriterion("show_base_msg <=", value, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgIn(List<Byte> values) {
            addCriterion("show_base_msg in", values, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgNotIn(List<Byte> values) {
            addCriterion("show_base_msg not in", values, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgBetween(Byte value1, Byte value2) {
            addCriterion("show_base_msg between", value1, value2, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowBaseMsgNotBetween(Byte value1, Byte value2) {
            addCriterion("show_base_msg not between", value1, value2, "showBaseMsg");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestIsNull() {
            addCriterion("show_friend_request is null");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestIsNotNull() {
            addCriterion("show_friend_request is not null");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestEqualTo(Byte value) {
            addCriterion("show_friend_request =", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestNotEqualTo(Byte value) {
            addCriterion("show_friend_request <>", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestGreaterThan(Byte value) {
            addCriterion("show_friend_request >", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_friend_request >=", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestLessThan(Byte value) {
            addCriterion("show_friend_request <", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestLessThanOrEqualTo(Byte value) {
            addCriterion("show_friend_request <=", value, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestIn(List<Byte> values) {
            addCriterion("show_friend_request in", values, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestNotIn(List<Byte> values) {
            addCriterion("show_friend_request not in", values, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestBetween(Byte value1, Byte value2) {
            addCriterion("show_friend_request between", value1, value2, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowFriendRequestNotBetween(Byte value1, Byte value2) {
            addCriterion("show_friend_request not between", value1, value2, "showFriendRequest");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusIsNull() {
            addCriterion("show_living_status is null");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusIsNotNull() {
            addCriterion("show_living_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusEqualTo(Byte value) {
            addCriterion("show_living_status =", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusNotEqualTo(Byte value) {
            addCriterion("show_living_status <>", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusGreaterThan(Byte value) {
            addCriterion("show_living_status >", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_living_status >=", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusLessThan(Byte value) {
            addCriterion("show_living_status <", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("show_living_status <=", value, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusIn(List<Byte> values) {
            addCriterion("show_living_status in", values, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusNotIn(List<Byte> values) {
            addCriterion("show_living_status not in", values, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusBetween(Byte value1, Byte value2) {
            addCriterion("show_living_status between", value1, value2, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowLivingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("show_living_status not between", value1, value2, "showLivingStatus");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteIsNull() {
            addCriterion("show_favorite is null");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteIsNotNull() {
            addCriterion("show_favorite is not null");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteEqualTo(Byte value) {
            addCriterion("show_favorite =", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteNotEqualTo(Byte value) {
            addCriterion("show_favorite <>", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteGreaterThan(Byte value) {
            addCriterion("show_favorite >", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_favorite >=", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteLessThan(Byte value) {
            addCriterion("show_favorite <", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteLessThanOrEqualTo(Byte value) {
            addCriterion("show_favorite <=", value, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteIn(List<Byte> values) {
            addCriterion("show_favorite in", values, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteNotIn(List<Byte> values) {
            addCriterion("show_favorite not in", values, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteBetween(Byte value1, Byte value2) {
            addCriterion("show_favorite between", value1, value2, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andShowFavoriteNotBetween(Byte value1, Byte value2) {
            addCriterion("show_favorite not between", value1, value2, "showFavorite");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusIsNull() {
            addCriterion("msg_read_status is null");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusIsNotNull() {
            addCriterion("msg_read_status is not null");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusEqualTo(Byte value) {
            addCriterion("msg_read_status =", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusNotEqualTo(Byte value) {
            addCriterion("msg_read_status <>", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusGreaterThan(Byte value) {
            addCriterion("msg_read_status >", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("msg_read_status >=", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusLessThan(Byte value) {
            addCriterion("msg_read_status <", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusLessThanOrEqualTo(Byte value) {
            addCriterion("msg_read_status <=", value, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusIn(List<Byte> values) {
            addCriterion("msg_read_status in", values, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusNotIn(List<Byte> values) {
            addCriterion("msg_read_status not in", values, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusBetween(Byte value1, Byte value2) {
            addCriterion("msg_read_status between", value1, value2, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgReadStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("msg_read_status not between", value1, value2, "msgReadStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusIsNull() {
            addCriterion("msg_send_status is null");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusIsNotNull() {
            addCriterion("msg_send_status is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusEqualTo(Byte value) {
            addCriterion("msg_send_status =", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusNotEqualTo(Byte value) {
            addCriterion("msg_send_status <>", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusGreaterThan(Byte value) {
            addCriterion("msg_send_status >", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("msg_send_status >=", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusLessThan(Byte value) {
            addCriterion("msg_send_status <", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusLessThanOrEqualTo(Byte value) {
            addCriterion("msg_send_status <=", value, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusIn(List<Byte> values) {
            addCriterion("msg_send_status in", values, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusNotIn(List<Byte> values) {
            addCriterion("msg_send_status not in", values, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusBetween(Byte value1, Byte value2) {
            addCriterion("msg_send_status between", value1, value2, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andMsgSendStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("msg_send_status not between", value1, value2, "msgSendStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusIsNull() {
            addCriterion("view_msg_status is null");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusIsNotNull() {
            addCriterion("view_msg_status is not null");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusEqualTo(Byte value) {
            addCriterion("view_msg_status =", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusNotEqualTo(Byte value) {
            addCriterion("view_msg_status <>", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusGreaterThan(Byte value) {
            addCriterion("view_msg_status >", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("view_msg_status >=", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusLessThan(Byte value) {
            addCriterion("view_msg_status <", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusLessThanOrEqualTo(Byte value) {
            addCriterion("view_msg_status <=", value, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusIn(List<Byte> values) {
            addCriterion("view_msg_status in", values, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusNotIn(List<Byte> values) {
            addCriterion("view_msg_status not in", values, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusBetween(Byte value1, Byte value2) {
            addCriterion("view_msg_status between", value1, value2, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andViewMsgStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("view_msg_status not between", value1, value2, "viewMsgStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusIsNull() {
            addCriterion("hongniang_status is null");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusIsNotNull() {
            addCriterion("hongniang_status is not null");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusEqualTo(Byte value) {
            addCriterion("hongniang_status =", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusNotEqualTo(Byte value) {
            addCriterion("hongniang_status <>", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusGreaterThan(Byte value) {
            addCriterion("hongniang_status >", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("hongniang_status >=", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusLessThan(Byte value) {
            addCriterion("hongniang_status <", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusLessThanOrEqualTo(Byte value) {
            addCriterion("hongniang_status <=", value, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusIn(List<Byte> values) {
            addCriterion("hongniang_status in", values, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusNotIn(List<Byte> values) {
            addCriterion("hongniang_status not in", values, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusBetween(Byte value1, Byte value2) {
            addCriterion("hongniang_status between", value1, value2, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHongniangStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("hongniang_status not between", value1, value2, "hongniangStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusIsNull() {
            addCriterion("historyview_status is null");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusIsNotNull() {
            addCriterion("historyview_status is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusEqualTo(Byte value) {
            addCriterion("historyview_status =", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusNotEqualTo(Byte value) {
            addCriterion("historyview_status <>", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusGreaterThan(Byte value) {
            addCriterion("historyview_status >", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("historyview_status >=", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusLessThan(Byte value) {
            addCriterion("historyview_status <", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusLessThanOrEqualTo(Byte value) {
            addCriterion("historyview_status <=", value, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusIn(List<Byte> values) {
            addCriterion("historyview_status in", values, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusNotIn(List<Byte> values) {
            addCriterion("historyview_status not in", values, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusBetween(Byte value1, Byte value2) {
            addCriterion("historyview_status between", value1, value2, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andHistoryviewStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("historyview_status not between", value1, value2, "historyviewStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusIsNull() {
            addCriterion("idcard_status is null");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusIsNotNull() {
            addCriterion("idcard_status is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusEqualTo(Byte value) {
            addCriterion("idcard_status =", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusNotEqualTo(Byte value) {
            addCriterion("idcard_status <>", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusGreaterThan(Byte value) {
            addCriterion("idcard_status >", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("idcard_status >=", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusLessThan(Byte value) {
            addCriterion("idcard_status <", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusLessThanOrEqualTo(Byte value) {
            addCriterion("idcard_status <=", value, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusIn(List<Byte> values) {
            addCriterion("idcard_status in", values, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusNotIn(List<Byte> values) {
            addCriterion("idcard_status not in", values, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusBetween(Byte value1, Byte value2) {
            addCriterion("idcard_status between", value1, value2, "idcardStatus");
            return (Criteria) this;
        }

        public Criteria andIdcardStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("idcard_status not between", value1, value2, "idcardStatus");
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