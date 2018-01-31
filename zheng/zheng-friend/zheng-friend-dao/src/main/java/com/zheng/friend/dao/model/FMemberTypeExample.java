package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FMemberTypeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FMemberTypeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInfoImgIsNull() {
            addCriterion("info_img is null");
            return (Criteria) this;
        }

        public Criteria andInfoImgIsNotNull() {
            addCriterion("info_img is not null");
            return (Criteria) this;
        }

        public Criteria andInfoImgEqualTo(String value) {
            addCriterion("info_img =", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgNotEqualTo(String value) {
            addCriterion("info_img <>", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgGreaterThan(String value) {
            addCriterion("info_img >", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgGreaterThanOrEqualTo(String value) {
            addCriterion("info_img >=", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgLessThan(String value) {
            addCriterion("info_img <", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgLessThanOrEqualTo(String value) {
            addCriterion("info_img <=", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgLike(String value) {
            addCriterion("info_img like", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgNotLike(String value) {
            addCriterion("info_img not like", value, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgIn(List<String> values) {
            addCriterion("info_img in", values, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgNotIn(List<String> values) {
            addCriterion("info_img not in", values, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgBetween(String value1, String value2) {
            addCriterion("info_img between", value1, value2, "infoImg");
            return (Criteria) this;
        }

        public Criteria andInfoImgNotBetween(String value1, String value2) {
            addCriterion("info_img not between", value1, value2, "infoImg");
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andServiceDaysIsNull() {
            addCriterion("service_days is null");
            return (Criteria) this;
        }

        public Criteria andServiceDaysIsNotNull() {
            addCriterion("service_days is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDaysEqualTo(Integer value) {
            addCriterion("service_days =", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysNotEqualTo(Integer value) {
            addCriterion("service_days <>", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysGreaterThan(Integer value) {
            addCriterion("service_days >", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_days >=", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysLessThan(Integer value) {
            addCriterion("service_days <", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysLessThanOrEqualTo(Integer value) {
            addCriterion("service_days <=", value, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysIn(List<Integer> values) {
            addCriterion("service_days in", values, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysNotIn(List<Integer> values) {
            addCriterion("service_days not in", values, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysBetween(Integer value1, Integer value2) {
            addCriterion("service_days between", value1, value2, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andServiceDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("service_days not between", value1, value2, "serviceDays");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Byte value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Byte value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Byte value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Byte value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Byte value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Byte> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Byte> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Byte value1, Byte value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
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