package com.bleiny.commons.domain.queries;

import com.bleiny.commons.domain.enity.BaseEntity;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
    List<BaseEntity> handle(T query);

}
