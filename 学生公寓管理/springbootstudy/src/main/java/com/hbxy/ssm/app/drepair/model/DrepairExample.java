package com.hbxy.ssm.app.drepair.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DrepairExample() {
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

        public Criteria andDrepairIdIsNull() {
            addCriterion("drepair_id is null");
            return (Criteria) this;
        }

        public Criteria andDrepairIdIsNotNull() {
            addCriterion("drepair_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrepairIdEqualTo(Integer value) {
            addCriterion("drepair_id =", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdNotEqualTo(Integer value) {
            addCriterion("drepair_id <>", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdGreaterThan(Integer value) {
            addCriterion("drepair_id >", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drepair_id >=", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdLessThan(Integer value) {
            addCriterion("drepair_id <", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdLessThanOrEqualTo(Integer value) {
            addCriterion("drepair_id <=", value, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdIn(List<Integer> values) {
            addCriterion("drepair_id in", values, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdNotIn(List<Integer> values) {
            addCriterion("drepair_id not in", values, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdBetween(Integer value1, Integer value2) {
            addCriterion("drepair_id between", value1, value2, "drepairId");
            return (Criteria) this;
        }

        public Criteria andDrepairIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drepair_id not between", value1, value2, "drepairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdIsNull() {
            addCriterion("repair_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairIdIsNotNull() {
            addCriterion("repair_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairIdEqualTo(Integer value) {
            addCriterion("repair_id =", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotEqualTo(Integer value) {
            addCriterion("repair_id <>", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThan(Integer value) {
            addCriterion("repair_id >", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_id >=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThan(Integer value) {
            addCriterion("repair_id <", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThanOrEqualTo(Integer value) {
            addCriterion("repair_id <=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdIn(List<Integer> values) {
            addCriterion("repair_id in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotIn(List<Integer> values) {
            addCriterion("repair_id not in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdBetween(Integer value1, Integer value2) {
            addCriterion("repair_id between", value1, value2, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_id not between", value1, value2, "repairId");
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

        public Criteria andDrepairDataIsNull() {
            addCriterion("drepair_data is null");
            return (Criteria) this;
        }

        public Criteria andDrepairDataIsNotNull() {
            addCriterion("drepair_data is not null");
            return (Criteria) this;
        }

        public Criteria andDrepairDataEqualTo(Date value) {
            addCriterion("drepair_data =", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataNotEqualTo(Date value) {
            addCriterion("drepair_data <>", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataGreaterThan(Date value) {
            addCriterion("drepair_data >", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataGreaterThanOrEqualTo(Date value) {
            addCriterion("drepair_data >=", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataLessThan(Date value) {
            addCriterion("drepair_data <", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataLessThanOrEqualTo(Date value) {
            addCriterion("drepair_data <=", value, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataIn(List<Date> values) {
            addCriterion("drepair_data in", values, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataNotIn(List<Date> values) {
            addCriterion("drepair_data not in", values, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataBetween(Date value1, Date value2) {
            addCriterion("drepair_data between", value1, value2, "drepairData");
            return (Criteria) this;
        }

        public Criteria andDrepairDataNotBetween(Date value1, Date value2) {
            addCriterion("drepair_data not between", value1, value2, "drepairData");
            return (Criteria) this;
        }

        public Criteria andRepairContentIsNull() {
            addCriterion("repair_content is null");
            return (Criteria) this;
        }

        public Criteria andRepairContentIsNotNull() {
            addCriterion("repair_content is not null");
            return (Criteria) this;
        }

        public Criteria andRepairContentEqualTo(String value) {
            addCriterion("repair_content =", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentNotEqualTo(String value) {
            addCriterion("repair_content <>", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentGreaterThan(String value) {
            addCriterion("repair_content >", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentGreaterThanOrEqualTo(String value) {
            addCriterion("repair_content >=", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentLessThan(String value) {
            addCriterion("repair_content <", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentLessThanOrEqualTo(String value) {
            addCriterion("repair_content <=", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentLike(String value) {
            addCriterion("repair_content like", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentNotLike(String value) {
            addCriterion("repair_content not like", value, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentIn(List<String> values) {
            addCriterion("repair_content in", values, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentNotIn(List<String> values) {
            addCriterion("repair_content not in", values, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentBetween(String value1, String value2) {
            addCriterion("repair_content between", value1, value2, "repairContent");
            return (Criteria) this;
        }

        public Criteria andRepairContentNotBetween(String value1, String value2) {
            addCriterion("repair_content not between", value1, value2, "repairContent");
            return (Criteria) this;
        }

        public Criteria andDrepairStateIsNull() {
            addCriterion("drepair_state is null");
            return (Criteria) this;
        }

        public Criteria andDrepairStateIsNotNull() {
            addCriterion("drepair_state is not null");
            return (Criteria) this;
        }

        public Criteria andDrepairStateEqualTo(String value) {
            addCriterion("drepair_state =", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateNotEqualTo(String value) {
            addCriterion("drepair_state <>", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateGreaterThan(String value) {
            addCriterion("drepair_state >", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateGreaterThanOrEqualTo(String value) {
            addCriterion("drepair_state >=", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateLessThan(String value) {
            addCriterion("drepair_state <", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateLessThanOrEqualTo(String value) {
            addCriterion("drepair_state <=", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateLike(String value) {
            addCriterion("drepair_state like", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateNotLike(String value) {
            addCriterion("drepair_state not like", value, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateIn(List<String> values) {
            addCriterion("drepair_state in", values, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateNotIn(List<String> values) {
            addCriterion("drepair_state not in", values, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateBetween(String value1, String value2) {
            addCriterion("drepair_state between", value1, value2, "drepairState");
            return (Criteria) this;
        }

        public Criteria andDrepairStateNotBetween(String value1, String value2) {
            addCriterion("drepair_state not between", value1, value2, "drepairState");
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