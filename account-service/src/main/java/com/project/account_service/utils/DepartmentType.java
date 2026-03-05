package com.project.account_service.utils;

public enum DepartmentType {
    DEV, TEST, SCRUM_MASTER, PM;

    public static DepartmentType toEnum(String type) {
        for(DepartmentType item: values()){
            if(item.toString().equals(type)) return item;
        }
        return null;
    }
}
