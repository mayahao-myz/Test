package com.hbxy.ssm.app.health.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HealthExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
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

        public Criteria andHealthIdIsNull() {
            addCriterion("health_id is null");
            return (Criteria) this;
        }

        public Criteria andHealthIdIsNotNull() {
            addCriterion("health_id is not null");
            return (Criteria) this;
        }

        public Criteria andHealthIdEqualTo(Integer value) {
            addCriterion("health_id =", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotEqualTo(Integer value) {
            addCriterion("health_id <>", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdGreaterThan(Integer value) {
            addCriterion("health_id >", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("health_id >=", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdLessThan(Integer value) {
            addCriterion("health_id <", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdLessThanOrEqualTo(Integer value) {
            addCriterion("health_id <=", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdIn(List<Integer> values) {
            addCriterion("health_id in", values, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotIn(List<Integer> values) {
            addCriterion("health_id not in", values, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdBetween(Integer value1, Integer value2) {
            addCriterion("health_id between", value1, value2, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("health_id not between", value1, value2, "healthId");
            return (Criteria) this;
        }

        public Criteria andDormNoIsNull() {
            addCriterion("dorm_no is null");
            return (Criteria) this;
        }

        public Criteria andDormNoIsNotNull() {
            addCriterion("dorm_no is not null");
            return (Criteria) this;
        }

        public Criteria andDormNoEqualTo(String value) {
            addCriterion("dorm_no =", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoNotEqualTo(String value) {
            addCriterion("dorm_no <>", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoGreaterThan(String value) {
            addCriterion("dorm_no >", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoGreaterThanOrEqualTo(String value) {
            addCriterion("dorm_no >=", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoLessThan(String value) {
            addCriterion("dorm_no <", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoLessThanOrEqualTo(String value) {
            addCriterion("dorm_no <=", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoLike(String value) {
            addCriterion("dorm_no like", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoNotLike(String value) {
            addCriterion("dorm_no not like", value, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoIn(List<String> values) {
            addCriterion("dorm_no in", values, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoNotIn(List<String> values) {
            addCriterion("dorm_no not in", values, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoBetween(String value1, String value2) {
            addCriterion("dorm_no between", value1, value2, "dormNo");
            return (Criteria) this;
        }

        public Criteria andDormNoNotBetween(String value1, String value2) {
            addCriterion("dorm_no not between", value1, value2, "dormNo");
            return (Criteria) this;
        }

        public Criteria andHealthDataIsNull() {
            addCriterion("health_data is null");
            return (Criteria) this;
        }

        public Criteria andHealthDataIsNotNull() {
            addCriterion("health_data is not null");
            return (Criteria) this;
        }

        public Criteria andHealthDataEqualTo(Date value) {
            addCriterion("health_data =", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataNotEqualTo(Date value) {
            addCriterion("health_data <>", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataGreaterThan(Date value) {
            addCriterion("health_data >", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataGreaterThanOrEqualTo(Date value) {
            addCriterion("health_data >=", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataLessThan(Date value) {
            addCriterion("health_data <", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataLessThanOrEqualTo(Date value) {
            addCriterion("health_data <=", value, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataIn(List<Date> values) {
            addCriterion("health_data in", values, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataNotIn(List<Date> values) {
            addCriterion("health_data not in", values, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataBetween(Date value1, Date value2) {
            addCriterion("health_data between", value1, value2, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthDataNotBetween(Date value1, Date value2) {
            addCriterion("health_data not between", value1, value2, "healthData");
            return (Criteria) this;
        }

        public Criteria andHealthGradeIsNull() {
            addCriterion("health_grade is null");
            return (Criteria) this;
        }

        public Criteria andHealthGradeIsNotNull() {
            addCriterion("health_grade is not null");
            return (Criteria) this;
        }

        public Criteria andHealthGradeEqualTo(Integer value) {
            addCriterion("health_grade =", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeNotEqualTo(Integer value) {
            addCriterion("health_grade <>", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeGreaterThan(Integer value) {
            addCriterion("health_grade >", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("health_grade >=", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeLessThan(Integer value) {
            addCriterion("health_grade <", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeLessThanOrEqualTo(Integer value) {
            addCriterion("health_grade <=", value, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeIn(List<Integer> values) {
            addCriterion("health_grade in", values, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeNotIn(List<Integer> values) {
            addCriterion("health_grade not in", values, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeBetween(Integer value1, Integer value2) {
            addCriterion("health_grade between", value1, value2, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("health_grade not between", value1, value2, "healthGrade");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkIsNull() {
            addCriterion("health_remark is null");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkIsNotNull() {
            addCriterion("health_remark is not null");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkEqualTo(String value) {
            addCriterion("health_remark =", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkNotEqualTo(String value) {
            addCriterion("health_remark <>", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkGreaterThan(String value) {
            addCriterion("health_remark >", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("health_remark >=", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkLessThan(String value) {
            addCriterion("health_remark <", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkLessThanOrEqualTo(String value) {
            addCriterion("health_remark <=", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkLike(String value) {
            addCriterion("health_remark like", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkNotLike(String value) {
            addCriterion("health_remark not like", value, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkIn(List<String> values) {
            addCriterion("health_remark in", values, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkNotIn(List<String> values) {
            addCriterion("health_remark not in", values, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkBetween(String value1, String value2) {
            addCriterion("health_remark between", value1, value2, "healthRemark");
            return (Criteria) this;
        }

        public Criteria andHealthRemarkNotBetween(String value1, String value2) {
            addCriterion("health_remark not between", value1, value2, "healthRemark");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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