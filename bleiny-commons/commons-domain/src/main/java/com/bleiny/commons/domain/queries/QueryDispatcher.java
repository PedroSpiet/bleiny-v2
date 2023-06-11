package com.bleiny.commons.domain.queries;

import com.bleiny.commons.domain.enity.BaseEntity;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void reegisterHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery baseQuery);
}
