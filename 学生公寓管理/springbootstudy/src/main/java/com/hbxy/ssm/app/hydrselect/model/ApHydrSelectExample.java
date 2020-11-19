package com.hbxy.ssm.app.hydrselect.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApHydrSelectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ApHydrSelectExample() {
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

        public Criteria andHydrIdIsNull() {
            addCriterion("hydr_id is null");
            return (Criteria) this;
        }

        public Criteria andHydrIdIsNotNull() {
            addCriterion("hydr_id is not null");
            return (Criteria) this;
        }

        public Criteria andHydrIdEqualTo(Integer value) {
            addCriterion("hydr_id =", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdNotEqualTo(Integer value) {
            addCriterion("hydr_id <>", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdGreaterThan(Integer value) {
            addCriterion("hydr_id >", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hydr_id >=", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdLessThan(Integer value) {
            addCriterion("hydr_id <", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdLessThanOrEqualTo(Integer value) {
            addCriterion("hydr_id <=", value, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdIn(List<Integer> values) {
            addCriterion("hydr_id in", values, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdNotIn(List<Integer> values) {
            addCriterion("hydr_id not in", values, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdBetween(Integer value1, Integer value2) {
            addCriterion("hydr_id between", value1, value2, "hydrId");
            return (Criteria) this;
        }

        public Criteria andHydrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hydr_id not between", value1, value2, "hydrId");
            return (Criteria) this;
        }

        public Criteria andDromNoIsNull() {
            addCriterion("drom_no is null");
            return (Criteria) this;
        }

        public Criteria andDromNoIsNotNull() {
            addCriterion("drom_no is not null");
            return (Criteria) this;
        }

        public Criteria andDromNoEqualTo(String value) {
            addCriterion("drom_no =", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoNotEqualTo(String value) {
            addCriterion("drom_no <>", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoGreaterThan(String value) {
            addCriterion("drom_no >", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoGreaterThanOrEqualTo(String value) {
            addCriterion("drom_no >=", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoLessThan(String value) {
            addCriterion("drom_no <", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoLessThanOrEqualTo(String value) {
            addCriterion("drom_no <=", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoLike(String value) {
            addCriterion("drom_no like", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoNotLike(String value) {
            addCriterion("drom_no not like", value, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoIn(List<String> values) {
            addCriterion("drom_no in", values, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoNotIn(List<String> values) {
            addCriterion("drom_no not in", values, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoBetween(String value1, String value2) {
            addCriterion("drom_no between", value1, value2, "dromNo");
            return (Criteria) this;
        }

        public Criteria andDromNoNotBetween(String value1, String value2) {
            addCriterion("drom_no not between", value1, value2, "dromNo");
            return (Criteria) this;
        }

        public Criteria andHydrDataIsNull() {
            addCriterion("hydr_data is null");
            return (Criteria) this;
        }

        public Criteria andHydrDataIsNotNull() {
            addCriterion("hydr_data is not null");
            return (Criteria) this;
        }

        public Criteria andHydrDataEqualTo(Date value) {
            addCriterion("hydr_data =", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataNotEqualTo(Date value) {
            addCriterion("hydr_data <>", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataGreaterThan(Date value) {
            addCriterion("hydr_data >", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataGreaterThanOrEqualTo(Date value) {
            addCriterion("hydr_data >=", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataLessThan(Date value) {
            addCriterion("hydr_data <", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataLessThanOrEqualTo(Date value) {
            addCriterion("hydr_data <=", value, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataIn(List<Date> values) {
            addCriterion("hydr_data in", values, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataNotIn(List<Date> values) {
            addCriterion("hydr_data not in", values, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataBetween(Date value1, Date value2) {
            addCriterion("hydr_data between", value1, value2, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrDataNotBetween(Date value1, Date value2) {
            addCriterion("hydr_data not between", value1, value2, "hydrData");
            return (Criteria) this;
        }

        public Criteria andHydrFreeIsNull() {
            addCriterion("hydr_free is null");
            return (Criteria) this;
        }

        public Criteria andHydrFreeIsNotNull() {
            addCriterion("hydr_free is not null");
            return (Criteria) this;
        }

        public Criteria andHydrFreeEqualTo(String value) {
            addCriterion("hydr_free =", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeNotEqualTo(String value) {
            addCriterion("hydr_free <>", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeGreaterThan(String value) {
            addCriterion("hydr_free >", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeGreaterThanOrEqualTo(String value) {
            addCriterion("hydr_free >=", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeLessThan(String value) {
            addCriterion("hydr_free <", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeLessThanOrEqualTo(String value) {
            addCriterion("hydr_free <=", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeLike(String value) {
            addCriterion("hydr_free like", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeNotLike(String value) {
            addCriterion("hydr_free not like", value, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeIn(List<String> values) {
            addCriterion("hydr_free in", values, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeNotIn(List<String> values) {
            addCriterion("hydr_free not in", values, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeBetween(String value1, String value2) {
            addCriterion("hydr_free between", value1, value2, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeNotBetween(String value1, String value2) {
            addCriterion("hydr_free not between", value1, value2, "hydrFree");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateIsNull() {
            addCriterion("hydr_free_state is null");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateIsNotNull() {
            addCriterion("hydr_free_state is not null");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateEqualTo(String value) {
            addCriterion("hydr_free_state =", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateNotEqualTo(String value) {
            addCriterion("hydr_free_state <>", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateGreaterThan(String value) {
            addCriterion("hydr_free_state >", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateGreaterThanOrEqualTo(String value) {
            addCriterion("hydr_free_state >=", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateLessThan(String value) {
            addCriterion("hydr_free_state <", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateLessThanOrEqualTo(String value) {
            addCriterion("hydr_free_state <=", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateLike(String value) {
            addCriterion("hydr_free_state like", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateNotLike(String value) {
            addCriterion("hydr_free_state not like", value, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateIn(List<String> values) {
            addCriterion("hydr_free_state in", values, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateNotIn(List<String> values) {
            addCriterion("hydr_free_state not in", values, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateBetween(String value1, String value2) {
            addCriterion("hydr_free_state between", value1, value2, "hydrFreeState");
            return (Criteria) this;
        }

        public Criteria andHydrFreeStateNotBetween(String value1, String value2) {
            addCriterion("hydr_free_state not between", value1, value2, "hydrFreeState");
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