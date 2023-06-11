package queries;

import com.bleiny.commons.domain.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindCommunityByUuid extends BaseQuery {
    private String uuid;
}
