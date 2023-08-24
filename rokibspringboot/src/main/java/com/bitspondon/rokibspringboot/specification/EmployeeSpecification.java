package com.bitspondon.rokibspringboot.specification;

import com.bitspondon.rokibspringboot.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification implements Specification<Employee> {
    @Override
    public Specification<Employee> and(Specification<Employee> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Employee> or(Specification<Employee> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
