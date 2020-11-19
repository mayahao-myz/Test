package com.hbxy.ssm.app.studentquery.model;

import java.util.ArrayList;
import java.util.List;

public class StudentQueryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public StudentQueryExample() {
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

        public Criteria andStuNoIsNull() {
            addCriterion("stu_no is null");
            return (Criteria) this;
        }

        public Criteria andStuNoIsNotNull() {
            addCriterion("stu_no is not null");
            return (Criteria) this;
        }
        //条件查询，addCriterion逻辑与
        public Criteria andStuNoEqualTo(Integer value) {
            addCriterion("stu_no =", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotEqualTo(Integer value) {
            addCriterion("stu_no <>", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoGreaterThan(Integer value) {
            addCriterion("stu_no >", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_no >=", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoLessThan(Integer value) {
            addCriterion("stu_no <", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoLessThanOrEqualTo(Integer value) {
            addCriterion("stu_no <=", value, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoIn(List<Integer> values) {
            addCriterion("stu_no in", values, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotIn(List<Integer> values) {
            addCriterion("stu_no not in", values, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoBetween(Integer value1, Integer value2) {
            addCriterion("stu_no between", value1, value2, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuNoNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_no not between", value1, value2, "stuNo");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNull() {
            addCriterion("stu_major is null");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNotNull() {
            addCriterion("stu_major is not null");
            return (Criteria) this;
        }

        public Criteria andStuMajorEqualTo(String value) {
            addCriterion("stu_major =", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotEqualTo(String value) {
            addCriterion("stu_major <>", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThan(String value) {
            addCriterion("stu_major >", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("stu_major >=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThan(String value) {
            addCriterion("stu_major <", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThanOrEqualTo(String value) {
            addCriterion("stu_major <=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLike(String value) {
            addCriterion("stu_major like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotLike(String value) {
            addCriterion("stu_major not like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorIn(List<String> values) {
            addCriterion("stu_major in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotIn(List<String> values) {
            addCriterion("stu_major not in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorBetween(String value1, String value2) {
            addCriterion("stu_major between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotBetween(String value1, String value2) {
            addCriterion("stu_major not between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNull() {
            addCriterion("stu_sex is null");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNotNull() {
            addCriterion("stu_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStuSexEqualTo(String value) {
            addCriterion("stu_sex =", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotEqualTo(String value) {
            addCriterion("stu_sex <>", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThan(String value) {
            addCriterion("stu_sex >", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThanOrEqualTo(String value) {
            addCriterion("stu_sex >=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThan(String value) {
            addCriterion("stu_sex <", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThanOrEqualTo(String value) {
            addCriterion("stu_sex <=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLike(String value) {
            addCriterion("stu_sex like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotLike(String value) {
            addCriterion("stu_sex not like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexIn(List<String> values) {
            addCriterion("stu_sex in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotIn(List<String> values) {
            addCriterion("stu_sex not in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexBetween(String value1, String value2) {
            addCriterion("stu_sex between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotBetween(String value1, String value2) {
            addCriterion("stu_sex not between", value1, value2, "stuSex");
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

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
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