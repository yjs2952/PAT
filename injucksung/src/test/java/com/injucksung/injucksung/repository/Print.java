package com.injucksung.injucksung.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

@Slf4j
public class Print {
    public static void print(Page<?> page) {
        log.info("totalElements: " + page.getTotalElements());
        log.info("totalPages: " + page.getTotalPages());
        for (Object element : page) {
            log.info(element.toString());
        }
    }
    public static void print(Set<?> set) {
        log.info("setSize: " + set.size());
        for (Object element : set) {
            log.info(element.toString());
        }
    }
    public static void print(List<?> list) {
        log.info("setSize: " + list.size());
        for (Object element : list) {
            log.info(element.toString());
        }
    }
}
