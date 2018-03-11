package com.zheng.friend.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FUserBaseMsgExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public FUserBaseMsgExample() {
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

        public Criteria andNikenameIsNull() {
            addCriterion("nikename is null");
            return (Criteria) this;
        }

        public Criteria andNikenameIsNotNull() {
            addCriterion("nikename is not null");
            return (Criteria) this;
        }

        public Criteria andNikenameEqualTo(String value) {
            addCriterion("nikename =", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameNotEqualTo(String value) {
            addCriterion("nikename <>", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameGreaterThan(String value) {
            addCriterion("nikename >", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameGreaterThanOrEqualTo(String value) {
            addCriterion("nikename >=", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameLessThan(String value) {
            addCriterion("nikename <", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameLessThanOrEqualTo(String value) {
            addCriterion("nikename <=", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameLike(String value) {
            addCriterion("nikename like", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameNotLike(String value) {
            addCriterion("nikename not like", value, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameIn(List<String> values) {
            addCriterion("nikename in", values, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameNotIn(List<String> values) {
            addCriterion("nikename not in", values, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameBetween(String value1, String value2) {
            addCriterion("nikename between", value1, value2, "nikename");
            return (Criteria) this;
        }

        public Criteria andNikenameNotBetween(String value1, String value2) {
            addCriterion("nikename not between", value1, value2, "nikename");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(String value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(String value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(String value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(String value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(String value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(String value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLike(String value) {
            addCriterion("birth_date like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotLike(String value) {
            addCriterion("birth_date not like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<String> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<String> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(String value1, String value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(String value1, String value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
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

        public Criteria andHeightEqualTo(Float value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Float value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Float value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Float value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Float value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Float value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Float> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Float> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Float value1, Float value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Float value1, Float value2) {
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

        public Criteria andYearIncomeIsNull() {
            addCriterion("year_income is null");
            return (Criteria) this;
        }

        public Criteria andYearIncomeIsNotNull() {
            addCriterion("year_income is not null");
            return (Criteria) this;
        }

        public Criteria andYearIncomeEqualTo(String value) {
            addCriterion("year_income =", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotEqualTo(String value) {
            addCriterion("year_income <>", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeGreaterThan(String value) {
            addCriterion("year_income >", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("year_income >=", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeLessThan(String value) {
            addCriterion("year_income <", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeLessThanOrEqualTo(String value) {
            addCriterion("year_income <=", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeLike(String value) {
            addCriterion("year_income like", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotLike(String value) {
            addCriterion("year_income not like", value, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeIn(List<String> values) {
            addCriterion("year_income in", values, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotIn(List<String> values) {
            addCriterion("year_income not in", values, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeBetween(String value1, String value2) {
            addCriterion("year_income between", value1, value2, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andYearIncomeNotBetween(String value1, String value2) {
            addCriterion("year_income not between", value1, value2, "yearIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNull() {
            addCriterion("month_income is null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIsNotNull() {
            addCriterion("month_income is not null");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeEqualTo(String value) {
            addCriterion("month_income =", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotEqualTo(String value) {
            addCriterion("month_income <>", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThan(String value) {
            addCriterion("month_income >", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("month_income >=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThan(String value) {
            addCriterion("month_income <", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLessThanOrEqualTo(String value) {
            addCriterion("month_income <=", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeLike(String value) {
            addCriterion("month_income like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotLike(String value) {
            addCriterion("month_income not like", value, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeIn(List<String> values) {
            addCriterion("month_income in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotIn(List<String> values) {
            addCriterion("month_income not in", values, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeBetween(String value1, String value2) {
            addCriterion("month_income between", value1, value2, "monthIncome");
            return (Criteria) this;
        }

        public Criteria andMonthIncomeNotBetween(String value1, String value2) {
            addCriterion("month_income not between", value1, value2, "monthIncome");
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

        public Criteria andDispositionIsNull() {
            addCriterion("disposition is null");
            return (Criteria) this;
        }

        public Criteria andDispositionIsNotNull() {
            addCriterion("disposition is not null");
            return (Criteria) this;
        }

        public Criteria andDispositionEqualTo(String value) {
            addCriterion("disposition =", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotEqualTo(String value) {
            addCriterion("disposition <>", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionGreaterThan(String value) {
            addCriterion("disposition >", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionGreaterThanOrEqualTo(String value) {
            addCriterion("disposition >=", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLessThan(String value) {
            addCriterion("disposition <", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLessThanOrEqualTo(String value) {
            addCriterion("disposition <=", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionLike(String value) {
            addCriterion("disposition like", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotLike(String value) {
            addCriterion("disposition not like", value, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionIn(List<String> values) {
            addCriterion("disposition in", values, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotIn(List<String> values) {
            addCriterion("disposition not in", values, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionBetween(String value1, String value2) {
            addCriterion("disposition between", value1, value2, "disposition");
            return (Criteria) this;
        }

        public Criteria andDispositionNotBetween(String value1, String value2) {
            addCriterion("disposition not between", value1, value2, "disposition");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyIsNull() {
            addCriterion("unit_property is null");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyIsNotNull() {
            addCriterion("unit_property is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyEqualTo(String value) {
            addCriterion("unit_property =", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyNotEqualTo(String value) {
            addCriterion("unit_property <>", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyGreaterThan(String value) {
            addCriterion("unit_property >", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("unit_property >=", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyLessThan(String value) {
            addCriterion("unit_property <", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyLessThanOrEqualTo(String value) {
            addCriterion("unit_property <=", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyLike(String value) {
            addCriterion("unit_property like", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyNotLike(String value) {
            addCriterion("unit_property not like", value, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyIn(List<String> values) {
            addCriterion("unit_property in", values, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyNotIn(List<String> values) {
            addCriterion("unit_property not in", values, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyBetween(String value1, String value2) {
            addCriterion("unit_property between", value1, value2, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andUnitPropertyNotBetween(String value1, String value2) {
            addCriterion("unit_property not between", value1, value2, "unitProperty");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNull() {
            addCriterion("work_unit is null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIsNotNull() {
            addCriterion("work_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUnitEqualTo(String value) {
            addCriterion("work_unit =", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotEqualTo(String value) {
            addCriterion("work_unit <>", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThan(String value) {
            addCriterion("work_unit >", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("work_unit >=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThan(String value) {
            addCriterion("work_unit <", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("work_unit <=", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitLike(String value) {
            addCriterion("work_unit like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotLike(String value) {
            addCriterion("work_unit not like", value, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitIn(List<String> values) {
            addCriterion("work_unit in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotIn(List<String> values) {
            addCriterion("work_unit not in", values, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitBetween(String value1, String value2) {
            addCriterion("work_unit between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkUnitNotBetween(String value1, String value2) {
            addCriterion("work_unit not between", value1, value2, "workUnit");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
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

        public Criteria andChildrenStatusIsNull() {
            addCriterion("children_status is null");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusIsNotNull() {
            addCriterion("children_status is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusEqualTo(String value) {
            addCriterion("children_status =", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusNotEqualTo(String value) {
            addCriterion("children_status <>", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusGreaterThan(String value) {
            addCriterion("children_status >", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusGreaterThanOrEqualTo(String value) {
            addCriterion("children_status >=", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusLessThan(String value) {
            addCriterion("children_status <", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusLessThanOrEqualTo(String value) {
            addCriterion("children_status <=", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusLike(String value) {
            addCriterion("children_status like", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusNotLike(String value) {
            addCriterion("children_status not like", value, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusIn(List<String> values) {
            addCriterion("children_status in", values, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusNotIn(List<String> values) {
            addCriterion("children_status not in", values, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusBetween(String value1, String value2) {
            addCriterion("children_status between", value1, value2, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andChildrenStatusNotBetween(String value1, String value2) {
            addCriterion("children_status not between", value1, value2, "childrenStatus");
            return (Criteria) this;
        }

        public Criteria andSoliloquyIsNull() {
            addCriterion("soliloquy is null");
            return (Criteria) this;
        }

        public Criteria andSoliloquyIsNotNull() {
            addCriterion("soliloquy is not null");
            return (Criteria) this;
        }

        public Criteria andSoliloquyEqualTo(String value) {
            addCriterion("soliloquy =", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyNotEqualTo(String value) {
            addCriterion("soliloquy <>", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyGreaterThan(String value) {
            addCriterion("soliloquy >", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyGreaterThanOrEqualTo(String value) {
            addCriterion("soliloquy >=", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyLessThan(String value) {
            addCriterion("soliloquy <", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyLessThanOrEqualTo(String value) {
            addCriterion("soliloquy <=", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyLike(String value) {
            addCriterion("soliloquy like", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyNotLike(String value) {
            addCriterion("soliloquy not like", value, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyIn(List<String> values) {
            addCriterion("soliloquy in", values, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyNotIn(List<String> values) {
            addCriterion("soliloquy not in", values, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyBetween(String value1, String value2) {
            addCriterion("soliloquy between", value1, value2, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andSoliloquyNotBetween(String value1, String value2) {
            addCriterion("soliloquy not between", value1, value2, "soliloquy");
            return (Criteria) this;
        }

        public Criteria andDeclarationIsNull() {
            addCriterion("declaration is null");
            return (Criteria) this;
        }

        public Criteria andDeclarationIsNotNull() {
            addCriterion("declaration is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarationEqualTo(String value) {
            addCriterion("declaration =", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationNotEqualTo(String value) {
            addCriterion("declaration <>", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationGreaterThan(String value) {
            addCriterion("declaration >", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationGreaterThanOrEqualTo(String value) {
            addCriterion("declaration >=", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationLessThan(String value) {
            addCriterion("declaration <", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationLessThanOrEqualTo(String value) {
            addCriterion("declaration <=", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationLike(String value) {
            addCriterion("declaration like", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationNotLike(String value) {
            addCriterion("declaration not like", value, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationIn(List<String> values) {
            addCriterion("declaration in", values, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationNotIn(List<String> values) {
            addCriterion("declaration not in", values, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationBetween(String value1, String value2) {
            addCriterion("declaration between", value1, value2, "declaration");
            return (Criteria) this;
        }

        public Criteria andDeclarationNotBetween(String value1, String value2) {
            addCriterion("declaration not between", value1, value2, "declaration");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andFromCityIsNull() {
            addCriterion("from_city is null");
            return (Criteria) this;
        }

        public Criteria andFromCityIsNotNull() {
            addCriterion("from_city is not null");
            return (Criteria) this;
        }

        public Criteria andFromCityEqualTo(String value) {
            addCriterion("from_city =", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityNotEqualTo(String value) {
            addCriterion("from_city <>", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityGreaterThan(String value) {
            addCriterion("from_city >", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityGreaterThanOrEqualTo(String value) {
            addCriterion("from_city >=", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityLessThan(String value) {
            addCriterion("from_city <", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityLessThanOrEqualTo(String value) {
            addCriterion("from_city <=", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityLike(String value) {
            addCriterion("from_city like", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityNotLike(String value) {
            addCriterion("from_city not like", value, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityIn(List<String> values) {
            addCriterion("from_city in", values, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityNotIn(List<String> values) {
            addCriterion("from_city not in", values, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityBetween(String value1, String value2) {
            addCriterion("from_city between", value1, value2, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityNotBetween(String value1, String value2) {
            addCriterion("from_city not between", value1, value2, "fromCity");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIsNull() {
            addCriterion("from_city_id is null");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIsNotNull() {
            addCriterion("from_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromCityIdEqualTo(Integer value) {
            addCriterion("from_city_id =", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotEqualTo(Integer value) {
            addCriterion("from_city_id <>", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdGreaterThan(Integer value) {
            addCriterion("from_city_id >", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_city_id >=", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdLessThan(Integer value) {
            addCriterion("from_city_id <", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_city_id <=", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIn(List<Integer> values) {
            addCriterion("from_city_id in", values, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotIn(List<Integer> values) {
            addCriterion("from_city_id not in", values, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdBetween(Integer value1, Integer value2) {
            addCriterion("from_city_id between", value1, value2, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_city_id not between", value1, value2, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdIsNull() {
            addCriterion("from_area_id is null");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdIsNotNull() {
            addCriterion("from_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdEqualTo(Integer value) {
            addCriterion("from_area_id =", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdNotEqualTo(Integer value) {
            addCriterion("from_area_id <>", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdGreaterThan(Integer value) {
            addCriterion("from_area_id >", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_area_id >=", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdLessThan(Integer value) {
            addCriterion("from_area_id <", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_area_id <=", value, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdIn(List<Integer> values) {
            addCriterion("from_area_id in", values, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdNotIn(List<Integer> values) {
            addCriterion("from_area_id not in", values, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("from_area_id between", value1, value2, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_area_id not between", value1, value2, "fromAreaId");
            return (Criteria) this;
        }

        public Criteria andFromAreaIsNull() {
            addCriterion("from_area is null");
            return (Criteria) this;
        }

        public Criteria andFromAreaIsNotNull() {
            addCriterion("from_area is not null");
            return (Criteria) this;
        }

        public Criteria andFromAreaEqualTo(String value) {
            addCriterion("from_area =", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaNotEqualTo(String value) {
            addCriterion("from_area <>", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaGreaterThan(String value) {
            addCriterion("from_area >", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaGreaterThanOrEqualTo(String value) {
            addCriterion("from_area >=", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaLessThan(String value) {
            addCriterion("from_area <", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaLessThanOrEqualTo(String value) {
            addCriterion("from_area <=", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaLike(String value) {
            addCriterion("from_area like", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaNotLike(String value) {
            addCriterion("from_area not like", value, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaIn(List<String> values) {
            addCriterion("from_area in", values, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaNotIn(List<String> values) {
            addCriterion("from_area not in", values, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaBetween(String value1, String value2) {
            addCriterion("from_area between", value1, value2, "fromArea");
            return (Criteria) this;
        }

        public Criteria andFromAreaNotBetween(String value1, String value2) {
            addCriterion("from_area not between", value1, value2, "fromArea");
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