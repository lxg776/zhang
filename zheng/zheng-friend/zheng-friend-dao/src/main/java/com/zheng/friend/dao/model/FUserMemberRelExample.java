package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FUserMemberRelExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FUserMemberRelExample() {
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

        public Criteria andMemberTypeIdIsNull() {
            addCriterion("member_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdIsNotNull() {
            addCriterion("member_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdEqualTo(Integer value) {
            addCriterion("member_type_id =", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdNotEqualTo(Integer value) {
            addCriterion("member_type_id <>", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdGreaterThan(Integer value) {
            addCriterion("member_type_id >", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_type_id >=", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdLessThan(Integer value) {
            addCriterion("member_type_id <", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_type_id <=", value, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdIn(List<Integer> values) {
            addCriterion("member_type_id in", values, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdNotIn(List<Integer> values) {
            addCriterion("member_type_id not in", values, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("member_type_id between", value1, value2, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_type_id not between", value1, value2, "memberTypeId");
            return (Criteria) this;
        }

        public Criteria andEndStatusIsNull() {
            addCriterion("end_status is null");
            return (Criteria) this;
        }

        public Criteria andEndStatusIsNotNull() {
            addCriterion("end_status is not null");
            return (Criteria) this;
        }

        public Criteria andEndStatusEqualTo(Byte value) {
            addCriterion("end_status =", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusNotEqualTo(Byte value) {
            addCriterion("end_status <>", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusGreaterThan(Byte value) {
            addCriterion("end_status >", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("end_status >=", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusLessThan(Byte value) {
            addCriterion("end_status <", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusLessThanOrEqualTo(Byte value) {
            addCriterion("end_status <=", value, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusIn(List<Byte> values) {
            addCriterion("end_status in", values, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusNotIn(List<Byte> values) {
            addCriterion("end_status not in", values, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusBetween(Byte value1, Byte value2) {
            addCriterion("end_status between", value1, value2, "endStatus");
            return (Criteria) this;
        }

        public Criteria andEndStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("end_status not between", value1, value2, "endStatus");
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