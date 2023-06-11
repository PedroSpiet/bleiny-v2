package com.bleiny.community.domain.service;

import com.bleiny.commons.domain.enity.BaseEntity;
import com.bleiny.commons.domain.queries.BaseQuery;
import com.bleiny.commons.domain.queries.QueryDispatcher;
import com.bleiny.commons.domain.queries.QueryHandlerMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
public class AccountQueryDispatcher implements QueryDispatcher {
    private final Map<Class<? extends BaseQuery>, List<QueryHandlerMethod>> routes = new HashMap<>();
    @Override
    public <T extends BaseQuery> void reegisterHandler(Class<T> type, QueryHandlerMethod<T> handler) {
        var handles = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handles.add(handler);
    }

    @Override
    public <U extends BaseEntity> List<U> send(BaseQuery baseQuery) {
        var handles = routes.get(baseQuery.getClass());
        if (handles == null) {
            throw new RuntimeException("No query handlers register");
        }

        return handles.get(0).handle(baseQuery);
    }
}
