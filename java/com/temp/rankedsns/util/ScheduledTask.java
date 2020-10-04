package com.navercorp.rankedsns.util;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.navercorp.rankedsns.user.service.UserService;
import com.navercorp.rankedsns.user.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTask {
	@Autowired
	UserService userService;

	@Scheduled(fixedRate = 1000 * 60 * 5)
	public void task() throws InterruptedException {
		log.info("update score start {}", new Date());
		List<UserVO> userList = userService.getAllUser();
		List<List<UserVO>> partitionedList = ListUtils.partition(userList, 10);
		for (List<UserVO> list : partitionedList) {
			userService.setScore(list);
		}
		log.info("update score end {}", new Date());
	}

}

//		int userCount = userDAO.getUserCount();
//		if (offset > userCount) {
//			offset = 0;
//			return;
//		}
//		Map<String, Integer> params = new HashMap<String, Integer>();
//		params.put("offset", offset);
//		params.put("count", count);
//		userDAO.setScore(params);
//		offset += count;

/*
score 업데이트
post -- like join 기간 설정하여 개수를 가져온다.
1번 유저의 모든 게시물 중 어제부터 눌린 좋아요 수.
select count(*) from post left join likes on post.post_id = likes.like_post_id where post.user_id = 1 and likes.like_date >= date_add(curdate(), interval -1 day);
가져온 좋아요 수로 스코어를 계산한다.
score = N일간의 좋아요 수로 점수를 테스트해보자.
select post.user_id, count(*) 
from post left join likes on post.post_id = likes.like_post_id 
where likes.like_date >= date_add(curdate(), interval -3 day)
group by post.user_id;
계산된 스코어를 user table에 업데이트한다.
트랜잭션 단위 나누기.
score desc 정렬하여 @rank 로 순위 계산 후 이걸 그대로 user rank에 넣는다.
위험한 방법 transaction을 전체 걸면 그동안 디비에 락이 걸린다. 서비스 운영 측면에서 매우 위험하다. 모든 row를 업데이트하는동안 다른 작업을 못하기 때문에 서비스가 멈추기도 한다.
 */