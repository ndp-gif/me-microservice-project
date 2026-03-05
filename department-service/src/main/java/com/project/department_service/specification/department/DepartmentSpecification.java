package com.project.department_service.specification.department;

import com.project.department_service.entity.Department;
import com.project.department_service.form.DepartmentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DepartmentSpecification {

    public static Specification<Department> buildWhere(String search, DepartmentFilterForm form) {
        return (Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(search)) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + search.trim().toLowerCase() + "%")
                );
            }

            if(form != null) {

                if(form.getCreatedDate()!= null) {
                    predicates.add(
                            cb.equal(root.get("createDate"), form.getCreatedDate())
                    );
                }
                if(form.getMinCreatedDate()!= null) {
                    predicates.add(
                            cb.equal(root.get("createDate"), form.getMinCreatedDate())
                    );
                }
                if(form.getMaxCreatedDate()!= null) {
                    predicates.add(
                            cb.equal(root.get("createDate"), form.getMaxCreatedDate())
                    );
                }

                if(form.getMinYear() != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, form.getMinYear());
                    calendar.set(Calendar.MONTH, Calendar.JANUARY);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);

                    predicates.add(
                            cb.greaterThanOrEqualTo(
                                    root.get("createDate"),
                                    calendar.getTime()
                            )
                    );
                }
                if(form.getType()!= null) {
                    predicates.add(
                            cb.equal(root.get("type"), form.getType())
                    );
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
