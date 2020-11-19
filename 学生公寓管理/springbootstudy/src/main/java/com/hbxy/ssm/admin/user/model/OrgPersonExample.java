package com.hbxy.ssm.admin.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgPersonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OrgPersonExample() {
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

        public Criteria andOrgPersonIdIsNull() {
            addCriterion("org_person_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdIsNotNull() {
            addCriterion("org_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdEqualTo(String value) {
            addCriterion("org_person_id =", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdNotEqualTo(String value) {
            addCriterion("org_person_id <>", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdGreaterThan(String value) {
            addCriterion("org_person_id >", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_person_id >=", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdLessThan(String value) {
            addCriterion("org_person_id <", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdLessThanOrEqualTo(String value) {
            addCriterion("org_person_id <=", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdLike(String value) {
            addCriterion("org_person_id like", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdNotLike(String value) {
            addCriterion("org_person_id not like", value, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdIn(List<String> values) {
            addCriterion("org_person_id in", values, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdNotIn(List<String> values) {
            addCriterion("org_person_id not in", values, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdBetween(String value1, String value2) {
            addCriterion("org_person_id between", value1, value2, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgPersonIdNotBetween(String value1, String value2) {
            addCriterion("org_person_id not between", value1, value2, "orgPersonId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andFromDateIsNull() {
            addCriterion("from_date is null");
            return (Criteria) this;
        }

        public Criteria andFromDateIsNotNull() {
            addCriterion("from_date is not null");
            return (Criteria) this;
        }

        public Criteria andFromDateEqualTo(Date value) {
            addCriterion("from_date =", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateNotEqualTo(Date value) {
            addCriterion("from_date <>", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateGreaterThan(Date value) {
            addCriterion("from_date >", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateGreaterThanOrEqualTo(Date value) {
            addCriterion("from_date >=", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateLessThan(Date value) {
            addCriterion("from_date <", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateLessThanOrEqualTo(Date value) {
            addCriterion("from_date <=", value, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateIn(List<Date> values) {
            addCriterion("from_date in", values, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateNotIn(List<Date> values) {
            addCriterion("from_date not in", values, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateBetween(Date value1, Date value2) {
            addCriterion("from_date between", value1, value2, "fromDate");
            return (Criteria) this;
        }

        public Criteria andFromDateNotBetween(Date value1, Date value2) {
            addCriterion("from_date not between", value1, value2, "fromDate");
            return (Criteria) this;
        }

        public Criteria andThruDateIsNull() {
            addCriterion("thru_date is null");
            return (Criteria) this;
        }

        public Criteria andThruDateIsNotNull() {
            addCriterion("thru_date is not null");
            return (Criteria) this;
        }

        public Criteria andThruDateEqualTo(Date value) {
            addCriterion("thru_date =", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateNotEqualTo(Date value) {
            addCriterion("thru_date <>", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateGreaterThan(Date value) {
            addCriterion("thru_date >", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateGreaterThanOrEqualTo(Date value) {
            addCriterion("thru_date >=", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateLessThan(Date value) {
            addCriterion("thru_date <", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateLessThanOrEqualTo(Date value) {
            addCriterion("thru_date <=", value, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateIn(List<Date> values) {
            addCriterion("thru_date in", values, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateNotIn(List<Date> values) {
            addCriterion("thru_date not in", values, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateBetween(Date value1, Date value2) {
            addCriterion("thru_date between", value1, value2, "thruDate");
            return (Criteria) this;
        }

        public Criteria andThruDateNotBetween(Date value1, Date value2) {
            addCriterion("thru_date not between", value1, value2, "thruDate");
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