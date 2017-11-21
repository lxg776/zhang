package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FUserRequestExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FUserRequestExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andShapeIsNull() {
            addCriterion("shape is null");
            return (Criteria) this;
        }

        public Criteria andShapeIsNotNull() {
            addCriterion("shape is not null");
            return (Criteria) this;
        }

        public Criteria andShapeEqualTo(String value) {
            addCriterion("shape =", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotEqualTo(String value) {
            addCriterion("shape <>", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThan(String value) {
            addCriterion("shape >", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThanOrEqualTo(String value) {
            addCriterion("shape >=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThan(String value) {
            addCriterion("shape <", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThanOrEqualTo(String value) {
            addCriterion("shape <=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLike(String value) {
            addCriterion("shape like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotLike(String value) {
            addCriterion("shape not like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeIn(List<String> values) {
            addCriterion("shape in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotIn(List<String> values) {
            addCriterion("shape not in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeBetween(String value1, String value2) {
            addCriterion("shape between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotBetween(String value1, String value2) {
            addCriterion("shape not between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyIsNull() {
            addCriterion("income_monthly is null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyIsNotNull() {
            addCriterion("income_monthly is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyEqualTo(String value) {
            addCriterion("income_monthly =", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyNotEqualTo(String value) {
            addCriterion("income_monthly <>", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyGreaterThan(String value) {
            addCriterion("income_monthly >", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyGreaterThanOrEqualTo(String value) {
            addCriterion("income_monthly >=", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyLessThan(String value) {
            addCriterion("income_monthly <", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyLessThanOrEqualTo(String value) {
            addCriterion("income_monthly <=", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyLike(String value) {
            addCriterion("income_monthly like", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyNotLike(String value) {
            addCriterion("income_monthly not like", value, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyIn(List<String> values) {
            addCriterion("income_monthly in", values, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyNotIn(List<String> values) {
            addCriterion("income_monthly not in", values, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyBetween(String value1, String value2) {
            addCriterion("income_monthly between", value1, value2, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthlyNotBetween(String value1, String value2) {
            addCriterion("income_monthly not between", value1, value2, "incomeMonthly");
            return (Criteria) this;
        }

        public Criteria andIncomeYearIsNull() {
            addCriterion("income_year is null");
            return (Criteria) this;
        }

        public Criteria andIncomeYearIsNotNull() {
            addCriterion("income_year is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeYearEqualTo(String value) {
            addCriterion("income_year =", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearNotEqualTo(String value) {
            addCriterion("income_year <>", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearGreaterThan(String value) {
            addCriterion("income_year >", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearGreaterThanOrEqualTo(String value) {
            addCriterion("income_year >=", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearLessThan(String value) {
            addCriterion("income_year <", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearLessThanOrEqualTo(String value) {
            addCriterion("income_year <=", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearLike(String value) {
            addCriterion("income_year like", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearNotLike(String value) {
            addCriterion("income_year not like", value, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearIn(List<String> values) {
            addCriterion("income_year in", values, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearNotIn(List<String> values) {
            addCriterion("income_year not in", values, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearBetween(String value1, String value2) {
            addCriterion("income_year between", value1, value2, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andIncomeYearNotBetween(String value1, String value2) {
            addCriterion("income_year not between", value1, value2, "incomeYear");
            return (Criteria) this;
        }

        public Criteria andHouseStateIsNull() {
            addCriterion("house_state is null");
            return (Criteria) this;
        }

        public Criteria andHouseStateIsNotNull() {
            addCriterion("house_state is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStateEqualTo(String value) {
            addCriterion("house_state =", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateNotEqualTo(String value) {
            addCriterion("house_state <>", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateGreaterThan(String value) {
            addCriterion("house_state >", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateGreaterThanOrEqualTo(String value) {
            addCriterion("house_state >=", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateLessThan(String value) {
            addCriterion("house_state <", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateLessThanOrEqualTo(String value) {
            addCriterion("house_state <=", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateLike(String value) {
            addCriterion("house_state like", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateNotLike(String value) {
            addCriterion("house_state not like", value, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateIn(List<String> values) {
            addCriterion("house_state in", values, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateNotIn(List<String> values) {
            addCriterion("house_state not in", values, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateBetween(String value1, String value2) {
            addCriterion("house_state between", value1, value2, "houseState");
            return (Criteria) this;
        }

        public Criteria andHouseStateNotBetween(String value1, String value2) {
            addCriterion("house_state not between", value1, value2, "houseState");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("marital_status like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("marital_status not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNull() {
            addCriterion("house_status is null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIsNotNull() {
            addCriterion("house_status is not null");
            return (Criteria) this;
        }

        public Criteria andHouseStatusEqualTo(String value) {
            addCriterion("house_status =", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotEqualTo(String value) {
            addCriterion("house_status <>", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThan(String value) {
            addCriterion("house_status >", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("house_status >=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThan(String value) {
            addCriterion("house_status <", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLessThanOrEqualTo(String value) {
            addCriterion("house_status <=", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusLike(String value) {
            addCriterion("house_status like", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotLike(String value) {
            addCriterion("house_status not like", value, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusIn(List<String> values) {
            addCriterion("house_status in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotIn(List<String> values) {
            addCriterion("house_status not in", values, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusBetween(String value1, String value2) {
            addCriterion("house_status between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andHouseStatusNotBetween(String value1, String value2) {
            addCriterion("house_status not between", value1, value2, "houseStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(String value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(String value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(String value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(String value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(String value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(String value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLike(String value) {
            addCriterion("car_status like", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotLike(String value) {
            addCriterion("car_status not like", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<String> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<String> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(String value1, String value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(String value1, String value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andFriendRequireIsNull() {
            addCriterion("friend_require is null");
            return (Criteria) this;
        }

        public Criteria andFriendRequireIsNotNull() {
            addCriterion("friend_require is not null");
            return (Criteria) this;
        }

        public Criteria andFriendRequireEqualTo(String value) {
            addCriterion("friend_require =", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireNotEqualTo(String value) {
            addCriterion("friend_require <>", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireGreaterThan(String value) {
            addCriterion("friend_require >", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireGreaterThanOrEqualTo(String value) {
            addCriterion("friend_require >=", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireLessThan(String value) {
            addCriterion("friend_require <", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireLessThanOrEqualTo(String value) {
            addCriterion("friend_require <=", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireLike(String value) {
            addCriterion("friend_require like", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireNotLike(String value) {
            addCriterion("friend_require not like", value, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireIn(List<String> values) {
            addCriterion("friend_require in", values, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireNotIn(List<String> values) {
            addCriterion("friend_require not in", values, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireBetween(String value1, String value2) {
            addCriterion("friend_require between", value1, value2, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andFriendRequireNotBetween(String value1, String value2) {
            addCriterion("friend_require not between", value1, value2, "friendRequire");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusIsNull() {
            addCriterion("drink_status is null");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusIsNotNull() {
            addCriterion("drink_status is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusEqualTo(String value) {
            addCriterion("drink_status =", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusNotEqualTo(String value) {
            addCriterion("drink_status <>", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusGreaterThan(String value) {
            addCriterion("drink_status >", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusGreaterThanOrEqualTo(String value) {
            addCriterion("drink_status >=", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusLessThan(String value) {
            addCriterion("drink_status <", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusLessThanOrEqualTo(String value) {
            addCriterion("drink_status <=", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusLike(String value) {
            addCriterion("drink_status like", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusNotLike(String value) {
            addCriterion("drink_status not like", value, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusIn(List<String> values) {
            addCriterion("drink_status in", values, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusNotIn(List<String> values) {
            addCriterion("drink_status not in", values, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusBetween(String value1, String value2) {
            addCriterion("drink_status between", value1, value2, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andDrinkStatusNotBetween(String value1, String value2) {
            addCriterion("drink_status not between", value1, value2, "drinkStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusIsNull() {
            addCriterion("smoke_status is null");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusIsNotNull() {
            addCriterion("smoke_status is not null");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusEqualTo(String value) {
            addCriterion("smoke_status =", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusNotEqualTo(String value) {
            addCriterion("smoke_status <>", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusGreaterThan(String value) {
            addCriterion("smoke_status >", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("smoke_status >=", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusLessThan(String value) {
            addCriterion("smoke_status <", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusLessThanOrEqualTo(String value) {
            addCriterion("smoke_status <=", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusLike(String value) {
            addCriterion("smoke_status like", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusNotLike(String value) {
            addCriterion("smoke_status not like", value, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusIn(List<String> values) {
            addCriterion("smoke_status in", values, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusNotIn(List<String> values) {
            addCriterion("smoke_status not in", values, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusBetween(String value1, String value2) {
            addCriterion("smoke_status between", value1, value2, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andSmokeStatusNotBetween(String value1, String value2) {
            addCriterion("smoke_status not between", value1, value2, "smokeStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusIsNull() {
            addCriterion("living_status is null");
            return (Criteria) this;
        }

        public Criteria andLivingStatusIsNotNull() {
            addCriterion("living_status is not null");
            return (Criteria) this;
        }

        public Criteria andLivingStatusEqualTo(String value) {
            addCriterion("living_status =", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusNotEqualTo(String value) {
            addCriterion("living_status <>", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusGreaterThan(String value) {
            addCriterion("living_status >", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("living_status >=", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusLessThan(String value) {
            addCriterion("living_status <", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusLessThanOrEqualTo(String value) {
            addCriterion("living_status <=", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusLike(String value) {
            addCriterion("living_status like", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusNotLike(String value) {
            addCriterion("living_status not like", value, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusIn(List<String> values) {
            addCriterion("living_status in", values, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusNotIn(List<String> values) {
            addCriterion("living_status not in", values, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusBetween(String value1, String value2) {
            addCriterion("living_status between", value1, value2, "livingStatus");
            return (Criteria) this;
        }

        public Criteria andLivingStatusNotBetween(String value1, String value2) {
            addCriterion("living_status not between", value1, value2, "livingStatus");
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