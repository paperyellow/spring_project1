package site.metacoding.red.web.dto.response.boards;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingDto {
	private Integer totalCount;
	private Integer totalPage;
	private Integer currentPage;
	private boolean isLast;
	private boolean isFirst;
}
