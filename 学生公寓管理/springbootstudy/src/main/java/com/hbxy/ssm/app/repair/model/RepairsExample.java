package com.hbxy.ssm.app.repair.model;

import java.util.ArrayList;
import java.util.List;

public class RepairsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public RepairsExample() {
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

        public Criteria andRepairsIdIsNull() {
            addCriterion("repairs_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairsIdIsNotNull() {
            addCriterion("repairs_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairsIdEqualTo(String value) {
            addCriterion("repairs_id =", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdNotEqualTo(String value) {
            addCriterion("repairs_id <>", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdGreaterThan(String value) {
            addCriterion("repairs_id >", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdGreaterThanOrEqualTo(String value) {
            addCriterion("repairs_id >=", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdLessThan(String value) {
            addCriterion("repairs_id <", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdLessThanOrEqualTo(String value) {
            addCriterion("repairs_id <=", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdLike(String value) {
            addCriterion("repairs_id like", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdNotLike(String value) {
            addCriterion("repairs_id not like", value, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdIn(List<String> values) {
            addCriterion("repairs_id in", values, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdNotIn(List<String> values) {
            addCriterion("repairs_id not in", values, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdBetween(String value1, String value2) {
            addCriterion("repairs_id between", value1, value2, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsIdNotBetween(String value1, String value2) {
            addCriterion("repairs_id not between", value1, value2, "repairsId");
            return (Criteria) this;
        }

        public Criteria andRepairsNoIsNull() {
            addCriterion("repairs_no is null");
            return (Criteria) this;
        }

        public Criteria andRepairsNoIsNotNull() {
            addCriterion("repairs_no is not null");
            return (Criteria) this;
        }

        public Criteria andRepairsNoEqualTo(String value) {
            addCriterion("repairs_no =", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoNotEqualTo(String value) {
            addCriterion("repairs_no <>", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoGreaterThan(String value) {
            addCriterion("repairs_no >", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoGreaterThanOrEqualTo(String value) {
            addCriterion("repairs_no >=", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoLessThan(String value) {
            addCriterion("repairs_no <", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoLessThanOrEqualTo(String value) {
            addCriterion("repairs_no <=", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoLike(String value) {
            addCriterion("repairs_no like", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoNotLike(String value) {
            addCriterion("repairs_no not like", value, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoIn(List<String> values) {
            addCriterion("repairs_no in", values, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoNotIn(List<String> values) {
            addCriterion("repairs_no not in", values, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoBetween(String value1, String value2) {
            addCriterion("repairs_no between", value1, value2, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsNoNotBetween(String value1, String value2) {
            addCriterion("repairs_no not between", value1, value2, "repairsNo");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceIsNull() {
            addCriterion("repairs_price is null");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceIsNotNull() {
            addCriterion("repairs_price is not null");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceEqualTo(String value) {
            addCriterion("repairs_price =", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceNotEqualTo(String value) {
            addCriterion("repairs_price <>", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceGreaterThan(String value) {
            addCriterion("repairs_price >", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("repairs_price >=", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceLessThan(String value) {
            addCriterion("repairs_price <", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceLessThanOrEqualTo(String value) {
            addCriterion("repairs_price <=", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceLike(String value) {
            addCriterion("repairs_price like", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceNotLike(String value) {
            addCriterion("repairs_price not like", value, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceIn(List<String> values) {
            addCriterion("repairs_price in", values, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceNotIn(List<String> values) {
            addCriterion("repairs_price not in", values, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceBetween(String value1, String value2) {
            addCriterion("repairs_price between", value1, value2, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsPriceNotBetween(String value1, String value2) {
            addCriterion("repairs_price not between", value1, value2, "repairsPrice");
            return (Criteria) this;
        }

        public Criteria andRepairsNameIsNull() {
            addCriterion("repairs_name is null");
            return (Criteria) this;
        }

        public Criteria andRepairsNameIsNotNull() {
            addCriterion("repairs_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepairsNameEqualTo(String value) {
            addCriterion("repairs_name =", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameNotEqualTo(String value) {
            addCriterion("repairs_name <>", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameGreaterThan(String value) {
            addCriterion("repairs_name >", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameGreaterThanOrEqualTo(String value) {
            addCriterion("repairs_name >=", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameLessThan(String value) {
            addCriterion("repairs_name <", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameLessThanOrEqualTo(String value) {
            addCriterion("repairs_name <=", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameLike(String value) {
            addCriterion("repairs_name like", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameNotLike(String value) {
            addCriterion("repairs_name not like", value, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameIn(List<String> values) {
            addCriterion("repairs_name in", values, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameNotIn(List<String> values) {
            addCriterion("repairs_name not in", values, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameBetween(String value1, String value2) {
            addCriterion("repairs_name between", value1, value2, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNameNotBetween(String value1, String value2) {
            addCriterion("repairs_name not between", value1, value2, "repairsName");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberIsNull() {
            addCriterion("repairs_number is null");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberIsNotNull() {
            addCriterion("repairs_number is not null");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberEqualTo(Integer value) {
            addCriterion("repairs_number =", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberNotEqualTo(Integer value) {
            addCriterion("repairs_number <>", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberGreaterThan(Integer value) {
            addCriterion("repairs_number >", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairs_number >=", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberLessThan(Integer value) {
            addCriterion("repairs_number <", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("repairs_number <=", value, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberIn(List<Integer> values) {
            addCriterion("repairs_number in", values, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberNotIn(List<Integer> values) {
            addCriterion("repairs_number not in", values, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberBetween(Integer value1, Integer value2) {
            addCriterion("repairs_number between", value1, value2, "repairsNumber");
            return (Criteria) this;
        }

        public Criteria andRepairsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("repairs_number not between", value1, value2, "repairsNumber");
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